package com.example.finalmovieapp.network;

import com.example.finalmovieapp.network.models.GetMovieDetailsResponse;
import com.example.finalmovieapp.network.models.GetMoviesResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;


public interface Api {

    @GET("/")
    Call<GetMoviesResponse> getMovies(@Query("apikey") String key, @Query("s") String searchText, @Query("type") String type);

    @GET("/")
    Call<GetMovieDetailsResponse> getMovieDetails(@Query("apikey") String key, @Query("i") String id);

}
