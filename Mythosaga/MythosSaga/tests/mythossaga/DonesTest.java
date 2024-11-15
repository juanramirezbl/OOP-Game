package mythossaga;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DonesTest {

    private Dones dones;

    @Before
    public void setUp() {
        dones = new Dones("Furia", 15, 10, 5);
    }

    @Test
    public void testDonesConstructor() {
        assertEquals("Furia", dones.getNombre());
        assertEquals((Integer) 15, dones.getAtaque());
        assertEquals((Integer) 10, dones.getDefensa());
        assertEquals((Integer) 5, dones.getRabiaMinima());
    }

    @Test
    public void testGetRabiaMinima() {
        assertEquals((Integer) 5, dones.getRabiaMinima());
    }

    @Test
    public void testSetRabiaMinima() {
        dones.setRabiaMinima(8);
        assertEquals((Integer) 8, dones.getRabiaMinima());
    }

    @Test
    public void testSetNombre() {
        dones.setNombre("Ira");
        assertEquals("Ira", dones.getNombre());
    }

    @Test
    public void testSetAtaque() {
        dones.setAtaque(20);
        assertEquals((Integer) 20, dones.getAtaque());
    }

    @Test
    public void testSetDefensa() {
        dones.setDefensa(12);
        assertEquals((Integer) 12, dones.getDefensa());
    }
}
