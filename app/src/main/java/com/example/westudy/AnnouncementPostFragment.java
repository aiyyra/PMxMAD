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

import com.google.common.reflect.TypeToken;
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

        AndroidThreeTen.init(getContext());

        View view = inflater.inflate(R.layout.fragment_announcement_post, container, false);

        //declare message content
        EditText ETAnnouncementPost = view.findViewById(R.id.ETAnnouncementPost);

        Button BtnPostAnnouncement = view.findViewById(R.id.BtnPostAnnouncement);
        BtnPostAnnouncement.setOnClickListener(v -> {
            String message = ETAnnouncementPost.getText().toString();

            // Get the current date and time
            LocalDateTime currentDateTime = LocalDateTime.now();

            // Format the date
            String formattedDate = currentDateTime.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));

            // Format the time
            String formattedTime = currentDateTime.format(DateTimeFormatter.ofPattern("hh:mm a"));

            // Concatenate the date and time with a newline character
            String formattedDateTime = formattedDate + "\n" + formattedTime;

            // Create an Announcement object with the obtained data
            Announcement announcement = new Announcement(formattedDateTime, message);
            AnnouncementMainFragment.announcementArrayList.add(announcement);

            // Save appointment data to SharedPreferences
            saveAnnouncement(announcement);

            Navigation.findNavController(v).popBackStack();
        });
        // Inflate the layout for this fragment
        return view;
    }

    private void saveAnnouncement(Announcement announcement){
        SharedPreferences sharedPreferences = requireActivity().getSharedPreferences("Announcements", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        // Get existing appointments from SharedPreferences
        Gson gson = new Gson();
        String json = sharedPreferences.getString("announcements", "");
        ArrayList<Announcement> announcementList;
        if (json.isEmpty()) {
            announcementList = new ArrayList<>();
        } else {
            Type type = new TypeToken<ArrayList<Announcement>>() {}.getType();
            announcementList = gson.fromJson(json, type);
        }

        // Add new announcement
        announcementList.add(announcement);

        // Save updated announcement SharedPreferences
        String updatedJson = gson.toJson(announcementList);
        editor.putString("announcements", updatedJson);
        editor.apply();
    }
}