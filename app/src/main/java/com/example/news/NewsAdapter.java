package com.example.news;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsViewHolder> {

    Context context;

    @NonNull
    @Override
    public NewsAdapter.NewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull NewsAdapter.NewsViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
    public class NewsViewHolder extends RecyclerView.ViewHolder{
        TextView title, source;
        ImageView headlineImage;
        CardView cardView;
        public NewsViewHolder(@NonNull View itemView) {
            super(itemView);
           title = itemView.findViewById(R.id.tv_newsTitle);
           source = itemView.findViewById(R.id.tv_newsLink);
           headlineImage = itemView.findViewById(R.id.iv_newsImage);
           cardView = itemView.findViewById(R.id.cardview);
        }
    }
}
