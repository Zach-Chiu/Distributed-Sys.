/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


package com.smartcity.server;

/**
 *
 * @author zachchiu
 */

import com.smartcity.parking.*;
import io.grpc.stub.StreamObserver;
import java.util.*;

public class ParkingServiceImpl extends ParkingServiceGrpc.ParkingServiceImplBase {

    private final Map<String, List<String>> parkingData;

    public ParkingServiceImpl() {
        parkingData = new HashMap<>();
        parkingData.put("Downtown", Arrays.asList("P1", "P2", "P3"));
        parkingData.put("Airport", Arrays.asList("P4", "P5"));
        parkingData.put("Mall", Arrays.asList("P6", "P7", "P8", "P9"));
    }

    // 1️⃣ 查詢可用車位
    @Override
    public void findAvailableParking(ParkingRequest request, StreamObserver<ParkingResponse> responseObserver) {
        String location = request.getLocation();
        System.out.println("Received parking request for location: " + location);

        List<String> availableSpots = parkingData.getOrDefault(location, Collections.emptyList());

        ParkingResponse response = ParkingResponse.newBuilder()
                .addAllAvailableSpots(availableSpots)
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    // 2️⃣ 預約車位（客戶端串流）
    @Override
    public StreamObserver<ReservationRequest> reserveParkingSpot(StreamObserver<ReservationResponse> responseObserver) {
        return new StreamObserver<ReservationRequest>() {
            private final List<String> reservedSpots = new ArrayList<>();

            @Override
            public void onNext(ReservationRequest request) {
                System.out.println("Reservation received - User: " + request.getUserId() + ", Spot: " + request.getParkingSpotId());
                reservedSpots.add(request.getParkingSpotId());
            }

            @Override
            public void onError(Throwable t) {
                System.err.println("Error in ReserveParkingSpot: " + t.getMessage());
            }

            @Override
            public void onCompleted() {
                String confirmation = "Reservations confirmed: " + reservedSpots;
                ReservationResponse response = ReservationResponse.newBuilder()
                        .setConfirmationMessage(confirmation)
                        .build();
                responseObserver.onNext(response);
                responseObserver.onCompleted();
                System.out.println(confirmation);
            }
        };
    }
}
