package mythossaga;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

public class PersonajeTest {

    private Personaje personaje;

    @BeforeEach
    public void setUp() {
        personaje = new Personaje("Heroe", 100, 50) {
            @Override
            public int getValorAtaqueEquipoActivo() {
                return super.getValorAtaqueEquipoActivo();
            }

            @Override
            public int getValorDefensaEquipoActivo() {
                return super.getValorDefensaEquipoActivo();
            }
        };
    }

    @Test
    public void testConstructor() {
        assertEquals("Heroe", personaje.getNombre());
        assertEquals(100, personaje.getSalud());
        assertEquals(50, personaje.getPoder());
        assertEquals(100, personaje.getOro()); // Verifica si el oro inicial es 100
        assertNotNull(personaje.getArmas());
        assertNotNull(personaje.getArmaduras());
        assertNotNull(personaje.getDebilidad());
        assertNotNull(personaje.getFortaleza());
        assertNotNull(personaje.getEsbirros());
    }

    @Test
    public void testSetNombre() {
        personaje.setNombre("Guerrero");
        assertEquals("Guerrero", personaje.getNombre());
    }

    @Test
    public void testAddArmas() {
        Arma espada = new Arma("Espada", 10, 1);
        personaje.addArmas(espada);
        assertEquals(espada, personaje.getArmas().get("Espada"));
    }

    @Test
    public void testAddArmadura() {
        Armadura escudo = new Armadura("Escudo", 5);
        personaje.addArmadura(escudo);
        assertEquals(escudo, personaje.getArmaduras().get("Escudo"));
    }

    @Test
    public void testSetArmaActiva() {
        Arma espada = new Arma("Espada", 10, 1);
        personaje.setArmaActiva(espada);
        assertEquals(espada, personaje.getArmaActiva()[0]);
    }

    @Test
    public void testSetArmaduraActiva() {
        Armadura escudo = new Armadura("Escudo", 5);
        personaje.setArmaduraActiva(escudo);
        assertEquals(escudo, personaje.getArmaduraActiva());
    }

    @Test
    public void testSetSalud() {
        personaje.setSalud(80);
        assertEquals(80, personaje.getSalud());
    }

    @Test
    public void testSetDebilidad() {
        ArrayList<Modificador> debilidades = new ArrayList<>();
        Debilidad debilidad = new Debilidad("Fuego", 10);
        debilidades.add(debilidad);
        personaje.setDebilidad(debilidades);
        assertEquals(debilidades, personaje.getDebilidad());
    }

    @Test
    public void testSetFortaleza() {
        ArrayList<Modificador> fortalezas = new ArrayList<>();
        Fortaleza fortaleza = new Fortaleza("Resistencia", 10);
        fortalezas.add(fortaleza);
        personaje.setFortaleza(fortalezas);
        assertEquals(fortalezas, personaje.getFortaleza());
    }

    @Test
    public void testSetOro() {
        personaje.setOro(200);
        assertEquals(200, personaje.getOro());
    }

    @Test
    public void testSetPoder() {
        personaje.setPoder(60);
        assertEquals(60, personaje.getPoder());
    }

    @Test
    public void testAddEsbirro() {
        Esbirro esbirro = new Humano(TypeEsbirro.humano, 100, Lealtad.ALTO);
        personaje.addEsbirro(esbirro);
        assertEquals(esbirro, personaje.getEsbirros().get(0));
    }

    @Test
    public void testGetValorAtaqueEquipoActivo() {
        Arma espada = new Arma("Espada", 10, 1);
        personaje.setArmaActiva(espada);
        assertEquals(10, personaje.getValorAtaqueEquipoActivo());
    }

    @Test
    public void testGetValorDefensaEquipoActivo() {
        Armadura escudo = new Armadura("Escudo", 5);
        personaje.setArmaduraActiva(escudo);
        assertEquals(5, personaje.getValorDefensaEquipoActivo());
    }
}
