package com.example.westudy.Utils;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.westudy.Model.UserModel;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

public class AndroidUtil {

    public static void passUserModelAsIntent(Intent intent, UserModel model){
        intent.putExtra("username", model.getUsername());
        intent.putExtra("email",model.getEmail());
        intent.putExtra("userID",model.getUserID());
    }

    public static UserModel getUserModelAsIntent(Intent intent){
        UserModel model = new UserModel();
        model.setUsername(intent.getStringExtra("username"));
        model.setEmail(intent.getStringExtra("email"));
        model.setUserID(intent.getStringExtra("userID"));

        return model;
    }

    public static  void setProfilePic(Context context, Uri imageUri, ImageView imageView){
        Glide.with(context).load(imageUri).apply(RequestOptions.circleCropTransform()).into(imageView);
    }
}
