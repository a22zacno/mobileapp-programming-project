package com.example.project;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity{

    public void showAbout(View view){
        //Starts the about activity
        Intent i = new Intent(MainActivity.this, AboutActivity.class);
        startActivity(i);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //new JsonTask(this).execute("https://mobprog.webug.se/json-api?login=a22zacno");

        ArrayList<RecyclerViewItem> items = new ArrayList<>(Arrays.asList(
                new RecyclerViewItem("test1"),
                new RecyclerViewItem("test2"),
                new RecyclerViewItem("test3")
        ));

        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, items, new RecyclerViewAdapter.OnClickListener() {
            @Override
            public void onClick(RecyclerViewItem item) {
                Toast.makeText(MainActivity.this, item.getTitle(), Toast.LENGTH_SHORT).show();
            }
        });

        RecyclerView view = findViewById(R.id.recycler_view);
        view.setLayoutManager(new LinearLayoutManager(this));
        view.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Creates and inflates the menu
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //Switches to the second activity if pressed
        int id = item.getItemId();

        if (id == R.id.about) {
            showAbout(findViewById(R.id.mainMenu));
            Log.d("==>","Displays about page for the app");
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
