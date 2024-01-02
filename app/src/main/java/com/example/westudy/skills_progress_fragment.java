package com.example.westudy;

import android.app.Dialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

public class skills_progress_fragment extends Fragment {

    private SharedViewModel sharedViewModel;
    private ProgressBar progressBarCP;
    private ProgressBar progressBarDA;
    private ProgressBar progressBarPM;
    SharedPreferences sharedPreferences;
    private static final String PREFS_NAME = "myPrefs";
    private static final String PROGRESS_BAR_CP = "pbCP";
    private static final String PROGRESS_BAR_DA = "pbDA";
    private static final String PROGRESS_BAR_PM = "pbPM";
    Handler handler = new Handler();
    TextView percentageCP;
    TextView percentageDA;
    TextView percentagePM;
    int progressPercentageCP = 0;
    int progressPercentageDA = 0;
    int progressPercentagePM = 0;
    String textPercentageCP = "";
    String textPercentageDA = "";
    String textPercentagePM = "";
    AppCompatButton btnClaimCP;
    AppCompatButton btnClaimDA;
    AppCompatButton btnClaimPM;
    Dialog dialog;





    public skills_progress_fragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_skills_progress, container, false);

        progressBarCP = view.findViewById(R.id.PbCP);
        progressBarDA = view.findViewById(R.id.PbDA);
        progressBarPM = view.findViewById(R.id.PbPM);

        sharedPreferences = getContext().getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        progressBarCP.setProgress(sharedPreferences.getInt(PROGRESS_BAR_CP,0));
        progressBarDA.setProgress(sharedPreferences.getInt(PROGRESS_BAR_DA,0));
        progressBarPM.setProgress(sharedPreferences.getInt(PROGRESS_BAR_PM,0));

        percentageCP = view.findViewById(R.id.textCpPercentage);
        percentageDA = view.findViewById(R.id.textDaPercentage);
        percentagePM = view.findViewById(R.id.textPmPercentage);

        btnClaimCP = view.findViewById(R.id.BtnClaimCp);
        btnClaimDA = view.findViewById(R.id.BtnClaimDa);
        btnClaimPM = view.findViewById(R.id.BtnClaimPm);
        btnClaimCP.setEnabled(false);
        btnClaimDA.setEnabled(false);
        btnClaimPM.setEnabled(false);

        dialog = new Dialog(requireContext());




        // Initialize the ViewModel
        sharedViewModel = new ViewModelProvider(requireActivity()).get(SharedViewModel.class);

        // Observe changes in the progress value
        sharedViewModel.getProgressLiveDataCP().observe(getViewLifecycleOwner(), new Observer<Integer>() {
            @Override
            public void onChanged(Integer progress) {
                // Update the ProgressBar with the new progress value
                progressBarCP.setProgress(progress);
                progressPercentageCP = progress;
                if(progressPercentageCP == 100){
                    btnClaimCP.setEnabled(true);
                }

                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        textPercentageCP = String.valueOf(progress) + "%";
                        percentageCP.setText(textPercentageCP);
                    }
                });
            }
        });

        sharedViewModel.getProgressLiveDataDA().observe(getViewLifecycleOwner(), new Observer<Integer>() {
            @Override
            public void onChanged(Integer progress) {
                // Update the ProgressBar with the new progress value
                progressBarDA.setProgress(progress);
                progressPercentageDA = progress;
                if(progressPercentageDA == 100){
                    btnClaimDA.setEnabled(true);
                }


                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        textPercentageDA = String.valueOf(progress) + "%";
                        percentageDA.setText(textPercentageDA);
                    }
                });
            }
        });

        sharedViewModel.getProgressLiveDataPM().observe(getViewLifecycleOwner(), new Observer<Integer>() {
            @Override
            public void onChanged(Integer progress) {
                // Update the ProgressBar with the new progress value
                progressBarPM.setProgress(progress);
                progressPercentagePM = progress;
                if(progressPercentagePM == 100){
                    btnClaimPM.setEnabled(true);
                }


                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        textPercentagePM = String.valueOf(progress) + "%";
                        percentagePM.setText(textPercentagePM);
                    }
                });
            }
        });

        textPercentageCP = String.valueOf(progressPercentageCP) + "%";
        textPercentageDA = String.valueOf(progressPercentageDA) + "%";
        textPercentagePM = String.valueOf(progressPercentagePM) + "%";

        btnClaimCP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.setContentView(R.layout.popup_reward_cp);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });
        btnClaimDA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.setContentView(R.layout.popup_reward_da);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });
        btnClaimPM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.setContentView(R.layout.popup_reward_pm);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });
        return view;
    }



    @Override
    public void onStop() {
        super.onStop();
        saveProgressToSharedPreferences();
    }

    private void saveProgressToSharedPreferences() {
        // Save progress values in SharedPreferences
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("progressCP", calculateProgress(progressBarCP));
        editor.putInt("progressDA", calculateProgress(progressBarDA));
        editor.putInt("progressPM", calculateProgress(progressBarPM));
        editor.putInt("textIntProgressCP", progressPercentageCP);
        editor.putInt("textIntProgressDA", progressPercentageDA);
        editor.putInt("textIntProgressPM", progressPercentagePM);
        editor.apply();
    }

    @Override
    public void onStart() {
        super.onStart();
        loadProgressFromSharedPreferences();
    }

    private void loadProgressFromSharedPreferences() {
        // Load progress values from SharedPreferences and update the progress bars
        int progressCP = sharedPreferences.getInt("progressCP", 0);
        int progressDA = sharedPreferences.getInt("progressDA", 0);
        int progressPM = sharedPreferences.getInt("progressPM", 0);
        int intTextPercentageCP = sharedPreferences.getInt("textIntProgressCP", progressPercentageCP);
        int intTextPercentageDA = sharedPreferences.getInt("textIntProgressDA", progressPercentageDA);
        int intTextPercentagePM = sharedPreferences.getInt("textIntProgressPM", progressPercentagePM);

        // Set progress values to the progress bars
        // Assume you have progress bars named progressBarCP1, progressBarCP2, etc.
        progressBarCP.setProgress(progressCP);
        progressBarDA.setProgress(progressDA);
        progressBarPM.setProgress(progressPM);

        percentageCP.setText(String.valueOf(progressPercentageCP) + "%");
        percentageDA.setText(String.valueOf(progressPercentageDA) + "%");
        percentagePM.setText(String.valueOf(progressPercentagePM) + "%");
    }


    private int calculateProgress(ProgressBar progressBar) {
        // Implement your logic to calculate progress based on checkbox state
        // For example, return 100 if checked, 0 if unchecked

        if(progressBar == progressBarCP) {
            return progressPercentageCP;
        } else if(progressBar == progressBarDA) {
            return progressPercentageDA;
        } else if(progressBar == progressBarPM) {
            return progressPercentagePM;
        }

        return 0;
    }
}
