package com.example.usrgam.aplicacion1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import modelo.Persona;

public class MainActivity extends AppCompatActivity {
    ListView listap;
    Persona [] datos;
    ArrayAdapter<Persona>adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = (Button) findViewById(R.id.button);
        Button botonpantalla2 = (Button) findViewById(R.id.botonpantalla2);

        listap = (ListView) findViewById(R.id.listView);
        final EditText escribiraqui = (EditText) findViewById(R.id.escribiraqui);
        escribiraqui.getText();
        cargarDatos();
        adapter =new ArrayAdapter<Persona>(getApplicationContext(),R.layout.support_simple_spinner_dropdown_item,datos);
        listap.setAdapter(adapter);

        listap.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
                //Toast.makeText(getApplicationContext(),datos[i].toString(),Toast.LENGTH_LONG).show();
                Intent intent = new Intent(getApplicationContext(),Main2Activity.class);
                //intent.putExtra("idTexto","mensaje de pantalla uno");
                intent.putExtra("idpersona",datos[i]);
                startActivity(intent);
            }
        });

        button.setOnClickListener( new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                Toast mensaje = Toast.makeText(getApplicationContext(), escribiraqui.getText().toString(), Toast.LENGTH_LONG);
                mensaje.setGravity(Gravity.CENTER_VERTICAL,0,0);
                mensaje.show();

            }
        });

         }
        private void cargarDatos(){
           datos = new Persona[] {new Persona("g","12","12","12","13"),new Persona("gr","11","11","11","11"),new Persona("gt","66","66","66","77")};
        }
       /* botonpantalla2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //si se pone this es el onclick
                //para ir a el mainactiviti
                //donde esta y a donde va a ir
                Intent intent = new Intent(getApplicationContext(),Main2Activity.class);
                //intent.putExtra("idTexto","mensaje de pantalla uno");
                intent.putExtra("idTexto", escribiraqui.getText().toString());
                startActivity(intent);
            }
        });*/



    public void abrirPantallaDos (View view){
        Intent intent = new Intent(getApplicationContext(),Main2Activity.class);
        //intent.putExtra("idTexto","mensaje de pantalla uno");
        intent.putExtra("idpersona",new Persona("graciels","moreno","cedula","chelinesmoreno","1726020801"));
        startActivity(intent);
    }


}

