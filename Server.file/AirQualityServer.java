/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.smartcity.server;

/**
 *
 * @author zachchiu
 */

import io.grpc.Server;
import io.grpc.ServerBuilder;
import javax.jmdns.JmDNS;
import javax.jmdns.ServiceInfo;
import java.io.IOException;
import java.net.InetAddress;

public class AirQualityServer {

    private Server server;       // Declare a gRPC server object
    private JmDNS jmdns;         // Declare JmDNS for service discovery

    public void start() throws IOException {
        int port = 50051;        // The port number where the server will listen
        // Create and start the gRPC server on the specified port
        server = ServerBuilder.forPort(port)
                .addService(new AirQualityServiceImpl())    // Add service implementation
                .build()
                .start();

        System.out.println("AirQualityServer started on port " + port);

         // Register this service on the local network using JmDNS
        jmdns = JmDNS.create(InetAddress.getLocalHost());   // Get local IP and create JmDNS instance
        ServiceInfo serviceInfo = ServiceInfo.create(
                "_airquality._tcp.local.",          // Service type for discovery
                "AirQualityService",                // service name
                port,                               // port number
                "Smart City Air Quality Service"    // Description
        );
        jmdns.registerService(serviceInfo);         // Register the service so other apps can discover it
        System.out.println("AirQualityService registered via JmDNS");

         // Add a shutdown hook — a special code that runs when the program is closing
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("Shutting down AirQualityServer...");
            AirQualityServer.this.stop();           // Call the stop method to close resources
        }));
    }
    
    // This method stops the server and closes JmDNS
    public void stop() {
        if (server != null) {
            server.shutdown();  // Stop the gRPC server
        }
        if (jmdns != null) {
            try {
                jmdns.unregisterAllServices();      // Unregister all services from the network
                jmdns.close();                      // Close JmDNS instance
                System.out.println(" AirQualityService registered via JmDNS");
            } catch (IOException e) {
                e.printStackTrace();                // Print error if something goes wrong
            }
        }
    }
    // Keep the server running until manually stopped
    public void blockUntilShutdown() throws InterruptedException {
        if (server != null) {
            server.awaitTermination();              // Wait for the server to shut down
        }
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        final AirQualityServer server = new AirQualityServer();     // Create a new server instance
        server.start();                                             // Start the server
        server.blockUntilShutdown();                                // Keep running until manually closed
    }
}
