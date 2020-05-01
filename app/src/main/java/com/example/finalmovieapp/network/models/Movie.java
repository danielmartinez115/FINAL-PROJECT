package com.example.finalmovieapp.network.models;

import android.databinding.BaseObservable;
import android.support.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

public class Movie extends BaseObservable {

    @SerializedName("imdbID")
    private String imdbId;

    @SerializedName("Title")
    private String title;

    @SerializedName("Year")
    private String year;

    @SerializedName("Poster")
    private String poster;

    public Movie(String imdbId, String title, String year, String poster) {
        this.imdbId = imdbId;
        this.title = title;
        this.year = year;
        this.poster = poster;
    }

    public String getImdbId() {
        return imdbId;
    }

    public void setImdbId(@NonNull String imdbId) {
        this.imdbId = imdbId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    @Override
    public String toString() {
        return "Movie{" + "imdbId='" + imdbId + '\'' + ", title='" + title + '\'' + ", year='" + year + '\'' + ", poster='" + poster +
                '\'' + '}';
    }
}
