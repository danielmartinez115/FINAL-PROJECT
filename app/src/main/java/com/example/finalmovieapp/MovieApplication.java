package com.example.finalmovieapp;

import android.app.Application;

import com.example.finalmovieapp.database.MovieRepositoryViewModel;

public class MovieApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        new MovieRepositoryViewModel(this);
    }

}
