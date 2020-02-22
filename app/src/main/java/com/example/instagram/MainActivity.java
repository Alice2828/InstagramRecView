package com.example.instagram;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
 private RecyclerView recyclerView;
    private NewsListAdapter adapter;
    private ImageButton like;

    private NewsListAdapter.ItemClickListener listener = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listener = new NewsListAdapter.ItemClickListener() {
            @Override
            public void itemClick(int position, News item) {
                Intent intent = new Intent(MainActivity.this, NewsDetailActivity.class);
                intent.putExtra("news", item);
                intent.putExtra("image", item.getImage());
                startActivity(intent);

            }

        };
        like.findViewById(R.id.like);
        like.setOnClickListener(new View.OnClickListener() {
                                    public void onClick(View v) {
                                        Toast toast = Toast.makeText(MainActivity.this, "Like", Toast.LENGTH_LONG);
                                        toast.show();
                                    }
                                });

            recyclerView=findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter = new NewsListAdapter(newsGenerator(), listener);
        recyclerView.setAdapter(adapter);
    }

    private List<News> newsGenerator() {

        List<News> items = new ArrayList<>();
        ArrayList<Integer> logo = new ArrayList<>();
        ArrayList<String> author = new ArrayList<>();
        ArrayList<Integer> image = new ArrayList<>();
        ArrayList<String> data = new ArrayList<>();

        logo.add(R.drawable.log);
        author.add("Adruino");
        image.add(R.drawable.im);
        data.add("Arduino — торговая марка аппаратно-программных средств");

        logo.add(R.drawable.logo);
        author.add("Adruino");
        image.add(R.drawable.ima);
        data.add("Arduino — торговая марка аппаратно-программных средств");

        logo.add(R.drawable.logot);
        author.add("Adruino");
        image.add(R.drawable.imag);
        data.add("Arduino — торговая марка аппаратно-программных средств");

        logo.add(R.drawable.log);
        author.add("Adruino");
        image.add(R.drawable.im);
        data.add("Arduino — торговая марка аппаратно-программных средств");
        for (int i = 0; i < logo.size(); i++) {
            News news = new News(
                    logo.get(i),
            author.get(i),
                   image.get(i),
            data.get(i),
                    i,
            i
            );
            items.add(news);
        }
        return items;
    }
}
