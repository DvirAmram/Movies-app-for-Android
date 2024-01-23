package com.example.myapplication;

import android.os.AsyncTask;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class Api {
    private static final String BASE_URL = "http://localhost:5000/";

    private static Api instance;

    private Data data;

    private Api() {
        String string = "{\n" +
                "  \"movies\": [\n" +
                "    {\n" +
                "      \"id\": 1,\n" +
                "      \"name\": \"Inception\",\n" +
                "      \"director_id\": 1,\n" +
                "      \"players\": [\"Leonardo DiCaprio\", \"Joseph Gordon-Levitt\"],\n" +
                "      \"plot_summary\": \"A thief who enters the dreams of others to steal their secrets.\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": 2,\n" +
                "      \"name\": \"The Shawshank Redemption\",\n" +
                "      \"director_id\": 2,\n" +
                "      \"players\": [\"Tim Robbins\", \"Morgan Freeman\"],\n" +
                "      \"plot_summary\": \"Two imprisoned men bond over a number of years, finding solace and eventual redemption through acts of common decency.\"\n" +
                "    }\n" +
                "\n" +
                "  ],\n" +
                "  \"directors\": [\n" +
                "    {\n" +
                "      \"id\": 1,\n" +
                "      \"name\": \"Christopher Nolan\",\n" +
                "      \"movies_directed\": [1, 3]\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": 2,\n" +
                "      \"name\": \"Frank Darabont\",\n" +
                "      \"movies_directed\": [2]\n" +
                "    }\n" +
                "\n" +
                "  ]\n" +
                "}\n";
        this.data = convert_json_2_data(string);
    }

    public static Api getInstance() {
        if (instance == null) {
            instance = new Api();
        }
        return instance;
    }


//    public interface ApiResponseListener {
//        void onSuccess(String response);
//
//        void onError(String error);
//    }

//    private void get_json(ApiResponseListener listener) throws IOException {
//        // String serverUrl = "http://localhost:5000/";
//
//        String apiUrl = BASE_URL;
//
//        new AsyncTask<String, Void, String>(){
//
//
//            @Override
//            protected String doInBackground(String[] params){
//
//                try {
//                    URL url = new URL(params[0]);
//                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
//                    connection.setRequestMethod("GET");
//                    BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
//                    StringBuilder response = new StringBuilder();
//                    String line;
//
//                    while ((line = reader.readLine()) != null) {
//                        response.append(line);
//                    }
//                    reader.close();
//                    connection.disconnect();
//                    String json_string = response.toString();
//                    return json_string;
//                }catch (Exception e) {
//                    return null;
//                }
//
//            }
//
//            @Override
//            protected void onPostExecute(String result) {
//                if (result != null) {
//                    listener.onSuccess(result);
//                    convert_json_2_data(result);
//                } else {
//                    listener.onError("Failed to fetch data from the server");
//                }
//            }
//        }.execute(apiUrl);
//    }


    private Data convert_json_2_data(String json) {
        Type type = new TypeToken<Data>() {
        }.getType();
        Gson gson = new Gson();
        this.data = gson.fromJson(json, type);
        return data;
    }

//    public void initialize_data() throws IOException {
//        ApiResponseListener listener = new ApiResponseListener();
//        convert_json_2_data(get_json());
//    }



//    private static void initialize_data(){
////        initialize_data();
//
//
//
//
//
//        this.data= convert_json_2_data(string);
//    }

    public void setData(Data data) {
        this.data = data;
    }

    public ArrayList<Movie> get_all_movies(){
        return this.data.getMovies();
    }

    public Movie get_movie_by_id(int id){
        for (Movie movie:
                this.data.getMovies()) {
            if (movie.getId() == id){
                return movie;
            }
        }
        return null;
    }
    public Director get_director_by_id(int id){
        for (Director director:
                this.data.getDirectors()) {
            if (director.getId() == id){
                return director;
            }
        }
        return null;
    }

}
