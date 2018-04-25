package com.example.davidgh.movies.fragments;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.davidgh.movies.R;
import com.example.davidgh.movies.adapters.RecyclerViewMoviesAdapter;
import com.example.davidgh.movies.models.SectionMovieModel;
import com.example.davidgh.movies.models.SingleMovieModel;
import com.example.davidgh.movies.utils.NetworkUtils;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class MoviesFragment extends Fragment {

    private ArrayList<SectionMovieModel> allSections;

    // Adapter
    private RecyclerViewMoviesAdapter adapter;

    public MoviesFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_movies, container, false);
        // Creating sections
        allSections = new ArrayList<>();
        downloadSectionData();
        RecyclerView mRv = (RecyclerView) v.findViewById(R.id.rv_sections);
        mRv.setHasFixedSize(true);

        adapter = new RecyclerViewMoviesAdapter(getContext(), allSections);
        mRv.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));

        mRv.setAdapter(adapter);

        return v;
    }

    private void downloadSectionData(){

        // Checking Network access
        if (NetworkUtils.isNetworkAvailable(getContext())){

            new GetMovies().execute(NetworkUtils.API_ALL_MULTS);

        } else {
            NetworkUtils.createAlertNoInternet(getContext());
        }
    }

    public class GetMovies extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... urls) {

            String stream = null;
            String urlString = urls[0];

            stream = NetworkUtils.getHttpData(urlString);

            return stream;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

            // TODO 11: Make Progress Dialog which will wait for download process

            Gson gson = new Gson();
            Type type = new TypeToken<SingleMovieModel>(){}.getType();

            try {
                JSONObject jsonObject = new JSONObject(s);
                JSONArray jsonArray = jsonObject.getJSONArray("mults");

                for (int i = 0; i < 3; i++) {
                    SectionMovieModel movies = new SectionMovieModel();
                    movies.setHeader(NetworkUtils.getMovieHeader(i));
                    ArrayList<SingleMovieModel> singleMovieModels = new ArrayList<>();

                    for (int j = i * 17; j < (i+1) * 17; j++) {
                        /*TODO IMPORTANT 2: ADD more popular 100 film list according to IMDB*/

                        JSONObject multObject = jsonArray.getJSONObject(j);
                        SingleMovieModel m = gson.fromJson(String.valueOf(multObject), type);

                        singleMovieModels.add(new SingleMovieModel(m.getId(), m.getName(), m.getUrl(), m.getDate(), m.getRating()));
                    }

                    movies.setAllItems(singleMovieModels);
                    allSections.add(movies);
                    adapter.notifyDataSetChanged();
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}
