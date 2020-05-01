package com.example.finalmovieapp.database;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;


@Dao
interface MovieDao {

    @Insert
    void insert(MovieDetails movie);

    @Query("SELECT * FROM favorite_movies_table WHERE imdbId = :imdbId")
    LiveData<MovieDetails> getMovie(String imdbId);

    @Query("SELECT EXISTS (SELECT * FROM favorite_movies_table WHERE imdbId = :imdbId)")
    LiveData<Integer> exists(String imdbId);

    @Query("UPDATE favorite_movies_table SET favorite = :favorite WHERE imdbId = :imdbId")
    void setFavorite(String imdbId, boolean favorite);

    @Query("SELECT * FROM favorite_movies_table ORDER BY year DESC")
    LiveData<List<MovieDetails>> getAllMovies();

}
