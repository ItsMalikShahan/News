package com.example.news;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.example.news.Api.Api;
import com.example.news.Api.ApiClient;
import com.example.news.Models.NewsApiResponse;
import com.example.news.MyModels.NewsXApiResponse;
import com.google.gson.Gson;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

public class RequestManager {
    Context context;
    ApiClient apiClient;


//    Retrofit retrofit = new Retrofit.Builder()
//            .baseUrl("https://newsapi.org/v2/")
//            .addConverterFactory(GsonConverterFactory.create())
//            .build();


    public void getNewsHeadline(OnFetchDataListener listener, String category, String query ){
        Api retrofitApi = ApiClient.getClient().create(Api.class);
          Call<NewsXApiResponse> call = retrofitApi.newsHeadline("us", category, query, context.getString(R.string.api_key));
          Log.e("Call", "onFetch: ");

          try {
              call.enqueue(new Callback<NewsXApiResponse>() {
                  @Override
                  public void onResponse(Call<NewsXApiResponse> call, Response<NewsXApiResponse> response) {
                      if (!response.isSuccessful()) {
                          Log.e("Api Check", "onResponse: ");
                          Toast.makeText(context, "Error!!", Toast.LENGTH_SHORT).show();
                      }
                      listener.onFetchData(response.body().getArticles(), response.message());
                  }

                  @Override
                  public void onFailure(Call<NewsXApiResponse> call, Throwable t) {
                      listener.onError("Request failed");
                      Log.e("Error Message", "onFailure: " + t.getMessage());
                  }
              });
          } catch (Exception e) {
              e.printStackTrace();
          }
      }

    public RequestManager(Context context) {
        this.context = context;
    }
//    public interface CallApi{
//        @GET("top-headlines")
//        Call<NewsApiResponse> callHeadline(@Query("country") String country,
//                                           @Query("category") String category,
//                                           @Query("q")  String query,
//                                           @Query("apiKey") String api_key
//            );
//    }
}
