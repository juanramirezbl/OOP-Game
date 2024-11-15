package mythossaga;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Date;
import java.util.Random;
import mythossaga.Combate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CombateTest {

    private Combate combate1;
    private Combate combate2;
    private Database database;
    private Desafio desafio;

    @BeforeEach
    public void setUp() {
        database = new Database();
        database.inicializarDatabase();

        combate1 = new Combate(new Vampiro("Willy"), new Cazador("Nano"), 20, 17, new Date());
        combate2 = new Combate(new Licantropo("Lobo", 3, 4, 5), new Cazador("Hunter", 4, 5), 3, 4, new Date());

        desafio = new Desafio(new UsuarioJugador("Fer", "Fernando", "1234"), new UsuarioJugador("Guille", "Willy", "1234"), 20);
    }

    @Test
    public void testCombateConstructor() {
        // Caso 1
        assertEquals("Willy", combate1.getDesafiante().getNombre());
        assertEquals("Nano", combate1.getDesafiado().getNombre());
        assertEquals(20, combate1.getDesafiante().getSalud());
        assertEquals(17, combate1.getDesafiado().getSalud());

        // Caso 2
        assertEquals("Lobo", combate2.getDesafiante().getNombre());
        assertEquals("Hunter", combate2.getDesafiado().getNombre());
        assertEquals(3,  combate2.getDesafiante().getSalud());
        assertEquals(4,  combate2.getDesafiado().getSalud());
    }

    @Test
    public void testCalcularExitos() {
        // Caso 1
        int exitos1 = combate1.calcularExitos(5);
        assertTrue(exitos1 >= 0 && exitos1 <= 5);

        // Caso 2
        int exitos2 = combate2.calcularExitos(10);
        assertTrue(exitos2 >= 0 && exitos2 <= 10);
    }


    @Test
    public void testJugarRonda() {
        combate1.jugarRonda(desafio, database);

        assertNotEquals(20, combate1.getDesafiante().getSalud());
        assertNotEquals(17, combate1.getDesafiado().getSalud());
    }

    @Test
    public void testTerminarCombate() {
        combate1.getDesafiante().getSalud();
        combate1.terminarCombate(desafio);

        assertNotNull(combate1.getVencedor());
    }


    @Test
    public void testCalcularSaludEsbirros() {
        int saludEsbirros1 = combate1.calcularSaludEsbirros(combate1.getDesafiante());
        int saludEsbirros2 = combate2.calcularSaludEsbirros(combate2.getDesafiante());

        assertTrue(saludEsbirros1 >= 0);
        assertTrue(saludEsbirros2 >= 0);
    }

    @Test
    public void testMensaje() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);

        combate1.mensaje(combate1.getDesafiante(), database);

        System.setOut(System.out);
        String salidaPantalla = outputStream.toString().trim();
        assertFalse(salidaPantalla.isEmpty());
    }
}
