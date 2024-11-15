package mythossaga;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EsbirroTest {

    @Test
    void getNombreEsbirroDemonio() {
        Esbirro esbirro = new Demonio(TypeEsbirro.demonio, 3, "Ofrezco poder y gloria a cambio de tu alma");

        assertEquals(TypeEsbirro.demonio, esbirro.getNombre());
        assertNotEquals(TypeEsbirro.humano, esbirro.getNombre());
    }

    @Test
    void lealtadEsbirro() {
        Humano esbirro = new Humano(TypeEsbirro.humano, 2, Lealtad.ALTO);
        assertInstanceOf(Humano.class, esbirro);
        Lealtad l = esbirro.getLealtad();
        assertNotEquals(Lealtad.NORMAL, l);
    }

    @Test
    void dependenciaEsbirro() {
        Ghoul esbirro = new Ghoul(TypeEsbirro.ghoul, 1, 3);
        assertInstanceOf(Ghoul.class, esbirro);
        // Corrección
        assertEquals(3, esbirro.getDependencia());
    }
}
