package com.android.bottomnavigation;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.android.bottomnavigation.databinding.NavigationBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class navigation extends AppCompatActivity {

    private NavigationBinding binding;
    private UserViewModel userViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        userViewModel = new ViewModelProvider(this).get(UserViewModel.class);

        Intent i = getIntent();

        String navuser = i.getStringExtra("username");
        String navemail = i.getStringExtra("email");
        String navpass = i.getStringExtra("password");
        String navgen = i.getStringExtra("gender");
        String navloc = i.getStringExtra("location");
        String navbran = i.getStringExtra("branch");

        userViewModel.setUsername(navuser);
        userViewModel.setEmail(navemail);
        userViewModel.setPassword(navpass);
        userViewModel.setGender(navgen);
        userViewModel.setLocation(navloc);
        userViewModel.setBranch(navbran);


        binding = NavigationBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(binding.navView, navController);
    }

}