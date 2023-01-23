

package com.example.superlive.auth;


import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import com.example.superlive.R;
import com.example.superlive.databinding.ActivityOTPPhoneNumberBinding;
import com.example.superlive.models.OtpRequest;

import dagger.hilt.android.AndroidEntryPoint;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

@AndroidEntryPoint
public class OTPPhoneNumberActivity extends AppCompatActivity {

    private ActivityOTPPhoneNumberBinding binding;
    //private AuthViewModel authViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_o_t_p_phone_number);

       // authViewModel = new ViewModelProvider(this).get(AuthViewModel.class);

        /*binding.btnSendOTPCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (TextUtils.isEmpty(binding.userName.getText().toString()) || TextUtils.isEmpty(binding.etNumber.getText().toString()) || TextUtils.isEmpty(binding.etPass.getText().toString())){
                    Toast.makeText(OTPPhoneNumberActivity.this, "Required all field", Toast.LENGTH_SHORT).show();
                }else {
                    RegisterRequest registerRequest = new RegisterRequest();
                    registerRequest.setName(binding.userName.getText().toString());
                    registerRequest.setMobile(binding.etNumber.getText().toString());
                    registerRequest.setPassword(binding.etPass.getText().toString());

                    registerUser(registerRequest);

                    OtpRequest otpRequest=new OtpRequest();
                    otpRequest.setMobile(binding.etNumber.getText().toString());
                    otpSnd(otpRequest);

                }
            }
        });*/
        binding.loginTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(OTPPhoneNumberActivity.this, LoginActivity.class));
                finish();
            }
        });

    }
/*
    public void registerUser(RegisterRequest registerRequest){
       // Call<RegisterResponse> registerResponseCall= ApiClient.getUserService().signup(registerRequest);

        *//*registerResponseCall.enqueue(new Callback<RegisterResponse>() {
            @Override
            public void onResponse(Call<RegisterResponse> call, Response<RegisterResponse> response) {
                if (response.isSuccessful()){
                    Toast.makeText(OTPPhoneNumberActivity.this, "Register Successful", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(OTPPhoneNumberActivity.this, OTPCodeActivity.class));
                    finish();


                }else {
                    Toast.makeText(OTPPhoneNumberActivity.this, "An error occurred! Please try again...", Toast.LENGTH_SHORT).show();

                }
            }

            @Override
            public void onFailure(Call<RegisterResponse> call, Throwable t) {
                Toast.makeText(OTPPhoneNumberActivity.this, "Register failed!"+t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });*//*
    }*/

    public void otpSnd(OtpRequest otpRequest){
       // Call<OtpResponse> otpResponseCall= ApiClient.getUserService().otpSndResponse(otpRequest);
/*
        otpResponseCall.enqueue(new Callback<OtpResponse>() {
            @Override
            public void onResponse(Call<OtpResponse> call, Response<OtpResponse> response) {
                if (response.isSuccessful()){

                    Toast.makeText(OTPPhoneNumberActivity.this, "OTP send successful", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(OTPPhoneNumberActivity.this, OTPCodeActivity.class));
                    finish();


                }else {
                    Toast.makeText(OTPPhoneNumberActivity.this, "Otp not send! Please try again...", Toast.LENGTH_SHORT).show();

                }
            }

            @Override
            public void onFailure(Call<OtpResponse> call, Throwable t) {
                Toast.makeText(OTPPhoneNumberActivity.this, "Register failed!"+t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });*/
    }



}
