package com.morisseau.flixster;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.codepath.asynchttpclient.AsyncHttpClient;
import com.codepath.asynchttpclient.callback.JsonHttpResponseHandler;
import com.morisseau.flixster.Adapters.MoviesAdapter;
import com.morisseau.flixster.Models.Movie;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import okhttp3.Headers;

public class MainActivity extends AppCompatActivity {

    public  static  final String NOW_PLAYING_URL="https://api.themoviedb.org/3/movie/now_playing?api_key=a07e22bc18f5cb106bfe4cc1f83ad8ed";
    public static final String TAG="Mainactivity";
    List<Movie> movies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView rvMovies=findViewById(R.id.rvMovies);
        movies =new ArrayList<>();

        final MoviesAdapter moviesAdapter= new MoviesAdapter (this, movies);

        rvMovies.setAdapter(moviesAdapter);

        rvMovies.setLayoutManager(new LinearLayoutManager(this));


        AsyncHttpClient client = new AsyncHttpClient();
        client.get(NOW_PLAYING_URL, new JsonHttpResponseHandler() {

            @Override
            public void onSuccess(int statusCode, Headers headers, JSON json) {
                Log.d(TAG,"onSuccess");
                JSONObject jsonObject = json.jsonObject;
                try {
                    jsonObject.getJSONArray("results");
                    JSONArray results=jsonObject.getJSONArray("results");
//                    Log.i(TAG,"Results: " + results.toString());
                    movies.addAll(Movie.FromJsonArray(results));
                    moviesAdapter.notifyDataSetChanged();
    //                Log.i(TAG,"Movies: " + movies.size());

                } catch (JSONException e) {
                    Log.e(TAG,"Hit json exception",e);
                }
            }

            @Override
            public void onFailure(int statusCode, Headers headers, String response, Throwable throwable) {
                Log.d(TAG,"onFailure");
            }
        });
    }
}