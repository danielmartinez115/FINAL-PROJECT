package com.example.finalmovieapp.database;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import java.util.List;

public class MovieRepositoryViewModel extends AndroidViewModel {

    private MovieRepository repository;
    private LiveData<List<MovieDetails>> allMovies;

    public MovieRepositoryViewModel(@NonNull Application application) {
        super(application);

        repository = new MovieRepository(application);
        allMovies = repository.getAllMovies();
    }

    public void insert(MovieDetails movie) {
        repository.insert(movie);
    }

    public LiveData<Integer> exists(String imdbId) {
        return repository.exists(imdbId);
    }

    public LiveData<MovieDetails> getMovie(String imdbId) {
        return repository.getMovie(imdbId);
    }

    public LiveData<List<MovieDetails>> getAllMovies() {
        return allMovies;
    }

    public void setFavorite(String imdbId, boolean isFavorite) {
        repository.setFavorite(imdbId, isFavorite);
    }
}
