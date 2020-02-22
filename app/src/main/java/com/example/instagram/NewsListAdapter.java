package com.example.instagram;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class NewsListAdapter extends RecyclerView.Adapter<NewsListAdapter.NewsViewHolder> {
    private List<News> newsList;

    @Nullable
    private ItemClickListener listener;

    public NewsListAdapter(List<News> newsList){
        this.newsList=newsList;
    }
    public NewsListAdapter(List<News> newsList, @Nullable ItemClickListener listener) {
        this.newsList = newsList;
        this.listener = listener;
    }

    @NonNull
    @Override

    public NewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_news,null,false);
        RecyclerView.LayoutParams params = new RecyclerView.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
        );
        view.setLayoutParams(params);
        return new NewsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsViewHolder holder,final int position) {
        final News news = newsList.get(position);
        Picasso.with(holder.logo.getContext()).load(news.getLogo()).into(holder.logo);
        holder.author.setText(news.getAuthor());
        Picasso.with(holder.image.getContext()).load(news.getImage()).into(holder.image);
        holder.data.setText(news.getData());
        holder.likes.setText("Нравится: "+String.valueOf(news.getLikes()));
        holder.comment.setText(String.valueOf(news.getComment()));


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    listener.itemClick(position, news);
                }
            }
        });
    }



    @Override
    public int getItemCount() {
        return newsList.size();
    }

    public class NewsViewHolder extends RecyclerView.ViewHolder{
        ImageView logo;
        TextView author;
        ImageView image;
        TextView data;
        TextView likes;
        TextView comment;
        public NewsViewHolder(@NonNull View itemView) {

           super(itemView);
             logo=itemView.findViewById(R.id.logo);
            author=itemView.findViewById(R.id.author);
             image=itemView.findViewById(R.id.image);
             data=itemView.findViewById(R.id.data);
             likes=itemView.findViewById(R.id.likes);
            comment=itemView.findViewById(R.id.comments);
        }
    }
    interface ItemClickListener {
        void itemClick(int position, News item);
    }
}
