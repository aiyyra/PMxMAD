package com.example.weducation;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SkillDataAnalystFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SkillDataAnalystFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public SkillDataAnalystFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SkillDataAnalystFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SkillDataAnalystFragment newInstance(String param1, String param2) {
        SkillDataAnalystFragment fragment = new SkillDataAnalystFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_skill_data_analyst, container, false);

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

        // Inflate the layout for this fragment
        return view;
    }
}