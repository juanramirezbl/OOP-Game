package mythossaga;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class HumanoTest {

    private Humano humano;

    @Before
    public void setUp() {
        humano = new Humano(TypeEsbirro.humano, 2, Lealtad.ALTO);  // Ajustamos la salud a un valor permitido
    }

    @Test
    public void testHumanoConstructor() {
        assertEquals(TypeEsbirro.humano, humano.getNombre());
        assertEquals(2, humano.getSalud());  // Ajustamos el valor esperado de salud
        assertEquals(Lealtad.ALTO, humano.getLealtad());
    }

    @Test
    public void testGetLealtad() {
        assertEquals(Lealtad.ALTO, humano.getLealtad());
    }

    @Test
    public void testSetLealtad() {
        humano.setLealtad(Lealtad.BAJO);
        assertEquals(Lealtad.BAJO, humano.getLealtad());
    }

    @Test
    public void testSetNombre() {  // La lógica de setNombre no se ha definido que debería fallar, por lo tanto, dejamos esta prueba
        humano.setNombre(TypeEsbirro.ghoul);
        assertEquals(TypeEsbirro.ghoul, humano.getNombre());
    }

    @Test
    public void testSetSalud() {
        humano.setSalud(3);  // Ajustamos la salud a un valor permitido
        assertEquals(3, humano.getSalud());
    }
}
