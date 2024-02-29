package com.android.vignanadhara;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Detailed_View extends AppCompatActivity {

    TextView detaildesc, detailtitle;

    ImageView detailimg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed_view);

        detaildesc = findViewById(R.id.det);
        detailtitle = findViewById(R.id.detailname);
        detailimg = findViewById(R.id.detailimg);

        Bundle bundle = getIntent().getExtras();
        if(bundle != null){
            detailtitle.setText(bundle.getString("Title"));
            detailimg.setImageResource(bundle.getInt("Image"));
            detaildesc.setText(bundle.getInt("Desc"));
        }

    }
}