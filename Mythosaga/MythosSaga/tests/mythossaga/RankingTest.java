package mythossaga;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

public class RankingTest {

    private Ranking ranking;
    private UsuarioJugador jugador;

    @BeforeEach
    public void setUp() {
        jugador = new UsuarioJugador("Carlos", "carlos123", "password123");
        jugador.setPersonaje(new Licantropo("Lobo", new HashMap<>(), new Arma[2], new HashMap<>(), null, 100, new ArrayList<>(), new ArrayList<>(), 200, 50, new ArrayList<>(), 20));
        ranking = new Ranking(jugador);
    }

    @Test
    public void testConstructor() {
        assertNotNull(ranking);
        assertEquals(jugador, ranking.getJugador());
        assertEquals(0, ranking.getCombateGanados());
        assertEquals(0, ranking.getCombatesJugados());
    }

    @Test
    public void testSetCombateGanados() {
        ranking.setCombateGanados(5);
        assertEquals(5, ranking.getCombateGanados());
    }

    @Test
    public void testAddCombateGanados() {
        ranking.addCombateGanados();
        assertEquals(1, ranking.getCombateGanados());
    }

    @Test
    public void testSetCombatesJugados() {
        ranking.setCombatesJugados(10);
        assertEquals(10, ranking.getCombatesJugados());
    }

    @Test
    public void testAddCombateJugados() {
        ranking.addCombateJugados();
        assertEquals(1, ranking.getCombatesJugados());
    }

    @Test
    public void testGetRatio() {
        ranking.setCombateGanados(5);
        ranking.setCombatesJugados(10);
        assertEquals(0.5f, ranking.getRatio());
    }

    @Test
    public void testToString() {
        String expectedString = "Nick: carlos123 || Combates Jugados: 0  || Combates Ganados: 0  || Oro del Personaje: 200.0";
        assertEquals(expectedString, ranking.toString());
    }
}
