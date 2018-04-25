package com.example.davidgh.movies.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.davidgh.movies.R;
import com.example.davidgh.movies.adapters.RecyclerGenresAdapter;
import com.example.davidgh.movies.utils.NetworkUtils;

public class GenresFragment extends Fragment {

    public GenresFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        if (!NetworkUtils.isNetworkAvailable(getContext())){
            NetworkUtils.createAlertNoInternet(getContext());
        }
        View v =  inflater.inflate(R.layout.fragment_genres, container, false);

        RecyclerView rvGenres = v.findViewById(R.id.rv_genres);
        rvGenres.setHasFixedSize(true);

        RecyclerGenresAdapter adapter = new RecyclerGenresAdapter(getContext(), NetworkUtils.getGenres());
        rvGenres.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        rvGenres.setAdapter(adapter);
        return v;
    }
}
