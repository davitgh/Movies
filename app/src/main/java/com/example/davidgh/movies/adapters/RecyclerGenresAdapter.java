package com.example.davidgh.movies.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.davidgh.movies.activities.GenreItemActivity;
import com.example.davidgh.movies.R;

public class RecyclerGenresAdapter extends RecyclerView.Adapter<RecyclerGenresAdapter.GenreHolder>{

    private Context mContext;
    private String [] mGenres;

    public RecyclerGenresAdapter() {
    }

    public RecyclerGenresAdapter(Context mContext, String[] mGenres) {
        this.mContext = mContext;
        this.mGenres = mGenres;
    }

    @NonNull
    @Override
    public GenreHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_genre_item, null);

        return new GenreHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull GenreHolder holder, final int position) {

        // TODO 14: add holder.ivGenreIcon icons
        holder.tvGenreTitle.setText(mGenres[position]);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(mContext, GenreItemActivity.class);
                i.putExtra("title", mGenres[position]);
                mContext.startActivity(i);
            }
        });

    }

    @Override
    public int getItemCount() {
        return mGenres.length;
    }

    public class GenreHolder extends RecyclerView.ViewHolder {

        protected ImageView ivGenreIcon;
        protected TextView tvGenreTitle;

        public GenreHolder(View v) {
            super(v);

            ivGenreIcon = (ImageView) v.findViewById(R.id.iv_genre_icon);
            tvGenreTitle = (TextView) v.findViewById(R.id.tv_genre_title);
        }
    }
}
