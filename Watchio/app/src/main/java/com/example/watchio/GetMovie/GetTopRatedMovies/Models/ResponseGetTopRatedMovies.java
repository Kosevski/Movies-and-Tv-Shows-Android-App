package com.example.watchio.GetMovie.GetTopRatedMovies.Models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResponseGetTopRatedMovies {

    @SerializedName("results")
    public List<ResultsGetTopRatedMovies> results;

    public ResponseGetTopRatedMovies(List<ResultsGetTopRatedMovies> results) {
        this.results = results;
    }

    public List<ResultsGetTopRatedMovies> getResults() {
        return results;
    }

    public void setResults(List<ResultsGetTopRatedMovies> results) {
        this.results = results;
    }
}
