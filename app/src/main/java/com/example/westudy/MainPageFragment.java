package com.example.westudy;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MainPageFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MainPageFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public MainPageFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MainPageFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MainPageFragment newInstance(String param1, String param2) {
        MainPageFragment fragment = new MainPageFragment();
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
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main_page, container, false);
    }

    Button viewSkills,viewCourse,viewAnnouncement;
    ImageButton iBtnChem,iBtnEng,iBtnPhy,iBtnMath,iBtnBio;
    ImageButton iBtnCP,iBtnDA,iBtnPM;
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initializeView(view);
        setBtnAction(view);
    }

    public  void initializeView(View view){
        iBtnChem = view.findViewById(R.id.iBtnChem);
        iBtnEng = view.findViewById(R.id.iBtnEng);

        iBtnPhy = view.findViewById(R.id.iBtnPhy);
        iBtnMath = view.findViewById(R.id.iBtnMath);
        iBtnBio = view.findViewById(R.id.iBtnBio);
        ///////////////////////
        ///////////////////////
        viewSkills = view.findViewById(R.id.btnViewSkill);
        viewCourse = view.findViewById(R.id.btnViewCourse);
        viewAnnouncement = view.findViewById(R.id.btnViewAnnouncement);
        iBtnCP = view.findViewById(R.id.iBtnCP);
        iBtnDA = view.findViewById(R.id.iBtnDA);
        iBtnPM = view.findViewById(R.id.iBtnPM);
    }

    public void setBtnAction(View view){
        iBtnChem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(view).navigate(R.id.action_mainPage_to_chemPage);
            }
        });
        iBtnEng.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(view).navigate(R.id.action_mainPage_to_engPage);
            }
        });
//        another button here >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
        iBtnPhy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(view).navigate(R.id.action_mainPage_to_phyPage);
            }
        });
        iBtnMath.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(view).navigate(R.id.action_mainPage_to_mathPage);
            }
        });
        iBtnBio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(view).navigate(R.id.action_mainPage_to_bioPage);
            }
        });
        ///////////////////////
        ///////////////////////Skills Section//////////////////////
        viewSkills.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(view).navigate(R.id.action_mainPage_to_skillsPage);
            }
        });

        iBtnCP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(view).navigate(R.id.action_mainPage_to_skillsPage);
                Navigation.findNavController(view).navigate(R.id.action_skillsPage_to_CPPage);
            }
        });
        iBtnDA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(view).navigate(R.id.action_mainPage_to_skillsPage);
                Navigation.findNavController(view).navigate(R.id.action_skillsPage_to_DAPage);
            }
        });
        iBtnPM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(view).navigate(R.id.action_mainPage_to_skillsPage);
                Navigation.findNavController(view).navigate(R.id.action_skillsPage_to_PMPage);
            }
        });
    }
}