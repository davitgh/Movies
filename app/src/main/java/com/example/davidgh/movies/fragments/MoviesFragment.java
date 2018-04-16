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

public class MoviesFragment extends Fragment {

    public MoviesFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        if (!NetworkUtils.isNetworkAvailable(getContext())){
/*
    TODO 4: Insert it into function
* */
/*
            final Dialog dialog = new Dialog(getContext());
            dialog.setContentView(R.layout.fragment_no_internet);
            dialog.show();
*/

            AlertDialog.Builder builder;

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
                builder = new AlertDialog.Builder(getContext(), android.R.style.Theme_Material_Dialog_Alert);
            } else {
                builder = new AlertDialog.Builder(getContext());
            }

            builder.setTitle("No Internet Connection")
                    .setMessage("There is no network available. Would you like to visit the network settings page to set one up?")
                    .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(getContext(), "Yes Selected", Toast.LENGTH_SHORT).show();
                        }
                    })
                    .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(getContext(), "Selected No", Toast.LENGTH_SHORT).show();
                        }
                    }).show();
        }
        return inflater.inflate(R.layout.fragment_movies, container, false);
    }
}
