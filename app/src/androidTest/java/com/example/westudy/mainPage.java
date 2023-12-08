package com.example.weducation;

import android.view.MenuItem;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import android.os.Bundle;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class mainPage extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize NavHostFragment and NavController
        NavHostFragment host = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.NHFMain);
        assert host != null;
        NavController navController = host.getNavController();

        Toolbar toolbar = findViewById(R.id.header);
        setSupportActionBar(toolbar);

        // Define the top-level destinations for the AppBarConfiguration
        appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.DestHome, R.id.DestChat, R.id.DestProfile, R.id.DestNoti, R.id.DestSettings)
                .build();

        // Set up ActionBar with NavController and AppBarConfiguration
        setSupportActionBar(findViewById(R.id.header)); // Set the toolbar as the support action bar

        // Change the text color of the toolbar title
        toolbar.setTitleTextColor(ContextCompat.getColor(this, R.color.white));

        // Change the text style of the toolbar title
        toolbar.setTitleTextAppearance(this, R.style.TextAppearanceHeadline1);

        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);

        // Set up bottom navigation with NavController
        setupBottomNavMenu(navController);
    }


    private void setupBottomNavMenu(NavController navController) {
        BottomNavigationView bottomNav = findViewById(R.id.bottom_nav_view);
        NavigationUI.setupWithNavController(bottomNav, navController);

        bottomNav.setOnItemSelectedListener(item -> {
            int id = item.getItemId();

            // Navigate based on the selected item ID
            if (id == R.id.DestHome) {
                navController.navigate(R.id.DestHome);
            } else if (id == R.id.DestChat) {
                navController.navigate(R.id.DestChat);
            } else if (id == R.id.DestProfile) {
                navController.navigate(R.id.DestProfile);
            } else if (id == R.id.DestNotification) {
                navController.navigate(R.id.DestNotification);
            } else {
                navController.navigate(R.id.DestSettings);
            }
            return true;
        });
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        try {
            return NavigationUI.onNavDestinationSelected(item, Navigation.findNavController(this, R.id.NHFMain))
                    || super.onOptionsItemSelected(item);
        } catch (Exception ex) {
            return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.NHFMain);
        return NavigationUI.navigateUp(navController, appBarConfiguration)
                || super.onSupportNavigateUp();
    }

    public void onBackPressed() {
        // Handle the hand gesture back feature
        // For example, navigate up if there are fragments in the back stack
        NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.NHFMain);
        if (navHostFragment != null && navHostFragment.getChildFragmentManager().getBackStackEntryCount() > 0) {
            navHostFragment.getChildFragmentManager().popBackStack();
        } else {
            super.onBackPressed(); // Let the system handle the back press if there's no fragment in the back stack
        }
    }
}