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


public class skills_PM_Fragment extends Fragment {

    CheckBox pm1,pm2,pm3,pm4;
    private SharedViewModel sharedViewModel;

    SharedPreferences sharedPreferences;
    private static final String PREFS_NAME = "myPrefs";
    private static final String CHECKBOX_1_PM = "pm1";
    private static final String CHECKBOX_2_PM = "pm2";
    private static final String CHECKBOX_3_PM = "pm3";
    private static final String CHECKBOX_4_PM = "pm4";


    public skills_PM_Fragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sharedViewModel = new ViewModelProvider(requireActivity()).get(SharedViewModel.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_skills__p_m_, container, false);

        WebView cp_vid1 = view.findViewById(R.id.cp_vid1);
        String cpvid1 = "<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/rck3MnC7OXA?si=-tdJCSRNKbTV5h8p\" title=\"YouTube video player\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" allowfullscreen></iframe>";
        cp_vid1.loadData(cpvid1,"text/html", "utf-8");
        cp_vid1.getSettings().setJavaScriptEnabled(true);
        cp_vid1.setWebChromeClient(new WebChromeClient());

        WebView cp_vid2 = view.findViewById(R.id.cp_vid2);
        String cpvid2 = "<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/kB4JL-BdB0Y?si=q3mWDdsRl8440lP1\" title=\"YouTube video player\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" allowfullscreen></iframe>";
        cp_vid2.loadData(cpvid2,"text/html", "utf-8");
        cp_vid2.getSettings().setJavaScriptEnabled(true);
        cp_vid2.setWebChromeClient(new WebChromeClient());

        WebView cp_vid3 = view.findViewById(R.id.cp_vid3);
        String cpvid3 = "<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/thsFsPnUHRA?si=y9M1cG2yYHmOhF68\" title=\"YouTube video player\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" allowfullscreen></iframe>";
        cp_vid3.loadData(cpvid3,"text/html", "utf-8");
        cp_vid3.getSettings().setJavaScriptEnabled(true);
        cp_vid3.setWebChromeClient(new WebChromeClient());

        WebView cp_vid4 = view.findViewById(R.id.cp_vid4);
        String cpvid4 = "<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/9TycLR0TqFA?si=p3qmQy43H8BoMS6G\" title=\"YouTube video player\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" allowfullscreen></iframe>";
        cp_vid4.loadData(cpvid4,"text/html", "utf-8");
        cp_vid4.getSettings().setJavaScriptEnabled(true);
        cp_vid4.setWebChromeClient(new WebChromeClient());

        pm1 = view.findViewById(R.id.checkBox);
        pm2 = view.findViewById(R.id.checkBox2);
        pm3 = view.findViewById(R.id.checkBox3);
        pm4 = view.findViewById(R.id.checkBox4);

        sharedPreferences = getContext().getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        pm1.setChecked(sharedPreferences.getBoolean(CHECKBOX_1_PM, false));
        pm2.setChecked(sharedPreferences.getBoolean(CHECKBOX_2_PM, false));
        pm3.setChecked(sharedPreferences.getBoolean(CHECKBOX_3_PM, false));
        pm4.setChecked(sharedPreferences.getBoolean(CHECKBOX_4_PM, false));

        setupCheckBoxListeners(editor);

        return view;

    }
    private void setupCheckBoxListeners(SharedPreferences.Editor editor) {
        pm1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                editor.putBoolean(CHECKBOX_1_PM, isChecked);
                editor.apply();
                updateProgress();
            }
        });

        pm2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                editor.putBoolean(CHECKBOX_2_PM, isChecked);
                editor.apply();
                updateProgress();
            }
        });

        pm3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                editor.putBoolean(CHECKBOX_3_PM, isChecked);
                editor.apply();
                updateProgress();
            }
        });

        pm4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                editor.putBoolean(CHECKBOX_4_PM, isChecked);
                editor.apply();
                updateProgress();
            }
        });
    }

    private void updateProgress() {
        // Calculate progress based on checkbox states and update the ViewModel
        int progress = calculateProgress();
        sharedViewModel.updateProgressPM(progress);
    }

    private int calculateProgress() {
        // Implement your logic to calculate progress based on checkbox states
        // For example, if all checkboxes are checked, return 100; if half are checked, return 50, and so on.
        // This logic depends on your specific requirements.
        int totalCheckboxes = 4;
        int checkedCheckboxes = 0;

        if (pm1.isChecked()) checkedCheckboxes++;
        if (pm2.isChecked()) checkedCheckboxes++;
        if (pm3.isChecked()) checkedCheckboxes++;
        if (pm4.isChecked()) checkedCheckboxes++;

        if (totalCheckboxes > 0) {
            return (checkedCheckboxes * 100) / totalCheckboxes;
        } else {
            return 0;
        }
    }
}