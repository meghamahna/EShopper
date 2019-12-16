package com.example.eshopperapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class ClothBrands extends AppCompatActivity {

    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cloth_brands);


        Intent intent = getIntent();
        String link = intent.getExtras().getString("link");

        webView = (WebView)findViewById(R.id.webview);
        webView.setWebViewClient(new WebViewClient());

        webView.loadUrl(link);



    }
}
