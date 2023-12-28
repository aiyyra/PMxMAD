package com.example.westudy;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.CheckBox;
import android.widget.CompoundButton;

public class skills_DA_Fragment extends Fragment {

    CheckBox da1,da2,da3,da4;
    private SharedViewModel sharedViewModel;

    SharedPreferences sharedPreferences;
    private static final String PREFS_NAME = "myPrefs";
    private static final String CHECKBOX_1_DA = "da1";
    private static final String CHECKBOX_2_DA = "da2";
    private static final String CHECKBOX_3_DA = "da3";
    private static final String CHECKBOX_4_DA = "da4";


    public skills_DA_Fragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sharedViewModel = new ViewModelProvider(requireActivity()).get(SharedViewModel.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_skills__d_a_, container, false);

        WebView cp_vid1 = view.findViewById(R.id.cp_vid1);
        String cpvid1 = "<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/lgCNTuLBMK4?si=4JEeLUSo4ciD5v9D\" title=\"YouTube video player\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" allowfullscreen></iframe>";
        cp_vid1.loadData(cpvid1,"text/html", "utf-8");
        cp_vid1.getSettings().setJavaScriptEnabled(true);
        cp_vid1.setWebChromeClient(new WebChromeClient());

        WebView cp_vid2 = view.findViewById(R.id.cp_vid2);
        String cpvid2 = "<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/qWEHO8b6WbA?si=zOsyHNPtZPYFZ3Va\" title=\"YouTube video player\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" allowfullscreen></iframe>";
        cp_vid2.loadData(cpvid2,"text/html", "utf-8");
        cp_vid2.getSettings().setJavaScriptEnabled(true);
        cp_vid2.setWebChromeClient(new WebChromeClient());

        WebView cp_vid3 = view.findViewById(R.id.cp_vid3);
        String cpvid3 = "<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/GLneLGYZgnA?si=8wmp3B4gDzLYyorW\" title=\"YouTube video player\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" allowfullscreen></iframe>";
        cp_vid3.loadData(cpvid3,"text/html", "utf-8");
        cp_vid3.getSettings().setJavaScriptEnabled(true);
        cp_vid3.setWebChromeClient(new WebChromeClient());

        WebView cp_vid4 = view.findViewById(R.id.cp_vid4);
        String cpvid4 = "<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/r-uOLxNrNk8?si=Y8RugwqS2S2Cyxk8\" title=\"YouTube video player\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" allowfullscreen></iframe>";
        cp_vid4.loadData(cpvid4,"text/html", "utf-8");
        cp_vid4.getSettings().setJavaScriptEnabled(true);
        cp_vid4.setWebChromeClient(new WebChromeClient());

        da1 = view.findViewById(R.id.checkBox);
        da2 = view.findViewById(R.id.checkBox2);
        da3 = view.findViewById(R.id.checkBox3);
        da4 = view.findViewById(R.id.checkBox4);

        sharedPreferences = getContext().getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        da1.setChecked(sharedPreferences.getBoolean(CHECKBOX_1_DA, false));
        da2.setChecked(sharedPreferences.getBoolean(CHECKBOX_2_DA, false));
        da3.setChecked(sharedPreferences.getBoolean(CHECKBOX_3_DA, false));
        da4.setChecked(sharedPreferences.getBoolean(CHECKBOX_4_DA, false));

        setupCheckBoxListeners(editor);

        return view;
    }

    private void setupCheckBoxListeners(SharedPreferences.Editor editor) {
        da1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                editor.putBoolean(CHECKBOX_1_DA, isChecked);
                editor.apply();
                updateProgress();
            }
        });

        da2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                editor.putBoolean(CHECKBOX_2_DA, isChecked);
                editor.apply();
                updateProgress();
            }
        });

        da3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                editor.putBoolean(CHECKBOX_3_DA, isChecked);
                editor.apply();
                updateProgress();
            }
        });

        da4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                editor.putBoolean(CHECKBOX_4_DA , isChecked);
                editor.apply();
                updateProgress();
            }
        });
    }

    private void updateProgress() {
        // Calculate progress based on checkbox states and update the ViewModel
        int progress = calculateProgress();
        sharedViewModel.updateProgressDA(progress);
    }

    private int calculateProgress() {
        // Implement your logic to calculate progress based on checkbox states
        // For example, if all checkboxes are checked, return 100; if half are checked, return 50, and so on.
        // This logic depends on your specific requirements.
        int totalCheckboxes = 4;
        int checkedCheckboxes = 0;

        if (da1.isChecked()) checkedCheckboxes++;
        if (da2.isChecked()) checkedCheckboxes++;
        if (da3.isChecked()) checkedCheckboxes++;
        if (da4.isChecked()) checkedCheckboxes++;

        if (totalCheckboxes > 0) {
            return (checkedCheckboxes * 100) / totalCheckboxes;
        } else {
            return 0;
        }
    }
}