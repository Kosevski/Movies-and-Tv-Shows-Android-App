package com.example.watchio.UI.TVShowsUI;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.watchio.GetTVShow.ResultsPopularTVShows;
import com.example.watchio.R;
import com.example.watchio.images.ImageLoader;
import com.example.watchio.images.ImageLoaderImpl;

import java.util.List;

class GetTvShowsAdapter extends RecyclerView.Adapter<GetTvShowsAdapter.TVShowsViewHolder> {

    List<ResultsPopularTVShows> results;

    public GetTvShowsAdapter(List<ResultsPopularTVShows> results) {
        this.results = results;
    }

    @NonNull
    @Override
    public GetTvShowsAdapter.TVShowsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_tvshows_popular, parent, false);
        return new TVShowsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GetTvShowsAdapter.TVShowsViewHolder holder, int position) {
        final ResultsPopularTVShows result = results.get(holder.getAdapterPosition());

        holder.tvShowTitle.setText(result.getName());
        holder.tvShowRating.setText(result.getVote_average());

        String picassoUrl = "https://image.tmdb.org/t/p/w500"+ result.getPoster_path();

        ImageLoader imageLoader = new ImageLoaderImpl();
        imageLoader.loadImage(picassoUrl, holder.tvShowPoster);



    }

    @Override
    public int getItemCount() {
        return results.size();
    }


    public class TVShowsViewHolder extends RecyclerView.ViewHolder {
        TextView tvShowTitle, tvShowRating;
        ImageView tvShowPoster;

        public TVShowsViewHolder(@NonNull View itemView) {
            super(itemView);

            tvShowPoster = itemView.findViewById(R.id.posterIMG);
            tvShowTitle = itemView.findViewById(R.id.tv_name);
            tvShowRating = itemView.findViewById(R.id.showRating);
        }

    }
}
