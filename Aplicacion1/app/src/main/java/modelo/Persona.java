package modelo;

import java.io.Serializable;

public class Persona implements Serializable{
    public String no,bre,apellido,correo,cedula;

    public Persona(String no, String bre, String apellido, String correo, String cedula) {
        this.no = no;
        this.bre = bre;
        this.apellido = apellido;
        this.correo = correo;
        this.cedula = cedula;
    }

    public String getNo() {
        return no;
    }

    public String getBre() {
        return bre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public String getCedula() {
        return cedula;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public void setBre(String bre) {
        this.bre = bre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
