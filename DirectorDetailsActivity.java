package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class DirectorDetailsActivity extends AppCompatActivity {

    private int directorId;
    private Director director;
    private ArrayList<Integer> movies;
    private Api apiManager;

    private TextView directorNameView;

    private ListView movies_list_view;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_director_details);

        apiManager = Api.getInstance();

        directorId = getIntent().getIntExtra("directorId", -1);

        movies_list_view = findViewById(R.id.moviesListView);

        if (directorId != -1) {
            // Use ApiManager to fetch details for the selected movie
            director = apiManager.get_director_by_id(directorId);
            movies = director.getMovies_directed();
        }


        directorNameView = findViewById(R.id.directorNameTextView);
        directorNameView.setText("Director: " + director.getName());

        ArrayList<String> movies_names = new ArrayList<String>();
        for (int id:movies) {
            Movie movie = apiManager.get_movie_by_id(id);
            if (movie != null)
                movies_names.add(movie.getName());
            else
                movies_names.add("null");
        }



        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, movies_names);
        movies_list_view.setAdapter(adapter);

    }
}