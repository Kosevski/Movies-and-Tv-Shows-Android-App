package com.example.watchio.GetMovie.GetSimilarMovies;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResponseGetSimilarMovies {

    @SerializedName("results")
    public List<ResultsGetSimilarMovies> results;

    public ResponseGetSimilarMovies(List<ResultsGetSimilarMovies> results) {
        this.results = results;
    }

    public List<ResultsGetSimilarMovies> getResults() {
        return results;
    }

    public void setResults(List<ResultsGetSimilarMovies> results) {
        this.results = results;
    }
}


