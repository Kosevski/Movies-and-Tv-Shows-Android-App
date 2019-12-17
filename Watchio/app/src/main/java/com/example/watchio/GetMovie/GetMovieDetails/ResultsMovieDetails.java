package com.example.watchio.GetMovie.GetMovieDetails;

import java.util.List;

public class ResultsMovieDetails {

    private String backdrop_path;

    private String imdb_id;

    private String overview;

    private String poster_path;

    private int budget;

    private int revenue;

    private int runtime;

    private String tagline;

    private String title;

    private double vote_average;

    private String vote_count;

    private String release_date;

    private List<MovieGenres> genres;

    public ResultsMovieDetails(String backdrop_path, String imdb_id, String overview, String poster_path,  int budget, int revenue, int runtime, String tagline, String title, double vote_average, String vote_count, String release_date,  List<MovieGenres> genres) {
        this.backdrop_path = backdrop_path;
        this.imdb_id = imdb_id;
        this.overview = overview;
        this.poster_path = poster_path;
        this.tagline = tagline;
        this.title = title;
        this.budget = budget;
        this.revenue = revenue;
        this.runtime = runtime;
        this.vote_average = vote_average;
        this.vote_count = vote_count;
        this.release_date=release_date;
        this.genres = genres;
    }

    public String getBackdrop_path() {
        return backdrop_path;
    }

    public void setBackdrop_path(String backdrop_path) {
        this.backdrop_path = backdrop_path;
    }

    public String getImdb_id() {
        return imdb_id;
    }

    public void setImdb_id(String imdb_id) {
        this.imdb_id = imdb_id;
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

    public int getBudget() {
        return budget;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }

    public int getRevenue() {
        return revenue;
    }

    public void setRevenue(int revenue) {
        this.revenue = revenue;
    }

    public int getRuntime() {
        return runtime;
    }

    public void setRuntime(int runtime) {
        this.runtime = runtime;
    }

    public String getTagline() {
        return tagline;
    }

    public void setTagline(String tagline) {
        this.tagline = tagline;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getVote_average() {
        return vote_average;
    }

    public void setVote_average(double vote_average) {
        this.vote_average = vote_average;
    }

    public String getVote_count() {
        return vote_count;
    }

    public void setVote_count(String vote_count) {
        this.vote_count = vote_count;
    }

    public String getRelease_date() {
        return release_date;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }

    public List<MovieGenres> getGenres() {
        return genres;
    }

    public void setGenres(List<MovieGenres> genres) {
        this.genres = genres;
    }
}
