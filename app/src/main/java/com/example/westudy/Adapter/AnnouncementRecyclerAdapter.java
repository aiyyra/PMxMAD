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

import com.example.westudy.Announcement;
import com.example.westudy.AnnouncementMainFragment;
import com.example.westudy.OnRemoveClickListener;
import com.example.westudy.R;

import java.util.ArrayList;

public class AnnouncementRecyclerAdapter extends RecyclerView.Adapter<AnnouncementRecyclerAdapter.MyViewHolder>{

    private OnRemoveClickListener removeClickListener;

    Context context;
    ArrayList<Announcement> announcementArrayList;
    public AnnouncementRecyclerAdapter(Context context, ArrayList<Announcement> announcementArrayList) {
        this.context = context;
        this.announcementArrayList = announcementArrayList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.individual_announcement_view,parent, false);
        return new MyViewHolder(view,removeClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull AnnouncementRecyclerAdapter.MyViewHolder holder, int position) {

        Announcement announcement = announcementArrayList.get(position);

        holder.TVDateAnnouncement.setText(announcement.TVDateAnnouncement);
        holder.TVAnnouncementContent.setText(announcement.TVAnnouncementContent);

    }

    @Override
    public int getItemCount() {
        return announcementArrayList.size();
    }

    public void setOnRemoveClickListener(AnnouncementMainFragment listener) {
        this.removeClickListener = listener;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView TVDateAnnouncement, TVAnnouncementContent;

        public MyViewHolder(@NonNull View itemView, OnRemoveClickListener listener) {
            super(itemView);

            TVDateAnnouncement = itemView.findViewById(R.id.TVDateAnnouncement);
            TVAnnouncementContent = itemView.findViewById(R.id.TVAnnouncementContent);

            ImageButton BtnRemoveAnnouncement = itemView.findViewById(R.id.BtnRemoveAnnouncement);
            // Handle remove button click
            BtnRemoveAnnouncement.setOnClickListener(v -> {
                if (listener != null) {
                    int position = getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION) {
                        // Show an alert dialog to confirm deletion
                        AlertDialog.Builder builder = new AlertDialog.Builder(itemView.getContext());
                        builder.setTitle("Delete Announcement");
                        builder.setMessage("Sure to delete this announcement?");
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
            builder.setMessage("Announcement successfully deleted");
            builder.setPositiveButton("OK", (dialog, which) -> dialog.dismiss());
            builder.show();
        }
    }
}
