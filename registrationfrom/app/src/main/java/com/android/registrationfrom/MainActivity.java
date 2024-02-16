package com.android.registrationfrom;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button but1, but2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void replacemain(Fragment frag){
        getSupportFragmentManager().beginTransaction().replace(R.id.main, frag).commit();
    }

    public void replacedown(Fragment frag){
        getSupportFragmentManager().beginTransaction().replace(R.id.down, frag).commit();
    }
}