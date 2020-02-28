package com.example.instagram;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;

public class NewsDetailActivity extends AppCompatActivity {
private ImageView imageViewIntentResult ;
private ImageView logo;
private TextView author;
private TextView likes;
private TextView comments;
private TextView data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_detail);

        imageViewIntentResult = findViewById(R.id.image);
         logo = findViewById(R.id.logo);
         author = findViewById(R.id.author);
         likes = findViewById(R.id.likes);
        comments = findViewById(R.id.comments);
         data = findViewById(R.id.data);


        News news = (News) getIntent().getParcelableExtra("news");
        Glide.with(this).load(news.getImage()).into(imageViewIntentResult);
        Glide.with(this).load(news.getLogo()).into(logo);
//        Picasso.with(imageViewIntentResult.getContext()).load(news.getImage()).into(imageViewIntentResult);
//        Picasso.with(logo.getContext()).load(news.getLogo()).into(logo);

      author.setText(news.getAuthor());
       likes.setText("Нравится: "+String.valueOf(news.getLikes()));
      comments.setText("Посмотреть все комментарии(30)");
      String s = "<b>"+news.getAuthor()+"</b>"+" "+news.getData();
       data.setText(Html.fromHtml(s));



    }
}
