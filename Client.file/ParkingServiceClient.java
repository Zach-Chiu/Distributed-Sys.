/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.smartcity.client;

/**
 *
 * @author zachchiu
 */

import com.smartcity.parking.*;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class ParkingServiceClient {
    private final ManagedChannel channel;
    private final ParkingServiceGrpc.ParkingServiceBlockingStub blockingStub;
    private final ParkingServiceGrpc.ParkingServiceStub asyncStub;

    public ParkingServiceClient(String host, int port) {
        this.channel = ManagedChannelBuilder.forAddress(host, port)
                .usePlaintext()
                .build();
        this.blockingStub = ParkingServiceGrpc.newBlockingStub(channel);
        this.asyncStub = ParkingServiceGrpc.newStub(channel);
    }

    public void findAvailableParking(String location) {
        ParkingRequest request = ParkingRequest.newBuilder().setLocation(location).build();
        ParkingResponse response = blockingStub.findAvailableParking(request);
        System.out.println("Available parking spots: " + response.getAvailableSpotsList());
    }

    public void reserveParkingSpot(String userId, String... spots) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(1);
        StreamObserver<ReservationRequest> requestObserver = asyncStub.reserveParkingSpot(new StreamObserver<ReservationResponse>() {
            @Override
            public void onNext(ReservationResponse response) {
                System.out.println(response.getConfirmationMessage());
            }

            @Override
            public void onError(Throwable t) {
                System.err.println("Error in reservation: " + t.getMessage());
                latch.countDown();
            }

            @Override
            public void onCompleted() {
                System.out.println("Parking reservation completed.");
                latch.countDown();
            }
        });

        for (String spot : spots) {
            requestObserver.onNext(ReservationRequest.newBuilder()
                    .setUserId(userId)
                    .setParkingSpotId(spot)
                    .build());
        }
        requestObserver.onCompleted();
        latch.await(3, TimeUnit.SECONDS);
    }

    public void shutdown() throws InterruptedException {
        channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
    }

    public static void main(String[] args) throws InterruptedException {
        ParkingServiceClient client = new ParkingServiceClient("localhost", 50051);
        
        System.out.println("🚗 查詢可用車位");
        client.findAvailableParking("Downtown");

        System.out.println("\n🅿️ 預約車位");
        client.reserveParkingSpot("User1", "P1", "P3");

        client.shutdown();
    }
}
