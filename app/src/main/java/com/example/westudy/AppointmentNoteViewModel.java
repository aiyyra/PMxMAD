package com.example.westudy;
import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

// 5. Created a class called MoodNoteViewModel that gets the Application as a parameter and
// extends AndroidViewModel.
public class AppointmentNoteViewModel extends AndroidViewModel {

    //Added a private member variable to hold a reference to the repository.
    private AppointmentNoteRepository mRepository;
    private final LiveData<List<AppointmentNote>> mAllNotes;

    //Implemented a constructor that creates the MoodNoteRepository.
    //In the constructor, initialized the allNotes LiveData using the repository.
    public AppointmentNoteViewModel(Application application) {
        super(application);
        mRepository = new AppointmentNoteRepository(application);
        mAllNotes = mRepository.getAllNotes();
    }
    //Added a getAllNotes() method to return a cached list of words.
    LiveData<List<AppointmentNote>> getAllNotes() { return mAllNotes; }

    // Created a wrapper insert() method that calls the Repository's insert() method.
    // In this way, the implementation of insert() is encapsulated from the UI.
    public void insert(AppointmentNote note) { mRepository.insert(note); }
}


