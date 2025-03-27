package com.firsapplication.newsapi;

import android.util.Log;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIClient {
//    private static final String TAG = "ApiClient";
private static final String BASE_URL = "https://newsapi.org/";
    private static Retrofit retrofit;

    public static Retrofit getClient() {
        if (retrofit == null) {
//            Log.d(TAG, "Creating new Retrofit instance");
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
//        else Log.d(TAG, "Using existing Retrofit instance");
        return retrofit;
    }
}

// Step 4: Setting Up Retrofit for API Calls
//1. Created Apiservice.java
//            Here, @GET tells Retrofit to make a GET request.
//2. Created a Retrofit Client
//        Created ApiClient.java:
//              This helps connect to the API using Retrofit.