package mythossaga;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Vampiro extends Personaje implements Serializable {

    private Integer edad;
    private Integer puntosSangre;

    public Vampiro(String nombre) {
        super(nombre);
    }

    public Vampiro(String nombre, Integer edad, Integer puntosSangre) {
        super(nombre);
        this.edad = edad;
        this.puntosSangre = puntosSangre;
    }

    public Vampiro(String nombre, int salud, int poder, Integer edad, Integer puntosSangre) {
        super(nombre, salud, poder);
        this.edad = edad;
        this.puntosSangre = puntosSangre;
    }

    public Vampiro(String nombre, HashMap<String, Equipo> armas, Equipo[] armaActiva, HashMap<String, Equipo> armaduras, Equipo armaduraActiva, int salud,
                   ArrayList<Modificador> debilidad, ArrayList<Modificador> fortaleza, double oro, int poder, ArrayList<Esbirro> esbirros, Integer edad, Integer puntosSangre) {
        super(nombre, armas, armaActiva, armaduras, armaduraActiva, salud, debilidad, fortaleza, oro, poder, esbirros);
        this.edad = edad;
        this.puntosSangre = puntosSangre;
    }

    public Integer getEdad() {
        return edad;
    }

    public Integer getPuntosSangre() {
        return puntosSangre;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public void setPuntosSangre(Integer puntosSangre) {
        this.puntosSangre = puntosSangre;
    }

    public int getValorAtaqueDisciplina() {
        return 2 * edad;// no dice nada, lo supongo
    }
    public int getValorDefensaDisciplina(){
        return 2 * edad; // no dice nada, lo supongo
    }


}
