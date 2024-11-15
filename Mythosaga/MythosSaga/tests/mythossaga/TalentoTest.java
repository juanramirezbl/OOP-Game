package mythossaga;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TalentoTest {

    private Talento talento;

    @Before
    public void setUp() {
        talento = new Talento("Furtividad", 20, 15);
    }

    @Test
    public void testTalentoConstructor() {
        assertEquals("Furtividad", talento.getNombre());
        assertEquals((Integer) 20, talento.getAtaque());
        assertEquals((Integer) 15, talento.getDefensa());
    }

    @Test
    public void testGetNombre() {
        assertEquals("Furtividad", talento.getNombre());
    }

    @Test
    public void testSetNombre() {
        talento.setNombre("Sigilo");
        assertEquals("Sigilo", talento.getNombre());
    }

    @Test
    public void testGetAtaque() {
        assertEquals((Integer) 20, talento.getAtaque());
    }

    @Test
    public void testSetAtaque() {
        talento.setAtaque(25);
        assertEquals((Integer) 25, talento.getAtaque());
    }

    @Test
    public void testGetDefensa() {
        assertEquals((Integer) 15, talento.getDefensa());
    }

    @Test
    public void testSetDefensa() {
        talento.setDefensa(18);
        assertEquals((Integer) 18, talento.getDefensa());
    }
}
