package mythossaga;

import org.junit.Test;
import static org.junit.Assert.*;

public class DebilidadTest {

    @Test
    public void testDebilidadConstructor() {
        String nombre1 = "Fuego";
        int valor1 = 10;
        Debilidad debilidad1 = new Debilidad(nombre1, valor1);
        assertEquals(nombre1, debilidad1.getNombre());
        assertEquals(valor1, debilidad1.getValor());

        String nombre2 = "Agua";
        int valor2 = 5;
        Debilidad debilidad2 = new Debilidad(nombre2, valor2);
        assertEquals(nombre2, debilidad2.getNombre());
        assertEquals(valor2, debilidad2.getValor());
    }

    @Test
    public void testSetNombre() {
        Debilidad debilidad = new Debilidad("Fuego", 10);
        debilidad.setNombre("Agua");
        assertEquals("Agua", debilidad.getNombre());

        debilidad.setNombre("Tierra");
        assertEquals("Tierra", debilidad.getNombre());
    }

    @Test
    public void testSetValor() {
        Debilidad debilidad = new Debilidad("Fuego", 10);
        debilidad.setValor(20);
        assertEquals(20, debilidad.getValor());

        debilidad.setValor(30);
        assertEquals(30, debilidad.getValor());
    }
}
