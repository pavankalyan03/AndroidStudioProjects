package com.example.socialmedia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Objects;

public class details extends AppCompatActivity {

    ImageView imageView;

    TextView bookname, authorname, year, desc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        Intent i = getIntent();

        imageView = findViewById(R.id.imageView);
        bookname = findViewById(R.id.textView);
        authorname = findViewById(R.id.textView6);
        year = findViewById(R.id.textView7);
        desc = findViewById(R.id.textView8);






        String val = i.getStringExtra("img");
        if (Objects.equals(val, "book1")) {
            String name = i.getStringExtra("bookname");
            String auth = i.getStringExtra("AuthorName");
            String ye = i.getStringExtra("Year");
            String de = i.getStringExtra("desc");

            imageView.setImageResource(R.drawable.b1);
            bookname.setText(name);
            authorname.setText(auth);
            year.setText(ye);
            desc.setText(de);
        }


        if (Objects.equals(val, "book2")) {
            String name = i.getStringExtra("bookname");
            String auth = i.getStringExtra("AuthorName");
            String ye = i.getStringExtra("Year");
            String de = i.getStringExtra("desc");

            imageView.setImageResource(R.drawable.b2);
            bookname.setText(name);
            authorname.setText(auth);
            year.setText(ye);
            desc.setText(de);
        }

        if (Objects.equals(val, "book3")) {
            String name = i.getStringExtra("bookname");
            String auth = i.getStringExtra("AuthorName");
            String ye = i.getStringExtra("Year");
            String de = i.getStringExtra("desc");

            imageView.setImageResource(R.drawable.b3);
            bookname.setText(name);
            authorname.setText(auth);
            year.setText(ye);
            desc.setText(de);
        }

        if (Objects.equals(val, "book4")) {
            String name = i.getStringExtra("bookname");
            String auth = i.getStringExtra("AuthorName");
            String ye = i.getStringExtra("Year");
            String de = i.getStringExtra("desc");

            imageView.setImageResource(R.drawable.b4);
            bookname.setText(name);
            authorname.setText(auth);
            year.setText(ye);
            desc.setText(de);
        }

    }
}