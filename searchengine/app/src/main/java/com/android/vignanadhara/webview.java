package com.android.vignanadhara;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class webview extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);
        WebView wb = findViewById(R.id.webview);
        wb.setWebViewClient(new WebViewClient());
        wb.getSettings().setJavaScriptEnabled(true);

        Intent i = getIntent();
        String reurl = i.getStringExtra("query");

        String ui = "https://google.com/search?q="+reurl;


        wb.loadUrl(ui);

    }
}