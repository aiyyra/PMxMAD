package com.example.westudy.Utils;

import android.content.Intent;

import com.example.westudy.Model.UserModel;

public class AndroidUtil {

    public static void passUserModelAsIntent(Intent intent, UserModel model){
        intent.putExtra("email",model.getEmail());
        intent.putExtra("userID",model.getUserID());
    }

    public static UserModel getUserModelAsIntent(Intent intent){
        UserModel model = new UserModel();
        model.setEmail(intent.getStringExtra("email"));
        model.setUserID(intent.getStringExtra("userID"));

        return model;
    }
}
