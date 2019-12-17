package com.example.watchio.UI.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.watchio.GetMovie.GetTopRatedMovies.Models.ResultsGetTopRatedMovies;
import com.example.watchio.Listeners.MovieDetailListener;
import com.example.watchio.R;
import com.example.watchio.UI.MoviesUI.MovieDetails.MovieDetailsFragment;
import com.squareup.picasso.Picasso;

import java.util.List;

public class GetTopRatedMoviesAdapter extends RecyclerView.Adapter<GetTopRatedMoviesAdapter.GetTopRatedMoviesViewHolder> {

    FragmentManager fragmentManager;
    List<ResultsGetTopRatedMovies> results;
    MovieDetailListener listener;

    public GetTopRatedMoviesAdapter(List<ResultsGetTopRatedMovies> results, MovieDetailListener listener, FragmentManager fragmentManager) {
        this.results = results;
        this.listener = listener;
        this.fragmentManager = fragmentManager;
    }

    public class GetTopRatedMoviesViewHolder extends RecyclerView.ViewHolder {

        TextView movieTitle, votes_average, movieDescription;
        ImageView moviePoster;

        public GetTopRatedMoviesViewHolder(@NonNull View itemView) {
            super(itemView);

            movieTitle = itemView.findViewById(R.id.tv_name);
            moviePoster = itemView.findViewById(R.id.posterIMG);
            votes_average = itemView.findViewById(R.id.tv_votes);
            movieDescription = itemView.findViewById(R.id.tv_description);
        }
    }


    @NonNull
    @Override
    public GetTopRatedMoviesAdapter.GetTopRatedMoviesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_movies_top_rated, parent, false);
        GetTopRatedMoviesViewHolder getTopRatedMoviesViewHolder= new GetTopRatedMoviesViewHolder(view);
        return getTopRatedMoviesViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull GetTopRatedMoviesAdapter.GetTopRatedMoviesViewHolder holder, int position) {
        final ResultsGetTopRatedMovies result = results.get(holder.getAdapterPosition());

        String vote =  String.valueOf(result.getVote_average());
        holder.votes_average.setText(vote);


        holder.movieTitle.setText(result.getTitle());
        holder.movieDescription.setText(result.getOverview());

        String picasoUrl = "https://image.tmdb.org/t/p/w500/"+ result.getBackdrop_path();

        Picasso.get().load(picasoUrl).into(holder.moviePoster);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                listener.openMovieDetailsFragment(result.getId());

             ;

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
        return 5;
    }

}
