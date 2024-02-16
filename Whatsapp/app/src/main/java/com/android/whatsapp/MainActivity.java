package com.android.whatsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText editTextMessage;
    Button send;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextMessage=(EditText)findViewById(R.id.editTextText2);

        send=(Button)findViewById(R.id.button);

        send.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View arg0) {
                String message=editTextMessage.getText().toString();

                Intent whats = new Intent(Intent.ACTION_SEND);

                whats.setType("text/plain");
                whats.setPackage("com.whatsapp");

                whats.putExtra(Intent.EXTRA_TEXT, message);

                //need this to prompts email client only


                startActivity(whats);

            }

        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
}