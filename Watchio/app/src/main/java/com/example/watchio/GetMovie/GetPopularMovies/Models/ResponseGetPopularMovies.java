package com.example.watchio.GetMovie.GetPopularMovies.Models;

import java.util.List;

public class ResponseGetPopularMovies {


     public List<ResultsGetPopularMovies> results;

    public ResponseGetPopularMovies(List<ResultsGetPopularMovies> results) {
        this.results = results;
    }

    public List<ResultsGetPopularMovies> getResults() {
        return results;
    }

    public void setResults(List<ResultsGetPopularMovies> results) {
        this.results = results;
    }
}
