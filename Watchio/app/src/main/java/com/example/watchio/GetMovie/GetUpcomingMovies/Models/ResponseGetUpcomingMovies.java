package com.example.watchio.GetMovie.GetUpcomingMovies.Models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResponseGetUpcomingMovies {

    @SerializedName("results")
    public List<ResultsGetUpcomingMovies> results;

    public ResponseGetUpcomingMovies(List<ResultsGetUpcomingMovies> results) {
        this.results = results;
    }

    public List<ResultsGetUpcomingMovies> getResults() {
        return results;
    }

    public void setResults(List<ResultsGetUpcomingMovies> results) {
        this.results = results;
    }
}
