package com.example.westudy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class SkillsPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.skills_main_page);
    }

    public void computerProgramming(View view){

        Intent i = new Intent(this, Skills_ComputerProgramming.class);
        startActivity(i);

    }
    public void dataAnalysis(View view){
        Intent i = new Intent(this, Skills_DataAnalysis.class);
        startActivity(i);

    }

    public void projectManagement(View view){
        Intent i = new Intent(this, Skills_ProjectManagement.class);
        startActivity(i);

    }
}