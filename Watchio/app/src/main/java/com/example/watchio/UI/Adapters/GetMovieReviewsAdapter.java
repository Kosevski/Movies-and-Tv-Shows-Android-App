package com.example.watchio.UI.Adapters;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.watchio.GetMovie.GetMovieReviews.ResultsGetMovieReviews;
import com.example.watchio.R;

import java.util.List;

public class GetMovieReviewsAdapter extends RecyclerView.Adapter<GetMovieReviewsAdapter.MovieReviewsViewHolder> {

    List<ResultsGetMovieReviews> results;

    Context context;
    public GetMovieReviewsAdapter(List<ResultsGetMovieReviews> results, Context context) {
        this.results = results;
        this.context = context;
    }

    @NonNull
    @Override
    public GetMovieReviewsAdapter.MovieReviewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_review, parent, false);
        MovieReviewsViewHolder movieReviewsViewHolder= new MovieReviewsViewHolder(view);
        return movieReviewsViewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull GetMovieReviewsAdapter.MovieReviewsViewHolder holder, int position) {
        final ResultsGetMovieReviews result = results.get(holder.getAdapterPosition());

        holder.review.setText(result.getContent());
        holder.username.setText(result.getAuthor());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = result.getUrl();
                Intent intentToApi = new Intent(Intent.ACTION_VIEW);
                intentToApi.setData(Uri.parse(url));
                context.startActivity(intentToApi);
            }
        });


    }

    @Override
    public int getItemCount() {
            int rev = 0;
         if(results.size()>3){
             rev = 3;
         } else {rev = results.size();}
        return rev;
    }

    public class MovieReviewsViewHolder extends RecyclerView.ViewHolder {

        TextView review, username;

        public MovieReviewsViewHolder(@NonNull View itemView) {
            super(itemView);


            review = itemView.findViewById(R.id.reviewTV);
            username = itemView.findViewById(R.id.username_Tv);


        }
    }
}

