package com.example.fragmentslogin;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;


public class details extends Fragment {
    EditText first,last,gender,dob,address;
    Button logout;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_details, container, false);
        helper shared = new ViewModelProvider(requireActivity()).get(helper.class);


        first = view.findViewById(R.id.editTextText4);
        last = view.findViewById(R.id.editTextText6);
        gender = view.findViewById(R.id.editTextText7);
        dob = view.findViewById(R.id.editTextText8);
        address = view.findViewById(R.id.editTextText9);
        logout = view.findViewById(R.id.logout);

        shared.getFname().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String s) {
                first.setText("Your first name is: " + s);
            }
        });

        shared.getLname().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String s) {
                last.setText("Your Last Name is: " + s);;
            }
        });

        shared.getGen().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String s) {
                gender.setText("Your Gender is: " + s);
            }
        });

        shared.getDob().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String s) {
                dob.setText("Your Date of Birth: " + s);
            }
        });

        shared.getAddr().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String s) {
                address.setText("Your address is: " + s);
            }
        });



        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity) requireActivity()).replacetopfrag(new Homescreen());
                ((MainActivity) requireActivity()).replacebottomfrag(new homebuttons());
            }
        });

        return view;
    }
}