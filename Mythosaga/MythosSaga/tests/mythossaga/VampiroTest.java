package mythossaga;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VampiroTest {

    private Vampiro vampiro;

    @BeforeEach
    public void setUp() {
        HashMap<String, Equipo> armas = new HashMap<>();
        Arma[] armaActiva = new Arma[10];
        HashMap<String, Equipo> armaduras = new HashMap<>();
        Armadura armaduraActiva = new Armadura("Coraza de la Noche", 3);
        ArrayList<Modificador> debilidad = new ArrayList<>();
        ArrayList<Modificador> fortaleza = new ArrayList<>();
        ArrayList<Esbirro> esbirros = new ArrayList<>();

        vampiro = new Vampiro(
                "VladCazador",
                armas,
                armaActiva,
                armaduras,
                armaduraActiva,
                2, // Salud dentro del rango permitido
                debilidad,
                fortaleza,
                100,
                25,
                esbirros,
                30,
                15
        );
    }

    @Test
    public void testSetSalud() {
        Integer saludInicial = 2; // Salud dentro del rango permitido
        assertEquals(saludInicial, vampiro.getSalud());

        vampiro.setSalud(3); // Cambiamos la salud a otro valor permitido
        assertEquals(3, vampiro.getSalud());
    }

    @Test
    public void testSetPuntosSangre() {
        Integer puntosSangre = 20;
        vampiro.setPuntosSangre(puntosSangre);
        assertEquals(puntosSangre, vampiro.getPuntosSangre());
    }

    @Test
    public void testGetOro() {
        Double oroEsperado = 100.0;
        assertEquals(oroEsperado, vampiro.getOro());
    }

    @Test
    public void testGetPuntosSangre() {
        Integer puntosSangreEsperados = 15;
        assertEquals(puntosSangreEsperados, vampiro.getPuntosSangre());
    }
}
