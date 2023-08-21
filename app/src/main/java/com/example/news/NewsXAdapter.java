package com.example.news;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.news.MyModels.NewsHeadlines;
import com.squareup.picasso.Picasso;

import java.util.List;

public class NewsXAdapter extends RecyclerView.Adapter<NewsXAdapter.NewsXViewHolder> {

    Context context;
    List<NewsHeadlines> headlinesList;
    @NonNull
    @Override
    public NewsXViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new NewsXViewHolder(LayoutInflater.from(context).inflate(R.layout.headline_list_item,parent,false));

    }

    @Override
    public void onBindViewHolder(@NonNull NewsXViewHolder holder, int position) {

        holder.newsTitle.setText(headlinesList.get(position).getTitle());
        holder.newsSource.setText(headlinesList.get(position).getSource().getName());
        if (headlinesList.get(position) != null){
            Picasso.get().load(headlinesList.get(position).getUrlToImage()).into(holder.imageId);
        }

    }


    @Override
    public int getItemCount() {
        return headlinesList.size();
    }
    public class NewsXViewHolder extends RecyclerView.ViewHolder {
        TextView newsTitle, newsSource;
        ImageView imageId;
        public NewsXViewHolder(@NonNull View itemView) {
            super(itemView);
            newsTitle = itemView.findViewById(R.id.tv_newsTitle);
            newsSource = itemView.findViewById(R.id.tv_newsLink);
            imageId = itemView.findViewById(R.id.iv_newsImage);
        }
    }
}
