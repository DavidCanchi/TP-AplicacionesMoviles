package com.tp.tpunla.activities;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import com.tp.tpunla.R;
import com.tp.tpunla.constants.Constants;

public class HomeActivity extends Activity {

    Button accederButton, registrarseButton;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        accederButton = findViewById(R.id.accederButton);
        registrarseButton = findViewById(R.id.registrarseButton);

        accederButton.setText("ACCEDER");
        registrarseButton.setText("REGISTRARSE");

        SharedPreferences prefs = getApplicationContext().getSharedPreferences(Constants.SP_CREDENCIALES, MODE_PRIVATE);
        String usuarioGuardado = prefs.getString(Constants.USUARIO, null);
        String passwordGuardado = prefs.getString(Constants.PASSWORD, null);

        if(usuarioGuardado != null && passwordGuardado != null) {
            Log.i(HomeActivity.class.getName(),"Usuario recuperado de memoria");
            Intent activityFilms = new Intent(HomeActivity.this, ActivityFilms.class);
            startActivity(activityFilms);
            finish();
        }

        accederButton.setOnClickListener(v -> {
            Intent loginActivity = new Intent(HomeActivity.this, LoginActivity.class);
            startActivity(loginActivity);
            finish();
        });

        registrarseButton.setOnClickListener(v -> {
            Intent loginActivity = new Intent(HomeActivity.this, RegisterActivity.class);
            startActivity(loginActivity);
            finish();
        });
    }
}