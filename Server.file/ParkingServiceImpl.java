/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.smartcity.server;

/**
 *
 * @author zachchiu
 */
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


/**
 *
 * @author zachchiu
 */

import com.smartcity.parking.*;
import io.grpc.stub.StreamObserver;
import java.util.*;

public class ParkingServiceImpl extends ParkingServiceGrpc.ParkingServiceImplBase {
    // This map holds parking data: location -> list of parking spot IDs
    private final Map<String, List<String>> parkingData;
    // Constructor: initialize parking data for different locations
    public ParkingServiceImpl() {
        parkingData = new HashMap<>();
        parkingData.put("Downtown", Arrays.asList("P1", "P2", "P3"));       // 3 spots in Downtown
        parkingData.put("Airport", Arrays.asList("P4", "P5"));              // 2 spots at Airport
        parkingData.put("Mall", Arrays.asList("P6", "P7", "P8", "P9"));     // 4 spots at Mall
    }

    // unction to handle parking availability request (Unary RPC)
        @Override
    public void findAvailableParking(ParkingRequest request, StreamObserver<ParkingResponse> responseObserver) {
        String location = request.getLocation();        // Get the location from the request
        System.out.println("Received parking request for location: " + location);
        
        // Find spots for this location; return empty list if location not found
        List<String> availableSpots = parkingData.getOrDefault(location, Collections.emptyList());
        
        // Build and send response with available spots
        ParkingResponse response = ParkingResponse.newBuilder()
                .addAllAvailableSpots(availableSpots)
                .build();

        responseObserver.onNext(response);      // Send the response to client
        responseObserver.onCompleted();         // End the communication
    }

    // Function to reserve parking spots (Client Streaming RPC)
    @Override
    public StreamObserver<ReservationRequest> reserveParkingSpot(StreamObserver<ReservationResponse> responseObserver) {
        return new StreamObserver<ReservationRequest>() {
            private final List<String> reservedSpots = new ArrayList<>();       // Store all reserved spot IDs
            
            // Called for each message sent by the client
            @Override
            public void onNext(ReservationRequest request) {
                System.out.println("Reservation received - User: " + request.getUserId() + ", Spot: " + request.getParkingSpotId());
                reservedSpots.add(request.getParkingSpotId());                  // Add the spot to the reservation list
            }
            // Called when an error occurs in the stream
            @Override
            public void onError(Throwable t) {
                System.err.println("Error in ReserveParkingSpot: " + t.getMessage());
            }
            // Called when client finishes sending all requests
            @Override
            public void onCompleted() {
                String confirmation = "Reservations confirmed: " + reservedSpots;
                ReservationResponse response = ReservationResponse.newBuilder()
                        .setConfirmationMessage(confirmation)
                        .build();
                responseObserver.onNext(response);          // Send confirmation to client
                responseObserver.onCompleted();             // End the communication
                System.out.println(confirmation);           // Print result on server console
            }
        };
    }
}
