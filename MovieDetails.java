package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MovieDetails extends AppCompatActivity {

    private int movieId;
    private Movie movie;
    private Director director;
    private ArrayList<String> players;
    private Api apiManager;

    private TextView movieNameTextView;
    private TextView directorTextView;

    private ListView players_list_view;
    private TextView plotSummaryTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_details);

        apiManager = Api.getInstance();

        movieId = getIntent().getIntExtra("movieId", -1);

        players_list_view = findViewById(R.id.playersListView);

        if (movieId != -1) {
            // Use ApiManager to fetch details for the selected movie
            movie = apiManager.get_movie_by_id(movieId);
            director = apiManager.get_director_by_id(movie.getDirector_id());
            players = movie.getPlayers();
        }

        // Update UI with movie details
        movieNameTextView = findViewById(R.id.movieNameTextView);
        movieNameTextView.setText("Movie: " + movie.getName());

        directorTextView = findViewById(R.id.directorTextView);
        directorTextView.setText("Director: " + director.getName());

        // Set a click listener for the director's name
        directorTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start DirectorDetailsActivity and pass the director ID
                Intent intent = new Intent(MovieDetails.this, DirectorDetailsActivity.class);
                intent.putExtra("directorId", director.getId());
                startActivity(intent);
            }
        });

        TextView playersTextView = findViewById(R.id.playersTextView);
        playersTextView.setText("Players:");

        players_list_view = findViewById(R.id.playersListView);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, players);
        players_list_view.setAdapter(adapter);


        plotSummaryTextView = findViewById(R.id.plotSummaryTextView);
        plotSummaryTextView.setText("Plot Summary: " + movie.getPlot_summary());
    }
}