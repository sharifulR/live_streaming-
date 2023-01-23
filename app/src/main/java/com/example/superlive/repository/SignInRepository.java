package com.example.superlive.repository;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import androidx.lifecycle.MutableLiveData;

import com.example.superlive.api.RetrofitInstance;
import com.example.superlive.api.UserService;
import com.example.superlive.models.LoginRequest;
import com.example.superlive.models.LoginResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignInRepository {

    @SuppressLint("StaticFieldLeak")
    public static SignInRepository signIn_repository;
    @SuppressLint("StaticFieldLeak")
    public static Context context;
    /*@SuppressLint("StaticFieldLeak")
    public static ProfileDataStore profileDataStore;*/
    public MutableLiveData<LoginRequest> LoginResponseLiveData;
    public MutableLiveData<Boolean> signin_progresss_showhide_status = new MutableLiveData<>();
    public MutableLiveData<Boolean> faceDetectUploadStatus = new MutableLiveData<>();

    public static SignInRepository getInstance(Context mContext) {
        context = mContext;
        if (signIn_repository == null) {
            signIn_repository = new SignInRepository();
        }
        return signIn_repository;
    }

    public MutableLiveData<LoginRequest> SignIn(String email, String password, String DeviceName, String deviceToken) {

        if (LoginResponseLiveData == null) {
            LoginResponseLiveData = new MutableLiveData<>();
        }

        //profileDataStore = new ProfileDataStore(context);
        signin_progresss_showhide_status.postValue(true);

        UserService apiServices = RetrofitInstance.getRetrofit().create(UserService.class);
        Call<LoginResponse> call = apiServices.userLogin(email, password, DeviceName, deviceToken);

        call.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {

                if (response.isSuccessful() && response.body().getData() != null) {

                    try {

                        String userPhone = response.body().getData().getMobile();
                        String userPassword = response.body().getData().getToken();
                        //profileDataStore.updateUserLogIngStatus(true);

                        /*profileDataStore.userAuthTokenNumberSave(response.body().getToken());
                        profileDataStore.profile_save_data((int) id, username, userEmail, userPhone);*/

                    } catch (Exception e) {
                    }

                    LoginResponseLiveData.postValue(response.body().getData());
                    signin_progresss_showhide_status.postValue(false);

                } else {
                    signin_progresss_showhide_status.postValue(false);
                    Toast.makeText(context, "user log in  failed", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {

                signin_progresss_showhide_status.postValue(false);
                Toast.makeText(context, "error" + t.getMessage().toString(), Toast.LENGTH_SHORT).show();
                Log.d("logInError", "----error---" + t.getMessage().toString());
            }
        });

        return LoginResponseLiveData;

    }

    /*public MutableLiveData<Boolean> FaceDetectWithWish(
            String useToken,
            String user_id,
            String mobile,
            String password) {

        faceDetectUploadStatus.postValue(true);

        UserService apiServices = RetrofitInstance.getRetrofit().create(UserService.class);
        Call<LoginResponse> call = apiServices.userLogin(
                useToken,
                user_id,
                mobile,
                password
        );

        call.enqueue(new Callback<FaceDetectResponse>() {
            @Override
            public void onResponse(Call<FaceDetectResponse> call,
                                   Response<FaceDetectResponse> response) {

                if (response.isSuccessful() && response.body().getData() != null) {
                    faceDetectUploadStatus.postValue(false);

                } else {
                    faceDetectUploadStatus.postValue(false);
                    Toast.makeText(context, "user log in  failed", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<FaceDetectResponse> call, Throwable t) {

                faceDetectUploadStatus.postValue(false);
            }
        });

        return faceDetectUploadStatus;

    }*/
}
