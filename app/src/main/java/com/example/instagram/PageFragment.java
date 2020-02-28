package com.example.instagram;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class PageFragment extends Fragment {



    private RecyclerView recyclerView;
    private NewsListAdapter adapter;
    private FragmentLike fragmentLike;
    List<News> news;
    List<News> newsLiked=new ArrayList<News>();


    private NewsListAdapter.ItemClickListener listener = null;


public PageFragment(List<News> news){
    this.news=news;

}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
         final View rootView =  inflater.inflate(
                R.layout.fragment_page, container, false);

        listener = new NewsListAdapter.ItemClickListener() {
            @Override
            public void itemClick(int position, News item) {
                Intent intent = new Intent(rootView.getContext(), NewsDetailActivity.class);
                intent.putExtra("news", item);
                intent.putExtra("image", item.getImage());
                startActivity(intent);
                    newsLiked.add(item);



            }
        };

        recyclerView=rootView.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(rootView.getContext()));

        adapter = new NewsListAdapter(news, listener, fragmentLike,getFragmentManager());
        recyclerView.setAdapter(adapter);


        return rootView;
    }


}
