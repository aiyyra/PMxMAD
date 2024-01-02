package com.example.westudy;

import static android.app.PendingIntent.getActivity;
import static java.security.AccessController.getContext;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

import com.example.westudy.Adapter.SearchUserRecyclerAdapter;
import com.example.westudy.Model.UserModel;
import com.example.westudy.Utils.FirebaseUtil;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.firestore.Query;

public class ChatSearchUser extends AppCompatActivity {

    EditText ETSearchUser;
    ImageButton IBSearchButton,IBBackBtn;
    RecyclerView RVUserList;

    SearchUserRecyclerAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_search_user);

        ETSearchUser = findViewById(R.id.ETSearchUser);
        IBSearchButton = findViewById(R.id.IBSearchButton);
        RVUserList = findViewById(R.id.RVUserList);
        IBBackBtn = findViewById(R.id.IBtnBack);

        IBBackBtn.setOnClickListener(v -> {
            onBackPressed();
        });

        setupSearchRecyclerView("");
        ETSearchUser.requestFocus();

        IBSearchButton.setOnClickListener( v -> {
            String searchTerm = ETSearchUser.getText().toString();
            setupSearchRecyclerView(searchTerm);
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        if(adapter!=null){
            adapter.startListening();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        if(adapter!=null){
            adapter.stopListening();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if(adapter!=null){
            adapter.notifyDataSetChanged();
        }
    }

    void setupSearchRecyclerView(String searchTerm) {

        Query query = FirebaseUtil.allUserCollectionReference()
                .whereGreaterThanOrEqualTo("username",searchTerm);

        FirestoreRecyclerOptions<UserModel> options = new FirestoreRecyclerOptions.Builder<UserModel>()
                .setQuery(query, UserModel.class).build();

        adapter = new SearchUserRecyclerAdapter(options,this.getApplicationContext());
        RVUserList.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        RVUserList.setAdapter(adapter);
        adapter.startListening();
    }

}