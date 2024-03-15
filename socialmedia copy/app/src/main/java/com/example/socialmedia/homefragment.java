package com.example.socialmedia;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.imageview.ShapeableImageView;


public class homefragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_homefragment, container, false);

        ShapeableImageView img1, img2, img3, img4,img5,img6,img7,img8;

        img1 = view.findViewById(R.id.image1);
        img2 = view.findViewById(R.id.image2);
        img3 = view.findViewById(R.id.image3);
        img4 = view.findViewById(R.id.image4);
        img5 = view.findViewById(R.id.image5);
        img6 = view.findViewById(R.id.image6);
        img7 = view.findViewById(R.id.image7);
        img8 = view.findViewById(R.id.image8);

        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), details.class);
                String desc = getString(R.string.app_name);
                i.putExtra("img","book1");
                i.putExtra("bookname","name1");
                i.putExtra("AuthorName", "author name1");
                i.putExtra("Year", "45");
                i.putExtra("desc","this is book1");
                startActivity(i);


            }
        });

        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), details.class);
                String desc = getString(R.string.app_name);
                i.putExtra("img","book2");
                i.putExtra("bookname","name2");
                i.putExtra("AuthorName", "author name2");
                i.putExtra("Year", "78");
                i.putExtra("desc","this is book2");
                startActivity(i);


            }
        });

        img3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), details.class);
                String desc = getString(R.string.app_name);
                i.putExtra("img","book3");
                i.putExtra("bookname","name3");
                i.putExtra("AuthorName", "author name3");
                i.putExtra("Year", "89");
                i.putExtra("desc","this is book3");
                startActivity(i);


            }
        });

        img4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), details.class);
                String desc = getString(R.string.app_name);
                i.putExtra("img","book4");
                i.putExtra("bookname","name4");
                i.putExtra("AuthorName", "author name4");
                i.putExtra("Year", "78");
                i.putExtra("desc","this is book4");
                startActivity(i);


            }
        });


    return view;
    }
}