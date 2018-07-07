package com.chuck.android.popularmovies_test;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;


import com.chuck.android.popularmovies_test.adapter.MovieTitleAdapter;
import com.chuck.android.popularmovies_test.models.MovieTitle;
import com.chuck.android.popularmovies_test.utils.SampleData;
import com.chuck.android.popularmovies_test.viewmodel.MainViewModel;
import com.facebook.stetho.Stetho;


import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private MovieTitleAdapter adapter;
    LinearLayoutManager movieGridLayoutManger;
    private List<MovieTitle> moviesData = new ArrayList<>();
    private MainViewModel mViewModel;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.movieDbList);
        Toolbar toolbar = findViewById(R.id.toolbar);
        movieGridLayoutManger = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(movieGridLayoutManger);
        adapter = new MovieTitleAdapter(R.layout.movie_list_item, getApplicationContext());
        recyclerView.setAdapter(adapter);
        initViewModel();
        Stetho.initializeWithDefaults(this);

        //List<MovieTitle> movies = SampleData.getMovies();
        //adapter.setMovies(movies);



    }
    private void initViewModel() {
        final Observer<List<MovieTitle>> movieObserver = new Observer<List<MovieTitle>>() {
            @Override
            public void onChanged(@Nullable List<MovieTitle> movieTitles) {
                moviesData.clear();
                moviesData.addAll(movieTitles);
                adapter.setMovies(moviesData);
            }
        };
        mViewModel = ViewModelProviders.of(this)
                .get(MainViewModel.class);
        mViewModel.mMovies.observe(this, movieObserver);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_add_sample_data) {
            addSampleData();

            return true;
        } else if (id == R.id.action_delete_all) {
            deleteAllNotes();
            return true;
        }else if (id==R.id.add_old_sample_Data){
            addOldSampleData();
        }

        return super.onOptionsItemSelected(item);
    }

    private void addOldSampleData() {
        mViewModel.addSampleData();

    }

    private void deleteAllNotes() {
        mViewModel.deleteAllNotes();
    }

    private void addSampleData() {
        mViewModel.addMoreSampleData();
    }
//TODO only have menu add more data
}
