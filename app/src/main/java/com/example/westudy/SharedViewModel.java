package com.example.westudy;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SharedViewModel extends ViewModel {
    private final MutableLiveData<Integer> progressLiveDataCP = new MutableLiveData<>();
    private final MutableLiveData<Integer> progressLiveDataDA = new MutableLiveData<>();
    private final MutableLiveData<Integer> progressLiveDataPM = new MutableLiveData<>();


    public LiveData<Integer> getProgressLiveDataCP() {
        return progressLiveDataCP;
    }
    public LiveData<Integer> getProgressLiveDataDA() {
        return progressLiveDataDA;
    }
    public LiveData<Integer> getProgressLiveDataPM() {
        return progressLiveDataPM;
    }

    public void updateProgressCP(int progress) {
        progressLiveDataCP.setValue(progress);
    }
    public void updateProgressDA(int progress) {
        progressLiveDataDA.setValue(progress);
    }
    public void updateProgressPM(int progress) {
        progressLiveDataPM.setValue(progress);
    }
}


