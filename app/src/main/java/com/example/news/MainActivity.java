package com.example.news;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.ContentLoadingProgressBar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import com.example.news.Models.NewsApiResponse;
import com.example.news.Models.NewsHeadline;
import com.example.news.MyModels.NewsHeadlines;

import java.util.List;

public class MainActivity extends AppCompatActivity implements SelectedListener, View.OnClickListener {

    RecyclerView recyclerView;
    NewsXAdapter newsAdapter;
    Button btn1, btn2, btn3, btn4, btn5, btn6, btn7;
//    ProgressBar loadingProgressBar;
    ProgressDialog dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        loadingProgressBar = findViewById(R.id.pb_loading);
        btn1 = findViewById(R.id.btn_1);
        btn2 = findViewById(R.id.btn_2);
        btn3 = findViewById(R.id.btn_3);
        btn4 = findViewById(R.id.btn_4);
        btn5 = findViewById(R.id.btn_5);
        btn6 = findViewById(R.id.btn_6);
        btn7 = findViewById(R.id.btn_7);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);

        recyclerView = findViewById(R.id.rl_news);
        dialog = new ProgressDialog(this);
        dialog.setTitle("Fetching Latest News...");
        dialog.show();
        RequestManager manager = new RequestManager(this);
        manager.getNewsHeadline(listener, "general", null);
    }
    private final OnFetchDataListener<NewsApiResponse> listener = new OnFetchDataListener<NewsApiResponse>() {
        @Override
        public void onFetchData(List<NewsHeadlines> list, String message) {
//            loadingProgressBar.setVisibility(View.GONE);
            recyclerView.setVisibility(View.VISIBLE);
            showNews(list);
            dialog.dismiss();
        }



        @Override
        public void onError(String message) {

        }
    };

    private void showNews(List<NewsHeadlines> list) {
        Log.e("Check list", "Checking list for data "+list.size() );
        recyclerView.setHasFixedSize(true);
        newsAdapter = new NewsXAdapter(this, list, this);
        recyclerView.setAdapter(newsAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

    @Override
    public void onNewsClicked(NewsHeadlines newsHeadlines) {
        startActivity(new Intent(MainActivity.this, NewsDetail.class)
                .putExtra("data", newsHeadlines));

    }

    @Override
    public void onClick(View view) {

        Button button = (Button) view;
        String category = button.getText().toString();
        dialog.setTitle("Fetching news articles of " + category);
        dialog.show();
        RequestManager manager = new RequestManager(this);
        manager.getNewsHeadline(listener, category, null);
    }
}