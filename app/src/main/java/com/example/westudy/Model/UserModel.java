package com.example.westudy.Model;

import com.google.firebase.Timestamp;

import java.util.Arrays;
import java.util.List;

public class UserModel {
    private String username,email,userID;
    List<Integer> skillsProgress;
    private Timestamp createdTimeStamp;

    public UserModel() {
    }

    public UserModel(String username, String email, String userID, Timestamp createdTimeStamp) {
        this.username = username;
        this.email = email;
        this.userID = userID;
        this.skillsProgress =  Arrays.asList(0,0,0);
        this.createdTimeStamp = createdTimeStamp;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String name) {
        this.username = name;
    }

    public List<Integer> getSkillsProgress() {
        return skillsProgress;
    }

    public void setSkillsProgress(List<Integer> skillsProgress) {
        this.skillsProgress = skillsProgress;
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
