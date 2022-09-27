package com.tp.tpunla.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.tp.tpunla.R;
import com.tp.tpunla.data.UsuarioManager;
import com.tp.tpunla.models.Usuario;

import java.sql.SQLException;

public class RegisterActivity extends AppCompatActivity {

    EditText registerUsuario, registerPassword, registerEmail;
    Button buttonRegistro, buttonLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        initVariables();

        buttonRegistro.setOnClickListener(v -> {
            String usuario = registerUsuario.getText().toString();
            String password = registerPassword.getText().toString();
            String email = registerEmail.getText().toString();
            if(usuario.isEmpty() || password.isEmpty() || email.isEmpty()) {
                Log.i(RegisterActivity.class.getName(),"Datos incompletos");
                Toast.makeText(RegisterActivity.this, "Completar datos", Toast.LENGTH_SHORT).show();
            } else {
                registrarUsuario(usuario, password, email);
            }
        });

        buttonLogin.setOnClickListener( v -> {
            Intent loginActivity = new Intent(RegisterActivity.this, LoginActivity.class);
            startActivity(loginActivity);
            finish();
        });

    }

    private void registrarUsuario(String usuario, String password, String email) {
        try {
            UsuarioManager usuarioManager = UsuarioManager.getInstancia(this);
            if(usuarioManager.isUsuarioValido(usuario, email)) {
                usuarioManager.agregarUsuario(new Usuario(usuario, password, email));
                Dialog dialog = new Dialog(this);
                dialog.setContentView(R.layout.usuario_registrado);
                dialog.show();
                registerEmail.setText("");
                registerUsuario.setText("");
                registerPassword.setText("");
                Log.i(RegisterActivity.class.getName(),"Usuario nuevo registrado");
            } else {
                Log.i(RegisterActivity.class.getName(),"Usuario ya registrado");
                Toast.makeText(RegisterActivity.this, "Usuario o email ya registrado", Toast.LENGTH_LONG).show();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            Toast.makeText(RegisterActivity.this, "Error durante el registro", Toast.LENGTH_SHORT).show();
        }
    }

    private void initVariables() {
        registerUsuario = findViewById(R.id.registerUsuario);
        registerPassword = findViewById(R.id.registerPassword);
        registerEmail = findViewById(R.id.registerEmail);
        buttonRegistro = findViewById(R.id.buttonRegistro);
        buttonLogin = findViewById(R.id.buttonLogin);
    }

}