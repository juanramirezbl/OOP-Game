package mythossaga;

public class Humano extends Esbirro{

    private Lealtad lealtad;

    public Humano(TypeEsbirro nombre, int salud, Lealtad lealtad) {
        super(nombre, salud);
        this.lealtad = lealtad;
    }

    public Lealtad getLealtad() {
        return lealtad;
    }

    public void setLealtad(Lealtad lealtad) {
        this.lealtad = lealtad;
    }
}
