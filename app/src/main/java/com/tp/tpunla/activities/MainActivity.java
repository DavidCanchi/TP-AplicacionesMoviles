package com.tp.tpunla.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.tp.tpunla.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /**
         * Metodo provisorio para acceder a la vista de films
         * TODO: eliminar/cambiar tras agregar logica de logueo.
         */
        findViewById(R.id.prueba).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent films = new Intent(MainActivity.this, ActivityFilms.class);
                startActivity(films);
                finish();
            }
        });
    }
}