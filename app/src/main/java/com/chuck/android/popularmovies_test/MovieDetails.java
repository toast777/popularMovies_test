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

    private ViewModel mViewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_details);
        //Get Passed Extra ID from intent
        int id = getIntent().getIntExtra("EXTRA_MOVIE_ID",0);
        String title = getIntent().getStringExtra("EXTRA_MOVIE_TITLE");
        final TextView movieTitle = findViewById(R.id.movieTitle);
        final TextView movieID  = findViewById(R.id.movieID);
        movieID.setText(Integer.toString(id));
        movieTitle.setText(title);
        final CheckBox checkbox=(CheckBox)findViewById(R.id.ck_favorites);
        checkbox.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if (checkbox.isChecked())
                {
                    Toast.makeText(getApplicationContext(),"Checkbox Selected",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Checkbox De-Selected",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void initViewModel() {
        final Observer<MovieTitle> movieTitleObserver = new Observer<MovieTitle>() {
            @Override
            public void onChanged(@Nullable MovieTitle movieTitle) {

            }
        };
        mViewModel = ViewModelProviders.of(this).get(MovieDetailsViewModel.class);
        mViewModel.mMovieTitle
    }

}
