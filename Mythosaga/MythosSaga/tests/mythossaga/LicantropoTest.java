package mythossaga;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LicantropoTest {

    public LicantropoTest() {
    }

    @Test
    public void testGetRabia() {
        // Creación del personaje Licantropo con datos iniciales
        Integer rabiaInicial = 50; // Valor inicial de rabia para el Licantropo
        Licantropo instance = new Licantropo(
                "GuerreroLunar", // nombre del Licantropo
                new HashMap<>(), // HashMap de armas
                new Arma[10], // Arreglo de armas activas
                new HashMap<>(), // HashMap de armaduras
                new Armadura("Cota de Mallas", 4), // Armadura activa
                2, // salud dentro del rango permitido
                new ArrayList<>(), // Lista de debilidades
                new ArrayList<>(), // Lista de fortalezas
                100, // oro
                20, // poder
                new ArrayList<>(), // Lista de esbirros
                rabiaInicial // rabia
        );

        assertEquals(rabiaInicial, instance.getRabia());
        instance.setRabia(1);
        assertEquals(1, instance.getRabia());
    }

    @Test
    public void testSetRabia() {
        // Creación del personaje Licantropo con datos iniciales
        Integer rabiaInicial = 50; // Valor inicial de rabia para el Licantropo
        Licantropo instance = new Licantropo(
                "GuerreroLunar", // nombre del Licantropo
                new HashMap<>(), // HashMap de armas
                new Arma[10], // Arreglo de armas activas
                new HashMap<>(), // HashMap de armaduras
                new Armadura("Cota de Mallas", 4), // Armadura activa
                2, // salud dentro del rango permitido
                new ArrayList<>(), // Lista de debilidades
                new ArrayList<>(), // Lista de fortalezas
                100, // oro
                20, // poder
                new ArrayList<>(), // Lista de esbirros
                rabiaInicial // rabia
        );

        instance.setRabia(1);
        assertEquals(1, instance.getRabia());

        instance.setRabia(70);
        assertEquals(70, instance.getRabia());
    }
}
