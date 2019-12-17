package com.example.watchio.UI.MoviesUI;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.watchio.GetMovie.GetNowPlayingMovies.Models.ResultsGetNowPlayingMovies;
import com.example.watchio.GetMovie.GetPopularMovies.Models.ResultsGetPopularMovies;
import com.example.watchio.GetMovie.GetTopRatedMovies.Models.ResultsGetTopRatedMovies;
import com.example.watchio.GetMovie.GetUpcomingMovies.Models.ResultsGetUpcomingMovies;
import com.example.watchio.GetTVShow.ResultsPopularTVShows;
import com.example.watchio.Listeners.LoadMoviesAndTVShowsListener;
import com.example.watchio.Utils.Repo;

import java.util.List;


public class MainViewModel extends AndroidViewModel {

    MutableLiveData<List<ResultsGetPopularMovies>> popularMovies = new MutableLiveData<>();
    MutableLiveData<List<ResultsGetNowPlayingMovies>> nowPlayingMovies = new MutableLiveData<>();
    MutableLiveData<List<ResultsGetTopRatedMovies>> topRatedMovies = new MutableLiveData<>();
    MutableLiveData<List<ResultsGetUpcomingMovies>> upcomingMovies = new MutableLiveData<>();
    public MutableLiveData<List<ResultsPopularTVShows>> popularTVShows = new MutableLiveData<>();


    MutableLiveData<Boolean> progressBar = new MutableLiveData<>();
    public MutableLiveData<String> error = new MutableLiveData<>();

    public MainViewModel(@NonNull Application application) {
        super(application);
    }

    public void loadPopularMovies() {
        progressBar.setValue(true);
        Repo repo = Repo.getINSTANCE(getApplication());
        repo.getPopularMovies(new LoadMoviesAndTVShowsListener<List<ResultsGetPopularMovies>>() {
            @Override
            public void onSuccess(List<ResultsGetPopularMovies> resultsGetPopularMovies) {
                progressBar.setValue(false);
                popularMovies.setValue(resultsGetPopularMovies);
            }

            @Override
            public void onError(Exception e) {
                progressBar.setValue(false);
                error.setValue(e.getMessage());
            }
        });
    }

    public void loadUpcomingMovies(){
        Repo repo = Repo.getINSTANCE(getApplication());
        repo.getUpcomingMovies(new LoadMoviesAndTVShowsListener<List<ResultsGetUpcomingMovies>>() {
            @Override
            public void onSuccess(List<ResultsGetUpcomingMovies> resultsGetUpcomingMovies) {
                upcomingMovies.setValue(resultsGetUpcomingMovies);
            }

            @Override
            public void onError(Exception e) {
                error.setValue(e.getMessage());
            }
        });
    }

      public void loadTopRatedMovies(){
        Repo repo = Repo.getINSTANCE(getApplication());
        repo.getTopRatedMovies(new LoadMoviesAndTVShowsListener<List<ResultsGetTopRatedMovies>>() {
            @Override
            public void onSuccess(List<ResultsGetTopRatedMovies> resultsGetTopRatedMovies) {
                topRatedMovies.setValue(resultsGetTopRatedMovies);
            }

            @Override
            public void onError(Exception e) {
                error.setValue(e.getMessage());
            }
        });
    }

      public void loadNowPlayingMovies(){
        Repo repo = Repo.getINSTANCE(getApplication());
        repo.getNowPlayingMovies(new LoadMoviesAndTVShowsListener<List<ResultsGetNowPlayingMovies>>() {
            @Override
            public void onSuccess(List<ResultsGetNowPlayingMovies> resultsGetNowPlayingMovies) {
                nowPlayingMovies.setValue(resultsGetNowPlayingMovies);
            }

            @Override
            public void onError(Exception e) {
                error.setValue(e.getMessage());
            }
        });
    }

    public void loadPopularTVShows(){
        Repo repo = Repo.getINSTANCE(getApplication());
        repo.getPopularTvShows(new LoadMoviesAndTVShowsListener<List<ResultsPopularTVShows>>() {
            @Override
            public void onSuccess(List<ResultsPopularTVShows> resultsPopularTVShows) {
                popularTVShows.setValue(resultsPopularTVShows);
            }

            @Override
            public void onError(Exception e) {

            }
        });



    }


}
