package com.tp.tpunla.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.tp.tpunla.R;
import com.tp.tpunla.data.Data;

public class ActivityFilms extends AppCompatActivity {

    RecyclerView rvFilms;
    FilmAdapter filmAdapter;
    Spinner dropdown;
    String[] cantidades = new String[]{"10", "8", "6", "4"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_films);
        dropdown = findViewById(R.id.filmsSpinner);
        rvFilms = findViewById(R.id.rv_films);

        setupAdapter(10);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, cantidades);
        dropdown.setAdapter(adapter);

        dropdown.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                setupAdapter(Integer.parseInt(cantidades[position]));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    };

    private void setupAdapter(int cantidad) {
        rvFilms = findViewById(R.id.rv_films);
        filmAdapter = new FilmAdapter(Data.getFilms(cantidad), film -> {
            Intent detailActivity = new Intent(ActivityFilms.this, ActivityFilmDetail.class);
            detailActivity.putExtra("id", film.getId());
            startActivity(detailActivity);
        });
        rvFilms.setAdapter(filmAdapter);
    }
}