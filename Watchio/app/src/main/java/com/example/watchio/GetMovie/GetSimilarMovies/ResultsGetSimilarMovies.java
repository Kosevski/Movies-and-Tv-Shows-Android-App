package com.example.watchio.GetMovie.GetSimilarMovies;

public class ResultsGetSimilarMovies {

    private String title;
    private String backdrop_path;
    private String overview;
    private String poster_path;
    private String id;
    private double vote_average;


    public ResultsGetSimilarMovies(String title, String backdrop_path, String overview, String poster_path, String id, double vote_average) {
        this.title = title;
        this.backdrop_path = backdrop_path;
        this.overview = overview;
        this.poster_path = poster_path;
        this.id = id;
        this.vote_average = vote_average;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBackdrop_path() {
        return backdrop_path;
    }

    public void setBackdrop_path(String backdrop_path) {
        this.backdrop_path = backdrop_path;
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getVote_average() {
        return vote_average;
    }

    public void setVote_average(double vote_average) {
        this.vote_average = vote_average;
    }
}
