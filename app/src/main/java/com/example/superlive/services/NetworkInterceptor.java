package com.example.superlive.services;

import androidx.annotation.NonNull;

import com.example.superlive.models.LoginResponse;
import com.example.superlive.preferance.StoreData;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class NetworkInterceptor implements Interceptor {
    private static LoginResponse loginResponse=new LoginResponse();
    //StoreData storeData=new StoreData();

    @NonNull
    @Override
    public Response intercept(@NonNull Chain chain) throws IOException {
        Request newRequest=chain.request().newBuilder()
                .header("Authorization", ""/*storeData.getToken()*/)
                .build();
        return chain.proceed(newRequest);
    }

}
