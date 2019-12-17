package com.example.watchio.GetTVShow;

import java.util.List;

public class ResponseGetTvShows {

    List<ResultsPopularTVShows> results;

    public ResponseGetTvShows(List<ResultsPopularTVShows> results) {
        this.results = results;
    }

    public List<ResultsPopularTVShows> getResults() {
        return results;
    }

    public void setResults(List<ResultsPopularTVShows> results) {
        this.results = results;
    }
}
