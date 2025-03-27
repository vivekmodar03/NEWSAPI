package com.firsapplication.newsapi;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIService {
    @GET("https://newsapi.org/v2/everything?q=tesla&from=2025-01-31sortBy=publishedAt&apiKey=bdb61350af014b279a03c82d66c704a0")  // Replace with your API endpoint
//    @GET("https://pudhari.news/topic/api");

    Call<NewsResponse> getNews();
}
