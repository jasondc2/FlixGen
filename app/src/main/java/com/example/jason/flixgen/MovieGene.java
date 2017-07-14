package com.example.jason.flixgen;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by jason on 7/9/2017.
 */

public class MovieGene extends AppCompatActivity {

    private Button home;
    private Button dna;
    private Button recs;
    private Button login;

    private TextView dnaType;
    private TextView dnaDesc;

    final DBHelper db = new DBHelper(this);

    public String DNA;
    public String dnaD;

    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.movie_dna);


        home = (Button) findViewById(R.id.home);
        dna = (Button) findViewById(R.id.userdna);
        recs = (Button) findViewById(R.id.movie);
        login = (Button) findViewById(R.id.login);

        dnaType = (TextView) findViewById(R.id.dnaType);
        dnaDesc = (TextView) findViewById(R.id.dnaDesc);

        getType();

        dnaType.setText(DNA);
        //dnaDesc.setText(dnaD);

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

                Intent myIntent = new Intent(v.getContext(), MovieGene.class);
                startActivityForResult(myIntent, 0);
            }
        });

        recs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

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

    void getType() {
        //DNA = db.user.getDNA;
        //dnaD = db.user.getDNADesc;

        DNA = db.getDNA(2);
    }
}
