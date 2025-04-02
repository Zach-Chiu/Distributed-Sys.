package com.smartcity.emergency;

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
    comments = "Source: emergency.proto")
public final class EmergencyServiceGrpc {

  private EmergencyServiceGrpc() {}

  public static final String SERVICE_NAME = "smartcity.emergency.EmergencyService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.smartcity.emergency.AccidentReport,
      com.smartcity.emergency.EmergencyUpdate> getReportAccidentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ReportAccident",
      requestType = com.smartcity.emergency.AccidentReport.class,
      responseType = com.smartcity.emergency.EmergencyUpdate.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<com.smartcity.emergency.AccidentReport,
      com.smartcity.emergency.EmergencyUpdate> getReportAccidentMethod() {
    io.grpc.MethodDescriptor<com.smartcity.emergency.AccidentReport, com.smartcity.emergency.EmergencyUpdate> getReportAccidentMethod;
    if ((getReportAccidentMethod = EmergencyServiceGrpc.getReportAccidentMethod) == null) {
      synchronized (EmergencyServiceGrpc.class) {
        if ((getReportAccidentMethod = EmergencyServiceGrpc.getReportAccidentMethod) == null) {
          EmergencyServiceGrpc.getReportAccidentMethod = getReportAccidentMethod = 
              io.grpc.MethodDescriptor.<com.smartcity.emergency.AccidentReport, com.smartcity.emergency.EmergencyUpdate>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "smartcity.emergency.EmergencyService", "ReportAccident"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.smartcity.emergency.AccidentReport.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.smartcity.emergency.EmergencyUpdate.getDefaultInstance()))
                  .setSchemaDescriptor(new EmergencyServiceMethodDescriptorSupplier("ReportAccident"))
                  .build();
          }
        }
     }
     return getReportAccidentMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.smartcity.emergency.EmergencyRequest,
      com.smartcity.emergency.EmergencyUpdate> getNotifyEmergencyTeamsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "NotifyEmergencyTeams",
      requestType = com.smartcity.emergency.EmergencyRequest.class,
      responseType = com.smartcity.emergency.EmergencyUpdate.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<com.smartcity.emergency.EmergencyRequest,
      com.smartcity.emergency.EmergencyUpdate> getNotifyEmergencyTeamsMethod() {
    io.grpc.MethodDescriptor<com.smartcity.emergency.EmergencyRequest, com.smartcity.emergency.EmergencyUpdate> getNotifyEmergencyTeamsMethod;
    if ((getNotifyEmergencyTeamsMethod = EmergencyServiceGrpc.getNotifyEmergencyTeamsMethod) == null) {
      synchronized (EmergencyServiceGrpc.class) {
        if ((getNotifyEmergencyTeamsMethod = EmergencyServiceGrpc.getNotifyEmergencyTeamsMethod) == null) {
          EmergencyServiceGrpc.getNotifyEmergencyTeamsMethod = getNotifyEmergencyTeamsMethod = 
              io.grpc.MethodDescriptor.<com.smartcity.emergency.EmergencyRequest, com.smartcity.emergency.EmergencyUpdate>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "smartcity.emergency.EmergencyService", "NotifyEmergencyTeams"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.smartcity.emergency.EmergencyRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.smartcity.emergency.EmergencyUpdate.getDefaultInstance()))
                  .setSchemaDescriptor(new EmergencyServiceMethodDescriptorSupplier("NotifyEmergencyTeams"))
                  .build();
          }
        }
     }
     return getNotifyEmergencyTeamsMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static EmergencyServiceStub newStub(io.grpc.Channel channel) {
    return new EmergencyServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static EmergencyServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new EmergencyServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static EmergencyServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new EmergencyServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class EmergencyServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public io.grpc.stub.StreamObserver<com.smartcity.emergency.AccidentReport> reportAccident(
        io.grpc.stub.StreamObserver<com.smartcity.emergency.EmergencyUpdate> responseObserver) {
      return asyncUnimplementedStreamingCall(getReportAccidentMethod(), responseObserver);
    }

    /**
     */
    public void notifyEmergencyTeams(com.smartcity.emergency.EmergencyRequest request,
        io.grpc.stub.StreamObserver<com.smartcity.emergency.EmergencyUpdate> responseObserver) {
      asyncUnimplementedUnaryCall(getNotifyEmergencyTeamsMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getReportAccidentMethod(),
            asyncBidiStreamingCall(
              new MethodHandlers<
                com.smartcity.emergency.AccidentReport,
                com.smartcity.emergency.EmergencyUpdate>(
                  this, METHODID_REPORT_ACCIDENT)))
          .addMethod(
            getNotifyEmergencyTeamsMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                com.smartcity.emergency.EmergencyRequest,
                com.smartcity.emergency.EmergencyUpdate>(
                  this, METHODID_NOTIFY_EMERGENCY_TEAMS)))
          .build();
    }
  }

  /**
   */
  public static final class EmergencyServiceStub extends io.grpc.stub.AbstractStub<EmergencyServiceStub> {
    private EmergencyServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private EmergencyServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected EmergencyServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new EmergencyServiceStub(channel, callOptions);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<com.smartcity.emergency.AccidentReport> reportAccident(
        io.grpc.stub.StreamObserver<com.smartcity.emergency.EmergencyUpdate> responseObserver) {
      return asyncBidiStreamingCall(
          getChannel().newCall(getReportAccidentMethod(), getCallOptions()), responseObserver);
    }

    /**
     */
    public void notifyEmergencyTeams(com.smartcity.emergency.EmergencyRequest request,
        io.grpc.stub.StreamObserver<com.smartcity.emergency.EmergencyUpdate> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getNotifyEmergencyTeamsMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class EmergencyServiceBlockingStub extends io.grpc.stub.AbstractStub<EmergencyServiceBlockingStub> {
    private EmergencyServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private EmergencyServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected EmergencyServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new EmergencyServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public java.util.Iterator<com.smartcity.emergency.EmergencyUpdate> notifyEmergencyTeams(
        com.smartcity.emergency.EmergencyRequest request) {
      return blockingServerStreamingCall(
          getChannel(), getNotifyEmergencyTeamsMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class EmergencyServiceFutureStub extends io.grpc.stub.AbstractStub<EmergencyServiceFutureStub> {
    private EmergencyServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private EmergencyServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected EmergencyServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new EmergencyServiceFutureStub(channel, callOptions);
    }
  }

  private static final int METHODID_NOTIFY_EMERGENCY_TEAMS = 0;
  private static final int METHODID_REPORT_ACCIDENT = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final EmergencyServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(EmergencyServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_NOTIFY_EMERGENCY_TEAMS:
          serviceImpl.notifyEmergencyTeams((com.smartcity.emergency.EmergencyRequest) request,
              (io.grpc.stub.StreamObserver<com.smartcity.emergency.EmergencyUpdate>) responseObserver);
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
        case METHODID_REPORT_ACCIDENT:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.reportAccident(
              (io.grpc.stub.StreamObserver<com.smartcity.emergency.EmergencyUpdate>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class EmergencyServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    EmergencyServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.smartcity.emergency.Emergency.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("EmergencyService");
    }
  }

  private static final class EmergencyServiceFileDescriptorSupplier
      extends EmergencyServiceBaseDescriptorSupplier {
    EmergencyServiceFileDescriptorSupplier() {}
  }

  private static final class EmergencyServiceMethodDescriptorSupplier
      extends EmergencyServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    EmergencyServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (EmergencyServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new EmergencyServiceFileDescriptorSupplier())
              .addMethod(getReportAccidentMethod())
              .addMethod(getNotifyEmergencyTeamsMethod())
              .build();
        }
      }
    }
    return result;
  }
}
