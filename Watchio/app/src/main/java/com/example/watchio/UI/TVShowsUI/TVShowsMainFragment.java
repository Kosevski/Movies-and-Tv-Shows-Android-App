package com.example.watchio.UI.TVShowsUI;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.watchio.GetTVShow.ResultsPopularTVShows;
import com.example.watchio.R;
import com.example.watchio.UI.MoviesUI.MainViewModel;

import java.util.List;

public class TVShowsMainFragment extends Fragment {

    View rootView;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);


        MainViewModel viewModel = ViewModelProviders.of(this).get(MainViewModel.class);

        viewModel.popularTVShows.observe(this, new Observer<List<ResultsPopularTVShows>>() {
            @Override
            public void onChanged(List<ResultsPopularTVShows> resultsPopularTVShows) {
                RecyclerView recyclerView = rootView.findViewById(R.id.tvShowsPopularRV);

                recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
                GetTvShowsAdapter adapter = new GetTvShowsAdapter(resultsPopularTVShows);
                recyclerView.setAdapter(adapter);

            }
        });

        viewModel.loadPopularTVShows();

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.tv_shows_main_fragment, container, false);



        return rootView;
    }



}
