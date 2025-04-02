package com.smartcity.parking;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.15.0)",
    comments = "Source: parking.proto")
public final class ParkingServiceGrpc {

  private ParkingServiceGrpc() {}

  public static final String SERVICE_NAME = "smartcity.parking.ParkingService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.smartcity.parking.ParkingRequest,
      com.smartcity.parking.ParkingResponse> getFindAvailableParkingMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "FindAvailableParking",
      requestType = com.smartcity.parking.ParkingRequest.class,
      responseType = com.smartcity.parking.ParkingResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.smartcity.parking.ParkingRequest,
      com.smartcity.parking.ParkingResponse> getFindAvailableParkingMethod() {
    io.grpc.MethodDescriptor<com.smartcity.parking.ParkingRequest, com.smartcity.parking.ParkingResponse> getFindAvailableParkingMethod;
    if ((getFindAvailableParkingMethod = ParkingServiceGrpc.getFindAvailableParkingMethod) == null) {
      synchronized (ParkingServiceGrpc.class) {
        if ((getFindAvailableParkingMethod = ParkingServiceGrpc.getFindAvailableParkingMethod) == null) {
          ParkingServiceGrpc.getFindAvailableParkingMethod = getFindAvailableParkingMethod = 
              io.grpc.MethodDescriptor.<com.smartcity.parking.ParkingRequest, com.smartcity.parking.ParkingResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "smartcity.parking.ParkingService", "FindAvailableParking"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.smartcity.parking.ParkingRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.smartcity.parking.ParkingResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new ParkingServiceMethodDescriptorSupplier("FindAvailableParking"))
                  .build();
          }
        }
     }
     return getFindAvailableParkingMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.smartcity.parking.ReservationRequest,
      com.smartcity.parking.ReservationResponse> getReserveParkingSpotMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ReserveParkingSpot",
      requestType = com.smartcity.parking.ReservationRequest.class,
      responseType = com.smartcity.parking.ReservationResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
  public static io.grpc.MethodDescriptor<com.smartcity.parking.ReservationRequest,
      com.smartcity.parking.ReservationResponse> getReserveParkingSpotMethod() {
    io.grpc.MethodDescriptor<com.smartcity.parking.ReservationRequest, com.smartcity.parking.ReservationResponse> getReserveParkingSpotMethod;
    if ((getReserveParkingSpotMethod = ParkingServiceGrpc.getReserveParkingSpotMethod) == null) {
      synchronized (ParkingServiceGrpc.class) {
        if ((getReserveParkingSpotMethod = ParkingServiceGrpc.getReserveParkingSpotMethod) == null) {
          ParkingServiceGrpc.getReserveParkingSpotMethod = getReserveParkingSpotMethod = 
              io.grpc.MethodDescriptor.<com.smartcity.parking.ReservationRequest, com.smartcity.parking.ReservationResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "smartcity.parking.ParkingService", "ReserveParkingSpot"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.smartcity.parking.ReservationRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.smartcity.parking.ReservationResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new ParkingServiceMethodDescriptorSupplier("ReserveParkingSpot"))
                  .build();
          }
        }
     }
     return getReserveParkingSpotMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ParkingServiceStub newStub(io.grpc.Channel channel) {
    return new ParkingServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ParkingServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new ParkingServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ParkingServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new ParkingServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class ParkingServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void findAvailableParking(com.smartcity.parking.ParkingRequest request,
        io.grpc.stub.StreamObserver<com.smartcity.parking.ParkingResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getFindAvailableParkingMethod(), responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<com.smartcity.parking.ReservationRequest> reserveParkingSpot(
        io.grpc.stub.StreamObserver<com.smartcity.parking.ReservationResponse> responseObserver) {
      return asyncUnimplementedStreamingCall(getReserveParkingSpotMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getFindAvailableParkingMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.smartcity.parking.ParkingRequest,
                com.smartcity.parking.ParkingResponse>(
                  this, METHODID_FIND_AVAILABLE_PARKING)))
          .addMethod(
            getReserveParkingSpotMethod(),
            asyncClientStreamingCall(
              new MethodHandlers<
                com.smartcity.parking.ReservationRequest,
                com.smartcity.parking.ReservationResponse>(
                  this, METHODID_RESERVE_PARKING_SPOT)))
          .build();
    }
  }

  /**
   */
  public static final class ParkingServiceStub extends io.grpc.stub.AbstractStub<ParkingServiceStub> {
    private ParkingServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ParkingServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ParkingServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ParkingServiceStub(channel, callOptions);
    }

    /**
     */
    public void findAvailableParking(com.smartcity.parking.ParkingRequest request,
        io.grpc.stub.StreamObserver<com.smartcity.parking.ParkingResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getFindAvailableParkingMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<com.smartcity.parking.ReservationRequest> reserveParkingSpot(
        io.grpc.stub.StreamObserver<com.smartcity.parking.ReservationResponse> responseObserver) {
      return asyncClientStreamingCall(
          getChannel().newCall(getReserveParkingSpotMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   */
  public static final class ParkingServiceBlockingStub extends io.grpc.stub.AbstractStub<ParkingServiceBlockingStub> {
    private ParkingServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ParkingServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ParkingServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ParkingServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.smartcity.parking.ParkingResponse findAvailableParking(com.smartcity.parking.ParkingRequest request) {
      return blockingUnaryCall(
          getChannel(), getFindAvailableParkingMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class ParkingServiceFutureStub extends io.grpc.stub.AbstractStub<ParkingServiceFutureStub> {
    private ParkingServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ParkingServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ParkingServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ParkingServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.smartcity.parking.ParkingResponse> findAvailableParking(
        com.smartcity.parking.ParkingRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getFindAvailableParkingMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_FIND_AVAILABLE_PARKING = 0;
  private static final int METHODID_RESERVE_PARKING_SPOT = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final ParkingServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(ParkingServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_FIND_AVAILABLE_PARKING:
          serviceImpl.findAvailableParking((com.smartcity.parking.ParkingRequest) request,
              (io.grpc.stub.StreamObserver<com.smartcity.parking.ParkingResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_RESERVE_PARKING_SPOT:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.reserveParkingSpot(
              (io.grpc.stub.StreamObserver<com.smartcity.parking.ReservationResponse>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class ParkingServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ParkingServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.smartcity.parking.Parking.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("ParkingService");
    }
  }

  private static final class ParkingServiceFileDescriptorSupplier
      extends ParkingServiceBaseDescriptorSupplier {
    ParkingServiceFileDescriptorSupplier() {}
  }

  private static final class ParkingServiceMethodDescriptorSupplier
      extends ParkingServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    ParkingServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (ParkingServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ParkingServiceFileDescriptorSupplier())
              .addMethod(getFindAvailableParkingMethod())
              .addMethod(getReserveParkingSpotMethod())
              .build();
        }
      }
    }
    return result;
  }
}
