package mythossaga;

import java.io.Serializable;

public class Arma extends Equipo implements Serializable {
    private int manos;
    private int valorAtaque;

    public Arma(String nombre, int modificador, int manos) {
        super(nombre, modificador);
        this.manos = manos;
    }

    public int getManos() {
        return manos;
    }

    @Override
    public String toString() {
        return "Nombre: " + this.nombre + ", Modificador de ataque: " + this.modificador + ", Manos ocupadas: " + this.manos;
    }

    public int getValorAtaque (){
        return getModificador();
    }

    public int getValorDefensa() {return 0; }
}
