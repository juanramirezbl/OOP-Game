package mythossaga;

import java.io.Serializable;

public abstract class Modificador implements Serializable {
    protected String nombre;
    protected int valor;

    public Modificador(String nombre, int valor) {
        this.nombre = nombre;
        this.valor = Math.max(1, Math.min(valor, 5));
    }

    public String getNombre() {
        return nombre;
    }

    public int getValor() {
        return valor;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }
}
