package com.android.bottomnavigation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class signup extends AppCompatActivity {

    EditText username, email, password, repassword, location, branch;
    RadioGroup gender;

    RadioButton male, female;

    String sex;

    Button reg, backlo;

    FirebaseDatabase firebaseDatabase;

    DatabaseReference databaseReference;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        gender = findViewById(R.id.radioGroup);
        male = findViewById(R.id.regmale);
        female = findViewById(R.id.regfemale);

        gender.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (male.isChecked()){
                    sex = "Male";
                }
                if (female.isChecked()){
                    sex = "Female";
                }
            }
        });


        username = findViewById(R.id.reguser);
        email = findViewById(R.id.regemail);
        password = findViewById(R.id.regpass);
        repassword = findViewById(R.id.regrepass);
        location = findViewById(R.id.reglocation);
        reg = findViewById(R.id.register);
        backlo = findViewById(R.id.backlogin);
        branch = findViewById(R.id.regbranch);

        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                firebaseDatabase = FirebaseDatabase.getInstance();
                databaseReference = firebaseDatabase.getReference("users");

                String signuser = username.getText().toString();
                String signemail = email.getText().toString();
                String signpass = password.getText().toString();
                String signlocation = location.getText().toString();
                String signbranch = branch.getText().toString();

                if (signuser.isEmpty() | signemail.isEmpty() | signpass.isEmpty()){
                    Toast.makeText(signup.this,"Enter Required Fields", Toast.LENGTH_SHORT).show();
                }
                else{
                    HelperClass helperClass = new HelperClass(signuser, signemail, signpass, sex, signlocation, signbranch);
                    databaseReference.child(signuser).setValue(helperClass);

                    Toast.makeText(signup.this, "Registered Sucessfully",Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(signup.this, login.class);
                    startActivity(i);
                }




            }
        });

        backlo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(signup.this, login.class);
                startActivity(i);
            }
        });




    }
}