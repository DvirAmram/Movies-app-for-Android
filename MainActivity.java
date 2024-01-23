package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity{

    private Api api_manager;
    private ArrayList<Movie> movies;

    private ListView movies_list_view;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        api_manager = Api.getInstance();
        movies = api_manager.get_all_movies();


        movies_list_view = findViewById(R.id.movieListView);


        // Create a string array to hold movie names
        String[] movieNames = new String[movies.size()];
        for (int i = 0; i < movies.size(); i++) {
            movieNames[i] = movies.get(i).getName();
        }

        // Use the default ArrayAdapter to populate the ListView
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, movieNames);
        movies_list_view.setAdapter(adapter);

        // Set click listener for ListView items
        movies_list_view.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Get the selected movie ID
                int selectedMovieId = movies.get(position).getId();

                // Start MovieDetailsActivity and pass the selected movie ID
                Intent intent = new Intent(MainActivity.this, MovieDetails.class);
                intent.putExtra("movieId", selectedMovieId);
                startActivity(intent);
            }
        });


    }


}