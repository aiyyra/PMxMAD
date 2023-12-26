package com.example.westudy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.westudy.Model.ChatroomModel;
import com.example.westudy.Model.UserModel;
import com.example.westudy.Utils.AndroidUtil;
import com.example.westudy.Utils.FirebaseUtil;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.Timestamp;
import com.google.firebase.firestore.DocumentSnapshot;

import java.util.Arrays;

public class ChatPersonal extends AppCompatActivity {

    UserModel otherUser;
    String chatroomId;
    ChatroomModel chatroomModel;

    EditText ETMessageInput;
    TextView TVOtherUsername;
    ImageButton IBtnBack, IBtnSendMessage;
    RecyclerView RVChatView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chat_personal);

        otherUser = AndroidUtil.getUserModelAsIntent(getIntent());
        chatroomId = FirebaseUtil.getChatroomId(FirebaseUtil.currentUserID(),otherUser.getUserID());

        ETMessageInput = findViewById(R.id.ETMessageInput);
        TVOtherUsername = findViewById(R.id.TVOtherUsername);
        IBtnSendMessage = findViewById(R.id.IBtnSendMessage);
        IBtnBack = findViewById(R.id.IBtnBack);
        RVChatView = findViewById(R.id.RVChatView);

        IBtnBack.setOnClickListener(v -> {
            onBackPressed();
        });

        TVOtherUsername.setText(otherUser.getEmail().toString());

        getOrCreateChatroomModel();

    }

    void getOrCreateChatroomModel(){
        FirebaseUtil.getChatroomReference(chatroomId).get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if(task.isSuccessful()){
                    chatroomModel = task.getResult().toObject(ChatroomModel.class);
                    if(chatroomModel ==null){
                        chatroomModel = new ChatroomModel(
                                chatroomId,
                                Arrays.asList(FirebaseUtil.currentUserID(),otherUser.getUserID()),
                                Timestamp.now(),
                                ""
                        );
                        FirebaseUtil.getChatroomReference(chatroomId).set(chatroomModel);
                    }
                }
            }
        });
    }
}