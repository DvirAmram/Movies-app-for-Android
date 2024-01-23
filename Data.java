package com.example.myapplication;

import java.util.ArrayList;

public class Data {

    private static volatile Data instance;
    private ArrayList<Director> directors;
    private ArrayList<Movie> movies;

    private Data(ArrayList<Director> directors, ArrayList<Movie> movies) {
        this.directors = directors;
        this.movies = movies;
    }

    public static Data getInstance(ArrayList<Director> directors, ArrayList<Movie> movies){
        if (instance == null){
            synchronized (Data.class) {
                if (instance == null) {
                    instance = new Data(directors, movies);
                }
            }
        }
        return instance;
    }

    public ArrayList<Director> getDirectors() {
        return directors;
    }

    public void setDirectors(ArrayList<Director> directors) {
        this.directors = directors;
    }

    public ArrayList<Movie> getMovies() {
        return movies;
    }

    public void setMovies(ArrayList<Movie> movies) {
        this.movies = movies;
    }

    @Override
    public String toString() {
        return "com.example.myapplication.Data{" +
                "directors=" + directors +
                ", movies=" + movies +
                '}';
    }
}