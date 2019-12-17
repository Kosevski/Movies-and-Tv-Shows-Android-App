package com.example.watchio.DB;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.watchio.GetMovie.GetNowPlayingMovies.Models.ResultsGetNowPlayingMovies;
import com.example.watchio.GetMovie.GetPopularMovies.Models.ResultsGetPopularMovies;
import com.example.watchio.GetMovie.GetTopRatedMovies.Models.ResultsGetTopRatedMovies;
import com.example.watchio.GetMovie.GetUpcomingMovies.Models.ResultsGetUpcomingMovies;


@Database(entities = {ResultsGetNowPlayingMovies.class, ResultsGetTopRatedMovies.class,
        ResultsGetPopularMovies.class, ResultsGetUpcomingMovies.class}, version = 2)
public abstract class MoviesDatabase extends RoomDatabase {


    public abstract MoviesDao moviesDao();

    private static MoviesDatabase INSTANCE;

    public static MoviesDatabase getMoviesDatabase(Context context) {

        if (INSTANCE == null) {
            synchronized (MoviesDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context,
                            MoviesDatabase.class,
                            "movies_db")
                            .addCallback(new Callback() {
                                @Override
                                public void onOpen(@NonNull SupportSQLiteDatabase db) {
                                    super.onOpen(db);
                                }
                            })
                            .fallbackToDestructiveMigration()
                            .build();
                }
            }
        }
        return INSTANCE;
    }


}
