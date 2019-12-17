package com.example.watchio.DB;


import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.watchio.GetMovie.GetNowPlayingMovies.Models.ResultsGetNowPlayingMovies;
import com.example.watchio.GetMovie.GetPopularMovies.Models.ResultsGetPopularMovies;
import com.example.watchio.GetMovie.GetTopRatedMovies.Models.ResultsGetTopRatedMovies;
import com.example.watchio.GetMovie.GetUpcomingMovies.Models.ResultsGetUpcomingMovies;

import java.util.List;

@Dao
public interface MoviesDao {


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertNowPlayingMovies(List<ResultsGetNowPlayingMovies> nowPlayingMovies);

    @Query("SELECT * FROM ResultsGetNowPlayingMovies")
    List<ResultsGetNowPlayingMovies> getNowPlayingMovies();


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertPopularMovies(List<ResultsGetPopularMovies> popularMovies);

    @Query("SELECT * FROM ResultsGetPopularMovies")
    List<ResultsGetPopularMovies> getPopularMovies();


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertTopRatedMovies(List<ResultsGetTopRatedMovies> topRatedMovies);

    @Query("SELECT * FROM ResultsGetTopRatedMovies")
    List<ResultsGetTopRatedMovies> getTopRatedMovies();


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertUpcomingMovies(List<ResultsGetUpcomingMovies> upcomingMovies);

    @Query("SELECT * FROM ResultsGetUpcomingMovies")
    List<ResultsGetUpcomingMovies> getUpcomingMovies();


}
