package com.example.finalmovieapp.views.models;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.example.finalmovieapp.network.models.Movie;

public class MovieCardViewModel extends BaseObservable {

    private Movie movie;

    public MovieCardViewModel(Movie movie) {
        this.movie = movie;
    }

    @Bindable
    public String getImdbId() {
        return movie.getImdbId();
    }

    @Bindable
    public String getTitle() {
        return movie.getTitle();
    }

    @Bindable
    public String getYear() {
        return movie.getYear();
    }

    @Bindable
    public String getPoster() {
        return movie.getPoster();
    }
}
