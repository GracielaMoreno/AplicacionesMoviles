package com.example.usrgam.prototipado;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import modelo1.Zapatos;

public class Main2Activity extends AppCompatActivity {
    ListView listaz;
    Zapatos []datos;
    ArrayAdapter<Zapatos>adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        listaz =(ListView)findViewById(R.id.listView);
        cargarDatos();
        adapter=new ArrayAdapter<Zapatos>(getApplicationContext(),R.layout.support_simple_spinner_dropdown_item);
        listaz.setAdapter(adapter);
        listaz.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
                Intent intent = new Intent(getApplicationContext(),Main3Activity.class);
                intent.putExtra("idzapato",datos[i]);
                startActivity(intent);
            }
        });
    }
    private void cargarDatos(){
        datos = new Zapatos[] {new Zapatos()};
    }

}
