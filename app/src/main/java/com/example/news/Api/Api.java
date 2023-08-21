package com.example.news.Api;

import com.example.news.MyModels.NewsXApiResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Api {
    @GET("top-headlines")
    Call<NewsXApiResponse> newsHeadline(@Query("country") String country,
                                        @Query("category") String category,
                                        @Query("q")  String query,
                                        @Query("apiKey") String api_key
    );
}
