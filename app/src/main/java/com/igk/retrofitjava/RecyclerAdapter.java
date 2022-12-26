package com.igk.retrofitjava;

import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {
    public List<Articles> articlesList;
    public Context context;

    public RecyclerAdapter(List<Articles> articlesList,Context context){
        this.articlesList = articlesList;
        this.context = context;
    }

    public class ViewHolder extends  RecyclerView.ViewHolder{
        public TextView titleTV;
        public TextView descTV;
        public ImageView imageView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            titleTV = itemView.findViewById(R.id.titleTV);
            descTV = itemView.findViewById(R.id.descTV);
            imageView = itemView.findViewById(R.id.imageView);
        }
    }

    @NonNull
    @Override
    public RecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_items,parent,false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapter.ViewHolder holder, int position) {
        String title = articlesList.get(position).title;
        String desc = articlesList.get(position).description;
        String url = articlesList.get(position).urlToImage;
        holder.titleTV.setText(title);
        holder.descTV.setText(desc);
        Glide.with(context).load(url).into(holder.imageView);
        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,DisplayNews.class);
                intent.putExtra("url",articlesList.get(holder.getAdapterPosition()).url);
;               context.startActivity(intent);
            }
        });
        holder.titleTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,DisplayNews.class);
                intent.putExtra("url",articlesList.get(holder.getAdapterPosition()).url);
                ;               context.startActivity(intent);
            }
        });holder.descTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,DisplayNews.class);
                intent.putExtra("url",articlesList.get(holder.getAdapterPosition()).url);
                ;               context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return articlesList.size();
    }

}
