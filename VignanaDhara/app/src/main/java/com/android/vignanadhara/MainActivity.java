package com.android.vignanadhara;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText search;

    ConstraintLayout phd, tbi, mahotsav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        search = (EditText) findViewById(R.id.editTextText);


        search.setOnFocusChangeListener(new View.OnFocusChangeListener(){
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(hasFocus){
                    search.setHint("");
                }
                else{
                    search.setHint("vignan search..");
                }

            }
        });

        search.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_SEARCH){
                    Intent i = new Intent(getApplicationContext(),search.class);
                    startActivity(i);
                    return true;
                }
                return false;
            }
        });

        phd = (ConstraintLayout) findViewById(R.id.disvig);

        phd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com"));
                startActivity(i);
            }
        });

        tbi = (ConstraintLayout) findViewById(R.id.tbicon);

        tbi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://vignan.ac.in/vignantbi/"));
                startActivity(i);
            }
        });

        mahotsav = (ConstraintLayout) findViewById(R.id.mahotsavcon);

        mahotsav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.vignan.ac.in/mahotsav/"));
                startActivity(i);
            }
        });

    }
}