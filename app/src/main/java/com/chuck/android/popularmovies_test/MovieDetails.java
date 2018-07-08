package com.chuck.android.popularmovies_test;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import com.chuck.android.popularmovies_test.models.MovieTitle;
import com.chuck.android.popularmovies_test.viewmodel.MovieDetailsViewModel;

public class MovieDetails extends AppCompatActivity {

    private MovieDetailsViewModel mViewModel;
    private MovieTitle mMovieTitle;
    TextView movieTitle;
    CheckBox checkbox;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_details);


        //Get Passed Extra ID from intent
        final int id = getIntent().getIntExtra("EXTRA_MOVIE_ID",0);
        final String title = getIntent().getStringExtra("EXTRA_MOVIE_TITLE");
        movieTitle = findViewById(R.id.movieTitle);
        movieTitle.setText(title);
        final TextView movieID  = findViewById(R.id.movieID);
        checkbox= findViewById(R.id.ck_favorites);
        initViewModel(id);
        movieID.setText(Integer.toString(id));

       // movieID.setText(Integer.toString(mMovieTitle.getId()));

 //       if (mMovieTitle.getId() == 0)
        checkbox.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if (checkbox.isChecked())
                {
                    Toast.makeText(getApplicationContext(),"Item Added",Toast.LENGTH_SHORT).show();
                    mViewModel.addMovie(id,title);

                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Item Deleted",Toast.LENGTH_SHORT).show();
                    mViewModel.deleteMovie();

                }
            }
        });
    }
    private void initViewModel(final int id) {

        mViewModel = ViewModelProviders.of(this).get(MovieDetailsViewModel.class);

        mViewModel.mLiveMovie.observe(this, new Observer<MovieTitle>() {
            @Override
            public void onChanged(@Nullable MovieTitle movieTitleObject) {
                if (movieTitleObject != null)
                    checkbox.setChecked(true);

            }
        });
        mViewModel.loadData(id);





    }


    }
