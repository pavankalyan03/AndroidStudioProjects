package com.android.model;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private DataViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewModel = new ViewModelProvider(this).get(DataViewModel.class);

        setData("dataaa");

        Intent i = new Intent(getApplicationContext(), test.class);
        startActivity(i);
    }

    // Method to set data in ViewModel
    public void setData(String data) {
        viewModel.setSharedData(data);
    }
}