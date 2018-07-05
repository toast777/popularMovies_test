package com.chuck.android.popularmovies_test.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import com.chuck.android.popularmovies_test.database.AppRepository;
import com.chuck.android.popularmovies_test.models.MovieTitle;


public class MovieDetailsViewModel extends AndroidViewModel {
    public LiveData<MovieTitle> mLiveMovie;
    private AppRepository mRepository;

    public MovieDetailsViewModel(@NonNull Application application) {
        super(application);
        mRepository = AppRepository.getInstance(application.getApplicationContext());
    }

    public void deleteMovie() {
        mRepository.deleteMovie(mLiveMovie.getValue());
    }
    public void addMovie(){
        mRepository.insertMovie(mLiveMovie.getValue());
    }

}
