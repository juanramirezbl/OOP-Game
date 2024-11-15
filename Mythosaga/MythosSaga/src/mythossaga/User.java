package mythossaga;

import java.io.Serializable;
import java.util.Scanner;

public abstract class User implements Serializable {
    private String nombre;
    private String nick;
    private String password;

    public User(){}
    public User(String nombre, String nick, String password) {
        this.nombre = nombre;
        this.nick = nick;
        this.password = password;
    }

    // Getters y setters


    @Override
    public String toString() {
        return "Nombre: " + this.nombre + " Nick: " + this.nick;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void menuGestionarPersonajes(Scanner scanner, Database data) {
    }
    public boolean comprobarPersonajes(){
        return false;
    }

    public boolean oroSuficiente(int oro){
        return false;
    }
}