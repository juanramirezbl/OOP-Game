package mythossaga;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class GhoulTest {

    private Ghoul ghoul;

    @Before
    public void setUp() {
        ghoul = new Ghoul(TypeEsbirro.ghoul, 2, 5);
    }

    @Test
    public void testGhoulConstructor() {
        assertEquals(TypeEsbirro.ghoul, ghoul.getNombre());
        assertEquals(2, ghoul.getSalud());
        assertEquals((Integer) 5, ghoul.getDependencia());
    }

    @Test
    public void testGetDependencia() {
        assertEquals((Integer) 5, ghoul.getDependencia());
    }

    @Test
    public void testSetDependencia() {
        ghoul.setDependencia(10);
        assertEquals((Integer) 10, ghoul.getDependencia());
    }

    @Test
    public void testSetNombre() {
        ghoul.setNombre(TypeEsbirro.demonio);
        assertEquals(TypeEsbirro.demonio, ghoul.getNombre());
    }

    @Test
    public void testSetSalud() {
        ghoul.setSalud(3);
        assertEquals(3, ghoul.getSalud());
    }
}
