package com.example.watchio.UI.MoviesUI;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.watchio.GetMovie.GetNowPlayingMovies.Models.ResultsGetNowPlayingMovies;
import com.example.watchio.GetMovie.GetPopularMovies.Models.ResultsGetPopularMovies;
import com.example.watchio.GetMovie.GetTopRatedMovies.Models.ResultsGetTopRatedMovies;
import com.example.watchio.GetMovie.GetUpcomingMovies.Models.ResultsGetUpcomingMovies;
import com.example.watchio.Listeners.MovieDetailListener;
import com.example.watchio.R;
import com.example.watchio.UI.Adapters.GetNowPlayingMoviesAdapter;
import com.example.watchio.UI.Adapters.GetPopularMoviesAdapter;
import com.example.watchio.UI.Adapters.GetTopRatedMoviesAdapter;
import com.example.watchio.UI.Adapters.GetUpcomingMoviesAdapter;

import java.util.List;

public class MoviesMainFragment extends Fragment {

    MovieDetailListener listener;

    public MoviesMainFragment() {
    }


    View rootView;
    ProgressBar progressBar;
    LinearLayout linearLayoutRVS;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);


        MainViewModel viewModel = ViewModelProviders.of(this).get(MainViewModel.class);

        viewModel.popularMovies.observe(this, new Observer<List<ResultsGetPopularMovies>>() {
            @Override
            public void onChanged(List<ResultsGetPopularMovies> resultsGetPopularMovies) {

                RecyclerView recyclerView = rootView.findViewById(R.id.RVPopularMovies);
                RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
                recyclerView.setLayoutManager(layoutManager);
                GetPopularMoviesAdapter adapter = new GetPopularMoviesAdapter(resultsGetPopularMovies, listener, getFragmentManager()
                );
                recyclerView.setAdapter(adapter);
                progressBar.setVisibility(View.GONE);
                linearLayoutRVS.setVisibility(View.VISIBLE);

            }
        });
        viewModel.loadPopularMovies();

        viewModel.nowPlayingMovies.observe(this, new Observer<List<ResultsGetNowPlayingMovies>>() {
            @Override
            public void onChanged(List<ResultsGetNowPlayingMovies> resultsGetNowPlayingMovies) {
                RecyclerView recyclerView = rootView.findViewById(R.id.RVNowPlayingdMovies);
                RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
                recyclerView.setLayoutManager(layoutManager);
                GetNowPlayingMoviesAdapter adapter = new GetNowPlayingMoviesAdapter(resultsGetNowPlayingMovies, listener, getFragmentManager());
                recyclerView.setAdapter(adapter);
                progressBar.setVisibility(View.GONE);
                linearLayoutRVS.setVisibility(View.VISIBLE);
            }
        });
        viewModel.loadNowPlayingMovies();

        viewModel.topRatedMovies.observe(this, new Observer<List<ResultsGetTopRatedMovies>>() {
            @Override
            public void onChanged(List<ResultsGetTopRatedMovies> resultsGetTopRatedMovies) {
                RecyclerView recyclerView = rootView.findViewById(R.id.RVTopRatedMovies);
                recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
                GetTopRatedMoviesAdapter adapter = new GetTopRatedMoviesAdapter(resultsGetTopRatedMovies, listener, getFragmentManager());
                recyclerView.setAdapter(adapter);
                progressBar.setVisibility(View.GONE);
                linearLayoutRVS.setVisibility(View.VISIBLE);
            }
        });
        viewModel.loadTopRatedMovies();

        viewModel.upcomingMovies.observe(this, new Observer<List<ResultsGetUpcomingMovies>>() {
            @Override
            public void onChanged(List<ResultsGetUpcomingMovies> resultsGetUpcomingMovies) {
                RecyclerView recyclerView = rootView.findViewById(R.id.RVUpcomingMovies);
                RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
                recyclerView.setLayoutManager(layoutManager);
                GetUpcomingMoviesAdapter adapter = new GetUpcomingMoviesAdapter(resultsGetUpcomingMovies, listener, getFragmentManager());
                recyclerView.setAdapter(adapter);
                progressBar.setVisibility(View.GONE);
                linearLayoutRVS.setVisibility(View.VISIBLE);
            }
        });
        viewModel.loadUpcomingMovies();

        viewModel.error.observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                Toast.makeText(getContext(), s, Toast.LENGTH_LONG).show();
            }
        });
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.movie_fragment_main, container, false);
        progressBar = rootView.findViewById(R.id.progressBarSections);
        linearLayoutRVS = rootView.findViewById(R.id.RVSLAYOT);
        linearLayoutRVS.setVisibility(View.GONE);

        return rootView;
    }
}
