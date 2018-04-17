package com.example.davidgh.movies.fragments;

import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.davidgh.movies.R;
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
        return inflater.inflate(R.layout.fragment_genres, container, false);
    }
}
