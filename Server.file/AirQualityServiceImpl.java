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

    private final Random random = new Random();

    // 1️⃣ 伺服器串流：監測空氣品質
    @Override
    public void monitorAirQuality(AirQualityRequest request, StreamObserver<PollutionResponse> responseObserver) {
        System.out.println("Monitoring air quality at location: " + request.getLocation());

        for (int i = 0; i < 5; i++) {
            float pollutionLevel = 50 + random.nextFloat() * 50;  // 模擬污染指數 (50~100)
            PollutionResponse response = PollutionResponse.newBuilder()
                    .setLocation(request.getLocation())
                    .setPollutionLevel(pollutionLevel)
                    .build();

            responseObserver.onNext(response);

            try {
                Thread.sleep(2000); // 模擬監測間隔
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        responseObserver.onCompleted();
    }

    // 2️⃣ 客戶端串流：警報通知
    @Override
    public StreamObserver<AlertRequest> alertAuthorities(StreamObserver<AlertResponse> responseObserver) {
        return new StreamObserver<AlertRequest>() {
            @Override
            public void onNext(AlertRequest request) {
                System.out.println("Alert received: " + request.getAlertMessage() + " at " + request.getLocation());
            }

            @Override
            public void onError(Throwable t) {
                System.err.println("Error in AlertAuthorities: " + t.getMessage());
            }

            @Override
            public void onCompleted() {
                AlertResponse response = AlertResponse.newBuilder()
                        .setConfirmation("All alerts have been received and authorities notified.")
                        .build();
                responseObserver.onNext(response);
                responseObserver.onCompleted();
            }
        };
    }
}
