package com.example.westudy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;

public class MainPage extends AppCompatActivity {


//    Take a button; FirebaseAuth.getInstance().signOut(); Intent to login page; finish activity

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);

        Toolbar toolbar = findViewById(R.id.TBMain);
        setSupportActionBar(toolbar);

        NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.NHFMain);
        NavController navController = navHostFragment.getNavController();

        setupBottomNavMenu(navController);
}
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_bottom, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        try {
            Navigation.findNavController(this, R.id.NHFMain).navigate(item.getItemId());
            return true;
        } catch (Exception exception) {
            return super.onOptionsItemSelected(item);
        }
    }
    @Override
    public boolean onSupportNavigateUp() {
        return Navigation.findNavController(this, R.id.NHFMain).navigateUp();
    }
    private void setupBottomNavMenu(NavController navController) {
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_nav);
        NavigationUI.setupWithNavController(bottomNavigationView, navController);
    }
}