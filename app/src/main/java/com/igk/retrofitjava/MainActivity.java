package com.igk.retrofitjava;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    public ArrayList<Articles> articlesList;
    public RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        articlesList = new ArrayList<>();
        recyclerView = findViewById(R.id.recyclerView);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://newsapi.org/v2/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();



        JsonPlaceHolderAPI jsonPlaceHolderAPI = retrofit.create(JsonPlaceHolderAPI.class);

        Call<newsAPI> call = jsonPlaceHolderAPI.getPosts("google-news-in","b1a1cfa0f55e41d88e1edf80967918fd");

        call.enqueue(new Callback<newsAPI>() {
            @Override
            public void onResponse(Call<newsAPI> call, Response<newsAPI> response) {
                if(!response.isSuccessful()){
                    Toast.makeText(MainActivity.this, "Code: "+response.code(), Toast.LENGTH_SHORT).show();
                    return;
                }
                newsAPI post = response.body();
                List<Articles> articles = post.articles;

                RecyclerAdapter recyclerAdapter = new RecyclerAdapter(articles,MainActivity.this);
                RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
                recyclerView.setLayoutManager(layoutManager);
                recyclerView.setItemAnimator(new DefaultItemAnimator());
                recyclerView.setAdapter(recyclerAdapter);
            }


            @Override
            public void onFailure(Call<newsAPI> call, Throwable t) {

            }
        });

    }
}