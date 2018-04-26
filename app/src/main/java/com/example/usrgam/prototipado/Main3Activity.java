package com.example.usrgam.prototipado;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import modelo1.Zapatos;

public class Main3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        Zapatos zapatos =(Zapatos)getIntent().getExtras().getSerializable("idzapato");
        ((TextView)findViewById(R.id.editTextNombre)).setText(zapatos.getNombre());
        ((TextView)findViewById(R.id.editTextprecio)).setText(zapatos.getPrecio());

        Button button =(Button)findViewById(R.id.buttonComprar);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast mensaje = Toast.makeText(getApplicationContext(), "su compra a sido realizado", Toast.LENGTH_LONG);
                mensaje.setGravity(Gravity.CENTER_VERTICAL,0,0);
                mensaje.show();
            }
        });

    }
}
