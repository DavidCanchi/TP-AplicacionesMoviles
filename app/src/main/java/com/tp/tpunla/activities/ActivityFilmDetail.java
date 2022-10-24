package com.tp.tpunla.activities;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;
import com.tp.tpunla.R;
import com.tp.tpunla.constants.Constants;
import com.tp.tpunla.services.studioghibli.FilmDetail;
import com.tp.tpunla.services.studioghibli.GhibliClient;

import java.io.IOException;
import java.util.Objects;

import retrofit2.Response;

public class ActivityFilmDetail extends AppCompatActivity {
    TextView filmDetailTitle,
            filmDetailOriginalTitle,
            filmDetailDescription,
            filmDetailDirector,
            filmDetailDuration,
            filmDetailYear,
            filmDetailScore;
    ImageView filmDetailImageBanner,
            filmDetailImage;
    SharedPreferences prefs;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_film_detail);
        initVariables();

        Intent intent = getIntent();
        String id = intent.getStringExtra("id");
        if (id != null) {
            new Thread() {
                public void run() {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                Log.i(ActivityFilmDetail.class.getName(), "Trayendo datos");
                                Response<FilmDetail> response = GhibliClient.INSTANCE.getApi().getFilm(id).execute();
                                FilmDetail filmDetail = response.body();
                                filmDetailTitle.setText(filmDetail.getTitle());
                                filmDetailOriginalTitle.setText(filmDetail.getOriginal_title_romanised());
                                filmDetailDescription.setText(filmDetail.getDescription());
                                filmDetailDirector.setText(filmDetail.getDirector());
                                filmDetailDuration.setText(filmDetail.getRunning_time());
                                filmDetailYear.setText(filmDetail.getRelease_date());
                                filmDetailScore.setText(filmDetail.getRt_score());
                                Picasso.get().load(filmDetail.getImage()).into(filmDetailImage);
                                Picasso.get().load(filmDetail.getMovie_banner()).into(filmDetailImageBanner);
                            }catch (IOException e) {
                                Log.e(ActivityFilmDetail.class.getName(),"Error al traer los datos " + e.getMessage());
                                Toast.makeText(ActivityFilmDetail.this, "Error al traer el film", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
            }.start();
        }
    }

    private void initVariables() {
        filmDetailTitle = findViewById(R.id.filmDetailTitle);
        filmDetailOriginalTitle = findViewById(R.id.filmDetailOriginalTitle);
        filmDetailDescription = findViewById(R.id.filmDetailDescription);
        filmDetailDirector = findViewById(R.id.filmDetailDirector);
        filmDetailDuration = findViewById(R.id.filmDetailDuration);
        filmDetailYear = findViewById(R.id.filmDetailYear);
        filmDetailScore = findViewById(R.id.filmDetailScore);
        filmDetailImageBanner = findViewById(R.id.filmDetailImageBanner);
        filmDetailImage = findViewById(R.id.filmDetailImage);
        prefs = getApplicationContext().getSharedPreferences(Constants.SP_CREDENCIALES, MODE_PRIVATE);
        Objects.requireNonNull(this.getSupportActionBar()).setSubtitle("Film detail");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
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
            Intent homeActivity = new Intent(ActivityFilmDetail.this, HomeActivity.class);
            startActivity(homeActivity);
            finish();
        } else if(item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

}