package mythossaga;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DesafioTest {

    @Test
    public void testConstructorAndGetters() {
        UsuarioJugador desafiante = new UsuarioJugador("Juan", "juan123", "password");
        UsuarioJugador desafiado = new UsuarioJugador("Pedro", "pedro456", "password");
        int apuesta = 50;

        Desafio desafio = new Desafio(desafiante, desafiado, apuesta);

        assertEquals(desafiante, desafio.getDesafiante());
        assertEquals(desafiado, desafio.getDesafiado());
        assertEquals(apuesta, desafio.getApuesta());
        assertFalse(desafio.isTerminado());
        assertFalse(desafio.isComprobado());

        UsuarioJugador desafiante2 = new UsuarioJugador("Ana", "ana789", "password");
        UsuarioJugador desafiado2 = new UsuarioJugador("Luis", "luis012", "password");
        int apuesta2 = 100;

        Desafio desafio2 = new Desafio(desafiante2, desafiado2, apuesta2);

        assertEquals(desafiante2, desafio2.getDesafiante());
        assertEquals(desafiado2, desafio2.getDesafiado());
        assertEquals(apuesta2, desafio2.getApuesta());
        assertFalse(desafio2.isTerminado());
        assertFalse(desafio2.isComprobado());
    }

    @Test
    public void testSetters() {
        UsuarioJugador desafiante = new UsuarioJugador("Juan", "juan123", "password");
        UsuarioJugador desafiado = new UsuarioJugador("Pedro", "pedro456", "password");
        Desafio desafio = new Desafio(desafiante, desafiado, 50);

        desafio.setApuesta(100);
        desafio.setTerminado(true);
        desafio.setComprobado(true);

        assertEquals(100, desafio.getApuesta());
        assertTrue(desafio.isTerminado());
        assertTrue(desafio.isComprobado());

        desafio.setApuesta(200);
        desafio.setTerminado(false);
        desafio.setComprobado(false);

        assertEquals(200, desafio.getApuesta());
        assertFalse(desafio.isTerminado());
        assertFalse(desafio.isComprobado());
    }
}
