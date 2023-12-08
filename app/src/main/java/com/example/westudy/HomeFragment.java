package com.example.weducation;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.navigation.Navigation;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    public HomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
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
            // TODO: Rename and change types of parameters
            String mParam1 = getArguments().getString(ARG_PARAM1);
            String mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        //opening course segment
        Button btnViewCourse = view.findViewById(R.id.BtnViewCourse);
        btnViewCourse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(requireView()).navigate(R.id.DestCourse);
            }
        });

        ImageButton btnChemistry = view.findViewById(R.id.btnChem);
        btnChemistry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(requireView()).navigate(R.id.DestChemistry);
            }
        });

        ImageButton btnEnglish = view.findViewById(R.id.btnEng);
        btnEnglish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(requireView()).navigate(R.id.DestEnglish);
            }
        });

        ImageButton btnGeography = view.findViewById(R.id.btnGeo);
        btnGeography.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(requireView()).navigate(R.id.DestGeography);
            }
        });

        ImageButton btnPhysics = view.findViewById(R.id.btnPhysics);
        btnPhysics.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(requireView()).navigate(R.id.DestPhysics);
            }
        });

        ImageButton btnMaths = view.findViewById(R.id.btnMath);
        btnMaths.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(requireView()).navigate(R.id.DestMaths);
            }
        });

        ImageButton btnBiology = view.findViewById(R.id.btnBio);
        btnBiology.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(requireView()).navigate(R.id.DestBiology);
            }
        });
        //closing course segment

        //opening announcement segment
        Button btnViewAnnouncement = view.findViewById(R.id.btnViewAnnouncement);
        btnViewAnnouncement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(requireView()).navigate(R.id.DestAnnouncement);
            }
        });
        //closing announcement segment

        //opening hard skill segment
        Button btnViewSkill = view.findViewById(R.id.btnViewSkill);
        btnViewSkill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(requireView()).navigate(R.id.DestSkill);
            }
        });

        ImageButton btnProjectManagement = view.findViewById(R.id.btnProjectManagement);
        btnProjectManagement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(requireView()).navigate(R.id.DestSkillProjectManagement);
            }
        });

        ImageButton btnDataAnalysis = view.findViewById(R.id.btnDataAnalysis);
        btnDataAnalysis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(requireView()).navigate(R.id.DestSkillDataAnalyst);
            }
        });

        ImageButton btnComputerProg = view.findViewById(R.id.btnComputerProg);
        btnComputerProg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(requireView()).navigate(R.id.DestSkillCompProgramming);
            }
        });
        //closing hard skill segment

        return view;
    }
}