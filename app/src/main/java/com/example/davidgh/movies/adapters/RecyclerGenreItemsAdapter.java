package com.example.davidgh.movies.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.davidgh.movies.R;
import com.example.davidgh.movies.models.SingleMovieModel;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class RecyclerGenreItemsAdapter extends RecyclerView.Adapter<RecyclerGenreItemsAdapter.ItemsHolder> {

    private Context mContext;
    private ArrayList<SingleMovieModel> movies;

    public RecyclerGenreItemsAdapter() {
    }

    public RecyclerGenreItemsAdapter(Context mContext, ArrayList<SingleMovieModel> movies) {
        this.mContext = mContext;
        this.movies = movies;
    }

    @NonNull
    @Override
    public ItemsHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_movie_card, null);
        return new ItemsHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemsHolder holder, int position) {

        SingleMovieModel m = movies.get(position);

        Picasso.with(mContext).load(m.getUrl()).into(holder.ivMovieImage);
        holder.tvIdMovie.setText(m.getId());
        holder.tvMovieTitle.setText(m.getName());
        holder.tvMovieSubtitle.setText(m.getName() + " subtitle");
        holder.tvMovieRating.setText(Float.toString(m.getRating()));

    }

    @Override
    public int getItemCount() {
        return (null != movies ? movies.size() : 0);
    }

    public class ItemsHolder extends RecyclerView.ViewHolder {

        protected ImageView ivMovieImage;
        protected TextView tvIdMovie;
        protected TextView tvMovieTitle;
        protected TextView tvMovieSubtitle;
        protected TextView tvMovieRating;

        public ItemsHolder(View itemView) {
            super(itemView);

            ivMovieImage = (ImageView) itemView.findViewById(R.id.iv_movie_image);
            tvIdMovie = (TextView) itemView.findViewById(R.id.tv_id_movie);
            tvMovieTitle = (TextView) itemView.findViewById(R.id.tv_movie_title);
            tvMovieSubtitle = (TextView) itemView.findViewById(R.id.tv_movie_subtitle);
            tvMovieRating = (TextView) itemView.findViewById(R.id.tv_movie_rating);

        }
    }
}
