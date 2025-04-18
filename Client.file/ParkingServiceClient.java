package com.smartcity.client;

import com.smartcity.parking.*;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.Metadata; 
import io.grpc.stub.MetadataUtils; 
import io.grpc.stub.StreamObserver;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class ParkingServiceClient {
    // gRPC channel to communicate with the server
    private final ManagedChannel channel;
    // Blocking stub: used for simple, synchronous calls
    private final ParkingServiceGrpc.ParkingServiceBlockingStub blockingStub;
    // Async stub: used for streaming (client-streaming in this case)
    private final ParkingServiceGrpc.ParkingServiceStub asyncStub;
    
    // Constructor to create a gRPC connection using host and port
    public ParkingServiceClient(String host, int port) {
        this.channel = ManagedChannelBuilder.forAddress(host, port)
                .usePlaintext()                  // Not using encryption (for local test)
                .build();
        
        // Create both blocking and async stubs from the channel
        this.blockingStub = ParkingServiceGrpc.newBlockingStub(channel);
        this.asyncStub = ParkingServiceGrpc.newStub(channel);
    }
    // 1. Server-side unary RPC to get a list of available parking spots
    public String findAvailableParking(String location) {
        // Build request message with the location
        ParkingRequest request = ParkingRequest.newBuilder().setLocation(location).build();
        
         // Send request and receive one response (unary RPC)
        ParkingResponse response = blockingStub.findAvailableParking(request);
        
        // Return result as string
        return "Available parking spots: " + response.getAvailableSpotsList();
    }
    
    // 1. Client-side streaming RPC to reserve multiple spots (with API Key)
    public String reserveParkingSpot(String userId, String... spots) throws InterruptedException {
        StringBuilder result = new StringBuilder();             // Store server responses
        CountDownLatch latch = new CountDownLatch(1);           // Used to wait until response is complete

        // Add API KEY metadata
        Metadata metadata = new Metadata();
        Metadata.Key<String> apiKeyHeader = Metadata.Key.of("api-key", Metadata.ASCII_STRING_MARSHALLER);
        metadata.put(apiKeyHeader, "abc123");           // Same key as server-side for access control

        // Attach API key to asyncStub
        ParkingServiceGrpc.ParkingServiceStub stubWithHeaders =
                MetadataUtils.attachHeaders(asyncStub, metadata);
        
        // Create a stream to send multiple reservation requests
        StreamObserver<ReservationRequest> requestObserver = stubWithHeaders.reserveParkingSpot(
            new StreamObserver<ReservationResponse>() {
                // Server replies with confirmation
                @Override
                public void onNext(ReservationResponse response) {
                    result.append(response.getConfirmationMessage()).append("\n");
                }
                // If something goes wrong
                @Override
                public void onError(Throwable t) {
                    result.append("Error in reservation: ").append(t.getMessage()).append("\n");
                    latch.countDown();          // Stop waiting
                }
                // When server completes sending all responses
                @Override
                public void onCompleted() {
                    result.append("Parking reservation completed.\n");
                    latch.countDown();          // Allow main thread to continue
                }
            });
        // Send multiple reservation requests (loop for each spot)
        for (String spot : spots) {
            requestObserver.onNext(ReservationRequest.newBuilder()
                    .setUserId(userId)
                    .setParkingSpotId(spot)
                    .build());
        }
        // Finish the stream
        requestObserver.onCompleted();
        // Wait for server to respond (max 3 seconds)
        latch.await(3, TimeUnit.SECONDS);

        return result.toString();       // Return result string
    }
    // Shutdown the gRPC connection properly
    public void shutdown() throws InterruptedException {
        channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
    }

    public static void main(String[] args) throws InterruptedException {
        ParkingServiceClient client = new ParkingServiceClient("localhost", 50053);

        System.out.println(" Check available parking spaces");
        System.out.println(client.findAvailableParking("Downtown"));

        System.out.println("\n Reserve a parking space");
        System.out.println(client.reserveParkingSpot("User1", "P1", "P3"));

        client.shutdown();
    }
}
