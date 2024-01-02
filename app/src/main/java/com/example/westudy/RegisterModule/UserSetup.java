package com.example.westudy.RegisterModule;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.westudy.MainPage;
import com.example.westudy.Model.UserModel;
import com.example.westudy.R;
import com.example.westudy.Utils.FirebaseUtil;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.Timestamp;

public class UserSetup extends AppCompatActivity {

    EditText ETUsername;
    Button BtnConfirmDetails;
    UserModel userModel;

    String Username,email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_setup);

        ETUsername = findViewById(R.id.ETUsername);
        BtnConfirmDetails = findViewById(R.id.BtnConfirmDetails);

        Username = ETUsername.getText().toString();
        email = getIntent().getStringExtra("email");

        BtnConfirmDetails.setOnClickListener(v -> {
            Username = ETUsername.getText().toString();
            email = getIntent().getStringExtra("email");
            setUser();

        });

    }
    public void setUser() {
        if(userModel==null){
            userModel = new UserModel(Username, email, FirebaseUtil.currentUserID(), Timestamp.now());
        }
        FirebaseUtil.currentUserDetails().set(userModel).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()){
                    login();
                }
            }
        });
    }

    public void login(){
        Toast.makeText(getApplicationContext(),"Login Successfully",Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(getApplicationContext(), MainPage.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }
}