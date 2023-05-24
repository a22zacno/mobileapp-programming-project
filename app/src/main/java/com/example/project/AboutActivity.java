package com.example.project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class AboutActivity extends AppCompatActivity {

    private WebView aboutWebView;

    public void showMain(View view){
        //Starts the main activity
        Intent i = new Intent(AboutActivity.this, MainActivity.class);
        startActivity(i);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        aboutWebView = (WebView) findViewById(R.id.my_webview);
        WebViewClient aboutClient = new WebViewClient();
        aboutWebView.setWebViewClient(aboutClient);
        aboutWebView.getSettings().setJavaScriptEnabled(true);
        aboutWebView.loadUrl("file///assets/About.html");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Creates and inflates the menu
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //Switches to the primary activity if pressed
        int id = item.getItemId();

        if (id == R.id.mainscreen) {
            showMain(findViewById(R.id.aboutMenu));
            Log.d("==>","Displays about page for the app");
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}