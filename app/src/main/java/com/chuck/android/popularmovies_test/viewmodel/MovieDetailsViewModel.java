package com.chuck.android.popularmovies_test.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;

import com.chuck.android.popularmovies_test.database.AppRepository;
import com.chuck.android.popularmovies_test.models.MovieTitle;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;


public class MovieDetailsViewModel extends AndroidViewModel {
    //TODO query movie db for movie title
    public MutableLiveData<MovieTitle> mLiveMovie =  new MutableLiveData<>();
    private AppRepository mRepository;
    private Executor executor = Executors.newSingleThreadExecutor();


    public MovieDetailsViewModel(@NonNull Application application) {
        super(application);
        mRepository = AppRepository.getInstance(application.getApplicationContext());
    }
    public void loadData(final int movieId) {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                MovieTitle movie = mRepository.getMovieById(movieId);
                mLiveMovie.postValue(movie);
            }
        });
    }

    public void deleteMovie() {
        mRepository.deleteMovie(mLiveMovie.getValue());
    }
    public void addMovie(){
        mRepository.insertMovie(mLiveMovie.getValue());
    }

}
