package com.example.loginappwithsql;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class register extends AppCompatActivity {

    EditText username, dob, phone, email, gender, password;
    Button register,login;
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_register);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        username = findViewById(R.id.username);
        dob = findViewById(R.id.dob);
        phone = findViewById(R.id.phone);
        email = findViewById(R.id.email);
        gender = findViewById(R.id.gender);
        password = findViewById(R.id.password);
        register = findViewById(R.id.register);
        login=findViewById(R.id.login);

        db = new DatabaseHelper(this);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = username.getText().toString();
                String dobValue = dob.getText().toString();
                String phoneValue = phone.getText().toString();
                String emailValue = email.getText().toString();
                String genderValue = gender.getText().toString();
                String pass = password.getText().toString();

                long val = db.addUser(user, pass, dobValue, phoneValue, emailValue, genderValue);
                if (val > 0) {
                    Toast.makeText(register.this, "Registration Successful", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(register.this, "Registration Failed", Toast.LENGTH_SHORT).show();
                }
            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(register.this, MainActivity.class);

                startActivity(intent);
            }
        });

    }
}