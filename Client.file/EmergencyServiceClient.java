/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.smartcity.client;

/**
 *
 * @author zachchiu
 */

import com.smartcity.emergency.*;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class EmergencyServiceClient {
    private final ManagedChannel channel;
    private final EmergencyServiceGrpc.EmergencyServiceBlockingStub blockingStub;
    private final EmergencyServiceGrpc.EmergencyServiceStub asyncStub;

    public EmergencyServiceClient(String host, int port) {
        this.channel = ManagedChannelBuilder.forAddress(host, port)
                .usePlaintext()
                .build();
        this.blockingStub = EmergencyServiceGrpc.newBlockingStub(channel);
        this.asyncStub = EmergencyServiceGrpc.newStub(channel);
    }

    public void reportAccident(String location, String severity) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(1);
        StreamObserver<AccidentReport> requestObserver = asyncStub.reportAccident(new StreamObserver<EmergencyUpdate>() {
            @Override
            public void onNext(EmergencyUpdate response) {
                System.out.println(response.getUpdateMessage());
            }

            @Override
            public void onError(Throwable t) {
                System.err.println("Error in reporting accident: " + t.getMessage());
                latch.countDown();
            }

            @Override
            public void onCompleted() {
                System.out.println("Accident reporting completed.");
                latch.countDown();
            }
        });

        requestObserver.onNext(AccidentReport.newBuilder().setLocation(location).setSeverity(severity).build());
        requestObserver.onCompleted();
        latch.await(3, TimeUnit.SECONDS);
    }

    public void notifyEmergencyTeams(String teamId) {
        EmergencyRequest request = EmergencyRequest.newBuilder().setTeamId(teamId).build();
        blockingStub.notifyEmergencyTeams(request)
                .forEachRemaining(response -> System.out.println("Emergency Update: " + response.getUpdateMessage()));
    }

    public void shutdown() throws InterruptedException {
        channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
    }

    public static void main(String[] args) throws InterruptedException {
        EmergencyServiceClient client = new EmergencyServiceClient("localhost", 50051);

        System.out.println("🚨 回報事故");
        client.reportAccident("Main Street", "High");

        System.out.println("\n🚒 通知緊急團隊");
        client.notifyEmergencyTeams("Team A");

        client.shutdown();
    }
}
