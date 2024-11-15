package mythossaga;

import java.io.Serializable;

public abstract class Esbirro implements Serializable {
    private TypeEsbirro nombre;
    private int salud;

    public Esbirro(TypeEsbirro nombre, int salud) {
        this.nombre = nombre;
        if (salud >= 1 && salud <= 3) {
            this.salud = salud;
        } else {
            System.out.println("Esa salud no esta permitida por lo que se asignara 1");
            this.salud = 1;
        }
    }

    public TypeEsbirro getNombre() {
        return nombre;
    }

    public void setNombre(TypeEsbirro nombre) {
        this.nombre = nombre;
    }

    public int getSalud() {
        return salud;
    }

    public void setSalud(int salud) {
        if (salud >= 1 && salud <= 3) {
            this.salud = salud;
        } else {
            System.out.println("Error: La salud debe estar entre 1 y 3.");
        }
    }
}
