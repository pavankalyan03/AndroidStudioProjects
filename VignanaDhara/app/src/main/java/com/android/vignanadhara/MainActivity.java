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
                Intent i = new Intent(MainActivity.this, webview.class);
                i.putExtra("instagram",search.getQuery().toString());
                startActivity(i);


                return true;
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

        androidData = new DataClass("Amar Jukuntla", R.string.faculty, R.drawable.amar, "Faculty");
        dataList.add(androidData);

        androidData = new DataClass("Bala Krishna", R.string.faculty, R.drawable.ml, "Faculty");
        dataList.add(androidData);

        androidData = new DataClass("C.K.Rao", R.string.faculty, R.drawable.ckr, "Faculty");
        dataList.add(androidData);

        androidData = new DataClass("Akash", R.string.Akash, R.drawable.akash, "student");
        dataList.add(androidData);

        androidData = new DataClass("Shivasai", R.string.shivsai, R.drawable.shivasai, "student");
        dataList.add(androidData);

        androidData = new DataClass("Adhi", R.string.Adhi, R.drawable.adhi, "student");
        dataList.add(androidData);

        androidData = new DataClass("Vaibai", R.string.Vaibav, R.drawable.vaibav, "student");
        dataList.add(androidData);

        androidData = new DataClass("Mayookh", R.string.Mayookh, R.drawable.mayookh, "student");
        dataList.add(androidData);

        androidData = new DataClass("Sri Vardhan", R.string.Sri_Vardhan, R.drawable.vardhan, "student");
        dataList.add(androidData);

        androidData = new DataClass("Dr. L. Rathaiah", R.string.Chairman, R.drawable.chairman, "Chairman");
        dataList.add(androidData);

        androidData = new DataClass("Dr. P. Nagabhushan", R.string.vice, R.drawable.vice, "Vice Chancellor");
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