package mythossaga;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DisciplinaTest {

    private Disciplina disciplina;

    @Before
    public void setUp() {
        disciplina = new Disciplina("Ofuscación", 10, 5, 20);
    }

    @Test
    public void testDisciplinaConstructor() {
        assertEquals("Ofuscación", disciplina.getNombre());
        assertEquals((Integer) 10, disciplina.getAtaque());
        assertEquals((Integer) 5, disciplina.getDefensa());
        assertEquals((Integer) 20, disciplina.getCostePuntosSangre());
    }

    @Test
    public void testGetCostePuntosSangre() {
        assertEquals((Integer) 20, disciplina.getCostePuntosSangre());
    }

    @Test
    public void testSetCostePuntosSangre() {
        disciplina.setCostePuntosSangre(30);
        assertEquals((Integer) 30, disciplina.getCostePuntosSangre());
    }

    @Test
    public void testSetNombre() {
        disciplina.setNombre("Dominación");
        assertEquals("Dominación", disciplina.getNombre());
    }

    @Test
    public void testSetAtaque() {
        disciplina.setAtaque(15);
        assertEquals((Integer) 15, disciplina.getAtaque());
    }

    @Test
    public void testSetDefensa() {
        disciplina.setDefensa(7);
        assertEquals((Integer) 7, disciplina.getDefensa());
    }
}
