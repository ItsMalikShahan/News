package com.example.news;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.news.Models.NewsApiResponse;
import com.example.news.Models.NewsHeadline;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    NewsAdapter newsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RequestManager manager = new RequestManager(this);
        manager.getNewsHeadline(listener, "general", null);
    }
    private final OnFetchDataListener<NewsApiResponse> listener = new OnFetchDataListener<NewsApiResponse>() {
        @Override
        public void onFetchData(List<NewsHeadline> list, String message) {

            showNews(list);
        }

        @Override
        public void onError(String message) {

        }
    };

    private void showNews(List<NewsHeadline> list) {
        Log.e("Check list", "Checking list for data "+list.size() );
        recyclerView = findViewById(R.id.rl_news);
        recyclerView.setHasFixedSize(true);
        newsAdapter = new NewsAdapter(this, list);
        recyclerView.setAdapter(newsAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }
}