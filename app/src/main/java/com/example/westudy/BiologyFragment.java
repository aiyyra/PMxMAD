package com.example.westudy;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BiologyFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BiologyFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public BiologyFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BiologyFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static BiologyFragment newInstance(String param1, String param2) {
        BiologyFragment fragment = new BiologyFragment();
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

        View view = inflater.inflate(R.layout.fragment_biology, container, false);

        WebView cp_vid1 = view.findViewById(R.id.cp_vid1);
        String cpvid1 = "<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/fp5H3SslskQ?si=pggi8sxkxbNPoHyS\" title=\"YouTube video player\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" allowfullscreen></iframe>";
        cp_vid1.loadData(cpvid1,"text/html", "utf-8");
        cp_vid1.getSettings().setJavaScriptEnabled(true);
        cp_vid1.setWebChromeClient(new WebChromeClient());

        WebView cp_vid2 = view.findViewById(R.id.cp_vid2);
        String cpvid2 = "<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/dN7c2JniR8U?si=R-mzr-km0c_qDxlG\" title=\"YouTube video player\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" allowfullscreen></iframe>";
        cp_vid2.loadData(cpvid2,"text/html", "utf-8");
        cp_vid2.getSettings().setJavaScriptEnabled(true);
        cp_vid2.setWebChromeClient(new WebChromeClient());

        WebView cp_vid3 = view.findViewById(R.id.cp_vid3);
        String cpvid3 = "<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/vMI46qGQMDw?si=c6fFgAxwvDFC9tib\" title=\"YouTube video player\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" allowfullscreen></iframe>";
        cp_vid3.loadData(cpvid3,"text/html", "utf-8");
        cp_vid3.getSettings().setJavaScriptEnabled(true);
        cp_vid3.setWebChromeClient(new WebChromeClient());

        WebView cp_vid4 = view.findViewById(R.id.cp_vid4);
        String cpvid4 = "<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/HiuXfbwND9s?si=1BcBR5TyRxnLAg9o\" title=\"YouTube video player\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" allowfullscreen></iframe>";
        cp_vid4.loadData(cpvid4,"text/html", "utf-8");
        cp_vid4.getSettings().setJavaScriptEnabled(true);
        cp_vid4.setWebChromeClient(new WebChromeClient());
        // Inflate the layout for this fragment
        return view;
    }
}