package com.example.westudy.Model;

import com.google.firebase.Timestamp;

public class UserModel {
    private String email;
    private Timestamp createdTimeStamp;

    public UserModel() {
    }
    public UserModel(String email, Timestamp createdTimeStamp) {
        this.email = email;
        this.createdTimeStamp = createdTimeStamp;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Timestamp getCreatedTimeStamp() {
        return createdTimeStamp;
    }

    public void setCreatedTimeStamp(Timestamp createdTimeStamp) {
        this.createdTimeStamp = createdTimeStamp;
    }
}
