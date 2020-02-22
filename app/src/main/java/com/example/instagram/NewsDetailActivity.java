package com.example.instagram;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class NewsDetailActivity extends AppCompatActivity {
private ImageView imageViewIntentResult ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_detail);

        imageViewIntentResult = findViewById(R.id.image);

        News news = (News) getIntent().getParcelableExtra("news");
        Picasso.with(imageViewIntentResult.getContext()).load(news.getImage()).into(imageViewIntentResult);

    }
}
