package com.example.westudy;
import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

//1. Room will use these data to create a table in sqlite database
@Entity
public class AppointmentNote {
    @PrimaryKey(autoGenerate = true)
    public int mNoteID;

    public int mSlot;
    @NonNull
    public String mDate;
    @NonNull
    public int mCourse;
    public AppointmentNote(@NonNull String date, @NonNull int course, int slot) {
        this.mDate = date;
        this.mSlot = slot;
        this.mCourse = course;
    }
    public String getmDate(){return this.mDate;}
    public int getmCourse(){return this.mCourse;}
    public int getmSlot(){return this.mSlot;}
}
