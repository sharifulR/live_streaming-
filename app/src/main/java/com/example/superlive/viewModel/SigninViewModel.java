package com.example.superlive.viewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.superlive.models.LoginRequest;
import com.example.superlive.repository.SignInRepository;

public class SigninViewModel extends AndroidViewModel {

    private SignInRepository signIn_repository;

    public MutableLiveData<String> profileid_livedata;

    public SigninViewModel(@NonNull Application application) {
        super(application);

        signIn_repository = SignInRepository.getInstance(application);

    }


    public MutableLiveData<LoginRequest> logIn(String mobile, String password, String DeviceName, String deviceToken) {
        return signIn_repository.SignIn(mobile, password, DeviceName, deviceToken);

    }

    /*public MutableLiveData<Boolean> FaceDetectWithWish(
            String useToken,
            String product_id,
            String user_id,
            String photo,
            String mobile) {
        return signIn_repository.FaceDetectWithWish(
                useToken,
                product_id,
                user_id,
                photo,
                mobile);
    }*/


    /*public MutableLiveData<Boolean> getsigninprogresshideshow_status() {
        return signIn_repository.signin_progresss_showhide_status;
    }

    public MutableLiveData<Boolean> getFaceDetectUploadStatus() {
        return signIn_repository.faceDetectUploadStatus;
    }*/


}