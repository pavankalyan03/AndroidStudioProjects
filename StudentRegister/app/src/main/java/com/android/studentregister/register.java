package com.android.studentregister;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class register extends AppCompatActivity {

    TextInputEditText user, pass;
    Button reg, ref;

    FirebaseAuth mAuth;

    ProgressBar prog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        user = findViewById(R.id.usernamer);
        pass = findViewById(R.id.passwordr);
        reg = findViewById(R.id.registerbutton);
        prog = findViewById(R.id.progress);

        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                prog.setVisibility(View.VISIBLE);
                String users, spass;
                mAuth = FirebaseAuth.getInstance();
                users = String.valueOf(user.getText());
                spass = String.valueOf(pass.getText());

                if (users.isEmpty()){
                    Toast.makeText(register.this,"Enter email",Toast.LENGTH_SHORT).show();
                }

                if (spass.isEmpty()){
                    Toast.makeText(register.this,"Enter Password",Toast.LENGTH_SHORT).show();
                }


                mAuth.createUserWithEmailAndPassword(users, spass)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    prog.setVisibility(View.GONE);
                                    // Sign in success, update UI with the signed-in user's information
                                    Log.d(TAG, "signInWithEmail:success");
                                    Toast.makeText(register.this, "Authentication success.",
                                            Toast.LENGTH_SHORT).show();


                                } else {
                                    prog.setVisibility(View.GONE);
                                    // If sign in fails, display a message to the user.
                                                        Log.w(TAG, "signInWithEmail:failure", task.getException());
                                    Toast.makeText(register.this, "Authentication failed.",
                                            Toast.LENGTH_SHORT).show();

                                }
                            }
                        });

            }
        });
        ref = findViewById(R.id.reflogin);

        ref.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Login.class);
                startActivity(i);
            }
        });



    }
}