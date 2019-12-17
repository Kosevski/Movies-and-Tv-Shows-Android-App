package com.example.watchio.Utils;

import android.content.Context;

import com.example.watchio.GetTVShow.ResponseGetTvShows;
import com.example.watchio.GetTVShow.ResultsPopularTVShows;
import com.example.watchio.Listeners.LoadMoviesAndTVShowsListener;
import com.example.watchio.Listeners.MovieDetailListener;
import com.example.watchio.Listeners.loadMovieDetailsListener;
import com.example.watchio.DB.MoviesDao;
import com.example.watchio.DB.MoviesDatabase;
import com.example.watchio.GetMovie.GetMovieDetails.ResultsMovieDetails;
import com.example.watchio.GetMovie.GetNowPlayingMovies.Models.ResponseGetNowPlayingMovies;
import com.example.watchio.GetMovie.GetNowPlayingMovies.Models.ResultsGetNowPlayingMovies;
import com.example.watchio.GetMovie.GetPopularMovies.Models.ResponseGetPopularMovies;
import com.example.watchio.GetMovie.GetPopularMovies.Models.ResultsGetPopularMovies;
import com.example.watchio.GetMovie.GetSimilarMovies.ResponseGetSimilarMovies;
import com.example.watchio.GetMovie.GetSimilarMovies.ResultsGetSimilarMovies;
import com.example.watchio.GetMovie.GetTopRatedMovies.Models.ResponseGetTopRatedMovies;
import com.example.watchio.GetMovie.GetTopRatedMovies.Models.ResultsGetTopRatedMovies;
import com.example.watchio.GetMovie.GetUpcomingMovies.Models.ResponseGetUpcomingMovies;
import com.example.watchio.GetMovie.GetUpcomingMovies.Models.ResultsGetUpcomingMovies;
import com.example.watchio.GetMovie.GetMovieReviews.ResponseGetMovieReviews;
import com.example.watchio.GetMovie.GetMovieReviews.ResultsGetMovieReviews;
import com.example.watchio.Retrofit.ApiInterface;
import com.example.watchio.Retrofit.RetrofitClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.watchio.Retrofit.ApiInterface.API_KEY;
import static com.example.watchio.Retrofit.ApiInterface.lng;
import static com.example.watchio.Retrofit.ApiInterface.region;

public class Repo {

    LoadMoviesAndTVShowsListener listener;
    com.example.watchio.Listeners.loadMovieDetailsListener loadMovieDetailsListener;

    private String id;
    private static Repo INSTANCE;
    private MoviesDao moviesDao;
    private ApiInterface apiInterface;

    private MovieDetailListener movieDetailListener;

    private Repo() {
    }

    public Repo(MovieDetailListener listener, String id) {
        this.movieDetailListener = listener;
        this.id = id;
    }

    public Repo(MovieDetailListener listener) {
    }

    public static Repo getINSTANCE(Context context) {
        if (INSTANCE == null) {
            INSTANCE = new Repo();
            MoviesDao moviesDao = MoviesDatabase.getMoviesDatabase(context).moviesDao();
            INSTANCE.setMovieDao(moviesDao);
            ApiInterface apiInterface = RetrofitClient.getInstance().getApiInterface();
            INSTANCE.setApiInterface(apiInterface);
        }
        return INSTANCE;
    }

    private void setMovieDao(MoviesDao moviesDao) {
        this.moviesDao = moviesDao;
    }

    public MoviesDao getMoviesDao() {
        return moviesDao;
    }

    public void setApiInterface(ApiInterface apiInterface) {
        this.apiInterface = apiInterface;
    }


    public void getPopularMovies(final LoadMoviesAndTVShowsListener<List<ResultsGetPopularMovies>> listener) {

        apiInterface.getPopularMovies(API_KEY, lng).enqueue(new Callback<ResponseGetPopularMovies>() {
            @Override
            public void onResponse(Call<ResponseGetPopularMovies> call, final Response<ResponseGetPopularMovies> response) {
                listener.onSuccess(response.body().getResults());
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        moviesDao.insertPopularMovies(response.body().getResults());
                    }
                }).start();
            }

            @Override
            public void onFailure(Call<ResponseGetPopularMovies> call, Throwable t) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        listener.onSuccess(moviesDao.getPopularMovies());
                    }
                });
            }
        });
    }

    public void getTopRatedMovies(final LoadMoviesAndTVShowsListener<List<ResultsGetTopRatedMovies>> listener) {

        apiInterface.getTopRatedMovies(API_KEY, lng, region).enqueue(new Callback<ResponseGetTopRatedMovies>() {
            @Override
            public void onResponse(Call<ResponseGetTopRatedMovies> call, final Response<ResponseGetTopRatedMovies> response) {
                listener.onSuccess(response.body().getResults());
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        moviesDao.insertTopRatedMovies(response.body().getResults());
                    }
                }).start();
            }

            @Override
            public void onFailure(Call<ResponseGetTopRatedMovies> call, Throwable t) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        listener.onSuccess(moviesDao.getTopRatedMovies());
                    }
                });
            }
        });
    }

    public void getUpcomingMovies(final LoadMoviesAndTVShowsListener<List<ResultsGetUpcomingMovies>> listener) {

        apiInterface.getUpcomingMovies(API_KEY, lng).enqueue(new Callback<ResponseGetUpcomingMovies>() {
            @Override
            public void onResponse(Call<ResponseGetUpcomingMovies> call, final Response<ResponseGetUpcomingMovies> response) {
                listener.onSuccess(response.body().getResults());
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        moviesDao.insertUpcomingMovies(response.body().getResults());
                    }
                }).start();
            }

            @Override
            public void onFailure(Call<ResponseGetUpcomingMovies> call, Throwable t) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        listener.onSuccess(moviesDao.getUpcomingMovies());
                    }
                });
            }
        });
    }

    public void getNowPlayingMovies(final LoadMoviesAndTVShowsListener<List<ResultsGetNowPlayingMovies>> listener) {
        apiInterface.getNowPlayingMovies(API_KEY, lng).enqueue(new Callback<ResponseGetNowPlayingMovies>() {
            @Override
            public void onResponse(Call<ResponseGetNowPlayingMovies> call, final Response<ResponseGetNowPlayingMovies> response) {
                listener.onSuccess(response.body().getResults());
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        moviesDao.insertNowPlayingMovies(response.body().getResults());
                    }
                }).start();
            }

            @Override
            public void onFailure(Call<ResponseGetNowPlayingMovies> call, Throwable t) {
                        new Thread(new Runnable() {
                            @Override
                            public void run() {
                                listener.onSuccess(moviesDao.getNowPlayingMovies());
                            }
                        });
                    }
                });
            }

    public void getSimilarMovies(final LoadMoviesAndTVShowsListener<List<ResultsGetSimilarMovies>> listener, String id) {

        apiInterface.getSimilarMovies(id, API_KEY, lng).enqueue(new Callback<ResponseGetSimilarMovies>() {
            @Override
            public void onResponse(Call<ResponseGetSimilarMovies> call, final Response<ResponseGetSimilarMovies> response) {
                listener.onSuccess(response.body().getResults());
                new Thread(new Runnable() {
                    @Override
                    public void run() {

                    }
                });
            }
            @Override
            public void onFailure(Call<ResponseGetSimilarMovies> call, Throwable t) {

            }
        });
    }

    public void getReviews(final LoadMoviesAndTVShowsListener<List<ResultsGetMovieReviews>> listener, String id) {

        apiInterface.getReviews(id, API_KEY, lng).enqueue(new Callback<ResponseGetMovieReviews>() {
            @Override
            public void onResponse(Call<ResponseGetMovieReviews> call, Response<ResponseGetMovieReviews> response) {
                listener.onSuccess(response.body().getResults());
            }

            @Override
            public void onFailure(Call<ResponseGetMovieReviews> call, Throwable t) {

            }
        });
    }

    public void getMovieDetails(final loadMovieDetailsListener listener, String id) {
        apiInterface.getMovieDetails(id, API_KEY, lng).enqueue(new Callback<ResultsMovieDetails>() {
            @Override
            public void onResponse(Call<ResultsMovieDetails> call, Response<ResultsMovieDetails> response) {

                listener.onSuccessMovieDetails(
                        response.body().getBackdrop_path(),
                        response.body().getImdb_id(),
                        response.body().getOverview(),
                        response.body().getPoster_path(),
                        response.body().getTagline(),
                        response.body().getTitle(),
                        response.body().getVote_count(),
                        response.body().getRelease_date(),
                        response.body().getRuntime(),
                        response.body().getRevenue(),
                        response.body().getBudget(),
                        response.body().getVote_average());
            }
            @Override
            public void onFailure(Call<ResultsMovieDetails> call, Throwable t) {
            }
        });
    }


    public void getPopularTvShows(final LoadMoviesAndTVShowsListener<List<ResultsPopularTVShows>> listener){
        apiInterface.getPopularTVShows(API_KEY).enqueue(new Callback<ResponseGetTvShows>() {
            @Override
            public void onResponse(Call<ResponseGetTvShows> call, Response<ResponseGetTvShows> response) {
                listener.onSuccess(response.body().getResults());
            }

            @Override
            public void onFailure(Call<ResponseGetTvShows> call, Throwable t) {
            }
        });
    }


}
