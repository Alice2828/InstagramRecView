package com.example.instagram;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class LikedListAdapter  extends RecyclerView.Adapter<LikedListAdapter.LikedNewsViewHolder>{
    private List<News> newsList=new ArrayList<News>();
    private List<News> newsLiked;


    private boolean hearted=false;
    @Nullable
    private NewsListAdapter.ItemClickListener listener;
    private LikedListAdapter.LikeClickListener listenerLike=null;
    private FragmentLike fragmentlike;
    List<Fragment> list=new ArrayList<Fragment>();
    private FragmentManager manager;


    public LikedListAdapter(List<News> newsList){
        this.newsList=newsList;
    }

    public LikedListAdapter(List<News> newsList, @Nullable NewsListAdapter.ItemClickListener listener) {

        this.newsList=newsList;
        this.listener = listener;


    }

    @NonNull
    @Override

    public LikedNewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_news,null,false);
        RecyclerView.LayoutParams params = new RecyclerView.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
        );
        view.setLayoutParams(params);
        return new LikedNewsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final LikedNewsViewHolder holder, final int position) {

        final News news=newsList.get(position);
        holder.author.setText(news.getAuthor());
        holder.data.setText(news.getData());
        Glide.with(holder.image.getContext()).load(news.getImage()).into(holder.image);
        Glide.with(holder.logo.getContext()).load(news.getLogo()).into(holder.logo);
        holder.likes.setText("Нравится: "+news.getLikes());
        holder.comment.setText("Посмотреть все (30)");

//        holder.like.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(v.getContext(),"Like",Toast.LENGTH_SHORT).show();
//
//
//                    Glide.with(holder.like.getContext()).load(R.drawable.hearted).into(holder.like);
//                    hearted=true;
//
//                    Fragment fragLike = manager.findFragmentById(R.id.fragment_like);



//                    ((RecyclerView)fragPage.getView().findViewById(R.id.recyclerView)).getAdapter().notifyDataSetChanged();
                  //  ((RecyclerView)fragLike.getView().findViewById(R.id.recyclerView)).getAdapter().notifyDataSetChanged();


//                     RecyclerView recView=((RecyclerView) fragLike.getView().findViewById(R.id.recyclerView));


//
//                    Glide.with(holder.logo.getContext()).load(news.getLogo()).into((ImageView) fragLike.getView().findViewById(R.id.logo));
//                    Glide.with(holder.image.getContext()).load(news.getImage()).into((ImageView) fragLike.getView().findViewById(R.id.image));
//                    Glide.with(holder.image.getContext()).load(news.getLikes()).into((ImageView) fragLike.getView().findViewById(R.id.like));

//                    ((ImageView) fragLike.getView().findViewById(R.id.logo))
//                            .setText("Access to Fragment 1 from Activity");
//                    ((ImageView) fragLike.getView().findViewById(R.id.image))
//                            .setText("Access to Fragment 1 from Activity");
//                    ((TextView) fragLike.getView().findViewById(R.id.data))
//                            .setText("Access to Fragment 1 from Activity");
//                    ((TextView) fragLike.getView().findViewById(R.id.likes))
//                            .setText("Access to Fragment 1 from Activity");
//                    ((TextView) fragLike.getView().findViewById(R.id.comments))
//                            .setText("Access to Fragment 1 from Activity");

//
//            }
//        });


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

    public class LikedNewsViewHolder extends RecyclerView.ViewHolder{
        ImageView logo;
        TextView author;
        ImageView image;
        TextView data;
        TextView likes;
        TextView comment;
        ImageButton like;
        public LikedNewsViewHolder(@NonNull View itemView) {

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
    interface LikeClickListener {
        void likeClick(int position, News item);

    }
}
