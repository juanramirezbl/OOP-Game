package mythossaga;

import java.util.ArrayList;

public class Demonio extends Esbirro{

    private ArrayList<Esbirro> esbirros;
    private String pacto;

    public Demonio(TypeEsbirro nombre, int salud, String pacto) {
        super(nombre, salud);
        this.esbirros = new ArrayList<>();
        this.pacto = pacto;
    }

    public ArrayList<Esbirro> getEsbirros() {
        return esbirros;
    }

    public String getPacto() {
        return pacto;
    }

    public void addEsbirros(Esbirro esbirro){this.esbirros.add(esbirro);}

    public void setEsbirros(ArrayList<Esbirro> esbirros) {
        this.esbirros = esbirros;
    }

    public void setPacto(String pacto) {
        this.pacto = pacto;
    }
}
