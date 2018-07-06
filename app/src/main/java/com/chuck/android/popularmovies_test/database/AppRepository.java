package com.chuck.android.popularmovies_test.database;

import android.arch.lifecycle.LiveData;
import android.content.Context;

import com.chuck.android.popularmovies_test.models.MovieTitle;
import com.chuck.android.popularmovies_test.utils.SampleData;
import com.chuck.android.popularmovies_test.utils.SampleDataMore;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class AppRepository {

    private static AppRepository ourInstance;

    public LiveData<List<MovieTitle>> mMovies;
    private AppDatabase mDb;
    private Executor executor = Executors.newSingleThreadExecutor();

    public static AppRepository getInstance(Context context) {
        if (ourInstance == null) {
            ourInstance = new AppRepository(context);
        }
        return ourInstance;
    }

    private AppRepository(Context context) {
        mDb = AppDatabase.getInstance(context);
        mMovies = getAllMovies();
    }

    public void addSampleData() {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                mDb.movieDao().insertAll(SampleData.getMovies());
            }
        });
    }
    public void addMoreSampleData() {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                mDb.movieDao().insertAll(SampleDataMore.getMovies());
            }
        });
    }

    private LiveData<List<MovieTitle>> getAllMovies() {
        return mDb.movieDao().getAll();
    }

    public void deleteAllMovies() {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                mDb.movieDao().deleteAll();
            }
        });
    }
    public MovieTitle getMovieById(int movieID) {
        return mDb.movieDao().getID(movieID);
    }

    public void insertMovie(final MovieTitle movie) {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                mDb.movieDao().insertMovie(movie);
            }
        });
    }

    public void deleteMovie(final MovieTitle movie) {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                mDb.movieDao().deleteMovie(movie);
            }
        });
    }


}
