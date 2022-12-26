package com.igk.retrofitjava;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import android.widget.TextView;

public class DisplayNews extends AppCompatActivity {

    WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_news);
        webView = findViewById(R.id.webView);
        Intent intent = getIntent();
        webView.loadUrl(intent.getStringExtra("url"));
        webView.canGoBack();
    }
}