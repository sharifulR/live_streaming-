package com.example.superlive.auth;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.superlive.R;
import com.example.superlive.api.RetrofitInstance;
import com.example.superlive.api.UserService;
import com.example.superlive.databinding.ActivityOTPCodeBinding;
import com.example.superlive.models.OtpResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class OTPCodeActivity extends AppCompatActivity {
    private ActivityOTPCodeBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_o_t_p_code);

        binding.btnOTPCodeSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               /* startActivity(new Intent(OTPCodeActivity.this, HomeActivity.class));
                finish();*/

               UserService userService =  RetrofitInstance.getRetrofit().create(UserService.class);

               String token = "Bearer "+"29|PLbFX8GQ38YMzlRxujaSYkPB0fhvSUrpuc8Cyxzy";

               Call<OtpResponse> call = userService.sendOtp(
                       token,
                       "",
                       "",
                       "",
                       ""
               );

               call.enqueue(new Callback<OtpResponse>() {
                   @Override
                   public void onResponse(Call<OtpResponse> call, Response<OtpResponse> response) {
                       if (response.isSuccessful()){
                           //Success
                       }
                   }

                   @Override
                   public void onFailure(Call<OtpResponse> call, Throwable t) {

                   }
               });

            }
        });


    }

}