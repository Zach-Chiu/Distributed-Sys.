/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.smartcity.server;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import java.io.IOException;
/**
 *
 * @author zachchiu
 */
public class SmartCityServer {
    private Server server;

    public void start() throws IOException {
        server = ServerBuilder.forPort(50051)
                .addService(new ParkingServiceImpl()) // 添加 ParkingService
                .addService(new EmergencyServiceImpl()) // 添加 EmergencyService
                .addService(new AirQualityServiceImpl()) // 添加 AirQualityService
                .build()
                .start();
        System.out.println("Smart City gRPC Server started on port 50051");
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("Shutting down gRPC server...");
            SmartCityServer.this.stop();
        }));
    }

    public void stop() {
        if (server != null) {
            server.shutdown();
        }
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        SmartCityServer server = new SmartCityServer();
        server.start();
        server.server.awaitTermination();
    }
}