package com.example.finalmovieapp.network.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GetMovieDetailsResponse {

    @SerializedName("imdbID")
    private String imdbId;

    @SerializedName("Title")
    private String title;

    @SerializedName("Year")
    private String year;

    @SerializedName("Poster")
    private String poster;

    @SerializedName("Released")
    private String released;

    @SerializedName("Rated")
    private String rated;

    @SerializedName("Runtime")
    private String runtime;

    @SerializedName("Ratings")
    private List<Rating> ratings;

    @SerializedName("Plot")
    private String plot;

    public String getImdbId() {
        return imdbId;
    }

    public void setImdbId(String imdbId) {
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

    public String getReleased() {
        return released;
    }

    public void setReleased(String released) {
        this.released = released;
    }

    public String getRated() {
        return rated;
    }

    public void setRated(String rated) {
        this.rated = rated;
    }

    public String getRuntime() {
        return runtime;
    }

    public void setRuntime(String runtime) {
        this.runtime = runtime;
    }

    public List<Rating> getRatings() {
        return ratings;
    }

    public void setRatings(List<Rating> ratings) {
        this.ratings = ratings;
    }

    public String getPlot() {
        return plot;
    }

    public void setPlot(String plot) {
        this.plot = plot;
    }

    @Override
    public String toString() {
        return "GetMovieDetailsResponse{" + "imdbId='" + imdbId + '\'' + ", title='" + title + '\'' + ", year='" + year + '\'' + ", " +
                "poster='" + poster + '\'' + ", released='" + released + '\'' + ", rated='" + rated + '\'' + ", runtime='" + runtime +
                '\'' + ", ratings=" + ratings + ", plot='" + plot + '\'' + '}';
    }
}
