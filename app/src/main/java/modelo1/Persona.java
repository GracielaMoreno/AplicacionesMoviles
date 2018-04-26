package modelo1;

import java.io.Serializable;

public class Persona  implements Serializable{
    public String usuario,pasword;

    public Persona(String usuario,String pasword){
        this.usuario=usuario;
        this.pasword=pasword;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPasword() {
        return pasword;
    }

    public void setPasword(String pasword) {
        this.pasword = pasword;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "usuario='" + usuario + '\'' +
                ", pasword='" + pasword + '\'' +
                '}';
    }


}
