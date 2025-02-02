package com.example.project;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements JsonTask.JsonTaskListener{

    private final String JSON_URL = "https://mobprog.webug.se/json-api?login=a22zacno";

    public void showAbout(View view){
        //Starts the about activity
        Intent i = new Intent(MainActivity.this, AboutActivity.class);
        startActivity(i);
    }

    public void detailedInfo(Dynasty item){
        Intent i = new Intent(MainActivity.this, DetailActivity.class);
        //adds the data of the dynasty
        i.putExtra("name", item.getName());
        i.putExtra("capital", item.getCapital());
        i.putExtra("establish", item.getEstablish());
        i.putExtra("disestablish", item.getDisestablish());
        i.putExtra("wikipedia", item.getWikipedia());
        startActivity(i);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        new JsonTask(this).execute(JSON_URL);
    }

    @Override
    protected void onResume() {
        super.onResume();
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
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

    @Override
    public void onPostExecute(String json) {
        Log.d("MainActivity", json);
        Gson gson = new Gson();

        Type type = new TypeToken<ArrayList<Dynasty>>() {}.getType();
        ArrayList<Dynasty> dynastyArrayList = gson.fromJson(json, type);

        RecyclerView view = findViewById(R.id.recycler_view);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(MainActivity.this, dynastyArrayList, new RecyclerViewAdapter.OnClickListener() {
            @Override
            public void onClick(Dynasty item) {
                detailedInfo(item);
                Log.d("==>","Displays detailed dynastic info");
            }
        });

        view.setAdapter(adapter);
        view.setLayoutManager(new LinearLayoutManager(MainActivity.this));
    }
}
