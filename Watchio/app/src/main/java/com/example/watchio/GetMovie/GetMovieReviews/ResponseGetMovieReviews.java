package com.example.watchio.GetMovie.GetMovieReviews;

import java.util.List;

public class ResponseGetMovieReviews {

    List<ResultsGetMovieReviews> results;

    public ResponseGetMovieReviews(List<ResultsGetMovieReviews> resultsGetMovieReviewsList) {
        this.results = resultsGetMovieReviewsList;
    }

    public List<ResultsGetMovieReviews> getResults() {
        return results;
    }

    public void setResults(List<ResultsGetMovieReviews> results) {
        this.results = results;
    }
}
