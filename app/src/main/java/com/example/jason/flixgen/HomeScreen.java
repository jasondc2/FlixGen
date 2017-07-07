package com.example.jason.flixgen;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

public class HomeScreen extends AppCompatActivity {

    private String TAG = HomeScreen.class.getSimpleName();
    private ListView lv;
    private EditText ed;
    private Button b1;
    private TextView tv;

    //public String title = ed.getText().toString();
    public String title;

    public String URL = "http://www.omdbapi.com/?";
    public String KEY = "4207e11d";

    ArrayList<HashMap<String, String>> movieList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_home);

        movieList = new ArrayList<>();
        lv = (ListView) findViewById(R.id.list);
        ed = (EditText) findViewById(R.id.rating);
        b1 = (Button) findViewById(R.id.search);
        tv = (TextView) findViewById(R.id.result1);

       //String title = ed.getText().toString();


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                title = ed.getText().toString();
                new GetMovies().execute();

            }
        });
       ;

    }

    private class GetMovies extends AsyncTask<Void, Void, String> {
        private Exception exception;

        protected void onPreExecute() {
            //progressBar.setVisibility(View.VISIBLE);
            tv.setText("");
        }

        protected String doInBackground(Void... urls) {
            //String title = ed.getText().toString();
            // Do some validation here

            try {
                URL url = new URL(URL + "t=" + title + "&apikey=" + KEY);
                HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
                try {
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
                    StringBuilder stringBuilder = new StringBuilder();
                    String line;
                    while ((line = bufferedReader.readLine()) != null) {
                        stringBuilder.append(line).append("\n");
                    }
                    bufferedReader.close();
                    return stringBuilder.toString();
                } finally {
                    urlConnection.disconnect();
                }
            } catch (Exception e) {
                Log.e("ERROR", e.getMessage(), e);
                return null;
            }
        }

        protected void onPostExecute(String response) {
            if (response == null) {
                response = "THERE WAS AN ERROR";
            }
            //progressBar.setVisibility(View.GONE);
            Log.i("INFO", response);
            for (int i = 0; i < response.length(); i++) {
                try {
                    //JSONObject movieObject = new JSONObject(response);
                    JSONObject obj = new JSONObject(response);
                    String mTitle = obj.getString("Title");
                    String mYear = obj.getString("Year");
                    String mRating = obj.getString("Rated");
                    String mGenre = obj.getString("Genre");
                    String mActor = obj.getString("Actors");

                    tv.setText(mTitle + ", " + mRating + ", " + mYear + ", " + mGenre + ", " + mActor);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

               // tv.setText(mTitle);
            }
        }
    }
}

