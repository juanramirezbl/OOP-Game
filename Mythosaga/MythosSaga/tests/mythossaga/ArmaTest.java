package mythossaga;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ArmaTest {

    private Arma arma1;
    private Arma arma2;

    @Before
    public void setUp() {
        arma1 = new Arma("Espada", 10, 1);
        arma2 = new Arma("Hacha", 15, 2);
    }

    @Test
    public void testArmaConstructor() {
        // Caso 1
        assertEquals("Espada", arma1.getNombre());
        assertEquals(10, arma1.getModificador());
        assertEquals(1, arma1.getManos());

        // Caso 2
        assertEquals("Hacha", arma2.getNombre());
        assertEquals(15, arma2.getModificador());
        assertEquals(2, arma2.getManos());
    }

    @Test
    public void testGetValorAtaque() {
        // Caso 1
        assertEquals(10, arma1.getValorAtaque());

        // Caso 2
        assertEquals(15, arma2.getValorAtaque());
    }

    @Test
    public void testGetValorDefensa() {
        // Caso 1
        assertEquals(0, arma1.getValorDefensa());

        // Caso 2
        assertEquals(0, arma2.getValorDefensa());
    }

    @Test
    public void testToString() {
        // Caso 1
        String expected1 = "Nombre: Espada, Modificador de ataque: 10, Manos ocupadas: 1";
        assertEquals(expected1, arma1.toString());

        // Caso 2
        String expected2 = "Nombre: Hacha, Modificador de ataque: 15, Manos ocupadas: 2";
        assertEquals(expected2, arma2.toString());
    }
}
