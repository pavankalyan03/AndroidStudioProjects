package com.android.vignanadhara;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
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


        SharedPreferences i = getSharedPreferences("myPrefs", MODE_PRIVATE);

        String prouser = i.getString("username","");
        String proemail = i.getString("email","");
        String propass = i.getString("password","");
        String progen = i.getString("gender","");
        String proloc = i.getString("location","");

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