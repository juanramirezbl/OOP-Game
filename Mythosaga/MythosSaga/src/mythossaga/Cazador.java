package mythossaga;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Cazador extends Personaje implements Serializable {
    private Integer voluntad;

    public Cazador(String nombre) {
        super(nombre);
    }

    public Cazador(String nombre, int salud, int poder) {
        super(nombre, salud, poder);
    }

    public Cazador(String nombre, List<Equipo> armas, Equipo armaActiva, List<Equipo> armaduras, Equipo armaduraActiva, int salud,
                   List<Modificador> debilidades, List<Modificador> fortalezas, int oro, int poder, ArrayList<Esbirro> esbirros, Integer voluntad) {
        super(nombre, salud, poder);
        this.voluntad = voluntad;
    }

    public int getValorAtaqueTalento(){
        return getPoder();
    }
    public int getVoluntadActual(){
        return voluntad;
    }
}
