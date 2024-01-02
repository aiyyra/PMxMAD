package com.example.westudy;

import static android.content.ContentValues.TAG;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Calendar;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BookAppointmentFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BookAppointmentFragment extends Fragment implements AdapterView.OnItemSelectedListener{

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private DatePickerDialog.OnDateSetListener dateSetListener;
    Spinner spinner_teacher;

    public BookAppointmentFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BookAppointmentFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static BookAppointmentFragment newInstance(String param1, String param2) {
        BookAppointmentFragment fragment = new BookAppointmentFragment();
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

        View view = inflater.inflate(R.layout.fragment_book_appointment, container, false);

        //radio group for slots
        RadioButton RB11_00 = view.findViewById(R.id.RB11_00);
        RadioButton RB11_30 = view.findViewById(R.id.RB11_30);
        RadioButton RB12_00 = view.findViewById(R.id.RB12_00);
        RadioButton RB12_30 = view.findViewById(R.id.RB12_30);
        RadioButton RB2_00 = view.findViewById(R.id.RB2_00);
        RadioButton RB2_30 = view.findViewById(R.id.RB2_30);

        //radio group for course
        RadioButton RBChemistry = view.findViewById(R.id.RBChemistry);
        RadioButton RBEnglish = view.findViewById(R.id.RBEnglish);
        RadioButton RBGeography = view.findViewById(R.id.RBGeography);
        RadioButton RBPhysics = view.findViewById(R.id.RBPhysics);
        RadioButton RBMaths = view.findViewById(R.id.RBMaths);
        RadioButton RBBiology = view.findViewById(R.id.RBBiology);

        //Drop down item for teacher
        spinner_teacher = view.findViewById(R.id.spinner_teacher);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getContext(), R.array.teachers_all, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_teacher.setAdapter(adapter);

        //declare message content
        EditText ETMessage = view.findViewById(R.id.ETMessage);

        //Date segment
        TextView TVDate = view.findViewById(R.id.TVDate);
        Button BtnDatePicker = view.findViewById(R.id.BtnDatePicker);
        BtnDatePicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar c = Calendar.getInstance();
                int year = c.get(Calendar.YEAR);
                int month = c.get(Calendar.MONTH);
                int day = c.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(getContext(),android.R.style.Theme_DeviceDefault_Dialog,dateSetListener,year,month,day);
                dialog.show();
            }
        });
        dateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                month = month + 1;
                Log.d(TAG, "onDateSet: dd/mm/yyyy "+dayOfMonth+"-"+month+"-"+year);
                String Date = dayOfMonth+"-"+month+"-"+year;
                TVDate.setText(Date);
            }
        };
        //end of date segment

        Button BtnSubmitAppointment = view.findViewById(R.id.BtnSubmitAppointment);
        BtnSubmitAppointment.setOnClickListener(v ->{

            String date = TVDate.getText().toString();
            String teacher = spinner_teacher.getSelectedItem().toString();
            String message = ETMessage.getText().toString();

            String course = "";
            if (RBChemistry.isChecked()){
                course = RBChemistry.getText().toString();}
            else if (RBEnglish.isChecked()){
                course = RBEnglish.getText().toString();}
            else if (RBGeography.isChecked()){
                course = RBGeography.getText().toString();}
            else if (RBPhysics.isChecked()){
                course = RBPhysics.getText().toString();}
            else if (RBMaths.isChecked()){
                course = RBMaths.getText().toString();}
            else if(RBBiology.isChecked()){
                course = RBBiology.getText().toString();}

            String slot = "";
            if (RB11_00.isChecked())
                slot = RB11_00.getText().toString();
            else if (RB11_30.isChecked())
                slot = RB11_30.getText().toString();
            else if (RB12_00.isChecked())
                slot = RB12_00.getText().toString();
            else if (RB12_30.isChecked())
                slot = RB12_30.getText().toString();
            else if (RB2_00.isChecked())
                slot = RB2_00.getText().toString();
            else if(RB2_30.isChecked())
                slot = RB2_30.getText().toString();

            // Check if any required field is empty
            if (date.isEmpty() || teacher.isEmpty() || course.isEmpty() || slot.isEmpty()) {
                // Prompt user to fill in all required fields
                Toast.makeText(getContext(), "Appointment is not valid. Please fill in all details.", Toast.LENGTH_SHORT).show();
            } else {
                // Create an Appointment object with the obtained data
                Appointment appointment = new Appointment(date, slot, course, teacher, message);
                AppointmentMainFragment.appointmentArrayList.add(appointment);
                
                // Save appointment data to SharedPreferences
                saveAppointment(appointment);

                Navigation.findNavController(v).popBackStack();
            }
        });
        // Inflate the layout for this fragment
        return view;
    }

    // Method to save appointment data using SharedPreferences
    private void saveAppointment(Appointment appointment) {
        SharedPreferences sharedPreferences = requireActivity().getSharedPreferences("Appointments", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        // Get existing appointments from SharedPreferences
        Gson gson = new Gson();
        String json = sharedPreferences.getString("appointments", "");
        ArrayList<Appointment> appointmentList;
        if (json.isEmpty()) {
            appointmentList = new ArrayList<>();
        } else {
            Type type = new TypeToken<ArrayList<Appointment>>() {}.getType();
            appointmentList = gson.fromJson(json, type);
        }

        // Add new appointment
        appointmentList.add(appointment);

        // Save updated appointment list to SharedPreferences
        String updatedJson = gson.toJson(appointmentList);
        editor.putString("appointments", updatedJson);
        editor.apply();
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        String teacher = adapterView.getItemAtPosition(i).toString();
        Toast.makeText(adapterView.getContext(), teacher, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}