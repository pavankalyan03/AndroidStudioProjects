package com.example.fragments;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;

import android.view.View;
import android.widget.Button;
import android.os.Bundle;

public class MainActivity2 extends AppCompatActivity {

    private SharedViewModel sharedViewModel;

    Button but, but1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        sharedViewModel = new ViewModelProvider(this).get(SharedViewModel.class);

        String message = "Hi from sending activitsdgy!";
        sharedViewModel.setMessage(message);

        but = (Button) findViewById(R.id.button1);
        but1 = (Button) findViewById(R.id.button2);
        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replaceable(new frag1());

            }
        });

        but1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replaceable(new frag2());
            }
        });
    }


    public void replaceable(Fragment frag){
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.frag, frag);
        transaction.commit();


    }
}