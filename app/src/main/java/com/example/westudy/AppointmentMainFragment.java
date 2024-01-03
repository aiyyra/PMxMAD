package com.example.westudy;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import android.view.Gravity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

//import com.example.westudy.Adapter.AppointmentRecyclerAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AppointmentMainFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AppointmentMainFragment extends Fragment implements OnRemoveClickListener {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private RecyclerView recyclerView;
    static ArrayList<Appointment> appointmentArrayList;

    public AppointmentMainFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AppointmentMainFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AppointmentMainFragment newInstance(String param1, String param2) {
        AppointmentMainFragment fragment = new AppointmentMainFragment();
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

        View view = inflater.inflate(R.layout.fragment_appointment_main, container, false);

        FloatingActionButton FABBookAppointment = view.findViewById(R.id.FABBookAppointment);
        FABBookAppointment.setOnClickListener(v -> {
            try {
                Navigation.findNavController(v).navigate(R.id.action_appointmentMainFragment_to_bookAppointmentFragment);
            } catch (Exception e) {
                Log.e("NavigationError", "Error navigating to BookAppointmentFragment: " + e.getMessage());
            }
        });

        // Inflate the layout for this fragment
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        
        dataInitialize();

        recyclerView = view.findViewById(R.id.RVAppointment);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setHasFixedSize(true);
//        AppointmentRecyclerAdapter adapter = new AppointmentRecyclerAdapter(getContext(),appointmentArrayList);
//        recyclerView.setAdapter(adapter);

        // Check if the RecyclerView is empty
        if (AppointmentMainFragment.appointmentArrayList.isEmpty()) {
            // Create and display a Toast message as a popup
            Toast toast = Toast.makeText(getContext(), "No appointment", Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER, 0, 0); // Set the toast message to appear in the center
            toast.show();
        }

//        adapter.setOnRemoveClickListener(this); // Set the remove click listener
//        adapter.notifyDataSetChanged();
    }

    @Override
    public void onRemoveClick(int position) {
        // Remove appointment at the given position from the list
        appointmentArrayList.remove(position);
        recyclerView.getAdapter().notifyItemRemoved(position);
    }

    private void dataInitialize() {

        // Initialize appointmentArrayList if it's not initialized
        if (appointmentArrayList == null) {
            appointmentArrayList = new ArrayList<>();
        }
    }
}