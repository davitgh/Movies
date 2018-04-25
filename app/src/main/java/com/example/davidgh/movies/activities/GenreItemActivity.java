package com.example.davidgh.movies.activities;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import com.example.davidgh.movies.R;
import com.example.davidgh.movies.adapters.RecyclerGenreItemsAdapter;
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

public class GenreItemActivity extends AppCompatActivity {

    private ArrayList<SingleMovieModel> movies;
    private RecyclerGenreItemsAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gente_item);

        String title = getIntent().getStringExtra("title");
        Toolbar tbGenres = findViewById(R.id.tb_genres);
        /*
        * Get Movies from API:
        * */
        movies = new ArrayList<>();
        new GetMovies().execute(NetworkUtils.API_ALL_MULTS);


        tbGenres.setTitle(title);
        setSupportActionBar(tbGenres);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        RecyclerView rvGenreItems = (RecyclerView) findViewById(R.id.rv_genre_items);
        rvGenreItems.setHasFixedSize(true);
        rvGenreItems.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        adapter = new RecyclerGenreItemsAdapter(this, movies);
        rvGenreItems.setAdapter(adapter);
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


                for (int i = 0; i < jsonArray.length(); i++) {
                    SingleMovieModel m = gson.fromJson(String.valueOf(jsonArray.getJSONObject(i)), type);

                    movies.add(new SingleMovieModel(m.getId(), m.getName(), m.getUrl(), m.getDate(), m.getRating()));

                }

                adapter.notifyDataSetChanged();
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}
