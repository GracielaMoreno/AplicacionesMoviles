package com.example.usrgam.prototipado;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import control.control;
import modelo1.Persona;

public class registrarusuario extends AppCompatActivity {

    EditText nombreUsuario;
    EditText contraseniaUsuario;

    private control lea = new control();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrarusuario);

        nombreUsuario = (EditText) findViewById(R.id.textUsuarioRegistrar);
        contraseniaUsuario = (EditText) findViewById(R.id.textContraseniaRegistrar);
    }

    public void crearArchivo(View v) {
        lea.escribirArchivo(new Persona(nombreUsuario.getText().toString(), contraseniaUsuario.getText().toString()), "usuario u");
        Toast.makeText(getApplicationContext(), "REGISTRADO", Toast.LENGTH_LONG).show();
    }
}

