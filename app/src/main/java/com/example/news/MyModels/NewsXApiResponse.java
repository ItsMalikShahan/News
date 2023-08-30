package com.example.news.MyModels;

import java.io.Serializable;
import java.util.List;

public class NewsXApiResponse implements Serializable {
    List<NewsHeadlines> articles;
    String status;
    String totalResults;

    public List<NewsHeadlines> getArticles() {
        return articles;
    }

    public void setArticles(List<NewsHeadlines> articles) {
        this.articles = articles;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(String totalResults) {
        this.totalResults = totalResults;
    }
}
