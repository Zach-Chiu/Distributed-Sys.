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

public class ParkingServer {
    public static void main(String[] args) throws Exception {
        // Create an API Key Interceptor
        // This will help check if the client has permission to use the reserve service
        ApiKeyInterceptor apiKeyInterceptor = new ApiKeyInterceptor();

        // Build and start the gRPC server
        // .addService() adds the parking service logic
        // .intercept() adds the API Key security check
        Server server = ServerBuilder.forPort(50053)                // Server will listen on port 50053
                .addService(new ParkingServiceImpl())               // Add the ParkingService implementation
                .intercept(apiKeyInterceptor)                       // Add the API key interceptor
                .build();                                           // Finish building the server

        server.start();                                             // Start the gRPC server
        System.out.println(" Smart Parking Server started on port 50053 with API Key validation");
        
        server.awaitTermination();                                   // Keep the server running and wait for shutdown
    }
}
