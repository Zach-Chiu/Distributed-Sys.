package com.smartcity.server;

import com.smartcity.emergency.EmergencyServiceGrpc;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import javax.jmdns.JmDNS;
import javax.jmdns.ServiceInfo;
import java.io.IOException;
import java.net.InetAddress;

// Define the main server class for EmergencyService
public class EmergencyServer {
    // Declare server and JmDNS as instance variables
    private Server server;  // gRPC server instance
    private JmDNS jmdns;    // JmDNS instance for service discovery
    
    // Method to start the server
    public void start() throws IOException {
        int port = 50052;

        // Create and start the gRPC server, and add our service implementation
        server = ServerBuilder.forPort(port)
                .addService(new EmergencyServiceImpl())
                .build()
                .start();
         // Print a message to show that the server is running
        System.out.println(" EmergencyServer started on port " + port);
        
        // ====== JmDNS Service Registration ======
        // Registering Services with JmDNS
        jmdns = JmDNS.create(InetAddress.getLocalHost());
        
        // Create a service info object for registration
        ServiceInfo serviceInfo = ServiceInfo.create(
                "_emergency._tcp.local.",     // Service type for local discovery (DNS-SD)
                "EmergencyService",           // Service name
                port,                         // Sevice port
                "path=/emergency"             
        );
        
        // Register the service with JmDNS
        jmdns.registerService(serviceInfo);
        System.out.println(" Emergency service registered via JmDNS.");

        // Automatically release resources when closing
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println(" Shutting down EmergencyServer...");
            EmergencyServer.this.stop();
        }));
    }

     // Method to stop the server and unregister the service
    public void stop() {
        try {
            if (jmdns != null) {
                jmdns.unregisterAllServices();  // Unregister the service from the network
                jmdns.close();
                System.out.println(" JmDNS service unregistered.");
            }
        } catch (IOException e) {
            // Print error message if JmDNS fails to stop
            System.err.println("️ Error stopping JmDNS: " + e.getMessage());
        }
         // Stop the gRPC server
        if (server != null) {
            server.shutdown();
            System.out.println(" EmergencyServer stopped.");
        }
    }
    // This method blocks the main thread until the server is manually stopped
    public void blockUntilShutdown() throws InterruptedException {
        if (server != null) {
            server.awaitTermination();
        }
    }
    // Main method — Entry point of the server application
    public static void main(String[] args) throws IOException, InterruptedException {
        final EmergencyServer server = new EmergencyServer();   // Create an instance of EmergencyServer
        server.start();                                         // Start the server
        server.blockUntilShutdown();                             // Keep the server alive
    }
}
