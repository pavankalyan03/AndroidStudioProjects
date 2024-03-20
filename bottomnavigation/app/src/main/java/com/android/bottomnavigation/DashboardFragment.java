package com.android.bottomnavigation;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.annotation.Nullable;
import com.android.bottomnavigation.databinding.FragmentDashboardBinding;



public class DashboardFragment extends Fragment {



    private FragmentDashboardBinding binding;

    private UserViewModel userViewModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("enty", "Gender: " );
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_dashboard, container, false);

        // Initialize your TextViews here
        TextView puser, pem, password, gender, location, branch;
        puser = view.findViewById(R.id.prouser);
        pem = view.findViewById(R.id.proemail);
        password = view.findViewById(R.id.propass);
        gender = view.findViewById(R.id.progender);
        location = view.findViewById(R.id.prolocation);
        branch = view.findViewById(R.id.probranch);

        Log.d("enty", "Gender: 45" );


        userViewModel = new ViewModelProvider(requireActivity()).get(UserViewModel.class);

        userViewModel.getGender().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String s) {
                // Update UI with gender data
                // For example: genderTextView.setText(s);
                Log.d("enty", "Gender: " + s);
                gender.setText(s);


            }
        });

        userViewModel.getLocation().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String s) {
                // Update UI with location data
                location.setText(s);
            }
        });

        userViewModel.getEmail().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String s) {
                // Update UI with email data
                pem.setText(s);
            }
        });

        userViewModel.getUsername().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String s) {
                // Update UI with username data

                puser.setText(s);
            }
        });

        userViewModel.getPassword().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String s) {
                password.setText(s);
            }
        });

        userViewModel.getBranch().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String s) {
                branch.setText(s);
            }
        });

        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}