/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.smartcity.server;

/**
 *
 * @author zachchiu
 */

import com.smartcity.emergency.*;
import io.grpc.stub.StreamObserver;
import java.util.ArrayList;
import java.util.List;

public class EmergencyServiceImpl extends EmergencyServiceGrpc.EmergencyServiceImplBase {

    // 1️⃣ 雙向串流：用戶回報事故，系統回應更新
    @Override
    public StreamObserver<AccidentReport> reportAccident(StreamObserver<EmergencyUpdate> responseObserver) {
        return new StreamObserver<AccidentReport>() {
            @Override
            public void onNext(AccidentReport report) {
                System.out.println("Accident reported at: " + report.getLocation() + ", Severity: " + report.getSeverity());

                // 模擬緊急更新
                EmergencyUpdate update = EmergencyUpdate.newBuilder()
                        .setUpdateMessage("Emergency response dispatched to: " + report.getLocation())
                        .build();

                // 發送回應
                responseObserver.onNext(update);
            }

            @Override
            public void onError(Throwable t) {
                System.err.println("Error in ReportAccident: " + t.getMessage());
            }

            @Override
            public void onCompleted() {
                System.out.println("Accident reporting completed.");
                responseObserver.onCompleted();
            }
        };
    }

    // 2️⃣ 伺服器串流：通知緊急團隊
    @Override
    public void notifyEmergencyTeams(EmergencyRequest request, StreamObserver<EmergencyUpdate> responseObserver) {
        System.out.println("Notifying emergency team: " + request.getTeamId());

        // 模擬多個更新
        List<String> updates = new ArrayList<>();
        updates.add("Team " + request.getTeamId() + " has been alerted.");
        updates.add("Team " + request.getTeamId() + " is on the way.");
        updates.add("Team " + request.getTeamId() + " has arrived at the scene.");

        for (String message : updates) {
            EmergencyUpdate update = EmergencyUpdate.newBuilder()
                    .setUpdateMessage(message)
                    .build();
            responseObserver.onNext(update);

            try {
                Thread.sleep(1000); // 模擬延遲
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        responseObserver.onCompleted();
    }
}
