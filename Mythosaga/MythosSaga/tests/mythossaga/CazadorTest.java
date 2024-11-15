package mythossaga;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class CazadorTest {

    private Cazador cazador1;
    private Cazador cazador2;

    @Before
    public void setUp() {
        cazador1 = new Cazador("Cazador1");
        List<Equipo> armas = new ArrayList<>();
        List<Equipo> armaduras = new ArrayList<>();
        List<Modificador> debilidades = new ArrayList<>();
        List<Modificador> fortalezas = new ArrayList<>();
        ArrayList<Esbirro> esbirros = new ArrayList<>();
        cazador2 = new Cazador("Cazador2", armas, null, armaduras, null, 100, debilidades, fortalezas, 50, 30, esbirros, 20);
    }

    @Test
    public void testCazadorConstructor() {
        // Caso 1
        assertEquals("Cazador1", cazador1.getNombre());
        assertNull(cazador1.getVoluntadActual());

        // Caso 2
        assertEquals("Cazador2", cazador2.getNombre());
        assertEquals(20, cazador2.getVoluntadActual());
        assertEquals(100, cazador2.getSalud());
        assertEquals(30, cazador2.getPoder());
        assertEquals(50, cazador2.getOro());
    }

    @Test
    public void testGetValorAtaqueTalento() {
        // Caso 1
        assertEquals(0, cazador1.getValorAtaqueTalento());

        // Caso 2
        assertEquals(30, cazador2.getValorAtaqueTalento());
    }

    @Test
    public void testGetVoluntadActual() {
        // Caso 1
        assertNull(cazador1.getVoluntadActual());

        // Caso 2
        assertEquals(20, cazador2.getVoluntadActual());
    }
}
