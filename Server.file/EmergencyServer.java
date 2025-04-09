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

import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

/**
 *
 * @author zachchiu
 */
public class EmergencyServer {

    private Server server;

    public void start() throws IOException {
        int port = 50052;
        server = ServerBuilder.forPort(port)
                .addService(new EmergencyServiceImpl())
                .build()
                .start();

        System.out.println("🚨 EmergencyServer started on port " + port);

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("🛑 Shutting down EmergencyServer...");
            EmergencyServer.this.stop();
        }));
    }

    public void stop() {
        if (server != null) {
            server.shutdown();
            System.out.println("✅ EmergencyServer stopped.");
        }
    }

    public void blockUntilShutdown() throws InterruptedException {
        if (server != null) {
            server.awaitTermination();
        }
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        final EmergencyServer server = new EmergencyServer();
        server.start();
        server.blockUntilShutdown();
    }
}

