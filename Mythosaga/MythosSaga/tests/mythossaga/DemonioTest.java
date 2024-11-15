package mythossaga;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class DemonioTest {

    private Demonio demonio;
    private Esbirro esbirro1;
    private Esbirro esbirro2;

    @Before
    public void setUp() {
        esbirro1 = new Demonio(TypeEsbirro.demonio, 100, "Pacto de Sangre"); // AUX 1
        esbirro2 = new Demonio(TypeEsbirro.demonio, 150, "Pacto de Sangre"); // AUX 2
        demonio = new Demonio(TypeEsbirro.demonio, 200, "Pacto de Sangre");
    }

    @Test
    public void testDemonioConstructor() {
        assertEquals(TypeEsbirro.demonio, demonio.getNombre());
        assertEquals("Pacto de Sangre", demonio.getPacto());
        assertNotNull(demonio.getEsbirros());

        Demonio demonio2 = new Demonio(TypeEsbirro.demonio, 300, "Pacto Infernal");
        assertEquals(TypeEsbirro.demonio, demonio2.getNombre());
        assertEquals("Pacto Infernal", demonio2.getPacto());
        assertNotNull(demonio2.getEsbirros());
    }

    @Test
    public void testGetEsbirros() {
        ArrayList<Esbirro> esbirros = demonio.getEsbirros();
        assertNotNull(esbirros);
        assertTrue(esbirros.isEmpty());

        demonio.addEsbirros(esbirro1);
        assertFalse(demonio.getEsbirros().isEmpty());
    }

    @Test
    public void testSetEsbirros() {
        ArrayList<Esbirro> esbirros = new ArrayList<>();
        esbirros.add(esbirro1);
        esbirros.add(esbirro2);
        demonio.setEsbirros(esbirros);
        assertEquals(esbirros, demonio.getEsbirros());

        ArrayList<Esbirro> esbirros2 = new ArrayList<>();
        Esbirro esbirro3 = new Demonio(TypeEsbirro.demonio, 120, "Pacto de Fuego");
        esbirros2.add(esbirro3);
        demonio.setEsbirros(esbirros2);
        assertEquals(esbirros2, demonio.getEsbirros());
    }

    @Test
    public void testAddEsbirros() {
        demonio.addEsbirros(esbirro1);
        assertTrue(demonio.getEsbirros().contains(esbirro1));
        assertEquals(1, demonio.getEsbirros().size());

        demonio.addEsbirros(esbirro2);
        assertTrue(demonio.getEsbirros().contains(esbirro2));
        assertEquals(2, demonio.getEsbirros().size());

        Esbirro esbirro3 = new Demonio(TypeEsbirro.demonio, 120, "Pacto de Fuego");
        demonio.addEsbirros(esbirro3);
        assertTrue(demonio.getEsbirros().contains(esbirro3));
        assertEquals(3, demonio.getEsbirros().size());
    }

    @Test
    public void testGetPacto() {
        assertEquals("Pacto de Sangre", demonio.getPacto());

        Demonio demonio2 = new Demonio(TypeEsbirro.demonio, 250, "Pacto Infernal");
        assertEquals("Pacto Infernal", demonio2.getPacto());
    }

    @Test
    public void testSetPacto() {
        demonio.setPacto("Nuevo Pacto");
        assertEquals("Nuevo Pacto", demonio.getPacto());

        demonio.setPacto("Pacto de Fuego");
        assertEquals("Pacto de Fuego", demonio.getPacto());
    }
}
