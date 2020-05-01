package com.example.finalmovieapp.network.interactors;

import android.support.annotation.NonNull;

import com.example.finalmovieapp.network.ApiUtils;
import com.example.finalmovieapp.network.models.GetMovieDetailsResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GetMovieDetails {

    public static void execute(final GetMovieDetailsCallback callback, String id) {
        ApiUtils.getApi().getMovieDetails(ApiUtils.API_KEY, id).enqueue(new Callback<GetMovieDetailsResponse>() {
            @Override
            public void onResponse(@NonNull Call<GetMovieDetailsResponse> call, @NonNull Response<GetMovieDetailsResponse> response) {
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
            public void onFailure(@NonNull Call<GetMovieDetailsResponse> call, @NonNull Throwable t) {
                callback.onError();
            }
        });
    }

    public interface GetMovieDetailsCallback {
        void onSuccess(GetMovieDetailsResponse responseBody);

        void onError();
    }
}
