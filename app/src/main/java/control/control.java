package control;

import android.content.Context;
import android.os.Environment;
import android.util.Log;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import modelo1.Persona;

public class control {


    private File file = Environment.getExternalStorageDirectory();
    private String ruta = file.getAbsolutePath() + File.separator;
    ArrayList<Persona> list = new ArrayList<Persona>();

    public void escribirArchivo(Persona u, String nombre) {
        try {
            FileInputStream file = new FileInputStream(ruta+nombre);
            ObjectInputStream in = new ObjectInputStream(file);

            list = (ArrayList<Persona>) in.readObject();
            in.close();

            FileOutputStream fos = new FileOutputStream(ruta+nombre);
            ObjectOutputStream out = new ObjectOutputStream(fos);

            list.add(u);
            out.writeObject(list);
            out.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Persona> leerArchivo(String nombre) {
        try {
            FileInputStream file = new FileInputStream(ruta + nombre);
            ObjectInputStream in = new ObjectInputStream(file);

            list = (ArrayList<Persona>) in.readObject();
            in.close();
        } catch (FileNotFoundException e) {
            Log.e("error escribir : ", e.toString());
            e.printStackTrace();
        } catch (IOException e) {
            Log.e("error IO : ", e.toString());
            //e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return list;
    }
}
