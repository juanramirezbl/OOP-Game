package mythossaga;

import java.io.Serializable;

public abstract class Habilidad implements Serializable {

    private String nombre;
    private Integer ataque;
    private Integer defensa;

    public Habilidad(String nombre, Integer ataque, Integer defensa) {
        this.nombre = nombre;
        this.ataque = ataque;
        this.defensa = defensa;
    }

    public String getNombre() {
        return nombre;
    }

    public Integer getAtaque() {
        return ataque;
    }

    public Integer getDefensa() {
        return defensa;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setAtaque(Integer ataque) {
        this.ataque = ataque;
    }

    public void setDefensa(Integer defensa) {
        this.defensa = defensa;
    }
}
