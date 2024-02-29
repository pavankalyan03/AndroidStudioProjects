package com.android.vignanadhara;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    SearchView search;
    RecyclerView recyclerView;
    List<DataClass> dataList;
    MyAdapter adapter;
    DataClass androidData;

    ConstraintLayout phd, tbi, mahotsav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycle);

        search = findViewById(R.id.searchtext);

        search.clearFocus();

        search.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                searchList(newText);
                return true;
            }
        });

        LinearLayoutManager linearLayout = new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(linearLayout);
        dataList = new ArrayList<>();

        androidData = new DataClass("Sri Vardhan", "hii everyone", R.drawable.vardhan, "Student");
        dataList.add(androidData);

        androidData = new DataClass("Akash", "hii crr", R.drawable.akash, "Student");
        dataList.add(androidData);

        androidData = new DataClass("Mayookh", "hii ", R.drawable.mayookh, "student");
        dataList.add(androidData);

        adapter = new MyAdapter(MainActivity.this,dataList);
        recyclerView.setAdapter(adapter);



    }

    private void searchList(String text){
        List<DataClass> datasearchlist = new ArrayList<>();
        for(DataClass data : dataList){
            if(data.getDatatitle().toLowerCase().contains(text.toLowerCase())){
                datasearchlist.add(data);
            }
        }
        if(datasearchlist.isEmpty()){
            Toast.makeText(this, "not found", Toast.LENGTH_SHORT).show();
        }
        else{
            adapter.setSearchList(datasearchlist);
        }
    }
}