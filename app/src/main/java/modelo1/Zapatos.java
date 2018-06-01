package modelo1;

import java.io.Serializable;

public class Zapatos implements Serializable {
    public String nombre;
    public String precio;

    public Zapatos(String nombre, String precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return
                "nombre='" + nombre + '\'' +
                ", precio='" + precio + '\'';
    }

    public String Imprimir(){
        return "nombre='"+ nombre +'\'';
    }

}
