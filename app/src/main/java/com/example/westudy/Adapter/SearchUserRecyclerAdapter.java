package com.example.westudy.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.westudy.ChatPersonal;
import com.example.westudy.Model.UserModel;
import com.example.westudy.R;
import com.example.westudy.Utils.AndroidUtil;
import com.example.westudy.Utils.FirebaseUtil;
import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;

public class SearchUserRecyclerAdapter extends FirestoreRecyclerAdapter<UserModel, SearchUserRecyclerAdapter.UserModelViewHolder> {


    Context context;
    /**
     * Create a new RecyclerView adapter that listens to a Firestore Query.  See {@link
     * FirestoreRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public SearchUserRecyclerAdapter(@NonNull FirestoreRecyclerOptions<UserModel> options, Context context) {
        super(options);
        this.context= context;
    }

    @Override
    protected void onBindViewHolder(@NonNull UserModelViewHolder holder, int position, @NonNull UserModel model) {
        holder.username.setText(model.getUsername());
        holder.email.setText(model.getEmail());
        if(model.getUserID().equals(FirebaseUtil.currentUserID())){
            holder.username.setText(model.getUsername()+"(ME)");
        }

        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(context, ChatPersonal.class);
            AndroidUtil.passUserModelAsIntent(intent,model);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);

        });
    }

    @NonNull
    @Override
    public UserModelViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.individual_chat_view,parent,false);
        return new UserModelViewHolder(view);
    }

    class UserModelViewHolder extends RecyclerView.ViewHolder{

        TextView email,username;
        ImageView profilePic;

        public UserModelViewHolder(@NonNull View itemView) {
            super(itemView);

            username = itemView.findViewById(R.id.TVUsername);
            email = itemView.findViewById(R.id.TVEmail);
            profilePic = itemView.findViewById(R.id.IVTempProfilePic);
        }
    }
}
