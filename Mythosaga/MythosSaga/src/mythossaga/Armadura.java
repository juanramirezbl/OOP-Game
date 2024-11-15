package mythossaga;

import java.io.Serializable;

public class Armadura extends Equipo implements Serializable {
    public Armadura(String nombre, int modificador) {
        super(nombre, modificador);
    }
    @Override
    public int getValorAtaque() {
        return 0;
    }
    public int getValorDefensa() {return getModificador(); }

    @Override
    public String toString() {
        return "Nombre: " + this.nombre + ", Modificador de defensa: " + this.modificador;
    }
}
