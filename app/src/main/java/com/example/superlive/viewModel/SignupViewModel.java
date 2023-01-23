package com.example.superlive.viewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.superlive.models.RegisterRequest;
import com.example.superlive.repository.SignupRepository;

public class SignupViewModel extends AndroidViewModel {

    private SignupRepository signup_repository;

    public SignupViewModel(@NonNull Application application, SignupRepository signup_repository) {
        super(application);
        this.signup_repository = signup_repository;
    }

    public MutableLiveData<RegisterRequest> signup(String name, String mobile, String password, String password_confirmation) {
        return signup_repository.Signup(name, mobile, password, password_confirmation);
    }

    public MutableLiveData<Boolean> getSignupLoadingProgressShowHideStatus() {
        return signup_repository.signupLoadingProgressShowHideStatus;

    }
}