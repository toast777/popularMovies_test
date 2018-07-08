package com.chuck.android.popularmovies_test.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Observer;
import android.support.annotation.NonNull;

import com.chuck.android.popularmovies_test.database.AppRepository;
import com.chuck.android.popularmovies_test.models.MovieTitle;
import com.chuck.android.popularmovies_test.utils.SampleDataMore;

import java.util.List;

public class MainViewModel extends AndroidViewModel {

    public LiveData<List<MovieTitle>> favoriteMovies;
    public MutableLiveData<List<MovieTitle>> sampleMovies;




    private AppRepository mRepository;

    public MainViewModel(@NonNull Application application) {
        super(application);

        mRepository = AppRepository.getInstance(application.getApplicationContext());
        favoriteMovies = mRepository.favoriteMovies;
        if (sampleMovies == null){
            sampleMovies = new MutableLiveData<>();
            sampleMovies.setValue(SampleDataMore.getMovies());
        }
    }

    public void addSampleData() {
        mRepository.addSampleData();
    }


    public void deleteAllNotes() {
        mRepository.deleteAllMovies();
    }
}
