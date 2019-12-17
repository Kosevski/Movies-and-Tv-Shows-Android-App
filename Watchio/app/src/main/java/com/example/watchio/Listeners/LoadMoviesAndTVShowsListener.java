package com.example.watchio.Listeners;

public interface LoadMoviesAndTVShowsListener<T> {



    void onSuccess(T t);

    void onError(Exception e);

}
