package com.example.superlive.auth;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import com.example.superlive.R;
import com.example.superlive.databinding.ActivityLoginBinding;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {
    private ActivityLoginBinding binding;

    String token;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_login);

        binding.signUpTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this,OTPPhoneNumberActivity.class));
                finish();
            }
        });
        /*binding.loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (TextUtils.isEmpty(binding.etNumber.getText().toString()) || TextUtils.isEmpty(binding.etPass.getText().toString())){
                    Toast.makeText(LoginActivity.this, "Required all field", Toast.LENGTH_SHORT).show();
                }else {
                    LoginRequest loginRequest = new LoginRequest();
                    loginRequest.setMobile(binding.etNumber.getText().toString());
                    loginRequest.setPassword(binding.etPass.getText().toString());

                    loginUser(loginRequest);
                }
            }
        });*/
    }

    /*public void loginUser(LoginRequest loginRequest){

        Call<LoginRequest> loginResponseCall= ApiClient.getUserService().loginResponse(loginRequest);
        loginResponseCall.enqueue(new Callback<LoginRequest>() {
            @Override
            public void onResponse(Call<LoginRequest> call, Response<LoginRequest> response) {
                if (response.isSuccessful()){
                    //token=response.body().g


                }else {
                    Toast.makeText(LoginActivity.this, "An error occurred! Please try again...", Toast.LENGTH_SHORT).show();

                }
            }

            @Override
            public void onFailure(Call<LoginRequest> call, Throwable t) {

            }
        });

    }*/

    /*private void getAuthToken(){
        Call<LoginResponse> loginResponseCall= ApiClient.getUserService().loginResponse();

        loginResponseCall.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                if (response.isSuccessful()){
                    token=response.body().getToken();
                    LoginResponse loginResponse=response.body();
                    startActivity(new Intent(LoginActivity.this, HomeActivity.class).putExtra("data",loginResponse));
                    finish();


                }else {
                    Toast.makeText(LoginActivity.this, "An error occurred! Please try again...", Toast.LENGTH_SHORT).show();

                }
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                Toast.makeText(LoginActivity.this, "Register failed!"+t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }*/
}