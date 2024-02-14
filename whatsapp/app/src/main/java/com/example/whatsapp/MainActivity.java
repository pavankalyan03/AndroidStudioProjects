package com.example.whatsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    EditText message;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        message = findViewById(R.id.editTextText);
        button = findViewById(R.id.button);


        button.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                String msg = message.getText().toString();

                Intent what = new Intent(Intent.ACTION_SEND);

                what.setType("text/plain");
                what.setPackage("com.whatsapp");

                what.putExtra(Intent.EXTRA_TEXT, msg);

                startActivity(what);


            }
        });
    }

    private void onClick(){

    }
}