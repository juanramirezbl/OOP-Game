package mythossaga;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Licantropo extends Personaje implements Serializable {
    private static final int rabia_minima_para_don = 5;
    private static final int valor_ataque_don= 3;
    private Integer rabia;

    public Licantropo(String nombre) {
        super(nombre);
    }

    public Licantropo(String nombre, Integer rabia) {
        super(nombre);
        this.rabia = rabia;
    }

    public Licantropo(String nombre, int salud, int poder, Integer rabia) {
        super(nombre, salud, poder);
        this.rabia = rabia;
    }

    public Licantropo(String nombre, HashMap<String, Equipo> armas, Equipo[] armaActiva, HashMap<String, Equipo> armaduras, Equipo armaduraActiva,
                      int salud, ArrayList<Modificador> debilidad, ArrayList<Modificador> fortaleza, double oro, int poder, ArrayList<Esbirro> esbirros, Integer rabia) {
        super(nombre, armas, armaActiva, armaduras, armaduraActiva, salud, debilidad, fortaleza, oro, poder, esbirros);
        this.rabia = rabia;
    }

    public Integer getRabia() {
        return rabia;
    }

    public void setRabia(Integer rabia) {
        this.rabia = rabia;
    }

    public int getValorAtaqueDon() {
        // Si la rabia actual del licántropo es menor que el valor mínimo requerido para activar el don, el valor de ataque del don es cero
        if (rabia < rabia_minima_para_don) {
            return 0;
        } else {
            return valor_ataque_don;
        }
    }
    public int getValorDefensaDon(){
        if (rabia < rabia_minima_para_don) {
            return 0;
        } else {
            return valor_ataque_don;
        }
    }
}
