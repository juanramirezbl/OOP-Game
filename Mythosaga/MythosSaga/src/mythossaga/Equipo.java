package mythossaga;

import java.io.Serializable;

public abstract class Equipo implements Serializable {
    protected String nombre;
    protected int modificador;

    public Equipo(String nombre, int modificador) {
        this.nombre = nombre;
        this.modificador = modificador;
    }

    public String getNombre() {
        return nombre;
    }

    public int getModificador() {
        return modificador;
    }

    public abstract int getValorAtaque();
    public abstract int getValorDefensa();
}
