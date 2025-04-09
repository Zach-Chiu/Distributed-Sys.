package com.smartcity.client;

import com.smartcity.parking.*;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.Metadata; //  add Metadata
import io.grpc.stub.MetadataUtils; //  add MetadataUtils
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

    public String findAvailableParking(String location) {
        ParkingRequest request = ParkingRequest.newBuilder().setLocation(location).build();
        ParkingResponse response = blockingStub.findAvailableParking(request);
        return "Available parking spots: " + response.getAvailableSpotsList();
    }

    public String reserveParkingSpot(String userId, String... spots) throws InterruptedException {
        StringBuilder result = new StringBuilder();
        CountDownLatch latch = new CountDownLatch(1);

        //  Add API KEY metadata
        Metadata metadata = new Metadata();
        Metadata.Key<String> apiKeyHeader = Metadata.Key.of("api-key", Metadata.ASCII_STRING_MARSHALLER);
        metadata.put(apiKeyHeader, "abc123"); // 這裡填入與 Server 端一致的 API Key

        // Use attachHeaders to create an asyncStub with an API KEY
        ParkingServiceGrpc.ParkingServiceStub stubWithHeaders =
                MetadataUtils.attachHeaders(asyncStub, metadata);

        StreamObserver<ReservationRequest> requestObserver = stubWithHeaders.reserveParkingSpot(
            new StreamObserver<ReservationResponse>() {
                @Override
                public void onNext(ReservationResponse response) {
                    result.append(response.getConfirmationMessage()).append("\n");
                }

                @Override
                public void onError(Throwable t) {
                    result.append("Error in reservation: ").append(t.getMessage()).append("\n");
                    latch.countDown();
                }

                @Override
                public void onCompleted() {
                    result.append("Parking reservation completed.\n");
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

        return result.toString();
    }

    public void shutdown() throws InterruptedException {
        channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
    }

    public static void main(String[] args) throws InterruptedException {
        ParkingServiceClient client = new ParkingServiceClient("localhost", 50053);

        System.out.println(" Check available parking spaces");
        System.out.println(client.findAvailableParking("Downtown"));

        System.out.println("\n Reserve a parking space");
        System.out.println(client.reserveParkingSpot("User1", "P1", "P3"));

        client.shutdown();
    }
}
