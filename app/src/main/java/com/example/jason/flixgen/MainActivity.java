package com.example.jason.flixgen;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button b1,b2;
    EditText ed1,ed2;
    final DBHelper db = new DBHelper(this);

    //TextView tx1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main);


        b1 = (Button) findViewById(R.id.button1);
        ed1 = (EditText) findViewById(R.id.editText1);
        ed2 = (EditText) findViewById(R.id.editText2);

        b2 = (Button) findViewById(R.id.button2);
        //tx1.setVisibility(View.GONE);


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i = 1; i <= db.getUsersCount(); i++) {
                    if (ed1.getText().toString().equals(db.getUser(i).getUsername()) &&
                            ed2.getText().toString().equals(db.getUser(i).getPassword())) {
                        Toast.makeText(getApplicationContext(),
                                "Logging In...", Toast.LENGTH_SHORT).show();
                        login(v);
                    } else {
                        Toast.makeText(getApplicationContext(), "Wrong Credentials", Toast.LENGTH_SHORT).show();
                    }
                }
            }

            public void login(View v) {
                Intent myIntent = new Intent(v.getContext(), HomeScreen.class);
                startActivityForResult(myIntent, 0);
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(v.getContext(), NewUser.class);
                startActivityForResult(myIntent, 0);
            }
        });

    }
}

