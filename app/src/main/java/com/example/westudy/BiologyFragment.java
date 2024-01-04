package com.example.westudy;

import android.os.Bundle;

import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class BiologyFragment extends Fragment {

    AppCompatButton btnC1,btnC2,btnC3,btnC4,btnC5;


    public BiologyFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_biology, container, false);

        btnC1 = view.findViewById(R.id.btnC1);
        btnC2 = view.findViewById(R.id.btnC2);
        btnC3 = view.findViewById(R.id.btnC3);
        btnC4 = view.findViewById(R.id.btnC4);
        btnC5 = view.findViewById(R.id.btnC5);

        btnC1.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Navigation.findNavController(view).navigate(R.id.action_bioPage_to_bioC1Page);
            }
        });

        btnC2.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Navigation.findNavController(view).navigate(R.id.action_bioPage_to_bioC2Page);
            }
        });

        btnC3.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Navigation.findNavController(view).navigate(R.id.action_bioPage_to_bioC3Page);
            }
        });

        btnC4.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Navigation.findNavController(view).navigate(R.id.action_bioPage_to_bioC4Page);
            }
        });

        btnC5.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Navigation.findNavController(view).navigate(R.id.action_bioPage_to_bioC5Page);
            }
        });

        return view;
    }
}

//        WebView cp_vid1 = view.findViewById(R.id.cp_vid1);
//        String cpvid1 = "<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/fp5H3SslskQ?si=pggi8sxkxbNPoHyS\" title=\"YouTube video player\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" allowfullscreen></iframe>";
//        cp_vid1.loadData(cpvid1,"text/html", "utf-8");
//        cp_vid1.getSettings().setJavaScriptEnabled(true);
//        cp_vid1.setWebChromeClient(new WebChromeClient());
//
//        WebView cp_vid2 = view.findViewById(R.id.cp_vid2);
//        String cpvid2 = "<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/dN7c2JniR8U?si=R-mzr-km0c_qDxlG\" title=\"YouTube video player\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" allowfullscreen></iframe>";
//        cp_vid2.loadData(cpvid2,"text/html", "utf-8");
//        cp_vid2.getSettings().setJavaScriptEnabled(true);
//        cp_vid2.setWebChromeClient(new WebChromeClient());
//
//        WebView cp_vid3 = view.findViewById(R.id.cp_vid3);
//        String cpvid3 = "<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/vMI46qGQMDw?si=c6fFgAxwvDFC9tib\" title=\"YouTube video player\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" allowfullscreen></iframe>";
//        cp_vid3.loadData(cpvid3,"text/html", "utf-8");
//        cp_vid3.getSettings().setJavaScriptEnabled(true);
//        cp_vid3.setWebChromeClient(new WebChromeClient());
//
//        WebView cp_vid4 = view.findViewById(R.id.cp_vid4);
//        String cpvid4 = "<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/HiuXfbwND9s?si=1BcBR5TyRxnLAg9o\" title=\"YouTube video player\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" allowfullscreen></iframe>";
//        cp_vid4.loadData(cpvid4,"text/html", "utf-8");
//        cp_vid4.getSettings().setJavaScriptEnabled(true);
//        cp_vid4.setWebChromeClient(new WebChromeClient());
