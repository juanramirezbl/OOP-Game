package mythossaga;

import java.io.Serializable;

public class Disciplina extends Habilidad{
    private Integer costePuntosSangre;

    public Disciplina(String nombre, Integer ataque, Integer defensa, Integer costePuntosSangre) {
        super(nombre, ataque, defensa);
        this.costePuntosSangre = costePuntosSangre;
    }

    public Integer getCostePuntosSangre() {
        return costePuntosSangre;
    }

    public void setCostePuntosSangre(Integer costePuntosSangre) {
        this.costePuntosSangre = costePuntosSangre;
    }
}