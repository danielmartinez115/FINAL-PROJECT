package com.example.finalmovieapp.network.interactors;

import android.support.annotation.NonNull;

import com.example.finalmovieapp.network.ApiUtils;
import com.example.finalmovieapp.network.models.GetMoviesResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GetMovies {

    private static final String type = "movie";

    public static void execute(final GetMoviesCallback callback, String searchText) {
        ApiUtils.getApi().getMovies(ApiUtils.API_KEY, searchText, type).enqueue(new Callback<GetMoviesResponse>() {
            @Override
            public void onResponse(@NonNull Call<GetMoviesResponse> call, @NonNull Response<GetMoviesResponse> response) {
                if (response.isSuccessful()) {
                    if (response.body() != null) {
                        callback.onSuccess(response.body());
                    } else {
                        callback.onError();
                    }
                } else {
                    callback.onError();
                }
            }

            @Override
            public void onFailure(@NonNull Call<GetMoviesResponse> call, @NonNull Throwable t) {
                callback.onError();
            }
        });
    }

    public interface GetMoviesCallback {
        void onSuccess(GetMoviesResponse responseBody);

        void onError();
    }
}
