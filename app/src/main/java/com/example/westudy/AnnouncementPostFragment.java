package com.example.westudy;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.example.westudy.Model.AnnouncementModel;
import com.example.westudy.Utils.FirebaseUtil;
import com.google.common.reflect.TypeToken;
import com.google.firebase.Timestamp;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.gson.Gson;
import com.jakewharton.threetenabp.AndroidThreeTen;

import java.lang.reflect.Type;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AnnouncementPostFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AnnouncementPostFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public AnnouncementPostFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AnnouncementPostFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AnnouncementPostFragment newInstance(String param1, String param2) {
        AnnouncementPostFragment fragment = new AnnouncementPostFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    String message;
    AnnouncementModel announcementModel;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_announcement_post, container, false);

        //declare message content
        EditText ETAnnouncementPost = view.findViewById(R.id.ETAnnouncementPost);

        Button BtnPostAnnouncement = view.findViewById(R.id.BtnPostAnnouncement);
        BtnPostAnnouncement.setOnClickListener(v -> {
            message = ETAnnouncementPost.getText().toString();

            saveAnnouncementToDB();

            Navigation.findNavController(v).popBackStack();
        });
        // Inflate the layout for this fragment
        return view;
    }

    public void saveAnnouncementToDB(){
        String announcementId = FirebaseUtil.getAnnouncementID(FirebaseUtil.currentUserID(),FirebaseUtil.timestampToString(Timestamp.now()));
        announcementModel = new AnnouncementModel(announcementId,message,Timestamp.now());
        FirebaseFirestore.getInstance().collection("announcements").document(announcementId).set(announcementModel);
    }
}