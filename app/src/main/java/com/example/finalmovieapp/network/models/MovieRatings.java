package com.example.finalmovieapp.network.models;

import java.util.List;

public class MovieRatings {

    private List<Rating> ratings;

    public MovieRatings(List<Rating> ratings) {
        this.ratings = ratings;
    }

    public List<Rating> getRatings() {
        return ratings;
    }

    public void setRatings(List<Rating> ratings) {
        this.ratings = ratings;
    }

    @Override
    public String toString() {
        return "MovieRatings{" + "ratings=" + ratings + '}';
    }
}
