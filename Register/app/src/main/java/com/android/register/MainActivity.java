package com.android.register;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentFactory;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void replacefrag(Fragment fg){
        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainerView, fg).commit();
    }
     public void replacedown(Fragment fg){
        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainerView3, fg).commit();
     }
}