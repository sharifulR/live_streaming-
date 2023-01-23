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
import android.view.WindowManager;
import android.widget.Toast;

import com.example.superlive.R;
import com.example.superlive.databinding.FragmentSignupBinding;
import com.example.superlive.internetCheck.NetworkCheck;
import com.example.superlive.view.HomeActivity;
import com.example.superlive.viewModel.SignupViewModel;

public class SignupFragment extends Fragment {

    private FragmentSignupBinding binding;

    public SignupViewModel signup_viewmodel;

    private String name, mobile, password,confPassword;

    private ProgressDialog progressDialog;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding= FragmentSignupBinding.inflate(inflater,container,false);

        getActivity().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);


        progressDialog = new ProgressDialog(getContext());
        progressDialog.setTitle("Registration");
        progressDialog.setMessage("please wait for Registration..");
        progressDialog.setCanceledOnTouchOutside(false);


        signup_viewmodel = new ViewModelProvider(this).get(SignupViewModel.class);

        binding.loginTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction().replace(R.id.mainFrameLayout, new SigninFragment());
                fragmentTransaction.commit();
            }
        });

        signup_viewmodel.getSignupLoadingProgressShowHideStatus()
                .observe(getViewLifecycleOwner(), new Observer<Boolean>() {
                    @Override
                    public void onChanged(Boolean aBoolean) {
                        if (aBoolean) {
                            progressDialog.show();

                        } else {
                            progressDialog.dismiss();
                        }
                    }
                });


        binding.btnSendOTPCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



            }
        });

        return binding.getRoot();
    }
}