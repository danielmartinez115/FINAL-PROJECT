package com.example.finalmovieapp.network.models;

import com.google.gson.annotations.SerializedName;

import java.util.Arrays;

public class GetMoviesResponse {

    @SerializedName("Search")
    private Movie[] movies;

    private int totalResults;

    public Movie[] getMovies() {
        return movies;
    }

    public void setMovies(Movie[] movies) {
        this.movies = movies;
    }

    public int getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(int totalResults) {
        this.totalResults = totalResults;
    }

    @Override
    public String toString() {
        return "GetMoviesResponse{" + "movies=" + Arrays.toString(movies) + ", totalResults=" + totalResults + '}';
    }
}
