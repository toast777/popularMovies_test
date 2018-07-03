package com.chuck.android.popularmovies_test.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import com.chuck.android.popularmovies_test.database.AppRepository;
import com.chuck.android.popularmovies_test.models.MovieTitle;

import java.util.List;

public class MainViewModel extends AndroidViewModel {

    public LiveData<List<MovieTitle>> mMovies;
    private AppRepository mRepository;

    public MainViewModel(@NonNull Application application) {
        super(application);

        mRepository = AppRepository.getInstance(application.getApplicationContext());
        mMovies = mRepository.mMovies;
    }

    public void addSampleData() {
        mRepository.addSampleData();
    }

    public void deleteAllNotes() {
        mRepository.deleteAllMovies();
    }
}
