package com.example.watchio.Retrofit;

import com.example.watchio.BuildConfig;
import com.example.watchio.GetMovie.GetMovieDetails.ResultsMovieDetails;
import com.example.watchio.GetMovie.GetMovieReviews.ResponseGetMovieReviews;
import com.example.watchio.GetMovie.GetNowPlayingMovies.Models.ResponseGetNowPlayingMovies;
import com.example.watchio.GetMovie.GetPopularMovies.Models.ResponseGetPopularMovies;
import com.example.watchio.GetMovie.GetSimilarMovies.ResponseGetSimilarMovies;
import com.example.watchio.GetMovie.GetTopRatedMovies.Models.ResponseGetTopRatedMovies;
import com.example.watchio.GetMovie.GetUpcomingMovies.Models.ResponseGetUpcomingMovies;
import com.example.watchio.GetTVShow.ResponseGetTvShows;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiInterface {

        String BASE_URL = "https://api.themoviedb.org";
        String API_KEY = BuildConfig.apikey;
        String lng = "en-US";
        String region = "us";

        @GET("/3/movie/popular")
        Call<ResponseGetPopularMovies> getPopularMovies(@Query("api_key") String API_KEY, @Query("language") String lng);

        @GET("/3/movie/now_playing")
        Call<ResponseGetNowPlayingMovies> getNowPlayingMovies(@Query("api_key") String API_KEY, @Query("language") String lng);

        @GET("/3/movie/upcoming")
        Call<ResponseGetUpcomingMovies> getUpcomingMovies(@Query("api_key") String API_KEY, @Query("language") String lng);

        @GET("/3/movie/top_rated")
        Call<ResponseGetTopRatedMovies> getTopRatedMovies(@Query("api_key") String API_KEY, @Query("language") String lng, @Query("region") String region);

        @GET("3/movie/{movie_id}")
        Call<ResultsMovieDetails> getMovieDetails(@Path("movie_id") String id, @Query("api_key") String API_KEY, @Query("language") String lng);

        @GET("3/movie/{movie_id}/similar")
        Call<ResponseGetSimilarMovies> getSimilarMovies(@Path("movie_id") String id, @Query("api_key") String API_KEY, @Query("language") String lng);

        @GET("3/movie/{movie_id}/reviews")
        Call<ResponseGetMovieReviews> getReviews(@Path("movie_id") String id, @Query("api_key") String API_KEY, @Query("language") String lng);

        @GET("3/tv/popular")
        Call<ResponseGetTvShows> getPopularTVShows(@Query("api_key") String API_KEY);

}
