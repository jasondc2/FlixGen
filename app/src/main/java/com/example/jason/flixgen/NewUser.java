package com.example.jason.flixgen;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by jason on 7/7/2017.
 */



public class NewUser extends AppCompatActivity {

    Button createUser, cancel;
    EditText userName, userPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_user);
        final DBHelper db = new DBHelper(this);

        createUser = (Button) findViewById(R.id.UserCreate);
        cancel = (Button) findViewById(R.id.UserCancel);

        userName = (EditText) findViewById(R.id.UserName);
        userPass = (EditText) findViewById(R.id.UserPass);

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(v.getContext(), MainActivity.class);
                startActivityForResult(myIntent, 0);
            }
         });

        createUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String un = userName.getText().toString();
                String pa = userPass.getText().toString();

                db.addUser(new User(un, pa));

                userName.setText("");
                userPass.setText("");
            }
        });
    }
}