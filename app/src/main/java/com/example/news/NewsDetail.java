package com.example.news;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.news.MyModels.NewsHeadlines;
import com.squareup.picasso.Picasso;

public class NewsDetail extends AppCompatActivity {

    NewsHeadlines headlines;
    TextView title, author, time, detail, content;
    ImageView news_image;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_detail);


        title = findViewById(R.id.tv_detail_title);
        author = findViewById(R.id.tv_author_detail);
        time = findViewById(R.id.tv_time_detail);
        detail = findViewById(R.id.tv_news_detail);
        content = findViewById(R.id.tv_news_content);
        news_image = findViewById(R.id.iv_detail_news);

        headlines =(NewsHeadlines) getIntent().getSerializableExtra("data");

        title.setText(headlines.getTitle());
        author.setText(headlines.getAuthor());
        time.setText(headlines.getPublishedAt());
        detail.setText(headlines.getDescription());
        content.setText(headlines.getContent());
        Picasso.get().load(headlines.getUrlToImage()).into(news_image);
    }
}