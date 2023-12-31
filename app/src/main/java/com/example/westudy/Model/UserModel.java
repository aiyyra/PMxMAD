package com.example.westudy.Model;

import com.google.firebase.Timestamp;

public class UserModel {
    private String email,userID;
    private Timestamp createdTimeStamp;

    public UserModel() {
    }
    public UserModel(String email, Timestamp createdTimeStamp,String userID) {
        this.email = email;
        this.createdTimeStamp = createdTimeStamp;
        this.userID = userID;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public Timestamp getCreatedTimeStamp() {
        return createdTimeStamp;
    }

    public void setCreatedTimeStamp(Timestamp createdTimeStamp) {
        this.createdTimeStamp = createdTimeStamp;
    }
}
