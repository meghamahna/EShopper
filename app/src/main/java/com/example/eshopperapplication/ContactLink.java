package com.example.eshopperapplication;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.appcompat.app.AppCompatActivity;

public class ContactLink extends AppCompatActivity{
 private  WebView webview;


    private ProgressDialog progDailog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_link);
        Intent i = getIntent();
        String link = i.getExtras().getString("link");

        webview = (WebView)findViewById(R.id.webview);
        webview.setWebViewClient(new WebViewClient());

//        webview.getSettings().setJavaScriptEnabled(true);
//        webview.getSettings().setLoadWithOverviewMode(true);
//        webview.getSettings().setAppCacheEnabled(true );
//        webview.getSettings().setUseWideViewPort(true);




     webview.loadUrl(link);




    }
}
