package com.tp.tpunla.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.tp.tpunla.R;
import com.tp.tpunla.constants.Constants;
import com.tp.tpunla.services.studioghibli.Film;
import com.tp.tpunla.services.studioghibli.GhibliClient;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

import retrofit2.Response;

public class ActivityFilms extends AppCompatActivity {

    RecyclerView rvFilms;
    FilmAdapter filmAdapter;
    SharedPreferences prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_films);
        initVariables();
        new Thread() {
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        setupAdapter();
                    }
                });
            }
        }.start();
    }

    private void initVariables() {
        rvFilms = findViewById(R.id.rv_films);
        prefs = getApplicationContext().getSharedPreferences(Constants.SP_CREDENCIALES, MODE_PRIVATE);
        Objects.requireNonNull(this.getSupportActionBar()).setSubtitle("Films");
    }

    private void setupAdapter() {
        try {
            Log.i(ActivityFilms.class.getName(),"Trayendo datos");
            Response<List<Film>> response = GhibliClient.INSTANCE.getApi().getFilms(20).execute();
            List<Film> films = response.body();
            filmAdapter = new FilmAdapter(films, film -> {
                Intent detailActivity = new Intent(ActivityFilms.this, ActivityFilmDetail.class);
                detailActivity.putExtra("id", film.getId());
                startActivity(detailActivity);
            });
            rvFilms.setAdapter(filmAdapter);
        } catch (IOException e) {
            Log.e(ActivityFilms.class.getName(),"Error al traer los datos " + e.getMessage());
            Toast.makeText(ActivityFilms.this, "Error al traer los films", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(@NonNull Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        super.onCreateOptionsMenu(menu);
        menu.findItem(R.id.itemUsuario).setTitle(prefs.getString(Constants.USUARIO, "Anónimo"));
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.itemLogout) {
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