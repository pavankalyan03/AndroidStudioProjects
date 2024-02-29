package com.android.vignanadhara;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;

public class webview extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);

        Intent i = getIntent();
        String reurl = i.getStringExtra("instagram");

        WebView wb = findViewById(R.id.webview);
        wb.loadUrl(reurl);

    }
}