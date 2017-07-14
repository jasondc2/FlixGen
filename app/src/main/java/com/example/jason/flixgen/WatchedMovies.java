package com.example.jason.flixgen;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import org.json.JSONObject;

import java.util.ArrayList;


/**
 * Created by jason on 7/9/2017.
 */

public class WatchedMovies extends AppCompatActivity {

    private Button home;
    private Button dna;
    private Button recs;
    private Button login;

    private ListView lv;

    final DBHelper db = new DBHelper(this);

    ArrayList<String> tester = new ArrayList<String>();

    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.watched_movies);


        home = (Button) findViewById(R.id.home);
        dna = (Button) findViewById(R.id.userdna);
        recs = (Button) findViewById(R.id.movie);
        login = (Button) findViewById(R.id.login);

        lv = (ListView) findViewById(R.id.listView);

        getStrings();

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, tester );

        lv.setAdapter(arrayAdapter);

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(v.getContext(), HomeScreen.class);
                startActivityForResult(myIntent, 0);
            }
        });

        dna.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //db.addMovie(db.getUser(1));

                Intent myIntent = new Intent(v.getContext(), MovieGene.class);
                startActivityForResult(myIntent, 0);
            }
        });

        recs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //db.addMovie(db.getUser(1));

                Intent myIntent = new Intent(v.getContext(), WatchedMovies.class);
                startActivityForResult(myIntent, 0);
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(v.getContext(), MainActivity.class);
                startActivityForResult(myIntent, 0);
            }
        });


    }

    void getStrings() {
        String movieString;

        String[] items = db.getMovie(2).split(",");
        for(String item : items) {
            tester.add(item);
        }
    }
}
