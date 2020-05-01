package com.example.finalmovieapp.database;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import java.util.List;

class MovieRepository {

    private MovieDao movieDao;
    private LiveData<List<MovieDetails>> allMovies;

    MovieRepository(Application application) {
        MovieDatabase db = MovieDatabase.getDatabase(application);
        movieDao = db.movieDao();
        allMovies = movieDao.getAllMovies();
    }

    void insert(MovieDetails movie) {
        new InsertAsyncTask(movieDao).execute(movie);
    }

    LiveData<MovieDetails> getMovie(String imdbId) {
        return movieDao.getMovie(imdbId);
    }

    LiveData<List<MovieDetails>> getAllMovies() {
        return allMovies;
    }

    void setFavorite(String imdbId, boolean isFavorite) {
        new UpdateAsyncTask(movieDao).execute(new UpdateAsyncTaskParams(imdbId, isFavorite));
    }

    public LiveData<Integer> exists(String imdbId) {
        return movieDao.exists(imdbId);
    }

    private static class InsertAsyncTask extends AsyncTask<MovieDetails, Void, Void> {
        private MovieDao asyncTaskDao;

        InsertAsyncTask(MovieDao dao) {
            asyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final MovieDetails... params) {
            asyncTaskDao.insert(params[0]);
            return null;
        }
    }

    private static class UpdateAsyncTask extends AsyncTask<UpdateAsyncTaskParams, Void, Void> {
        private MovieDao asyncTaskDao;

        UpdateAsyncTask(MovieDao dao) {
            asyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final UpdateAsyncTaskParams... params) {
            asyncTaskDao.setFavorite(params[0].imdbId, params[0].isFavorite);
            return null;
        }
    }

    private class UpdateAsyncTaskParams {
        private String imdbId;
        private boolean isFavorite;

        private UpdateAsyncTaskParams(String imdbId, boolean isFavorite) {
            this.imdbId = imdbId;
            this.isFavorite = isFavorite;
        }
    }
}
