package com.example.westudy;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class skills_CP_Fragment extends Fragment {

    CheckBox cp1, cp2, cp3, cp4;

    SharedPreferences sharedPreferences;
    private static final String PREFS_NAME = "myPrefs";
    private static final String CHECKBOX_1_CP = "cp1";
    private static final String CHECKBOX_2_CP = "cp2";
    private static final String CHECKBOX_3_CP = "cp3";
    private static final String CHECKBOX_4_CP = "cp4";


//    FirebaseDatabase database;
//    DatabaseReference reference;
//    Member member;
//    int i = 0;

    public skills_CP_Fragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_skills__c_p_, container, false);

        WebView cp_vid1 = view.findViewById(R.id.cp_vid1);
        String cpvid1 = "<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/ifo76VyrBYo?si=FnjJiRkidjHBwQym\" title=\"YouTube video player\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" allowfullscreen></iframe>";
        cp_vid1.loadData(cpvid1, "text/html", "utf-8");
        cp_vid1.getSettings().setJavaScriptEnabled(true);
        cp_vid1.setWebChromeClient(new WebChromeClient());

        WebView cp_vid2 = view.findViewById(R.id.cp_vid2);
        String cpvid2 = "<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/M4d3FXu9-3I?si=1AGCff89ihhTkl3x\" title=\"YouTube video player\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" allowfullscreen></iframe>";
        cp_vid2.loadData(cpvid2, "text/html", "utf-8");
        cp_vid2.getSettings().setJavaScriptEnabled(true);
        cp_vid2.setWebChromeClient(new WebChromeClient());

        WebView cp_vid3 = view.findViewById(R.id.cp_vid3);
        String cpvid3 = "<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/pTB0EiLXUC8?si=sZ8it1LbaROhtzW2\" title=\"YouTube video player\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" allowfullscreen></iframe>";
        cp_vid3.loadData(cpvid3, "text/html", "utf-8");
        cp_vid3.getSettings().setJavaScriptEnabled(true);
        cp_vid3.setWebChromeClient(new WebChromeClient());

        WebView cp_vid4 = view.findViewById(R.id.cp_vid4);
        String cpvid4 = "<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/DuDz6B4cqVc?si=t6ZooBZdm6DFZAXN\" title=\"YouTube video player\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" allowfullscreen></iframe>";
        cp_vid4.loadData(cpvid4, "text/html", "utf-8");
        cp_vid4.getSettings().setJavaScriptEnabled(true);
        cp_vid4.setWebChromeClient(new WebChromeClient());

//        reference = database.getInstance().getReference().child("progress");
//        member = new Member();

        cp1 = view.findViewById(R.id.checkBox);
        cp2 = view.findViewById(R.id.checkBox2);
        cp3 = view.findViewById(R.id.checkBox3);
        cp4 = view.findViewById(R.id.checkBox4);

        sharedPreferences = getContext().getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        cp1.setChecked(sharedPreferences.getBoolean(CHECKBOX_1_CP, false));
        cp2.setChecked(sharedPreferences.getBoolean(CHECKBOX_2_CP, false));
        cp3.setChecked(sharedPreferences.getBoolean(CHECKBOX_3_CP, false));
        cp4.setChecked(sharedPreferences.getBoolean(CHECKBOX_4_CP, false));

        cp1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                editor.putBoolean(CHECKBOX_1_CP, isChecked);
                editor.apply();
            }
        });

        cp2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                editor.putBoolean(CHECKBOX_2_CP, isChecked);
                editor.apply();
            }
        });

        cp3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                editor.putBoolean(CHECKBOX_3_CP, isChecked);
                editor.apply();
            }
        });

        cp4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                editor.putBoolean(CHECKBOX_4_CP, isChecked);
                editor.apply();
            }
        });



//        reference.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot snapshot) {
//                if(snapshot.exists()){
//                    i = (int) snapshot.getChildrenCount();
//                }
//
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//
//            }
//        });



        return view;

    }
}