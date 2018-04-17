package com.example.davidgh.movies.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.davidgh.movies.R;
import com.example.davidgh.movies.utils.NetworkUtils;

public class TvsFragment extends Fragment {

    public TvsFragment() {
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
        return inflater.inflate(R.layout.fragment_tvs, container, false);
    }
}
