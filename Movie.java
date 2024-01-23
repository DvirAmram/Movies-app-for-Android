package com.example.myapplication;

import java.util.ArrayList;

public class Movie {
    private int director_id;
    private int id;
    private String name;
    private ArrayList<String> players;
    private String plot_summary;

    public Movie(int director_id, int id, String name, ArrayList<String> players, String plot_summary) {
        this.director_id = director_id;
        this.id = id;
        this.name = name;
        this.players = players;
        this.plot_summary = plot_summary;
    }

    public int getDirector_id() {
        return director_id;
    }

    public void setDirector_id(int director_id) {
        this.director_id = director_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<String> getPlayers() {
        return players;
    }

    public void setPlayers(ArrayList<String> players) {
        this.players = players;
    }

    public String getPlot_summary() {
        return plot_summary;
    }

    public void setPlot_summary(String plot_summary) {
        this.plot_summary = plot_summary;
    }

    @Override
    public String toString() {
        return "com.example.myapplication.Movie{" +
                "director_id=" + director_id +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", players=" + players +
                ", plot_summary='" + plot_summary + '\'' +
                '}';
    }
}
