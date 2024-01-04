package com.example.westudy;

import android.os.Bundle;

import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class MathsFragment extends Fragment {

    AppCompatButton btnC1,btnC2,btnC3,btnC4,btnC5;


    public MathsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_maths, container, false);

        btnC1 = view.findViewById(R.id.btnC1);
        btnC2 = view.findViewById(R.id.btnC2);
        btnC3 = view.findViewById(R.id.btnC3);
        btnC4 = view.findViewById(R.id.btnC4);
        btnC5 = view.findViewById(R.id.btnC5);

        btnC1.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Navigation.findNavController(view).navigate(R.id.action_mathsPage_to_mathsC1Page);
            }
        });

        btnC2.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Navigation.findNavController(view).navigate(R.id.action_mathsPage_to_mathsC2Page);
            }
        });

        btnC3.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Navigation.findNavController(view).navigate(R.id.action_mathsPage_to_mathsC3Page);
            }
        });

        btnC4.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Navigation.findNavController(view).navigate(R.id.action_mathsPage_to_mathsC4Page);
            }
        });

        btnC5.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Navigation.findNavController(view).navigate(R.id.action_mathsPage_to_mathsC5Page);
            }
        });

        return view;
    }
}