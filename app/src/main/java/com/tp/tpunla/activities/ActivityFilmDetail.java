package com.tp.tpunla.activities;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.tp.tpunla.R;
import com.tp.tpunla.data.Data;
import com.tp.tpunla.models.FilmDetail;

import java.util.Objects;

public class ActivityFilmDetail extends AppCompatActivity {
    TextView filmDetailTitle, filmDetailOriginalTitle, filmDetailDescription,
            filmDetailDirector, filmDetailDuration, filmDetailYear, filmDetailScore;
    ImageView filmDetailImageBanner, filmDetailImage;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_film_detail);

        filmDetailTitle = findViewById(R.id.filmDetailTitle);
        filmDetailOriginalTitle = findViewById(R.id.filmDetailOriginalTitle);
        filmDetailDescription = findViewById(R.id.filmDetailDescription);
        filmDetailDirector = findViewById(R.id.filmDetailDirector);
        filmDetailDuration = findViewById(R.id.filmDetailDuration);
        filmDetailYear = findViewById(R.id.filmDetailYear);
        filmDetailScore = findViewById(R.id.filmDetailScore);
        filmDetailImageBanner = findViewById(R.id.filmDetailImageBanner);
        filmDetailImage = findViewById(R.id.filmDetailImage);

        Intent intent = getIntent();
        int id = intent.getIntExtra("id", 0);
        if (id != 0) {
            FilmDetail filmDetail = Data.getFilmDetails(id);   // TODO: Cambiar por llamado a la API
            filmDetailTitle.setText(filmDetail.getTitle());
            filmDetailOriginalTitle.setText(filmDetail.getOriginalTitle());
            filmDetailDescription.setText(filmDetail.getSinopsis());
            filmDetailDirector.setText(filmDetail.getDirector());
            filmDetailDuration.setText(String.valueOf(filmDetail.getDurationString()));
            filmDetailYear.setText(String.valueOf(filmDetail.getReleaseDate()));
            filmDetailScore.setText(String.valueOf(filmDetail.getScore()));
            Picasso.get().load(filmDetail.getUrlImage()).into(filmDetailImage);
            Picasso.get().load(filmDetail.getUrlImageBanner()).into(filmDetailImageBanner);
        }

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }

}