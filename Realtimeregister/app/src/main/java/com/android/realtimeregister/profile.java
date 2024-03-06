package com.android.realtimeregister;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class profile extends AppCompatActivity {

    TextView username, email, password, gender, location;
    Button logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        username = findViewById(R.id.prouser);
        email = findViewById(R.id.proemail);
        password = findViewById(R.id.propass);
        gender = findViewById(R.id.progender);
        location = findViewById(R.id.prolocation);

        Intent i = getIntent();

        String prouser = i.getStringExtra("username");
        String proemail = i.getStringExtra("email");
        String propass = i.getStringExtra("password");
        String progen = i.getStringExtra("gender");
        String proloc = i.getStringExtra("location");

        username.setText(prouser);
        email.setText(proemail);
        password.setText(propass);
        gender.setText(progen);
        location.setText(proloc);

        logout = findViewById(R.id.logout);

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(profile.this, Login.class);
                startActivity(i);
            }
        });



    }
}