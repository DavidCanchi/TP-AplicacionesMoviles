package com.tp.tpunla.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.tp.tpunla.R;
import com.tp.tpunla.constants.Constants;
import com.tp.tpunla.data.UsuarioManager;

import java.sql.SQLException;

public class LoginActivity extends AppCompatActivity {
    EditText loginUsuario, loginPassword;
    Button buttonIniciarSesion, buttonRegister;
    CheckBox loginCheckbox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initVariables();

        buttonIniciarSesion.setOnClickListener(v -> {
            String usuario = loginUsuario.getText().toString();
            String password = loginPassword.getText().toString();
            if(usuario.isEmpty() || password.isEmpty()) {
                Log.i(LoginActivity.class.getName(),"Datos incompletos");
                Toast.makeText(LoginActivity.this, "Completar datos", Toast.LENGTH_SHORT).show();
            } else {
                iniciarSesion(usuario, password);
            }
        });

        buttonRegister.setOnClickListener( v -> {
            Intent registroActivity = new Intent(LoginActivity.this, RegisterActivity.class);
            startActivity(registroActivity);
            finish();
        });
    }

    private void initVariables() {
        loginUsuario = findViewById(R.id.loginUsuario);
        loginPassword = findViewById(R.id.loginPassword);
        buttonIniciarSesion = findViewById(R.id.buttonIniciarSesion);
        buttonRegister = findViewById(R.id.buttonRegister);
        loginCheckbox = findViewById(R.id.loginCheckbox);
    }

    private void iniciarSesion(String usuario, String password) {
        try {
            if(UsuarioManager.getInstancia(this).isUsuarioCorrecto(usuario, password)) {
                if(loginCheckbox.isChecked()) {
                    SharedPreferences prefs = getApplicationContext().getSharedPreferences(Constants.SP_CREDENCIALES, MODE_PRIVATE);
                    SharedPreferences.Editor editor = prefs.edit();
                    editor.putString(Constants.USUARIO, usuario);
                    editor.putString(Constants.PASSWORD, password);
                    editor.apply();
                    Log.i(LoginActivity.class.getName(),"Usuario guardado en memoria");
                    NotificationManagerCompat.from(this).notify(1, crearNotificacion());
                }
                Log.i(LoginActivity.class.getName(),"Usuario logueado correctamente");
                Intent activityYesNo = new Intent(LoginActivity.this, ActivityYesNo.class);
                activityYesNo.putExtra("seRecuerdaUsuario", loginCheckbox.isChecked());
                startActivity(activityYesNo);
                finish();
            } else {
                Toast.makeText(LoginActivity.this, "Datos incorrectos", Toast.LENGTH_SHORT).show();
                Log.i(LoginActivity.class.getName(),"Usuario incorrecto");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            Toast.makeText(LoginActivity.this, "Error al iniciar sesión", Toast.LENGTH_SHORT).show();
        }
    }

    private Notification crearNotificacion(){
        return new NotificationCompat.Builder(this, Constants.CHANNEL_ID)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle("Usuario logueado")
                .setContentText("El usuario logueado será recordado")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .build();
    }
}