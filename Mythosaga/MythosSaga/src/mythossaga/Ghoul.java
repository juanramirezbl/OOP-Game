package mythossaga;

public class Ghoul extends Esbirro{
    private Integer dependencia;

    public Ghoul(TypeEsbirro nombre, int salud, Integer dependencia) {
        super(nombre, salud);
        this.dependencia = dependencia;
    }

    public Integer getDependencia() {
        return dependencia;
    }

    public void setDependencia(Integer dependencia) {
        this.dependencia = dependencia;
    }
}
