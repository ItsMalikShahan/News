package com.example.news;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.news.MyModels.NewsHeadlines;
import com.squareup.picasso.Picasso;

import java.util.List;

public class NewsXAdapter extends RecyclerView.Adapter<NewsXAdapter.NewsXViewHolder> {

    Context context;
    List<NewsHeadlines> headlinesList;
    SelectedListener listener;

    public NewsXAdapter(Context context, List<NewsHeadlines> headlinesList, SelectedListener listener) {
        this.context = context;
        this.headlinesList = headlinesList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public NewsXViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new NewsXViewHolder(LayoutInflater.from(context).inflate(R.layout.headline_list_item,parent,false));

    }

    @Override
    public void onBindViewHolder(@NonNull NewsXViewHolder holder, @SuppressLint("RecyclerView") int position) {

        holder.newsTitle.setText(headlinesList.get(position).getTitle());
        holder.newsSource.setText(headlinesList.get(position).getSource().getName());
        if (headlinesList.get(position) != null){
            Picasso.get().load(headlinesList.get(position).getUrlToImage()).into(holder.imageId);
        }
        holder.articleCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onNewsClicked(headlinesList.get(position));
            }
        });

    }


    @Override
    public int getItemCount() {
        return headlinesList.size();
    }
    public class NewsXViewHolder extends RecyclerView.ViewHolder {
        TextView newsTitle, newsSource;
        ImageView imageId;
        CardView articleCard;
        public NewsXViewHolder(@NonNull View itemView) {
            super(itemView);
            newsTitle = itemView.findViewById(R.id.tv_newsTitle);
            newsSource = itemView.findViewById(R.id.tv_newsLink);
            imageId = itemView.findViewById(R.id.iv_newsImage);
            articleCard = itemView.findViewById(R.id.cardview);
        }
    }
}
