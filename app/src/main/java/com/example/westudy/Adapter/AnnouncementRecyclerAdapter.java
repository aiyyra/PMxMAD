package com.example.westudy.Adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.westudy.ChatPersonal;
import com.example.westudy.Model.AnnouncementModel;
import com.example.westudy.AnnouncementMainFragment;
import com.example.westudy.Model.ChatroomModel;
import com.example.westudy.Model.UserModel;
import com.example.westudy.OnRemoveClickListener;
import com.example.westudy.R;
import com.example.westudy.Utils.AndroidUtil;
import com.example.westudy.Utils.FirebaseUtil;
import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.Timestamp;

import java.util.ArrayList;

public class AnnouncementRecyclerAdapter extends FirestoreRecyclerAdapter<AnnouncementModel, AnnouncementRecyclerAdapter.AnnouncementModelViewHolder> {

    Context context;
    ArrayList<AnnouncementModel> announcementArrayList;
    public AnnouncementRecyclerAdapter(@NonNull FirestoreRecyclerOptions<AnnouncementModel> options, Context context) {
        super(options);
        this.context= context;
    }

    @Override
    protected void onBindViewHolder(@NonNull AnnouncementModelViewHolder holder, int position, @NonNull AnnouncementModel model) {
        FirebaseUtil.getAllAnnouncementReference()
                .get().addOnCompleteListener(task -> {
                    if(task.isSuccessful()){
                        holder.TVAnnouncementContent.setText(model.getTVAnnouncementContent());
                        holder.AnnouncementTimestamp.setText(FirebaseUtil.timestampToString(model.getAnnouncementTimestamp()));
                    }
                });
    }

    @NonNull
    @Override
    public AnnouncementModelViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.individual_announcement_view,parent, false);
        return new AnnouncementModelViewHolder(view);
    }

    class AnnouncementModelViewHolder extends RecyclerView.ViewHolder{

        TextView TVAnnouncementContent;
        TextView AnnouncementTimestamp;
        public AnnouncementModelViewHolder(@NonNull View itemView) {
            super(itemView);

            TVAnnouncementContent = itemView.findViewById(R.id.TVAnnouncementContent);
            AnnouncementTimestamp = itemView.findViewById(R.id.TVDateAnnouncement);

        }
    }
}
