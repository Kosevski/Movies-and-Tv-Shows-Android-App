package com.example.watchio.UI.Adapters;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.watchio.GetMovie.GetPopularMovies.Models.ResultsGetPopularMovies;
import com.example.watchio.Listeners.MovieDetailListener;
import com.example.watchio.R;
import com.example.watchio.UI.MoviesUI.MovieDetails.MovieDetailsFragment;
import com.squareup.picasso.Picasso;

import java.util.List;



public class GetPopularMoviesAdapter extends RecyclerView.Adapter<GetPopularMoviesAdapter.GetPopularMoviesViewHolder>{

    FragmentManager fragmentManager;
    List<ResultsGetPopularMovies> results;
    MovieDetailListener listener;

    public GetPopularMoviesAdapter(List<ResultsGetPopularMovies> results, MovieDetailListener listener, FragmentManager fragmentManager) {
        this.results = results;
        this.listener = listener;
        this.fragmentManager = fragmentManager;
    }

    public class GetPopularMoviesViewHolder extends RecyclerView.ViewHolder {

        TextView movieTitle, votes_average;
        ImageView moviePoster;

        public GetPopularMoviesViewHolder(@NonNull View itemView) {
            super(itemView);

            votes_average = itemView.findViewById(R.id.tv_votes);
            movieTitle = itemView.findViewById(R.id.tv_name);
            moviePoster = itemView.findViewById(R.id.posterIMG);
        }
    }

    @NonNull
    @Override
    public GetPopularMoviesAdapter.GetPopularMoviesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_movies_popular, parent, false);
        GetPopularMoviesViewHolder getPopularMoviesViewHolder = new GetPopularMoviesViewHolder(view);
        return getPopularMoviesViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull GetPopularMoviesAdapter.GetPopularMoviesViewHolder holder, int position) {
        final ResultsGetPopularMovies result = results.get(holder.getAdapterPosition());

        holder.movieTitle.setText(result.getTitle());
        String vote =  String.valueOf(result.getVote_average());
        holder.votes_average.setText(vote);

        String picassoURL = "https://image.tmdb.org/t/p/w500/"+ result.getBackdrop_path();

        Picasso.get().load(picassoURL).into(holder.moviePoster);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Bundle bundle = new Bundle();
                bundle.putString("movieId", result.getId());

                MovieDetailsFragment fragment = new MovieDetailsFragment(result.getId());

                fragmentManager
                        .beginTransaction()
                        .replace(R.id.frame_layout, fragment)
                        .addToBackStack("null")
                        .commit();
            }
        });


    }

    @Override
    public int getItemCount() {
        return results.size();
    }


}
