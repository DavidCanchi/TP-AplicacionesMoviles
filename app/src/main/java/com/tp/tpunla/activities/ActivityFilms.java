package com.tp.tpunla.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.tp.tpunla.R;
import com.tp.tpunla.data.Data;

public class ActivityFilms extends AppCompatActivity {

    RecyclerView rvFilms;
    FilmAdapter filmAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_films);
        setupAdapter();
    }

    private void setupAdapter() {
        rvFilms = findViewById(R.id.rv_films);
        filmAdapter = new FilmAdapter(Data.getFilms(10), film -> {
            Intent detailActivity = new Intent(ActivityFilms.this, ActivityFilmDetail.class);
            detailActivity.putExtra("id", film.getId());
            startActivity(detailActivity);
        });
        rvFilms.setAdapter(filmAdapter);
    }
}