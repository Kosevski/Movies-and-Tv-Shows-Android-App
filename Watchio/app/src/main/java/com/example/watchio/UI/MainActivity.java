package com.example.watchio.UI;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.watchio.R;
import com.example.watchio.UI.MoviesUI.MoviesMainActivity;
import com.example.watchio.UI.TVShowsUI.TVShowsMainActivity;

public class MainActivity extends AppCompatActivity {

    Button explore;
    TextView tvmovies, tvTVshows;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvmovies = findViewById(R.id.moviestv);

        tvmovies.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MoviesMainActivity.class);
                startActivity(intent);
            }
        });

        tvTVshows = findViewById(R.id.tv_showsTV);

        tvTVshows.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, TVShowsMainActivity.class);
                startActivity(intent);
            }
        });



    }
}
