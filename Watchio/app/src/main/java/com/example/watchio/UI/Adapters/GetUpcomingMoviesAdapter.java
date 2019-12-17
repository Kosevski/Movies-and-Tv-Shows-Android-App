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

import com.example.watchio.GetMovie.GetUpcomingMovies.Models.ResultsGetUpcomingMovies;
import com.example.watchio.Listeners.MovieDetailListener;
import com.example.watchio.R;
import com.example.watchio.UI.MoviesUI.MovieDetails.MovieDetailsFragment;
import com.squareup.picasso.Picasso;

import java.util.List;

public class GetUpcomingMoviesAdapter extends RecyclerView.Adapter<GetUpcomingMoviesAdapter.GetUpcomingMoviesViewHolder> {

    FragmentManager fragmentManager;
    List<ResultsGetUpcomingMovies> results;
    MovieDetailListener listener;

    public GetUpcomingMoviesAdapter(List<ResultsGetUpcomingMovies> results, MovieDetailListener listener, FragmentManager fragmentManager) {
        this.results = results;
        this.listener= listener;
        this.fragmentManager = fragmentManager;
    }

    public class GetUpcomingMoviesViewHolder extends RecyclerView.ViewHolder {

        TextView movieTitle, releaseDate;
        ImageView moviePoster;

        public GetUpcomingMoviesViewHolder(@NonNull View itemView) {
            super(itemView);
            movieTitle = itemView.findViewById(R.id.tv_name);
            moviePoster = itemView.findViewById(R.id.posterIMG);
            releaseDate = itemView.findViewById(R.id.tv_release_date);
        }
    }

    @NonNull
    @Override
    public GetUpcomingMoviesAdapter.GetUpcomingMoviesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_movies_upcoming, parent, false);
        return new GetUpcomingMoviesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GetUpcomingMoviesAdapter.GetUpcomingMoviesViewHolder holder, int position) {
        final ResultsGetUpcomingMovies result = results.get(holder.getAdapterPosition());



        holder.movieTitle.setText(result.getTitle());

        holder.releaseDate.setText(result.getRelease_date());
        String picasoUrl = "https://image.tmdb.org/t/p/w500/"+ result.getPoster_path();

        Picasso.get().load(picasoUrl).into(holder.moviePoster);

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
