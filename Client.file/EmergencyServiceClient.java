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

        public String reportAccident(String location, String severity) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(1);
        StringBuilder result = new StringBuilder(); // 用來儲存訊息

        StreamObserver<AccidentReport> requestObserver = asyncStub.reportAccident(new StreamObserver<EmergencyUpdate>() {
            @Override
            public void onNext(EmergencyUpdate response) {
                result.append(response.getUpdateMessage()).append("\n"); // ✅ 存進字串
            }

            @Override
            public void onError(Throwable t) {
                result.append("Error in reporting accident: ").append(t.getMessage()).append("\n");
                latch.countDown();
            }

            @Override
            public void onCompleted() {
                result.append("Accident reporting completed.\n");
                latch.countDown();
            }
        });

        requestObserver.onNext(AccidentReport.newBuilder()
                .setLocation(location)
                .setSeverity(severity)
                .build());

        requestObserver.onCompleted();
        latch.await(3, TimeUnit.SECONDS);

        return result.toString(); // ✅ 將訊息傳回 GUI 顯示
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
        EmergencyServiceClient client = new EmergencyServiceClient("localhost", 50052);

        System.out.println(" Report an incident");
        client.reportAccident("Main Street", "High");

        System.out.println("\n Notify the emergency team");
        client.notifyEmergencyTeams("Team A");

        client.shutdown();
    }

    public String notifyTeam(String teamId) {
        StringBuilder result = new StringBuilder();
        EmergencyRequest request = EmergencyRequest.newBuilder().setTeamId(teamId).build();

        blockingStub.notifyEmergencyTeams(request)
            .forEachRemaining(response -> {
                result.append("Emergency Update: ").append(response.getUpdateMessage()).append("\n");
            });

    return result.toString();
}
}
