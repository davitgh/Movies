package com.example.davidgh.movies.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.davidgh.movies.NotificationSettingsActivity;
import com.example.davidgh.movies.R;

public class NotificationsFragment extends Fragment {

    public NotificationsFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_notifications, container, false);

        Button btnSettings = (Button) v.findViewById(R.id.btn_notify_settings);
        btnSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent settingsIntent = new Intent(getContext(), NotificationSettingsActivity.class);
                startActivity(settingsIntent);
            }
        });
        return v;
    }
}
