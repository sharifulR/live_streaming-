package com.example.superlive.auth;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.superlive.R;
import com.example.superlive.databinding.FragmentSigninBinding;
import com.example.superlive.databinding.FragmentSignupBinding;
import com.example.superlive.internetCheck.NetworkCheck;
import com.example.superlive.models.LoginRequest;
import com.example.superlive.utils.Constants;
import com.example.superlive.view.HomeActivity;
import com.example.superlive.viewModel.SigninViewModel;


public class SigninFragment extends Fragment {

    private FragmentSigninBinding binding;

    private SigninViewModel signInViewModel;
    private String mobile, password;
    private ProgressDialog progressDialog;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding=FragmentSigninBinding.inflate(inflater, container, false);

        signInViewModel = new ViewModelProvider(getActivity()).get(SigninViewModel.class);
       /* profileDataStore = new ProfileDataStore(getContext());*/


        progressDialog = new ProgressDialog(getContext());
        progressDialog.setTitle("LogIn");
        progressDialog.setMessage("please wait Log In..");
        progressDialog.setCanceledOnTouchOutside(false);

        binding.loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                /*if (NetworkCheck.isConnect(getContext())){*/
                    if (validateNumber()) {
                        mobile = binding.etNumber.getText().toString().trim();
                    }
                    if (validatePassword()) {
                        password = binding.etPass.getText().toString().trim();
                    }
                    if (!TextUtils.isEmpty(mobile) && !TextUtils.isEmpty(password) && Constants.DeviceToken != null) {

                        signInViewModel.logIn(mobile, password, "Test", Constants.DeviceToken)
                                .observe(getViewLifecycleOwner(), new Observer<LoginRequest>() {
                                    @Override
                                    public void onChanged(LoginRequest logInData) {
                                        if (logInData != null) {
                                            Intent intent = new Intent(getContext(), HomeActivity.class);
                                            startActivity(intent);
                                        }
                                    }
                                });

                    } else {
                        Toast.makeText(getContext(), "check this field ", Toast.LENGTH_SHORT).show();
                    }
               /* }else {
                    Toast.makeText(getContext(), "Please check your internet connection.", Toast.LENGTH_SHORT).show();
                }*/


            }
        });


        binding.signUpTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.mainFrameLayout, new SignupFragment());
                fragmentTransaction.commit();
            }
        });

        return binding.getRoot();
    }

    private boolean validateNumber() {
        String passwordInput = binding.etNumber.getText().toString().trim();

        if (passwordInput.isEmpty()) {
            binding.etNumber.setError("Field can't be empty");
            return false;
        } else {
            binding.etNumber.setError(null);
            return true;
        }
    }

    private boolean validatePassword() {
        String passwordInput = binding.etPass.getText().toString().trim();

        if (passwordInput.isEmpty()) {
            binding.etPass.setError("Field can't be empty");
            return false;
        } else {
            binding.etPass.setError(null);
            return true;
        }
    }
}