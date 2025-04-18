/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.smartcity.server;

/**
 *
 * @author zachchiu
 */
import io.grpc.*;

// This class is a gRPC server interceptor used to check API keys for security.
public class ApiKeyInterceptor implements ServerInterceptor {
    
    // Set the correct (valid) API key that the client must use
    private static final String VALID_API_KEY = "abc123";
    
    // Define the header key name used to pass the API key from the client
    private static final String API_KEY_METADATA = "api-key";
    
    // This method will run every time a client calls a service method
    @Override
    public <ReqT, RespT> ServerCall.Listener<ReqT> interceptCall(   
        ServerCall<ReqT, RespT> call,               // Contains information about the RPC call
        Metadata headers,                           // Contains metadata from the client (including API key)
        ServerCallHandler<ReqT, RespT> next) {      // Handler for the next step in the call

        // Get the full name of the method being called
        String methodName = call.getMethodDescriptor().getFullMethodName();

        // Only check the API key if the method is "reserveParkingSpot"
        if (methodName.endsWith("reserveParkingSpot")) {
            // Read the API key sent by the client
            String apiKey = headers.get(Metadata.Key.of(API_KEY_METADATA, Metadata.ASCII_STRING_MARSHALLER));
            
            // If API key is wrong or missing, reject the request
            if (!VALID_API_KEY.equals(apiKey)) {
                // Return an error to the client (Unauthenticated)
                call.close(Status.UNAUTHENTICATED.withDescription("Invalid or missing API Key"), new Metadata());
                return new ServerCall.Listener<ReqT>() {};      // Return an empty listener (no action)
            }
        }

        // If everything is okay, or if the method is not protected, continue with the RPC call
        return next.startCall(call, headers);
    }
}
