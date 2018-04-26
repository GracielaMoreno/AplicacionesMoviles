package com.example.usrgam.prototipado;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import modelo1.Persona;

public class MainActivity extends AppCompatActivity {
     Persona[] dato;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText usuario =(EditText)findViewById(R.id.iduser);
        EditText pasword =(EditText)findViewById(R.id.idpasword);
        Button buttonIngresar =(Button)findViewById(R.id.buttoningresar);
        Button buttonInvitado =(Button)findViewById(R.id.buttoninvitado);

    }

    public void AbrirListalogin (View view){
        Intent intent =new Intent(getApplicationContext(),Main2Activity.class);
        intent.putExtra("idpersona",new Persona("Graciela","12345"));
        startActivity(intent);
    }
}
