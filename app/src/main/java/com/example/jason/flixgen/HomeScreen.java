package com.example.jason.flixgen;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Config;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class HomeScreen extends YouTubeBaseActivity {
    private Activity mActivity;

    private String TAG = HomeScreen.class.getSimpleName();
    //private ListView lv;
    private EditText ed;
    private Button b1;
    private Button b2;
    private Button b3;
    private Button b4;
    private TextView tv;
    public String title;
    private ImageView iv;

    public  JSONObject obj;
    public String mTitle;
    public String mGenre;

    private YouTubePlayerView youTubePlayerView;
    private YouTubePlayer.OnInitializedListener onInitializedListener;

    public String URL = "http://www.omdbapi.com/?";
    public String KEY = "4207e11d";

    public String YTUBE;
    public String posterURL;

    ArrayList<HashMap<String, String>> movieList;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_home);
        final DBHelper db = new DBHelper(this);


        movieList = new ArrayList<>();
        //lv = (ListView) findViewById(R.id.list);
        ed = (EditText) findViewById(R.id.rating);
        b1 = (Button) findViewById(R.id.search);
        b2 = (Button) findViewById(R.id.clear);
        b3 = (Button) findViewById(R.id.add);
        b4 = (Button) findViewById(R.id.testies);
        tv = (TextView) findViewById(R.id.result1);
        iv = (ImageView) findViewById(R.id.posterView);

        youTubePlayerView = (YouTubePlayerView) findViewById(R.id.you_tube);
        onInitializedListener = new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b){
                youTubePlayer.loadVideo(YTUBE);
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

            }
        };



        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                //GetMovies[] movieSearch = new GetMovies[10];


                title = ed.getText().toString();

                if(title.equals("Guardians of the Galaxy Vol 2")||title.equals("guardians of the galaxy vol 2")) {
                    YTUBE = "duGqrYw4usE";
                }
                else if(title.equals("Baby Driver")||title.equals("baby driver")){
                    YTUBE = "z2z857RSfhk";
                }
                else if(title.equals("Wonder Woman")||title.equals("wonder woman"))
                {
                    YTUBE = "VSB4wGIdDwo";
                }
                else if(title.equals("Spider Man Homecoming")||title.equals("spider man homecoming"))
                {
                    YTUBE = "VSB4wGIdDwo";
                }
                else
                    YTUBE = "iBFrKgaMYv4";

                youTubePlayerView.initialize("AIzaSyDk5mQRP-tUKmQrwgXBseRJMLVP1YlOMzM", onInitializedListener);

                new GetMovies().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, null);


            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(v.getContext(), HomeScreen.class);
                startActivityForResult(myIntent, 0);

            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //db.addMovie(new Movie(2,mTitle, mGenre));
                db.addMovie(db.getUser(1), mTitle, mGenre);
            }
        });

        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //db.getUser(3);

                tv.setText(db.getUser(1).getMovieTitle(mTitle) + db.getUser(1).getMovieGenre(mGenre));
            }
        });


    }

    private class GetMovies extends AsyncTask<Void, Void, String> {
        private Exception exception;

        protected void onPreExecute() {
            //progressBar.setVisibility(View.VISIBLE);
            //tv.setText("");
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
                    obj = new JSONObject(response);
                    mTitle = obj.getString("Title");
                    String mYear = obj.getString("Year");
                    String mRating = obj.getString("Rated");
                    mGenre = obj.getString("Genre");
                    String mActor = obj.getString("Actors");
                    String mPoster = obj.getString("Poster");


                    posterURL = mPoster;

                    new DownLoadImageTask(iv).execute(posterURL);


                    tv.setText(mTitle + ", " + mRating + ", " + mYear + ", " + mGenre + ", " + mActor);

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }
    }

    private class DownLoadImageTask extends AsyncTask<String, Void, Bitmap> {
        ImageView imageView;

        public DownLoadImageTask(ImageView imageView) {
            this.imageView = imageView;
        }

        /*
            doInBackground(Params... params)
                Override this method to perform a computation on a background thread.
         */
        protected Bitmap doInBackground(String... urls) {
            String urlOfImage = urls[0];
            Bitmap logo = null;
            try {
                InputStream is = new URL(urlOfImage).openStream();
                /*
                    decodeStream(InputStream is)
                        Decode an input stream into a bitmap.
                 */
                logo = BitmapFactory.decodeStream(is);
            } catch (Exception e) { // Catch the download exception
                e.printStackTrace();
            }
            return logo;
        }

        /*
            onPostExecute(Result result)
                Runs on the UI thread after doInBackground(Params...).
         */
        protected void onPostExecute(Bitmap result) {
            imageView.setImageBitmap(result);
        }
    }

}

