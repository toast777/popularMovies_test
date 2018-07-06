package com.chuck.android.popularmovies_test.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.chuck.android.popularmovies_test.MovieDetails;
import com.chuck.android.popularmovies_test.R;
import com.chuck.android.popularmovies_test.models.MovieTitle;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class MovieTitleAdapter extends RecyclerView.Adapter<MovieTitleAdapter.MovieTitleViewHolder> {

    private List<MovieTitle> movies;
    private int rowLayout;
    private Context context;


    public class MovieTitleViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        LinearLayout moviesLayout;
        @BindView(R.id.movie_title)
        TextView movieTitle;
        private Context context;


        MovieTitleViewHolder(Context context,View itemView) {
            super(itemView);
            moviesLayout = itemView.findViewById(R.id.movies_layout);
            this.context = context;
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            int position = getAdapterPosition();
            Intent myIntent = new Intent(context, MovieDetails.class);
            myIntent.putExtra("EXTRA_MOVIE_ID", movies.get(position).getId() );
            //TODO only send movie id
            myIntent.putExtra("EXTRA_MOVIE_TITLE", movies.get(position).getTitle() );
            context.startActivity(myIntent);
        }
    }

    public MovieTitleAdapter(int rowLayout, Context mContext) {
        this.rowLayout = rowLayout;
        this.context = mContext;
    }

    @NonNull
    @Override
    public MovieTitleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent, false);
        return new MovieTitleViewHolder(parent.getContext(),view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieTitleAdapter.MovieTitleViewHolder holder, int position) {
        if (movies != null)
        {
            String movieTitleText = movies.get(position).getTitle();
            holder.movieTitle.setText(movieTitleText);
        }

    }

    public void setMovies(List<MovieTitle> movies){
        this.movies = movies;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        if (movies != null)
            return movies.size();
        else
            return 0;    }


}
