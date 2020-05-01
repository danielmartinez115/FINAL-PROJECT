package com.example.finalmovieapp.database;

import android.arch.persistence.room.TypeConverter;

import com.example.finalmovieapp.network.models.MovieRatings;
import com.example.finalmovieapp.network.models.Rating;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RatingsConverter {

    @TypeConverter
    public MovieRatings storedStringToRatings(String value) {
        List<Rating> ratings = new ArrayList<>();
        for (String ratingString : Arrays.asList(value.split("\\s*,\\s*"))) {
            final List<String> ratingStringAsList = Arrays.asList(ratingString.split("\\s*:\\s*"));
            String ratingSource = ratingStringAsList.get(0);
            String ratingValue = ratingStringAsList.get(1);
            ratings.add(new Rating(ratingSource, ratingValue));
        }

        return new MovieRatings(ratings);
    }

    @TypeConverter
    public String ratingsToStoredString(MovieRatings ratings) {
        StringBuilder value = new StringBuilder();

        for (Rating rating : ratings.getRatings()) {
            value.append(rating.getSource()).append(":").append(rating.getValue()).append(",");
        }

        return value.toString();
    }

}
