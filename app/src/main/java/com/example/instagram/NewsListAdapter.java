package com.example.instagram;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class NewsListAdapter extends RecyclerView.Adapter<NewsListAdapter.NewsViewHolder> {
    private List<News> newsList;
    private List<News> newsLiked;


    private boolean hearted=false;
    @Nullable
    private ItemClickListener listener;
    private LikedListAdapter.LikeClickListener listenerLike;
    private FragmentLike fragmentlike;
    List<Fragment> list=new ArrayList<Fragment>();
private FragmentManager manager;


    public NewsListAdapter(List<News> newsList){
        this.newsList=newsList;
    }

    public NewsListAdapter(List<News> newsList, @Nullable ItemClickListener listener,FragmentLike fragmentLike,FragmentManager manager) {
        this.newsList = newsList;
        this.listener = listener;
        this.fragmentlike=fragmentLike;
        this.manager=manager;

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
    public void onBindViewHolder(@NonNull final NewsViewHolder holder,final int position) {

        final News news=newsList.get(position);
        holder.author.setText(news.getAuthor());
        holder.data.setText(news.getData());
        Glide.with(holder.image.getContext()).load(news.getImage()).into(holder.image);
        Glide.with(holder.logo.getContext()).load(news.getLogo()).into(holder.logo);
        holder.likes.setText("Нравится: "+news.getLikes());
        holder.comment.setText("Посмотреть все (30)");

        holder.like.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(),"Like",Toast.LENGTH_SHORT).show();
                if(!hearted) {

                    Glide.with(holder.like.getContext()).load(R.drawable.hearted).into(holder.like);
                    hearted=true;

                }
                else {
                    Glide.with(holder.like.getContext()).load(R.drawable.heart).into(holder.like);
                    hearted=false;


                }
            }
        });



        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener!=null)
                    listener.itemClick(position,news);

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
        ImageButton like;
        public NewsViewHolder(@NonNull View itemView) {

           super(itemView);
             logo=itemView.findViewById(R.id.logo);
            author=itemView.findViewById(R.id.author);
             image=itemView.findViewById(R.id.image);
             data=itemView.findViewById(R.id.data);
             likes=itemView.findViewById(R.id.likes);
            comment=itemView.findViewById(R.id.comments);
            like=itemView.findViewById(R.id.like);
        }
    }

    interface ItemClickListener {
        void itemClick(int position, News item);

    }


}
