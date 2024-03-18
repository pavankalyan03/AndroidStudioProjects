package com.android.model;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link test#newInstance} factory method to
 * create an instance of this fragment.
 */
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

public class test extends Fragment {
    private DataViewModel viewModel;

    TextView fu;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = new ViewModelProvider(requireActivity()).get(DataViewModel.class);



    }

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_test, container, false);

        fu = view.findViewById(R.id.fuck);
        String te = getData();
        fu.setText(te);


        return view;
    }

    // Method to get data from ViewModel
    public String getData() {
        return viewModel.getSharedData();
    }
}
