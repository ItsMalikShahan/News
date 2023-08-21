package com.example.news;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.news.Models.NewsHeadline;
import com.example.news.MyModels.NewsHeadlines;
import com.squareup.picasso.Picasso;

import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsViewHolder> {

    Context context;
    List<NewsHeadlines> headlines;

    public NewsAdapter(Context context, List<NewsHeadlines> headlines) {
        this.context = context;
        this.headlines = headlines;
    }

    @NonNull
    @Override
    public NewsAdapter.NewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new NewsViewHolder(LayoutInflater.from(context).inflate(R.layout.headline_list_item, parent,false));

    }

    @Override
    public void onBindViewHolder(@NonNull NewsAdapter.NewsViewHolder holder, int position) {
      holder.title.setText(headlines.get(position).getTitle());
      holder.source.setText(headlines.get(position).getSource().getName());
      if (headlines.get(position).getUrlToImage() != null){
          Picasso.get().load(headlines.get(position).getUrlToImage()).into(holder.headlineImage);
      }
    }

    @Override
    public int getItemCount() {
        return headlines.size();
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
