package com.example.watchio.GetMovie.GetNowPlayingMovies.Models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResponseGetNowPlayingMovies {

    @SerializedName("results")
    public List<ResultsGetNowPlayingMovies> results;

    public ResponseGetNowPlayingMovies(List<ResultsGetNowPlayingMovies> results) {
        this.results = results;
    }

    public List<ResultsGetNowPlayingMovies> getResults() {
        return results;
    }

    public void setResults(List<ResultsGetNowPlayingMovies> results) {
        this.results = results;
    }
}
