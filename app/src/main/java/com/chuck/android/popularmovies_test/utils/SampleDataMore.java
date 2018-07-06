package com.chuck.android.popularmovies_test.utils;

import com.chuck.android.popularmovies_test.models.MovieTitle;

import java.util.ArrayList;
import java.util.List;

public class SampleDataMore {
    private static final String SAMPLE_TITLE_1 = "Jumanji";
    private static final String SAMPLE_TITLE_2 = "Ghostbusters";
    private static final String SAMPLE_TITLE_3 = "Avengers";


    private static final int SAMPLE_ID_1 = 121221;
    private static final int SAMPLE_ID_2 = 522312;
    private static final int SAMPLE_ID_3 = 128213;

    public static List<MovieTitle> getMovies() {
        List<MovieTitle> movies = new ArrayList<>();
        movies.add(new MovieTitle(SAMPLE_ID_1,SAMPLE_TITLE_1));
        movies.add(new MovieTitle(SAMPLE_ID_2,SAMPLE_TITLE_2));
        movies.add(new MovieTitle(SAMPLE_ID_3,SAMPLE_TITLE_3));
        return movies;
    }
}
