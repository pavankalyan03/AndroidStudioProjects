package com.example.loginappwithsql;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ProfileActivity extends AppCompatActivity {

    TextView username, dob, phone, email, gender;
    Button logout;
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        username = findViewById(R.id.username);
        dob = findViewById(R.id.dob);
        phone = findViewById(R.id.phone);
        email = findViewById(R.id.email);
        gender = findViewById(R.id.gender);
        logout=findViewById(R.id.logout);

        db = new DatabaseHelper(this);

        String emailValue = getIntent().getStringExtra("email");
        Cursor cursor = db.getUser(emailValue);
        if (cursor.moveToFirst()) {
            do {
                username.setText(cursor.getString(1));
                dob.setText(cursor.getString(2));
                phone.setText(cursor.getString(3));
                email.setText(cursor.getString(4));
                gender.setText(cursor.getString(5));
            } while (cursor.moveToNext());
        }
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProfileActivity.this, MainActivity.class);

                startActivity(intent);
            }
        });
    }
}
