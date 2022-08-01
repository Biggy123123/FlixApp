package com.morisseau.flixster.Models;

import androidx.annotation.NonNull;

import com.codepath.asynchttpclient.AbsCallback;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.parceler.Parcel;

import java.util.ArrayList;
import java.util.List;

@Parcel
public class Movie {

    int movieId;
    String backdropPath;
    String posterPath;
    String title;
    String overview;
    double rating;

    public Movie(){ }

    public Movie(@NonNull JSONObject JsonObject) throws JSONException {
        backdropPath=JsonObject.getString("backdrop_path");
        posterPath=JsonObject.getString("poster_path");
        title=JsonObject.getString("title");
        overview=JsonObject.getString("overview");
        rating = JsonObject.getDouble("vote_average");
        movieId = Integer.parseInt(JsonObject.getString("id"));
    }

    @NonNull
    public static List<Movie>FromJsonArray(@NonNull JSONArray movieJsonArray)throws JSONException{
        List<Movie> movie=new ArrayList<>();
        for (int i=0; i<movieJsonArray.length(); i++){
            movie.add(new Movie(movieJsonArray.getJSONObject(i)));

        }
        return movie;
    }
    public String getBackdropPath(){
        return String.format("https://image.tmdb.org/t/p/w342/%s", backdropPath);

    }

    public String getPosterPath() {
        return String.format("https://image.tmdb.org/t/p/w342/%s", posterPath);
    }

    public String getTitle() {
        return title;
    }

    public String getOverview() {
        return overview;
    }

    public double getRating() {
        return rating;
    }

    public int getMovieId() {
        return movieId;
    }
}
