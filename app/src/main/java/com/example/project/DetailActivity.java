package com.example.project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.text.util.Linkify;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    public void showAbout(View view){
        //Starts the about activity
        Intent i = new Intent(DetailActivity.this, AboutActivity.class);
        startActivity(i);
    }

    public void showMain(View view){
        //Starts the main activity
        Intent i = new Intent(DetailActivity.this, MainActivity.class);
        startActivity(i);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Bundle extras = getIntent().getExtras();
        String name = null;
        String capital = null;
        int establish = 0;
        int disestablish = 0;
        String wikipedia = null;
        if (extras != null) {
            name = extras.getString("name");
            capital = extras.getString("capital");
            establish = extras.getInt("establish");
            disestablish = extras.getInt("disestablish");
            wikipedia = extras.getString("wikipedia");
        }


        TextView nameView = findViewById(R.id.nameView);
        TextView capitalView = findViewById(R.id.capitalView);
        TextView establishView = findViewById(R.id.establishView);
        TextView disestablishView = findViewById(R.id.disestablishView);
        TextView wikiView = findViewById(R.id.wikiView);
        nameView.setText(name);
        capitalView.setText("Their capital/capitals were " + capital);
        establishView.setText("Their realm was established in " + establish + " AD");
        disestablishView.setText("Their realm dissolved in " + disestablish + " AD");
        wikiView.setText("Wikipedia Link:" + wikipedia);
        Linkify.addLinks(wikiView, Linkify.WEB_URLS);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Creates and inflates the menu
        getMenuInflater().inflate(R.menu.details_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //Switches to the second activity if pressed
        int id = item.getItemId();

        if (id == R.id.about) {
            showAbout(findViewById(R.id.detailMenu));
            Log.d("==>","Displays about page for the app");
            return true;
        }

        if (id == R.id.mainscreen) {
            showMain(findViewById(R.id.detailMenu));
            Log.d("==>","Displays about page for the app");
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}