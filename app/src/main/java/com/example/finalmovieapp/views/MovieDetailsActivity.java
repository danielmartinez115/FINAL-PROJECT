package com.example.finalmovieapp.views;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.example.finalmovieapp.R;
import com.example.finalmovieapp.database.MovieRepositoryViewModel;
import com.example.finalmovieapp.databinding.ActivityMovieDetailsBinding;
import com.example.finalmovieapp.network.interactors.GetMovieDetails;
import com.example.finalmovieapp.network.models.GetMovieDetailsResponse;
import com.example.finalmovieapp.database.MovieDetails;

public class MovieDetailsActivity extends AppCompatActivity {

    public static final String EXTRA_MOVIE = "EXTRA_MOVIE_IMDB_ID";

    private String movieImdbId;

    private ActivityMovieDetailsBinding binding;

    private MovieRepositoryViewModel movieRepository;

    private boolean alreadyExists = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_details);

        initView();
        movieImdbId = getIntent().getStringExtra(EXTRA_MOVIE);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_movie_details);
        binding.setHandler(this);

        observeMovieExists();
        observeMovieDetails();
    }

    private void initView() {
        movieRepository = ViewModelProviders.of(this).get(MovieRepositoryViewModel.class);
    }

    public void onFavoriteClick() {
        if (binding.getMovie() == null) {
            return;
        }

        binding.setMovie(binding.getMovie().toggleFavorite());

        if (alreadyExists) {
            movieRepository.setFavorite(movieImdbId, binding.getMovie().isFavorite());
        } else {
            movieRepository.insert(binding.getMovie());
        }
    }

    private void getMovieDetails(String imdbId) {
        GetMovieDetails.execute(new GetMovieDetails.GetMovieDetailsCallback() {
            @Override
            public void onSuccess(GetMovieDetailsResponse responseBody) {
                binding.setMovie(new MovieDetails(responseBody));
            }

            @Override
            public void onError() {
                Toast.makeText(MovieDetailsActivity.this, "GetMovieDetails failed.", Toast.LENGTH_LONG).show();
            }
        }, imdbId);
    }

    private void observeMovieExists() {
        movieRepository.exists(movieImdbId).observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(@Nullable Integer integer) {
                if (Integer.valueOf(1).equals(integer)) {
                    alreadyExists = true;
                    return;
                }
                getMovieDetails(movieImdbId);
            }
        });
    }

    private void observeMovieDetails() {
        movieRepository.getMovie(movieImdbId).observe(this, new Observer<MovieDetails>() {
            @Override
            public void onChanged(@Nullable MovieDetails movieDetails) {
                binding.setMovie(movieDetails);
            }
        });
    }
}
