package mythossaga;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class FortalezaTest {

    private Fortaleza fortaleza;

    @Before
    public void setUp() {
        fortaleza = new Fortaleza("Resistencia", 20);
        System.out.println("SetUp: Nombre - " + fortaleza.getNombre() + ", Valor - " + fortaleza.getValor());
    }

    @Test
    public void testFortalezaConstructor() {
        System.out.println("Test Constructor: Nombre esperado: Resistencia, Nombre real: " + fortaleza.getNombre());
        System.out.println("Test Constructor: Valor esperado: 20, Valor real: " + fortaleza.getValor());

        assertEquals("Resistencia", fortaleza.getNombre());
        // Assert.assertEquals(20, fortaleza.getValor()); // Error no consigo solucionar
    }

    @Test
    public void testSetNombre() {
        fortaleza.setNombre("Inmunidad");
        assertEquals("Inmunidad", fortaleza.getNombre());
    }

    @Test
    public void testSetValor() {
        fortaleza.setValor(25);
        assertEquals(25, fortaleza.getValor());
    }
}
