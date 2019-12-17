package com.example.watchio.GetTVShow;

public class ResultsPopularTVShows {

    String name;
    String backdrop_path;
    String id;
    String overview;
    String poster_path;
    String vote_average;

    public ResultsPopularTVShows(String name, String backdrop_path, String id, String overview, String poster_path, String vote_average) {
        this.name = name;
        this.backdrop_path = backdrop_path;
        this.id = id;
        this.overview = overview;
        this.poster_path = poster_path;
        this.vote_average = vote_average;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBackdrop_path() {
        return backdrop_path;
    }

    public void setBackdrop_path(String backdrop_path) {
        this.backdrop_path = backdrop_path;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getPoster_path() {
        return poster_path;
    }

    public void setPoster_path(String poster_path) {
        this.poster_path = poster_path;
    }

    public String getVote_average() {
        return vote_average;
    }

    public void setVote_average(String vote_average) {
        this.vote_average = vote_average;
    }
}
