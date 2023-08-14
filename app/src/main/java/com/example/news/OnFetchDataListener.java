package com.example.news;

import com.example.news.Models.NewsHeadline;

import java.util.List;

public interface OnFetchDataListener {
    void onFetchData(List<NewsHeadline> list, String message);
    void onError(String message);
}