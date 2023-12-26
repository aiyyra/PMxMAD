package com.example.westudy;

import static android.app.Activity.RESULT_OK;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class UpcomingAppointmentFragment extends Fragment {
    public static final int NEW_NOTE_ACTIVITY_REQUEST_CODE = 1;
    private AppointmentNoteViewModel mNoteViewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_upcoming_appointment, container, false);
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == NEW_NOTE_ACTIVITY_REQUEST_CODE && resultCode == RESULT_OK) {
            if (data != null) {
                int course = data.getIntExtra(BookAppointmentFragment.ExtraCourse, 0);
                int slot = data.getIntExtra(BookAppointmentFragment.ExtraSlot, 0);
                String date = data.getStringExtra(BookAppointmentFragment.ExtraDate);

                AppointmentNote note = new AppointmentNote(date, course, slot);
                mNoteViewModel.insert(note);
            } else {
                Toast.makeText(getContext(), R.string.empty_not_saved, Toast.LENGTH_LONG).show();
            }
        }
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        RecyclerView recyclerView = view.findViewById(R.id.RVAppointmentNote);
        final AppointmentNoteListAdapter adapter = new AppointmentNoteListAdapter(new AppointmentNoteListAdapter.NoteDiff());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setHasFixedSize(true);

        mNoteViewModel = new ViewModelProvider(this).get(AppointmentNoteViewModel.class);

        // Update the cached copy of the notes in the adapter.
        mNoteViewModel.getAllNotes().observe(getViewLifecycleOwner(), adapter::submitList);
    }
}
