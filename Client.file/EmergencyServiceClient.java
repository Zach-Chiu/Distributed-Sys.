package com.smartcity.client;

import com.smartcity.emergency.*;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceInfo;
import javax.jmdns.ServiceEvent;
import javax.jmdns.ServiceListener;
import java.io.IOException;
import java.net.InetAddress;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * EmergencyServiceClient
 * This class connects to the EmergencyService via gRPC.
 * It can report accidents (bidirectional streaming) and
 * notify teams (server streaming).
 */
public class EmergencyServiceClient {

    private ManagedChannel channel;                                             // gRPC channel to the server
    private EmergencyServiceGrpc.EmergencyServiceBlockingStub blockingStub;     // blocking (synchronous) stub
    private EmergencyServiceGrpc.EmergencyServiceStub asyncStub;                // async (non-blocking) stub
      
    /**
     * Constructor with explicit host and port.
     * Use this when you know the server address in advance.
     */
    public EmergencyServiceClient(String host, int port) {
        // Build a plaintext channel (no TLS) to the given host and port
        this.channel = ManagedChannelBuilder.forAddress(host, port)
                .usePlaintext()
                .build();
        // Create stubs for making calls
        this.blockingStub = EmergencyServiceGrpc.newBlockingStub(channel);
        this.asyncStub = EmergencyServiceGrpc.newStub(channel);
    }

    /**
     * No-argument constructor uses JmDNS for service discovery.
     * It finds the EmergencyService on the local network automatically.
     */
    public EmergencyServiceClient() {
        try {
            // Create JmDNS on the local host address
            JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost());

            // Use a latch to wait for service resolution
            final CountDownLatch latch = new CountDownLatch(1);
            
            // Listen for services of type "_emergency._tcp.local."
            jmdns.addServiceListener("_emergency._tcp.local.", new ServiceListener() {
                @Override
                public void serviceAdded(ServiceEvent event) {
                    // Ask for full service info when a service is added
                    jmdns.requestServiceInfo(event.getType(), event.getName(), 1);
                }

                @Override
                public void serviceRemoved(ServiceEvent event) {}
                // We ignore removals in this example
                @Override
                public void serviceResolved(ServiceEvent event) {
                    ServiceInfo info = event.getInfo();
                    String host = info.getHostAddresses()[0];
                    int port = info.getPort();
                    System.out.println(" Discovered EmergencyService at " + host + ":" + port);

                    // Build the channel and stubs using discovered info
                    channel = ManagedChannelBuilder.forAddress(host, port)
                            .usePlaintext()
                            .build();
                    blockingStub = EmergencyServiceGrpc.newBlockingStub(channel);
                    asyncStub = EmergencyServiceGrpc.newStub(channel);
                    
                    // Signal that discovery is complete
                    latch.countDown();
                }
            });

            // Wait up to 3 seconds for discovery, then close JmDNS
            latch.await(3, TimeUnit.SECONDS);
            jmdns.close();

        } catch (IOException | InterruptedException e) {
            System.err.println(" Failed to discover EmergencyService: " + e.getMessage());
        }
    }
    /**
     * reportAccident: Bidirectional streaming RPC.
     * The client sends multiple AccidentReport messages,
     * and receives EmergencyUpdate messages as they arrive.
     *
     * @param location the location of the accident
     * @param severity the severity level (e.g., "High", "Medium", "Low")
     * @return combined responses from the server
     * @throws InterruptedException if the thread is interrupted while waiting
     */
    public String reportAccident(String location, String severity) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(1);   // latch to wait until stream ends
        StringBuilder result = new StringBuilder();     // accumulate server responses
        
        // Create a StreamObserver to handle server responses
        StreamObserver<AccidentReport> requestObserver = asyncStub.reportAccident(new StreamObserver<EmergencyUpdate>() {
            @Override
            public void onNext(EmergencyUpdate response) {
                // Called each time the server sends an update
                result.append(response.getUpdateMessage()).append("\n");
            }

            @Override
            public void onError(Throwable t) {
                // Called if there is an error on the stream
                result.append("Error in reporting accident: ").append(t.getMessage()).append("\n");
                latch.countDown();
            }

            @Override
            public void onCompleted() {
                // Called when the server signals stream completion
                result.append("Accident reporting completed.\n");
                latch.countDown();
            }
        });

        // Send three accident reports as an example
        for (int i = 1; i <= 3; i++) { 
        requestObserver.onNext(AccidentReport.newBuilder()
                .setLocation(location)
                .setSeverity(severity)
                .build());}
        
        // Signal we are done sending
        requestObserver.onCompleted();
        // Wait for server to finish up to 3 seconds
        latch.await(3, TimeUnit.SECONDS);

        return result.toString();
    }
    /**
     * notifyEmergencyTeams: Server streaming RPC.
     * The client sends one EmergencyRequest, then
     * reads a stream of EmergencyUpdate messages.
     *
     * @param teamId the ID of the emergency response team
     */
    public void notifyEmergencyTeams(String teamId) {
        // Build the request with a team ID
        EmergencyRequest request = EmergencyRequest.newBuilder().setTeamId(teamId).build();
        // Call the server and iterate over each response
        blockingStub.notifyEmergencyTeams(request)
                .forEachRemaining(response -> System.out.println("Emergency Update: " + response.getUpdateMessage()));
    }
    
    /**
     * notifyTeam: Helper method to return responses as a String.
     * Used by GUI to display updates in a text area.
     *
     * @param teamId the ID of the emergency response team
     * @return concatenated update messages
     */
    public String notifyTeam(String teamId) {
        StringBuilder result = new StringBuilder();
        EmergencyRequest request = EmergencyRequest.newBuilder().setTeamId(teamId).build();
        // Gather each server response
        blockingStub.notifyEmergencyTeams(request)
                .forEachRemaining(response -> {
                    result.append("Emergency Update: ").append(response.getUpdateMessage()).append("\n");
                });

        return result.toString();
    }
    /**
     * shutdown: Gracefully close the gRPC channel.
     *
     * @throws InterruptedException if shutdown is interrupted
     */
    public void shutdown() throws InterruptedException {
        if (channel != null) {
            channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
        }
    }
    /**
     * main: Example usage of the client.
     * Demonstrates both RPC types.
     */
    public static void main(String[] args) throws InterruptedException {
        EmergencyServiceClient client = new EmergencyServiceClient();

        System.out.println(" Report an incident");
        String result = client.reportAccident("Main Street", "High");
        System.out.println(result);

        System.out.println("\n Notify the emergency team");
        client.notifyEmergencyTeams("Team A");

        client.shutdown();
    }
}
