package com.example.finalmovieapp.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiUtils {

    public static final String API_KEY = "efb4dafd";

    private static final String BASE_URL = "http://www.omdbapi.com";

    private static Retrofit retrofitInstance;
    private static Api apiInstance;

    public static Api getApi() {
        if (apiInstance == null) {
            apiInstance = getRetrofitClient().create(Api.class);
        }

        return apiInstance;
    }

    private static Retrofit getRetrofitClient() {
        if (retrofitInstance == null) {
            retrofitInstance = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        }
        return retrofitInstance;
    }
}
