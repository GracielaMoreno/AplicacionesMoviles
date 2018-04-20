package com.example.usrgam.aplicacion1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import modelo.Persona;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        //getIntent().getExtras().getString("idTexto");

        //Toast.makeText(getApplicationContext(),getIntent().getExtras().getString("idTexto"),Toast.LENGTH_LONG).show();

        Persona Persona = (Persona)getIntent().getExtras().getSerializable("idpersona");
        ((TextView)findViewById(R.id.nombre)).setText(Persona.getNo());
        ((TextView)findViewById(R.id.apellido)).setText(Persona.getBre());
        ((TextView)findViewById(R.id.correo)).setText(Persona.getCorreo());
        ((TextView)findViewById(R.id.cedula)).setText(Persona.getCedula());

        Toast.makeText(getApplicationContext(),getIntent().getExtras().getString("idTexto"),Toast.LENGTH_LONG).show();
    }
}
