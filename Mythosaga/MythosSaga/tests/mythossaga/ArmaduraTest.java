package mythossaga;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ArmaduraTest {

    private Armadura armadura1;
    private Armadura armadura2;

    @Before
    public void setUp() {
        armadura1 = new Armadura("Cota de malla", 15);
        armadura2 = new Armadura("Escudo de hierro", 20);
    }

    @Test
    public void testArmaduraConstructor() {
        // Caso 1
        assertEquals("Cota de malla", armadura1.getNombre());
        assertEquals(15, armadura1.getModificador());

        // Caso 2
        assertEquals("Escudo de hierro", armadura2.getNombre());
        assertEquals(20, armadura2.getModificador());
    }

    @Test
    public void testGetValorAtaque() {
        // Caso 1
        assertEquals(0, armadura1.getValorAtaque());

        // Caso 2
        assertEquals(0, armadura2.getValorAtaque());
    }

    @Test
    public void testGetValorDefensa() {
        // Caso 1
        assertEquals(15, armadura1.getValorDefensa());

        // Caso 2
        assertEquals(20, armadura2.getValorDefensa());
    }

    @Test
    public void testToString() {
        // Caso 1
        String expected1 = "Nombre: Malla, Modificador de defensa: 15";
        assertEquals(expected1, armadura1.toString());

        // Caso 2
        String expected2 = "Nombre: Escudo de hierro, Modificador de defensa: 20";
        assertEquals(expected2, armadura2.toString());
    }
}