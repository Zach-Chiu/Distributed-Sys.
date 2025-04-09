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

public class ApiKeyInterceptor implements ServerInterceptor {

    // ✅ 你可以自訂這裡的 API 金鑰
    private static final String VALID_API_KEY = "abc123";
    private static final String API_KEY_METADATA = "api-key";

    @Override
    public <ReqT, RespT> ServerCall.Listener<ReqT> interceptCall(
        ServerCall<ReqT, RespT> call,
        Metadata headers,
        ServerCallHandler<ReqT, RespT> next) {

        String apiKey = headers.get(Metadata.Key.of(API_KEY_METADATA, Metadata.ASCII_STRING_MARSHALLER));

        if (VALID_API_KEY.equals(apiKey)) {
            return next.startCall(call, headers); // 通過驗證
        } else {
            call.close(Status.UNAUTHENTICATED.withDescription("Invalid or missing API Key"), new Metadata());
            return new ServerCall.Listener<ReqT>() {}; // 拒絕請求
        }
    }
}

