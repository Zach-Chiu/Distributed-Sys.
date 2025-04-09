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

public class AirQualityServer {
    public static void main(String[] args) throws Exception {
        Server server = ServerBuilder.forPort(50051)
                .addService(new AirQualityServiceImpl())
                .build();

        server.start();
        System.out.println("Air Quality Server started on port 50051");
        server.awaitTermination();
    }
}