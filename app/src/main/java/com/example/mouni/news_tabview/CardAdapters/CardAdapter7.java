package com.example.mouni.news_tabview.CardAdapters;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.example.mouni.news_tabview.ActivityTwo;
import com.example.mouni.news_tabview.CustomVolleyRequest;
import com.example.mouni.news_tabview.ObjectClasses.Object11;
import com.example.mouni.news_tabview.R;

import java.io.Serializable;
import java.util.ArrayList;


/**
 * Created by MOUNI on 06-Aug-16.
 */

public class CardAdapter7 extends RecyclerView.Adapter<CardAdapter7.ViewHolder> {

    //public ImageLoader imageLoader;
    private Context context;
    public ImageLoader imageLoader;

    //List of images and title
    //public static ArrayList<ImageAndTitle> img_list;
    public static ArrayList<Object11> img_list;

    public CardAdapter7(ArrayList<Object11> img_list, Context context) {
        super();
        //Getting all the superheroes
        this.img_list = img_list;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        Object11 superHero = img_list.get(position);

        imageLoader = CustomVolleyRequest.getInstance(context).getImageLoader();
        imageLoader.get(superHero.getImageUrl(), ImageLoader.getImageListener(holder.imageView, R.mipmap.ic_launcher, android.R.drawable.ic_dialog_alert));
        holder.imageView.setImageUrl(superHero.getImageUrl(), imageLoader);
        holder.textViewTitle.setText(superHero.getTitle());
        holder.textViewContent.setText(superHero.getContent());

    }

    @Override
    public int getItemCount() {
        return img_list.size();
    }


    class ViewHolder extends RecyclerView.ViewHolder {
       public NetworkImageView imageView;
        public TextView textViewTitle;
        public View view;
        public TextView textViewContent;

        public ViewHolder(View itemView) {
            super(itemView);
            view = itemView;
            imageView = (NetworkImageView) itemView.findViewById(R.id.imageViewHero);
            textViewTitle = (TextView) itemView.findViewById(R.id.txv_row);
            textViewContent = (TextView) itemView.findViewById(R.id.tv_content);
            view.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v)
                {
                    int i=getAdapterPosition();
                    Intent intent=new Intent(context.getApplicationContext(),ActivityTwo.class);
                    Bundle args =new Bundle();
                    args.putSerializable("LIST",(Serializable)img_list);
                    intent.putExtra("BUNDLE",args);
                    intent.putExtra("position",i);
                    //intent.putExtra("newsobject",content);
                    context.startActivity(intent);

                }
            });
        }
    }
}

