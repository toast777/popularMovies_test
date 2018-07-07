package com.chuck.android.popularmovies_test.database;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.chuck.android.popularmovies_test.models.MovieTitle;

import java.util.List;

@Dao
public interface MovieTitleDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertMovie(MovieTitle movieTitle);
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<MovieTitle> movieTitle);
    @Delete
    void deleteMovie(MovieTitle movieTitle);

    @Query("SELECT * FROM movies WHERE id = :id")
    MovieTitle getMovieByID(int id);

    @Query("SELECT * FROM movies")
    LiveData<List<MovieTitle>> getAll();

    @Query("DELETE FROM movies")
    int deleteAll();

    @Query("SELECT COUNT(*) FROM movies")
    int getCount();

}
