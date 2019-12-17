package com.example.watchio.UI.MoviesUI.MovieDetails;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.watchio.GetMovie.GetMovieReviews.ResultsGetMovieReviews;
import com.example.watchio.GetMovie.GetSimilarMovies.ResultsGetSimilarMovies;
import com.example.watchio.Listeners.LoadMoviesAndTVShowsListener;
import com.example.watchio.Listeners.MovieDetailListener;
import com.example.watchio.Listeners.loadMovieDetailsListener;
import com.example.watchio.R;
import com.example.watchio.UI.Adapters.GetMovieReviewsAdapter;
import com.example.watchio.UI.Adapters.GetSimilarMoviesAdapter;
import com.example.watchio.Utils.ConvertUtil;
import com.example.watchio.Utils.Repo;
import com.example.watchio.images.ImageLoader;
import com.example.watchio.images.ImageLoaderImpl;

import java.util.List;

public class MovieDetailsFragment extends Fragment {

    private String id;
    private RecyclerView recyclerViewReviews;

    private MovieDetailListener listener;

    private ImageLoader imageLoader;

    public MovieDetailsFragment(String id) {
        this.id = id;
    }

    private ImageView posterImg, coverImg;
    private TextView movieTitle;
    private TextView movieOverview;
    private TextView movieReleaseDate;
    private TextView rating;
    private TextView runTime;
    private TextView genres;
    private TextView budgetM;
    private TextView revenueM;
    private TextView tagLine;
    private TextView reviewtextRV;

    private View rootView;


    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);


        Repo repo = Repo.getINSTANCE(getContext());
        repo.getMovieDetails(new loadMovieDetailsListener() {
            @Override
            public void onSuccessMovieDetails(String backdrop_path,
                                              String imdb_id,
                                              String overview,
                                              String poster_path,
                                              String tagline,
                                              String title,
                                              String vote_count,
                                              String release_date,
                                              int runtime,
                                              int revenue,
                                              int budget,
                                              double vote_average) {

                movieTitle.setText(title);
                movieOverview.setText(overview);

                String picassoUrlP = "https://image.tmdb.org/t/p/w300/" + poster_path;

                imageLoader.loadImage(picassoUrlP, posterImg);

                movieOverview.setText(overview);
                movieReleaseDate.setText(release_date);
                tagLine.setText(getString(R.string.navodnici) + tagline + getString(R.string.navodnici));
                String sRuntime = String.valueOf(runtime);
                runTime.setText(sRuntime + " min.");
                String sRating = String.valueOf(vote_average);
                rating.setText(sRating);
                String budgetStr = ConvertUtil.converter(budget);
                budgetM.setText(budgetStr);
                String revenueStr = ConvertUtil.converter(revenue);
                revenueM.setText(revenueStr);
            }

            @Override
            public void onError(Exception e) {

            }
        }, id);

        repo.getSimilarMovies(new LoadMoviesAndTVShowsListener<List<ResultsGetSimilarMovies>>() {
            @Override
            public void onSuccess(List<ResultsGetSimilarMovies> resultsGetSimilarMovies) {

                RecyclerView recyclerView = rootView.findViewById(R.id.similar_moviesRV);

                RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
                recyclerView.setLayoutManager(layoutManager);
                GetSimilarMoviesAdapter adapter = new GetSimilarMoviesAdapter(resultsGetSimilarMovies, listener, getFragmentManager());
                recyclerView.setAdapter(adapter);

            }

            @Override
            public void onError(Exception e) {

            }
        }, id);

        repo.getReviews(new LoadMoviesAndTVShowsListener<List<ResultsGetMovieReviews>>() {
            @Override
            public void onSuccess(List<ResultsGetMovieReviews> resultsGetMovieReviews) {
                recyclerViewReviews = rootView.findViewById(R.id.movie_reviewsRV);

                final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
                recyclerViewReviews.setLayoutManager(linearLayoutManager);
                GetMovieReviewsAdapter adapter = new GetMovieReviewsAdapter(resultsGetMovieReviews, getContext());
                recyclerViewReviews.setAdapter(adapter);

                recyclerViewReviews.setVisibility(View.VISIBLE);
                reviewtextRV.setVisibility(View.VISIBLE);
            }

            @Override
            public void onError(Exception e) {

            }
        }, id);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.movie_fragment_detail, container, false);

        getActivity().setTitle("Movie Details");

        imageLoader = new ImageLoaderImpl();

        posterImg = rootView.findViewById(R.id.poster_img);
        movieOverview = rootView.findViewById(R.id.details_overviewTV);
        movieTitle = rootView.findViewById(R.id.details_movie_nameTV);
        movieReleaseDate = rootView.findViewById(R.id.release_date_details_movie);
        rating = rootView.findViewById(R.id.average_votes_details_movie);
        budgetM = rootView.findViewById(R.id.budget_details_movie);
        revenueM = rootView.findViewById(R.id.revenue_details_movie);
        runTime = rootView.findViewById(R.id.runtime_details_movie);
        tagLine = rootView.findViewById(R.id.tagline_movie_details);
        reviewtextRV = rootView.findViewById(R.id.ReviewsRVtext);
        TextView morereviews = rootView.findViewById(R.id.more_reviews);

        morereviews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://www.themoviedb.org/movie/" + id + "/reviews";
                Intent intentToRev = new Intent(Intent.ACTION_VIEW);
                intentToRev.setData(Uri.parse(url));
                getContext().startActivity(intentToRev);
            }
        });
        return rootView;
    }
}
