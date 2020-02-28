package com.example.instagram;


import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */



public class FragmentLike extends Fragment {

    private RecyclerView recyclerView;
    private LikedListAdapter adapter;

    private NewsListAdapter.ItemClickListener listener = null;



    List<News> news=new ArrayList<News>();

    public FragmentLike(List<News> news){

        this.news=news;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       final ViewGroup rootView=(ViewGroup) inflater.inflate(R.layout.fragment_fragment_like, container, false);
//
//        listener = new NewsListAdapter.ItemClickListener() {
//            @Override
//            public void itemClick(int position, News item) {
//                Intent intent = new Intent(rootView.getContext(), NewsDetailActivity.class);
//                intent.putExtra("news", item);
//                intent.putExtra("image", item.getImage());
//                startActivity(intent);
//
//            }
//        };
        recyclerView=rootView.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(rootView.getContext()));


        adapter = new LikedListAdapter( news, listener);

        recyclerView.setAdapter(adapter);

//        News item = new News();
//        int insertIndex = 2;
//        data.add(insertIndex, item);
//        adapter.notifyItemInserted(insertIndex);
        return rootView;
    }





}

