package com.smartcity.airquality;

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
    comments = "Source: airquality.proto")
public final class AirQualityServiceGrpc {

  private AirQualityServiceGrpc() {}

  public static final String SERVICE_NAME = "smartcity.airquality.AirQualityService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.smartcity.airquality.AirQualityRequest,
      com.smartcity.airquality.PollutionResponse> getMonitorAirQualityMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "MonitorAirQuality",
      requestType = com.smartcity.airquality.AirQualityRequest.class,
      responseType = com.smartcity.airquality.PollutionResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<com.smartcity.airquality.AirQualityRequest,
      com.smartcity.airquality.PollutionResponse> getMonitorAirQualityMethod() {
    io.grpc.MethodDescriptor<com.smartcity.airquality.AirQualityRequest, com.smartcity.airquality.PollutionResponse> getMonitorAirQualityMethod;
    if ((getMonitorAirQualityMethod = AirQualityServiceGrpc.getMonitorAirQualityMethod) == null) {
      synchronized (AirQualityServiceGrpc.class) {
        if ((getMonitorAirQualityMethod = AirQualityServiceGrpc.getMonitorAirQualityMethod) == null) {
          AirQualityServiceGrpc.getMonitorAirQualityMethod = getMonitorAirQualityMethod = 
              io.grpc.MethodDescriptor.<com.smartcity.airquality.AirQualityRequest, com.smartcity.airquality.PollutionResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "smartcity.airquality.AirQualityService", "MonitorAirQuality"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.smartcity.airquality.AirQualityRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.smartcity.airquality.PollutionResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new AirQualityServiceMethodDescriptorSupplier("MonitorAirQuality"))
                  .build();
          }
        }
     }
     return getMonitorAirQualityMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.smartcity.airquality.AlertRequest,
      com.smartcity.airquality.AlertResponse> getAlertAuthoritiesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "AlertAuthorities",
      requestType = com.smartcity.airquality.AlertRequest.class,
      responseType = com.smartcity.airquality.AlertResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
  public static io.grpc.MethodDescriptor<com.smartcity.airquality.AlertRequest,
      com.smartcity.airquality.AlertResponse> getAlertAuthoritiesMethod() {
    io.grpc.MethodDescriptor<com.smartcity.airquality.AlertRequest, com.smartcity.airquality.AlertResponse> getAlertAuthoritiesMethod;
    if ((getAlertAuthoritiesMethod = AirQualityServiceGrpc.getAlertAuthoritiesMethod) == null) {
      synchronized (AirQualityServiceGrpc.class) {
        if ((getAlertAuthoritiesMethod = AirQualityServiceGrpc.getAlertAuthoritiesMethod) == null) {
          AirQualityServiceGrpc.getAlertAuthoritiesMethod = getAlertAuthoritiesMethod = 
              io.grpc.MethodDescriptor.<com.smartcity.airquality.AlertRequest, com.smartcity.airquality.AlertResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "smartcity.airquality.AirQualityService", "AlertAuthorities"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.smartcity.airquality.AlertRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.smartcity.airquality.AlertResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new AirQualityServiceMethodDescriptorSupplier("AlertAuthorities"))
                  .build();
          }
        }
     }
     return getAlertAuthoritiesMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static AirQualityServiceStub newStub(io.grpc.Channel channel) {
    return new AirQualityServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static AirQualityServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new AirQualityServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static AirQualityServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new AirQualityServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class AirQualityServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void monitorAirQuality(com.smartcity.airquality.AirQualityRequest request,
        io.grpc.stub.StreamObserver<com.smartcity.airquality.PollutionResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getMonitorAirQualityMethod(), responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<com.smartcity.airquality.AlertRequest> alertAuthorities(
        io.grpc.stub.StreamObserver<com.smartcity.airquality.AlertResponse> responseObserver) {
      return asyncUnimplementedStreamingCall(getAlertAuthoritiesMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getMonitorAirQualityMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                com.smartcity.airquality.AirQualityRequest,
                com.smartcity.airquality.PollutionResponse>(
                  this, METHODID_MONITOR_AIR_QUALITY)))
          .addMethod(
            getAlertAuthoritiesMethod(),
            asyncClientStreamingCall(
              new MethodHandlers<
                com.smartcity.airquality.AlertRequest,
                com.smartcity.airquality.AlertResponse>(
                  this, METHODID_ALERT_AUTHORITIES)))
          .build();
    }
  }

  /**
   */
  public static final class AirQualityServiceStub extends io.grpc.stub.AbstractStub<AirQualityServiceStub> {
    private AirQualityServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private AirQualityServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AirQualityServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new AirQualityServiceStub(channel, callOptions);
    }

    /**
     */
    public void monitorAirQuality(com.smartcity.airquality.AirQualityRequest request,
        io.grpc.stub.StreamObserver<com.smartcity.airquality.PollutionResponse> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getMonitorAirQualityMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<com.smartcity.airquality.AlertRequest> alertAuthorities(
        io.grpc.stub.StreamObserver<com.smartcity.airquality.AlertResponse> responseObserver) {
      return asyncClientStreamingCall(
          getChannel().newCall(getAlertAuthoritiesMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   */
  public static final class AirQualityServiceBlockingStub extends io.grpc.stub.AbstractStub<AirQualityServiceBlockingStub> {
    private AirQualityServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private AirQualityServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AirQualityServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new AirQualityServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public java.util.Iterator<com.smartcity.airquality.PollutionResponse> monitorAirQuality(
        com.smartcity.airquality.AirQualityRequest request) {
      return blockingServerStreamingCall(
          getChannel(), getMonitorAirQualityMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class AirQualityServiceFutureStub extends io.grpc.stub.AbstractStub<AirQualityServiceFutureStub> {
    private AirQualityServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private AirQualityServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AirQualityServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new AirQualityServiceFutureStub(channel, callOptions);
    }
  }

  private static final int METHODID_MONITOR_AIR_QUALITY = 0;
  private static final int METHODID_ALERT_AUTHORITIES = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AirQualityServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(AirQualityServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_MONITOR_AIR_QUALITY:
          serviceImpl.monitorAirQuality((com.smartcity.airquality.AirQualityRequest) request,
              (io.grpc.stub.StreamObserver<com.smartcity.airquality.PollutionResponse>) responseObserver);
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
        case METHODID_ALERT_AUTHORITIES:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.alertAuthorities(
              (io.grpc.stub.StreamObserver<com.smartcity.airquality.AlertResponse>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class AirQualityServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    AirQualityServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.smartcity.airquality.Airquality.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("AirQualityService");
    }
  }

  private static final class AirQualityServiceFileDescriptorSupplier
      extends AirQualityServiceBaseDescriptorSupplier {
    AirQualityServiceFileDescriptorSupplier() {}
  }

  private static final class AirQualityServiceMethodDescriptorSupplier
      extends AirQualityServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    AirQualityServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (AirQualityServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new AirQualityServiceFileDescriptorSupplier())
              .addMethod(getMonitorAirQualityMethod())
              .addMethod(getAlertAuthoritiesMethod())
              .build();
        }
      }
    }
    return result;
  }
}
