package com.example.finalmovieapp.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;
import android.content.Context;

@Database(entities = {MovieDetails.class}, version = 1, exportSchema = false)
@TypeConverters({RatingsConverter.class})
abstract class MovieDatabase extends RoomDatabase {

    private static MovieDatabase instance;

    static MovieDatabase getDatabase(final Context context) {
        if (instance == null) {
            synchronized (MovieDatabase.class) {
                if (instance == null) {
                    instance = Room
                            .databaseBuilder(context.getApplicationContext(), MovieDatabase.class, "movie_database")
                            .fallbackToDestructiveMigration()
                            .build();
                }
            }
        }
        return instance;
    }

    abstract MovieDao movieDao();
}
