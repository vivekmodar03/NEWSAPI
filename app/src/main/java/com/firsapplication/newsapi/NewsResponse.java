package com.firsapplication.newsapi;

import java.util.List;

public class NewsResponse {
    private String status;
    private List<Article> articles;

    public String getStatus() { return status; }
    public List<Article> getArticles() { return articles; }
}

//Step 3: Creating a Response Wrapper Class
//        The API returns a list of articles, so we created another class to hold the full response.

//        Created NewsResponse.java: