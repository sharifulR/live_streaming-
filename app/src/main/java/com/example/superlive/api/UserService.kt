package com.example.superlive.api

import com.example.superlive.models.LoginResponse
import com.example.superlive.models.OtpResponse
import com.example.superlive.models.RegisterResponse
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.Header
import retrofit2.http.POST

interface UserService {

    //Registration LogInData System-------------------
    @FormUrlEncoded
    @POST("register")
    fun userSignup(
        @Field("name") name: String?,
        @Field("mobile") mobile_no: String?,
        @Field("password") password: String?,
        @Field("password_confirmation") passwordConfirmation: String?
    ): Call<RegisterResponse?>?

    @FormUrlEncoded
    @POST("login")
    fun userLogin(
        @Field("mobile") email: String?,
        @Field("password") password: String?,
        @Field("device_name") DeviceName: String?,
        @Field("android_token") deviceToken: String?
    ): Call<LoginResponse?>?


    @FormUrlEncoded
    @POST("user/send-otp")
    fun sendOtp(
        @Header("Authorization") authToken:String,
        @Field("name") name: String?,
        @Field("mobile") mobile_no: String?,
        @Field("password") password: String?,
        @Field("password_confirmation") passwordConfirmation: String?
    ): Call<OtpResponse?>?

}