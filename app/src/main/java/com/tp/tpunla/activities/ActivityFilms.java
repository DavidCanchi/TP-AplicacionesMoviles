package com.tp.tpunla.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.tp.tpunla.R;
import com.tp.tpunla.constants.Constants;
import com.tp.tpunla.data.Data;

public class ActivityFilms extends AppCompatActivity {

    RecyclerView rvFilms;
    FilmAdapter filmAdapter;
    Spinner dropdown;
    String[] cantidades = new String[]{"10", "8", "6", "4"};
    Button buttonLogout;

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

    @Override
    public boolean onCreateOptionsMenu(@NonNull Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.buttonLogout) {
            SharedPreferences prefs = getApplicationContext().getSharedPreferences(Constants.SP_CREDENCIALES, MODE_PRIVATE);
            SharedPreferences.Editor editor = prefs.edit();
            editor.remove(Constants.USUARIO);
            editor.remove(Constants.PASSWORD);
            editor.apply();
            Intent homeActivity = new Intent(ActivityFilms.this, HomeActivity.class);
            startActivity(homeActivity);
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}