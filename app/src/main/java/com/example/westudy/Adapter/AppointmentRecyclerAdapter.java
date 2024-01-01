package com.example.westudy.Adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.westudy.Appointment;
import com.example.westudy.AppointmentMainFragment;
import com.example.westudy.OnRemoveClickListener;
import com.example.westudy.R;

import java.util.ArrayList;

public class AppointmentRecyclerAdapter extends RecyclerView.Adapter<AppointmentRecyclerAdapter.MyViewHolder> {

    private OnRemoveClickListener removeClickListener;

    Context context;
    ArrayList <Appointment> appointmentArrayList;
    public AppointmentRecyclerAdapter(Context context, ArrayList<Appointment> appointmentArrayList) {
        this.context = context;
        this.appointmentArrayList = appointmentArrayList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.individual_item_view,parent, false);
        return new MyViewHolder(view,removeClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        Appointment appointment = appointmentArrayList.get(position);

        holder.TVDateContent.setText(appointment.TVDateContent);
        holder.TVSlotContent.setText(appointment.TVSlotContent);
        holder.TVCourseContent.setText(appointment.TVCourseContent);
        holder.TVTeacherContent.setText(appointment.TVTeacherContent);
        holder.TVMessageContent.setText(appointment.TVMessageContent);
;
    }

    @Override
    public int getItemCount() {
        return appointmentArrayList.size();
    }

    // Setter method for the remove click listener
    public void setOnRemoveClickListener(AppointmentMainFragment listener) {
        this.removeClickListener = listener;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView TVDateContent, TVSlotContent, TVCourseContent, TVTeacherContent, TVMessageContent;

        public MyViewHolder(@NonNull View itemView, OnRemoveClickListener listener) {
            super(itemView);

            TVDateContent = itemView.findViewById(R.id.TVDateContent);
            TVSlotContent = itemView.findViewById(R.id.TVSlotContent);
            TVCourseContent = itemView.findViewById(R.id.TVCourseContent);
            TVTeacherContent = itemView.findViewById(R.id.TVTeacherContent);
            TVMessageContent = itemView.findViewById(R.id.TVMessageContent);

            ImageButton BtnRemoveAppointment = itemView.findViewById(R.id.BtnRemoveAppointment);
            // Handle remove button click
            BtnRemoveAppointment.setOnClickListener(v -> {
                if (listener != null) {
                    int position = getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION) {
                        // Show an alert dialog to confirm deletion
                        AlertDialog.Builder builder = new AlertDialog.Builder(itemView.getContext());
                        builder.setTitle("Delete Appointment");
                        builder.setMessage("Sure to delete this appointment?");
                        builder.setPositiveButton("Yes", (dialog, which) -> {
                            // Perform deletion
                            listener.onRemoveClick(position);
                            dialog.dismiss();
                            // Show a success message
                            showDeletionSuccess(itemView.getContext());
                        });
                        builder.setNegativeButton("No", (dialog, which) -> dialog.dismiss());
                        builder.show();
                    }
                }
            });
        }
        // Method to show deletion success message
        private void showDeletionSuccess(Context context) {
            AlertDialog.Builder builder = new AlertDialog.Builder(context);
            builder.setTitle("Success");
            builder.setMessage("Appointment successfully deleted");
            builder.setPositiveButton("OK", (dialog, which) -> dialog.dismiss());
            builder.show();
        }
    }
}
