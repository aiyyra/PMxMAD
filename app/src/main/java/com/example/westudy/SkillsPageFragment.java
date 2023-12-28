package com.example.westudy;

import android.media.Image;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageButton;

import com.google.android.material.imageview.ShapeableImageView;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class SkillsPageFragment extends Fragment {



    public SkillsPageFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment



        return inflater.inflate(R.layout.fragment_skills_page, container, false);

    }

    ShapeableImageView iBtnCP,iBtnDA,iBtnPM;
    AppCompatButton btnProgress;
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initializeView(view);
        setBtnAction(view);
    }

    public void initializeView(View view){
        iBtnCP = view.findViewById(R.id.roundRectangle);
        iBtnDA = view.findViewById(R.id.roundRectangle2);
        iBtnPM = view.findViewById(R.id.roundRectangle3);
        btnProgress = view.findViewById(R.id.BtnProgress);
    }

    public void setBtnAction(View view){
        iBtnCP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(view).navigate(R.id.action_skillsPage_to_CPPage);
            }
        });
        iBtnDA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(view).navigate(R.id.action_skillsPage_to_DAPage);
            }
        });
        iBtnPM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(view).navigate(R.id.action_skillsPage_to_PMPage);
            }
        });

        btnProgress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(view).navigate(R.id.action_skillsPage_to_progressPage);
            }
        });
    }
}



