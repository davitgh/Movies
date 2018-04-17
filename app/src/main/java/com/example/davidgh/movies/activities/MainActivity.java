package com.example.davidgh.movies.activities;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;

import com.example.davidgh.movies.R;
import com.example.davidgh.movies.adapters.ViewPagerAdapter;
import com.example.davidgh.movies.fragments.GenresFragment;
import com.example.davidgh.movies.fragments.HomeFragment;
import com.example.davidgh.movies.fragments.MoviesFragment;
import com.example.davidgh.movies.fragments.NewsFragment;
import com.example.davidgh.movies.fragments.NotificationsFragment;
import com.example.davidgh.movies.fragments.TvsFragment;

public class MainActivity extends AppCompatActivity {

    private Toolbar mToolbar;
    private TabLayout mTabs;
    private ViewPager mPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Toolbar
        mToolbar = (Toolbar) findViewById(R.id.tb_main);
        setSupportActionBar(mToolbar);

        // Android Layout
        mPager = (ViewPager) findViewById(R.id.view_pager);
        setupViewPager(mPager);
        mTabs = (TabLayout) findViewById(R.id.tabs);
        mTabs.setupWithViewPager(mPager);

    }

    private void setupViewPager (ViewPager viewPager){
        ViewPagerAdapter adapter  = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new HomeFragment(), "Home");
        adapter.addFragment(new MoviesFragment(), "Movies");
        adapter.addFragment(new TvsFragment(), "Tv Series");
        adapter.addFragment(new GenresFragment(), "Genres");
        adapter.addFragment(new NewsFragment(), "Awards&Events");
        adapter.addFragment(new NotificationsFragment(), "Notifications");
        viewPager.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main, menu);

        /* TODO 3: Change color of Toolbar
        // change color for icon 0
            Drawable yourdrawable = menu.getItem(0).getIcon(); // change 0 with 1,2 ...
            yourdrawable.mutate();
            yourdrawable.setColorFilter(getResources().getColor(android.R.color.white), PorterDuff.Mode.SRC_IN);
        */

        return true;
    }
}
