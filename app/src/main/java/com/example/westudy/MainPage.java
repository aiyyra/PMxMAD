package com.example.westudy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.content.res.ColorStateList;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;

public class MainPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);

        Toolbar toolbar = findViewById(R.id.TBMain);
        setSupportActionBar(toolbar);

        // Change the text color of the toolbar title
        toolbar.setTitleTextColor(ContextCompat.getColor(this, R.color.white));

        // Change the text style of the toolbar title
        toolbar.setTitleTextAppearance(this, R.style.TextAppearanceToolbar);

        // Initialize NavHostFragment and NavController
        NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.NHFMain);
        assert navHostFragment != null;
        NavController navController = navHostFragment.getNavController();

        // Define the top-level destinations for the AppBarConfiguration
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();

        // Set up ActionBar with NavController and AppBarConfiguration
        setSupportActionBar(findViewById(R.id.TBMain)); // Set the toolbar as the support action bar
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);

        // Set up bottom navigation with NavController
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

        // Change the text color of the bottom navigation view
        bottomNavigationView.setItemTextColor(ColorStateList.valueOf(ContextCompat.getColor(this,R.color.white)));

        // Change the text style of bottom bar title
        bottomNavigationView.setItemTextAppearanceActive(R.style.TextAppearanceBottomBar);

        // Set the background for the icon in the bottom navigation view
        bottomNavigationView.setItemActiveIndicatorColor(ColorStateList.valueOf(ContextCompat.getColor(this,R.color.transparent)));
    }
}