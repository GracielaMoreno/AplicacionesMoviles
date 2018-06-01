package com.example.usrgam.prototipado;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.Toast;


import java.util.ArrayList;

import modelo1.Zapatos;

public class Registro extends AppCompatActivity {

    private ArrayList<Zapatos> Productos;
    Zapatos [] datos;
    private ArrayAdapter<Zapatos> adaptador1;
    private ListView lv1;
    private EditText et1;
    private EditText et2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        adaptador1=new ArrayAdapter<Zapatos>(this,android.R.layout.simple_list_item_1,datos);
        lv1=(ListView)findViewById(R.id.listView);
        lv1.setAdapter(adaptador1);

        et1=(EditText)findViewById(R.id.editText);
        et2=(EditText)findViewById(R.id.ediTprecio);
        lv1.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                final int posicion=i;

                AlertDialog.Builder dialogo1 = new AlertDialog.Builder(Registro.this);
                dialogo1.setTitle("Importante");
                dialogo1.setMessage("¿ Elimina este Producto ?");
                dialogo1.setCancelable(false);
                dialogo1.setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogo1, int id) {
                        Productos.remove(posicion);
                        adaptador1.notifyDataSetChanged();
                    }
                });
                dialogo1.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogo1, int id) {
                    }
                });
                dialogo1.show();

                return false;
            }
        });

        lv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override

            public void onItemClick(AdapterView<?> parent, View view, int i, long id) {


                //Intent intent = new Intent(getApplicationContext(), Main3Activity.class);
                //intent.putExtra("idzapato", datos[i]);
                //startActivity(intent);
                abrirmenu(view, i);

            }
        });

    }
    public void agregar(View v) {
        Productos.add(new Zapatos(et1.getText().toString(),et2.getText().toString()));
        adaptador1.notifyDataSetChanged();
        et1.setText("");
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
}
