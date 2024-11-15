package mythossaga;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class OperadorTest {

    private Operador operador;

    @BeforeEach
    public void setUp() {
        operador = new Operador("Juan", "juan123", "password123");
    }

    @Test
    public void testConstructor() {
        assertNotNull(operador);
        assertEquals("Juan", operador.getNombre());
        assertEquals("juan123", operador.getNick());
        assertEquals("password123", operador.getPassword());
    }

    @Test
    public void testSetNombre() {
        operador.setNombre("Carlos");
        assertEquals("Carlos", operador.getNombre());
    }

    @Test
    public void testSetNick() {
        operador.setNick("carlos123");
        assertEquals("carlos123", operador.getNick());
    }

    @Test
    public void testSetPassword() {
        operador.setPassword("newpassword123");
        assertEquals("newpassword123", operador.getPassword());
    }

    @Test
    public void testToString() {
        String expectedString = "Nombre: Juan Nick: juan123";
        assertEquals(expectedString, operador.toString());
    }
}
