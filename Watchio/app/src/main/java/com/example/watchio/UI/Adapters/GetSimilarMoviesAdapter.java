package com.example.watchio.UI.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.watchio.GetMovie.GetSimilarMovies.ResultsGetSimilarMovies;
import com.example.watchio.Listeners.MovieDetailListener;
import com.example.watchio.R;
import com.example.watchio.UI.MoviesUI.MovieDetails.MovieDetailsFragment;
import com.squareup.picasso.Picasso;

import java.util.List;

public class GetSimilarMoviesAdapter extends RecyclerView.Adapter<GetSimilarMoviesAdapter.GetSimilarMoviesViewHolder> {

    FragmentManager fragmentManager;
    List<ResultsGetSimilarMovies> results;
    MovieDetailListener listener;

    public GetSimilarMoviesAdapter(List<ResultsGetSimilarMovies> results, MovieDetailListener listener, FragmentManager fragmentManager) {
        this.results = results;
        this.listener = listener;
        this.fragmentManager = fragmentManager;
    }

    @NonNull
    @Override
    public GetSimilarMoviesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_movies_similar, parent, false);
        GetSimilarMoviesViewHolder getSimilarMoviesViewHolder = new GetSimilarMoviesViewHolder(view);
        return getSimilarMoviesViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull GetSimilarMoviesViewHolder holder, int position) {
        final ResultsGetSimilarMovies result = results.get(holder.getAdapterPosition());

        holder.movieTitle.setText(result.getTitle());
        String picassoUrl = "https://image.tmdb.org/t/p/w500/"+ result.getPoster_path();

        Picasso.get().load(picassoUrl).into(holder.moviePoster);

        String vote =  String.valueOf(result.getVote_average());
        holder.votes_average.setText(vote);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

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
        return 10;
    }

    public class GetSimilarMoviesViewHolder extends RecyclerView.ViewHolder {

        TextView movieTitle, votes_average;
        ImageView moviePoster;

        public GetSimilarMoviesViewHolder(@NonNull View itemView) {
            super(itemView);

            votes_average = itemView.findViewById(R.id.tv_votes);
            movieTitle = itemView.findViewById(R.id.tv_name);
            moviePoster = itemView.findViewById(R.id.posterIMG);
        }
    }
}
