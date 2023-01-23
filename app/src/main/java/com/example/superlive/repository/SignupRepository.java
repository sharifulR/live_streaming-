package com.example.superlive.repository;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import androidx.lifecycle.MutableLiveData;

import com.example.superlive.api.RetrofitInstance;
import com.example.superlive.api.UserService;
import com.example.superlive.models.RegisterRequest;
import com.example.superlive.models.RegisterResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignupRepository {

    public static SignupRepository signup_repository;
    public static Context context;
    //public ProfileDataStore profile_data_store;
    public MutableLiveData<RegisterRequest> signupStatusMutableLiveData;
    public MutableLiveData<String> profile_update_status_livedata;
    public MutableLiveData<Boolean> signupLoadingProgressShowHideStatus = new MutableLiveData<>();

    public static SignupRepository getInstance(Context mContext) {
        context = mContext;
        if (signup_repository == null) {
            signup_repository = new SignupRepository();
        }

        return signup_repository;
    }

    public MutableLiveData<RegisterRequest> Signup(String name, String email, String mobile, String password) {

        signupLoadingProgressShowHideStatus.postValue(true);
        if (signupStatusMutableLiveData == null) {
            signupStatusMutableLiveData = new MutableLiveData<>();
        }
        UserService apiServices = RetrofitInstance.getRetrofit().create(UserService.class);
        Call<RegisterResponse> call = apiServices.userSignup(name, email, mobile, password, password);

        call.enqueue(new Callback<RegisterResponse>() {
            @Override
            public void onResponse(Call<RegisterResponse> call, Response<RegisterResponse> response) {
                if (response.isSuccessful() && response.body().getSuccess()) {
                    signupLoadingProgressShowHideStatus.postValue(false);
                    signupStatusMutableLiveData.postValue(response.body().getData());

                } else {
                    signupLoadingProgressShowHideStatus.postValue(false);
                    Toast.makeText(context, "user already exists", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<RegisterResponse> call, Throwable t) {
                signupLoadingProgressShowHideStatus.postValue(false);
                Toast.makeText(context, "user registration fail" + t.getMessage().toString(), Toast.LENGTH_SHORT).show();
                Log.d("error", t.getMessage().toString());
            }
        });

        return signupStatusMutableLiveData;


    }
}
