package com.example.westudy;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.westudy.Adapter.AnnouncementRecyclerAdapter;
import com.example.westudy.Model.AnnouncementModel;
import com.example.westudy.Utils.FirebaseUtil;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.firestore.Query;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AnnouncementMainFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AnnouncementMainFragment extends Fragment{

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;




    public AnnouncementMainFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AnnouncementMainFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AnnouncementMainFragment newInstance(String param1, String param2) {
        AnnouncementMainFragment fragment = new AnnouncementMainFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    Button BtnNewAnnouncement;
    AnnouncementRecyclerAdapter adapter;
    private RecyclerView RVAnnouncement;
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
        View view = inflater.inflate(R.layout.fragment_announcement_main, container, false);

        RVAnnouncement = view.findViewById(R.id.RVAnnouncement);
        BtnNewAnnouncement = view.findViewById(R.id.BtnNewAnnouncement);
        BtnNewAnnouncement.setOnClickListener(v -> {
            try {
                Navigation.findNavController(v).navigate(R.id.action_announcementMainFragment_to_announcementPostFragment);
            } catch (Exception e) {
                Log.e("NavigationError", "Error navigating to BookAppointmentFragment: " + e.getMessage());
            }
        });

        setupAnnouncementRecyclerView();

        return view;
    }

     void setupAnnouncementRecyclerView(){
         Query query = FirebaseUtil.getAllAnnouncementReference()
                 .orderBy("announcementTimestamp", Query.Direction.DESCENDING);

         FirestoreRecyclerOptions<AnnouncementModel> options = new FirestoreRecyclerOptions.Builder<AnnouncementModel>()
                 .setQuery(query,AnnouncementModel.class).build();

         adapter = new AnnouncementRecyclerAdapter(options, getContext());
         LinearLayoutManager manager = new LinearLayoutManager(getContext());
         RVAnnouncement.setLayoutManager(manager);
         RVAnnouncement.setAdapter(adapter);
         adapter.startListening();
         adapter.registerAdapterDataObserver(new RecyclerView.AdapterDataObserver() {
             @Override
             public void onItemRangeInserted(int positionStart, int itemCount) {
                 super.onItemRangeInserted(positionStart, itemCount);
                 RVAnnouncement.smoothScrollToPosition(0);
             }
         });
     }
    @Override
    public void onStart() {
        super.onStart();
        if(adapter!=null){
            adapter.startListening();
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        if(adapter!=null){
            adapter.stopListening();
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        if(adapter!=null){
            adapter.notifyDataSetChanged();
        }
    }
}