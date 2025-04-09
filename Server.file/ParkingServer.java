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
        // ✅ 建立攔截器
        ApiKeyInterceptor apiKeyInterceptor = new ApiKeyInterceptor();

        // ✅ 正確使用 intercept() 加入攔截器
        Server server = ServerBuilder.forPort(50053)
                .addService(new ParkingServiceImpl())                // ✅ 加入 ParkingService
                .intercept(apiKeyInterceptor)                       // ✅ 加入 API Key 驗證攔截器
                .build();

        server.start();
        System.out.println("✅ Smart Parking Server started on port 50053 with API Key validation");
        server.awaitTermination();
    }
}
