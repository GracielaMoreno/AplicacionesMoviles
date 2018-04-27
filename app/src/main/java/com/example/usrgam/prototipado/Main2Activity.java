package com.example.usrgam.prototipado;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.Toast;

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
        adapter=new ArrayAdapter<Zapatos>(getApplicationContext(),R.layout.support_simple_spinner_dropdown_item, datos);
        listaz.setAdapter(adapter);
        listaz.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override

            public void onItemClick(AdapterView<?> parent, View view, int i, long id) {


                //Intent intent = new Intent(getApplicationContext(), Main3Activity.class);
                //intent.putExtra("idzapato", datos[i]);
                //startActivity(intent);
                abrirmenu(view, i);

            }
        });
    }

    public void abrirmenu(View view, final int i) {
        //public void abrirmenu(View view,String itemLista){
        //abrir datos ,toast
        PopupMenu popupMenu = new PopupMenu(this, view);
        //si estoy en la misma vista debemos usar el this y si estamos en otro lado ponemos getcontext
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.itver:
                        //Toast.makeText(getApplicationContext(), "ver productos", Toast.LENGTH_LONG).show();
                        //Toast.makeText(getApplicationContext(), "ver productos", Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(getApplicationContext(),Main3Activity.class);
                        //intent.putExtra("idTexto","mensaje de pantalla uno");
                        intent.putExtra("idzapato",datos[i]);
                        startActivity(intent);
                        return true;
                    case R.id.itcomprar:
                        Toast.makeText(getApplicationContext(), "comprar", Toast.LENGTH_LONG).show();
                        return true;
                    case R.id.itcomparar:
                        Toast.makeText(getApplicationContext(), "comparar", Toast.LENGTH_LONG).show();
                        return true;
                    default:return false;
                }

            }
        });
        popupMenu.inflate(R.menu.menu);
        popupMenu.show();
    }
    private void cargarDatos(){
        datos = new Zapatos[] {new Zapatos("z1","23.4"),new Zapatos("z2","23.4"),new Zapatos("z3","23.4"),new Zapatos("z4","23.4"),new Zapatos("z5","23.4"),new Zapatos("z1","23.4")};
    }

}
