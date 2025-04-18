/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.smartcity.server;

/**
 *
 * @author zachchiu
 */

import com.smartcity.airquality.*;
import io.grpc.stub.StreamObserver;
import java.util.Random;

public class AirQualityServiceImpl extends AirQualityServiceGrpc.AirQualityServiceImplBase {
    // Create a random number generator to simulate pollution data
    private final Random random = new Random();

    // 1. Server Streaming RPC: This function sends multiple pollution data results to the client
    @Override
    public void monitorAirQuality(AirQualityRequest request, StreamObserver<PollutionResponse> responseObserver) {
        // Print the location received from the client
        System.out.println("Monitoring air quality at location: " + request.getLocation());
        // Send 5 pollution readings to the client (simulated data)
        for (int i = 0; i < 5; i++) {
            // Generate a random pollution level between 50 and 100
            float pollutionLevel = 50 + random.nextFloat() * 50;  // Simulated pollution index (50~100)
            // Create a PollutionResponse message
            PollutionResponse response = PollutionResponse.newBuilder()
                    .setLocation(request.getLocation())
                    .setPollutionLevel(pollutionLevel)
                    .build();
            // Send this response to the client
            responseObserver.onNext(response);

            try {
                Thread.sleep(2000);                   // Pause for 2 seconds to simulate delay between readings
            } catch (InterruptedException e) {
                e.printStackTrace();                  // Print error if something goes wrong
            }
        }
        // After sending all 5 readings, complete the stream
        responseObserver.onCompleted();
    }

    //️ 2. Client Streaming RPC: This function receives multiple alert messages from the client
    @Override
    public StreamObserver<AlertRequest> alertAuthorities(StreamObserver<AlertResponse> responseObserver) {
        return new StreamObserver<AlertRequest>() {
            
            // This method is called every time a message is sent by the client
            @Override
            public void onNext(AlertRequest request) {
                // Print the alert message and location to the server console
                System.out.println("Alert received: " + request.getAlertMessage() + " at " + request.getLocation());
            }
            // If something goes wrong with the stream
            @Override
            public void onError(Throwable t) {
                System.err.println("Error in AlertAuthorities: " + t.getMessage());
            }
            // When the client finishes sending all alert messages
            @Override
            public void onCompleted() {
                // Build a response message to confirm all alerts were received
                AlertResponse response = AlertResponse.newBuilder()
                        .setConfirmation("All alerts have been received and authorities notified.")
                        .build();
                // Send confirmation message to client
                responseObserver.onNext(response);
                // Close the stream
                responseObserver.onCompleted();
            }
        };
    }
}
