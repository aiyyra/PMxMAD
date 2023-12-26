package com.example.westudy;

import static android.app.Activity.RESULT_CANCELED;
import static android.app.Activity.RESULT_OK;
import static android.content.ContentValues.TAG;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import java.util.Calendar;
import java.util.List;

public class BookAppointmentFragment extends Fragment implements AdapterView.OnItemSelectedListener{

    public static final String ExtraDate = "date";
    public static final String ExtraCourse = "course";
    public static final String ExtraSlot = "slot";
    private DatePickerDialog.OnDateSetListener dateSetListener;

    Spinner spinner_teacher;
    List<String> name_teacher;
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
                Log.d(TAG, "onDateSet: dd/mm/yyyy "+dayOfMonth+"/"+month+"/"+year);
                String Date = dayOfMonth+"/"+month+"/"+year;
                TVDate.setText(Date);
            }
        };
        //end of date segment

        final Button BtnSubmitAppointment = view.findViewById(R.id.BtnSubmitAppointment);
        BtnSubmitAppointment.setOnClickListener( v -> {
            Intent replyIntent = new Intent();

            int course = 0;
            if (RBChemistry.isChecked())
                course = 1;
            else if (RBEnglish.isChecked())
                course = 2;
            else if (RBGeography.isChecked())
                course = 3;
            else if (RBPhysics.isChecked())
                course = 4;
            else if (RBMaths.isChecked())
                course = 5;
            else if(RBBiology.isChecked())
                course = 6;

            int slot = 0;
            if (RB11_00.isChecked())
                slot = 1;
            else if (RB11_30.isChecked())
                slot = 2;
            else if (RB12_00.isChecked())
                slot = 3;
            else if (RB12_30.isChecked())
                slot = 4;
            else if (RB2_00.isChecked())
                slot = 5;
            else if(RB2_30.isChecked())
                slot = 6;

            if (TextUtils.isEmpty(TVDate.getText())) {
                requireActivity().setResult(RESULT_CANCELED, replyIntent);
            } else {
                replyIntent.putExtra(ExtraCourse, Integer.toString(course));
                replyIntent.putExtra(ExtraSlot, Integer.toString(slot));
                requireActivity().setResult(RESULT_OK, replyIntent);
            }
            //requireActivity().finish(); --> used for return back to previous activity(we want to return to previous fragment)
            requireActivity().getSupportFragmentManager().popBackStack(); // Finish the activity to return to the previous screen (fragment)
        });
        return view;
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String teacher = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(), teacher, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}