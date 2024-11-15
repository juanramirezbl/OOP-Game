package mythossaga;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public abstract class Personaje implements Serializable {
    private String nombre;
    private HashMap<String, Equipo> armas;
    private Equipo[] armaActiva;

    private HashMap<String, Equipo> armaduras;
    private Equipo armaduraActiva;
    private int salud;
    private ArrayList<Modificador> debilidad;
    private ArrayList<Modificador> fortaleza;
    private double oro;
    private int poder;
    private ArrayList<Esbirro> esbirros;



    public Personaje(String nombre) {
        this.nombre = nombre;
    }

    public Personaje(String nombre, int salud, int poder) {
        this.nombre = nombre;
        this.salud = salud;
        this.oro = 100;
        this.poder = poder;
        this.armaActiva = new Equipo[2];
        this.armaduras = new HashMap<>();
        this.armas = new HashMap<>();
        this.debilidad = new ArrayList<>();
        this.fortaleza = new ArrayList<>();
        this.esbirros = new ArrayList<>();
    }

    public Personaje(String nombre, HashMap<String, Equipo> armas, Equipo[] armaActiva, HashMap<String, Equipo> armaduras, Equipo armaduraActiva, int salud,
                     ArrayList<Modificador> debilidad,ArrayList<Modificador> fortaleza, double oro, int poder, ArrayList<Esbirro> esbirros) {
        this.nombre = nombre;
        this.armas = armas;
        this.armaActiva = armaActiva;
        this.armaduras = armaduras;
        this.armaduraActiva = armaduraActiva;
        this.salud = salud;
        this.debilidad = debilidad;
        this.fortaleza = fortaleza;
        this.oro = oro;
        this.poder = poder;
        this.esbirros = esbirros;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public HashMap<String, Equipo> getArmas() {
        return armas;
    }

    public void setArmas(HashMap<String, Equipo> armas) {
        this.armas = armas;
    }

    public Equipo[] getArmaActiva() {
        return armaActiva;
    }
    public void setArmaActiva(Equipo... equipos){
        Arrays.fill(this.armaActiva, null);

        // Agrega los nuevos equipos
        int index = 0;
        for (Equipo equipo : equipos) {
            this.armaActiva[index++] = equipo;
            // Verifica si hemos alcanzado el límite del array
            if (index >= this.armaActiva.length) {
                break;
            }
        }
    }
    public HashMap<String, Equipo> getArmaduras() {
        return armaduras;
    }

    public void setArmaduras(HashMap<String, Equipo> armaduras) {
        this.armaduras = armaduras;
    }

    public Equipo getArmaduraActiva() {
        return armaduraActiva;
    }

    public void setArmaduraActiva(Equipo armaduraActiva) {
        this.armaduraActiva = armaduraActiva;
    }

    public int getSalud() {
        return salud;
    }

    public void setSalud(int salud) {
        this.salud = salud;
    }

    public ArrayList<Modificador> getDebilidad() {
        return debilidad;
    }

    public void setDebilidad(ArrayList<Modificador> debilidad) {
        this.debilidad = debilidad;
    }

    public ArrayList<Modificador> getFortaleza() {
        return fortaleza;
    }

    public void setFortaleza(ArrayList<Modificador> fortaleza) {
        this.fortaleza = fortaleza;
    }

    public double getOro() {
        return oro;
    }

    public void setOro(double oro) {
        this.oro = oro;
    }

    public int getPoder() {
        return poder;
    }

    public void setPoder(int poder) {
        this.poder = poder;
    }

    public ArrayList<Esbirro> getEsbirros() {
        return this.esbirros;
    }

    public void setEsbirros(ArrayList<Esbirro> esbirros) {
        this.esbirros = esbirros;
    }


    public void addArmas(Arma arma) {
        if (this.armas == null){
            this.armas = new HashMap<>();
        }
        this.armas.put(arma.getNombre(), arma);
    }

    public void addArmadura(Armadura armadura) {
        if (this.armaduras == null){
            this.armaduras = new HashMap<>();
        }
        this.armaduras.put(armadura.getNombre(), armadura);
    }
    public int getValorAtaqueEquipoActivo() {
        int valorAtaque = 0;
        if (armaActiva != null) {
            for (Equipo arma : armaActiva) {
                if (arma != null) {
                    valorAtaque += arma.getValorAtaque();
                }
            }
        }
        return valorAtaque;
    }

    public int getValorDefensaEquipoActivo() {
        int valorDefensa = 0;
        if (armaduraActiva != null) {
            valorDefensa += armaduraActiva.getValorDefensa();
        }
        return valorDefensa;
    }


    public void addEsbirro(Esbirro esbirro) {
        if (this.esbirros == null){
            this.esbirros = new ArrayList<>();
        }
        this.esbirros.add(esbirro);
    }


}
