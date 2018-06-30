package com.chuck.android.popularmovies_test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.widget.LinearLayout;

import com.chuck.android.popularmovies_test.adapter.MovieTitleAdapter;
import com.chuck.android.popularmovies_test.models.MovieTitle;
import com.chuck.android.popularmovies_test.utils.SampleData;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private MovieTitleAdapter adapter;
    LinearLayoutManager movieGridLayoutManger;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.movieDbList);
        movieGridLayoutManger = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(movieGridLayoutManger);
        adapter = new MovieTitleAdapter(R.layout.movie_list_item, getApplicationContext());
        recyclerView.setAdapter(adapter);
        List<MovieTitle> movies = SampleData.getMovies();
        adapter.setMovies(movies);

    }
}
