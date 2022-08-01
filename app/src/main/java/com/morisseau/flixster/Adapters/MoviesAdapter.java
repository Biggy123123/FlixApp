package com.morisseau.flixster.Adapters;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.content.res.Configuration;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.morisseau.flixster.DetailActivity;
import com.morisseau.flixster.Models.Movie;
import com.morisseau.flixster.R;

import org.parceler.Parcels;

import java.util.List;

            public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.VideoAdapter> {

                Context context;
                List<Movie> movies;

                public MoviesAdapter(Context context, List<Movie> movies) {
                    this.context = context;
                    this.movies = movies;
                }

                @NonNull
                @Override
                public VideoAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                    Log.d("MovieAdapter", "onCreateViewHolder");
                    View movieView = LayoutInflater.from(context).inflate(R.layout.item_movie, parent, false);
                    return new VideoAdapter(movieView);
                }

                @Override
                public void onBindViewHolder(@NonNull VideoAdapter holder, int position) {
                    Log.d("MovieAdapter", "onBindViewHolder" + position);
                    Movie movie = movies.get(position);
                    holder.bind(movie);

                }

                @Override
                public int getItemCount() {
                    return movies.size();
                }

                public class VideoAdapter extends RecyclerView.ViewHolder {

                    RelativeLayout container;
                    TextView tvTitle;
                    ImageView ivPoster;
                    TextView tvOverview;


                    public VideoAdapter(@NonNull View itemView) {
                        super(itemView);
                        tvTitle = itemView.findViewById(R.id.tvTitle);
                        ivPoster = itemView.findViewById(R.id.ivPoster);
                        tvOverview = itemView.findViewById(R.id.tvOverview);
                        container = itemView.findViewById(R.id.container);
                    }

                    public void bind(@NonNull Movie movie) {
                        tvTitle.setText(movie.getTitle());
                        tvOverview.setText(movie.getOverview());
                        String img;
                        if (context.getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
                            img = movie.getBackdropPath();
                        } else {
                            img = movie.getPosterPath();
                        }
                        Glide.with(context).load(img).placeholder(R.drawable.cine).error(R.drawable.error).into(ivPoster);
                        container.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Toast.makeText(context, movie.getTitle(), Toast.LENGTH_LONG).show();
                                Intent i = new Intent(context, DetailActivity.class);
                                i.putExtra("title", movie.getTitle());
                                i.putExtra("movie", Parcels.wrap(movie));
                                context.startActivity(i);

                            }
                        });
                    }
                }
            }
