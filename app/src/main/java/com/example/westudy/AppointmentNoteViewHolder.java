package com.example.westudy;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class AppointmentNoteViewHolder extends RecyclerView.ViewHolder {
    private final TextView noteDate;
    private final TextView noteSlot;
    private final TextView noteCourse;

    private AppointmentNoteViewHolder(View itemView) {
        super(itemView);

        noteDate = itemView.findViewById(R.id.TVDateContent);
        noteSlot = itemView.findViewById(R.id.TVSlotsContent);
        noteCourse = itemView.findViewById(R.id.TVCourseContent);
    }

    public void bind(String date, int course, int slot) {
        noteDate.setText(date);

        switch (slot) {
            case 1:
                noteSlot.setText(R.string._11_00_am);
                break;
            case 2:
                noteSlot.setText(R.string._11_30_am);
                break;
            case 3:
                noteSlot.setText(R.string._12_00_pm);
                break;
            case 4:
                noteSlot.setText(R.string._12_30_pm);
                break;
            case 5:
                noteSlot.setText(R.string._2_00_pm);
                break;
            case 6:
                noteSlot.setText(R.string._2_30_pm);
                break;
            default:
                noteSlot.setText("");
                break;
        }

        switch (course) {
            case 1:
                noteSlot.setText(R.string.chemistry);
                break;
            case 2:
                noteCourse.setText(R.string.english);
                break;
            case 3:
                noteCourse.setText(R.string.geography);
                break;
            case 4:
                noteCourse.setText(R.string.physics);
                break;
            case 5:
                noteCourse.setText(R.string.maths);
                break;
            case 6:
                noteCourse.setText(R.string.biology);
                break;
            default:
                noteCourse.setText("");
                break;
        }
    }

    static AppointmentNoteViewHolder create(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.individual_item_view, parent, false);
        return new AppointmentNoteViewHolder(view);
    }
}
