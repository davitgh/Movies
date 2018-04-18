package com.example.davidgh.movies.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.davidgh.movies.R;
import com.example.davidgh.movies.models.SingleMovieModel;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class SectionListMultAdapter extends RecyclerView.Adapter<SectionListMultAdapter.SingleItemRowHolder> {

    private Context mContext;
    private ArrayList<SingleMovieModel> itemList;

    public SectionListMultAdapter(Context mContext, ArrayList<SingleMovieModel> itemList) {
        this.mContext = mContext;
        this.itemList = itemList;
    }

    public SectionListMultAdapter() {
    }

    @NonNull
    @Override
    public SingleItemRowHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_single_card, null);

        return new SingleItemRowHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull SingleItemRowHolder holder, int position) {
        SingleMovieModel movie = itemList.get(position);

        holder.tvMovieTitle.setText(movie.getName());
        Picasso.with(mContext).load(movie.getUrl()).into(holder.ivMovieImage);

    }

    @Override
    public int getItemCount() {
        return (null != itemList ? itemList.size() : 0);
    }

    public class SingleItemRowHolder extends RecyclerView.ViewHolder {

        protected TextView tvMovieTitle;
        protected ImageView ivMovieImage;

        public SingleItemRowHolder(View itemView) {
            super(itemView);

            tvMovieTitle = (TextView) itemView.findViewById(R.id.tv_movie_title);
            ivMovieImage = (ImageView) itemView.findViewById(R.id.iv_movie_image);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(mContext, "Clicked Single Movie Item", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}
