package com.example.watchio.Listeners;


public interface loadMovieDetailsListener {

    void onSuccessMovieDetails(String backdrop_path,
                               String imdb_id,
                               String overview,
                               String poster_path,
                               String tagline,
                               String title,
                               String vote_count,
                               String release_date,
                               int runtime,
                               int revenue,
                               int budget,
                               double vote_average);

    void onError(Exception e);

}