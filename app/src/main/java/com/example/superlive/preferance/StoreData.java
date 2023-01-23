package com.example.superlive.preferance;

import static android.content.Context.MODE_PRIVATE;

import android.content.Context;
import android.content.SharedPreferences;

public class StoreData {

    private Context context;
    private SharedPreferences sharedPreferences;

    public StoreData(Context context, SharedPreferences sharedPreferences) {
        this.context = context;
        this.sharedPreferences = sharedPreferences;
    }

    public void saveToken(String token) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("UserAuthTokenNumber", token);
        editor.apply();
    }

    public String getToken(){
        return sharedPreferences.getString("UserAuthTokenNumber", "");
    }
}
