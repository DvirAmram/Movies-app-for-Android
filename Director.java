package com.example.myapplication;

import java.util.ArrayList;

public class Director {
    private int id;
    private ArrayList<Integer> movies_directed;
    private String name;

    public Director(int id, ArrayList<Integer> movies_directed, String name) {
        this.id = id;
        this.movies_directed = movies_directed;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<Integer> getMovies_directed() {
        return movies_directed;
    }

    public void setMovies_directed(ArrayList<Integer> movies_directed) {
        this.movies_directed = movies_directed;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "com.example.myapplication.Director{" +
                "id=" + id +
                ", movies_directed=" + movies_directed +
                ", name='" + name + '\'' +
                '}';
    }
}
