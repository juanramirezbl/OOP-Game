package mythossaga;

import org.junit.Before;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.Assert.*;

public class DatabaseTest {

    private Database database;
    private User user1;
    private User user2;

    @Before
    public void setUp() {
        database = new Database();
        database.inicializarDatabase();
        user1 = new UsuarioJugador("nombre1", "nick1", "password1");
        user2 = new UsuarioJugador("nombre2", "nick2", "password2");
    }

    @Test
    public void testGetUsuarios() {
        HashMap<String, User> usuarios = database.getUsuarios();
        assertNotNull(usuarios);

        database.nuevoUsuario(user1);
        database.nuevoUsuario(user2);
        usuarios = database.getUsuarios();
        assertEquals(7, usuarios.size()); // 5 usuarios iniciales + 2 nuevos
    }

    @Test
    public void testGetDesafios() {
        assertNotNull(database.getDesafios());

        database.crearDesafio((UsuarioJugador) user1, (UsuarioJugador) user2, 50);
        assertEquals(3, database.getDesafios().size()); // 2 desafíos iniciales + 1 nuevo
    }

    @Test
    public void testSaveData() throws FileNotFoundException, IOException {
        database.saveData();
        database.nuevoUsuario(user1);
        database.saveData();
    }

    @Test
    public void testCheckNick() {
        database.nuevoUsuario(user1);
        boolean result1 = database.checkNick("nick1");
        assertTrue(result1);

        boolean result2 = database.checkNick("nonexistent");
        assertFalse(result2);
    }

    @Test
    public void testNuevoUsuario() {
        database.nuevoUsuario(user1);
        assertEquals(user1, database.getUsuarios().get("nick1"));

        database.nuevoUsuario(user2);
        assertEquals(user2, database.getUsuarios().get("nick2"));
    }

    @Test
    public void testEliminarUsuario() {
        database.nuevoUsuario(user1);
        database.eliminarUsuario("nick1");
        assertNull(database.getUsuarios().get("nick1"));

        database.nuevoUsuario(user2);
        database.eliminarUsuario("nick2");
        assertNull(database.getUsuarios().get("nick2"));
    }

    @Test
    public void testCheckLogIN() {
        database.nuevoUsuario(user1);
        boolean result1 = database.checkLogIN("nick1", "password1");
        assertTrue(result1);

        boolean result2 = database.checkLogIN("nick1", "wrongpassword");
        assertFalse(result2);
    }

    @Test
    public void testCrearDesafio() {
        database.getDesafios().clear();  // Asegúrate de que la lista de desafíos esté vacía antes de empezar la prueba
        UsuarioJugador desafiante1 = new UsuarioJugador("nombre1", "nick1", "password1");
        UsuarioJugador desafiado1 = new UsuarioJugador("nombre2", "nick2", "password2");
        database.crearDesafio(desafiante1, desafiado1, 100);
        assertEquals(1, database.getDesafios().size());

        UsuarioJugador desafiante2 = new UsuarioJugador("nombre3", "nick3", "password3");
        UsuarioJugador desafiado2 = new UsuarioJugador("nombre4", "nick4", "password4");
        database.crearDesafio(desafiante2, desafiado2, 200);
        assertEquals(2, database.getDesafios().size());
    }

    @Test
    public void testInicializarDatabase() {
        database.inicializarDatabase();
        assertNotNull(database.getUsuarios());
        assertNotNull(database.getDesafios());

        database.nuevoUsuario(user1);
        database.nuevoUsuario(user2);
        assertEquals(7, database.getUsuarios().size()); // 5 usuarios iniciales + 2 nuevos
    }

    @Test
    public void testGetArmas() {
        assertNotNull(database.getArmas());

        Arma arma1 = new Arma("Espada", 10, 1);
        Arma arma2 = new Arma("Hacha", 12, 2);
        database.addArmas(arma1);
        database.addArmas(arma2);
        assertTrue(database.getArmas().contains(arma1));
        assertTrue(database.getArmas().contains(arma2));
    }

    @Test
    public void testSetArmas() {
        ArrayList<Arma> armas1 = new ArrayList<>();
        database.setArmas(armas1);
        assertEquals(armas1, database.getArmas());

        ArrayList<Arma> armas2 = new ArrayList<>();
        Arma arma = new Arma("Lanza", 15, 1);
        armas2.add(arma);
        database.setArmas(armas2);
        assertEquals(armas2, database.getArmas());
    }

    @Test
    public void testAddArmas() {
        Arma arma1 = new Arma("Espada", 10, 1);
        database.addArmas(arma1);
        assertTrue(database.getArmas().contains(arma1));

        Arma arma2 = new Arma("Daga", 8, 1);
        database.addArmas(arma2);
        assertTrue(database.getArmas().contains(arma2));
    }

    @Test
    public void testGetArmaduras() {
        assertNotNull(database.getArmaduras());

        Armadura armadura1 = new Armadura("Cota de malla", 15);
        Armadura armadura2 = new Armadura("Escudo", 10);
        database.addArmaduras(armadura1);
        database.addArmaduras(armadura2);
        assertTrue(database.getArmaduras().contains(armadura1));
        assertTrue(database.getArmaduras().contains(armadura2));
    }

    @Test
    public void testSetArmaduras() {
        ArrayList<Armadura> armaduras1 = new ArrayList<>();
        database.setArmaduras(armaduras1);
        assertEquals(armaduras1, database.getArmaduras());

        ArrayList<Armadura> armaduras2 = new ArrayList<>();
        Armadura armadura = new Armadura("Armadura de cuero", 12);
        armaduras2.add(armadura);
        database.setArmaduras(armaduras2);
        assertEquals(armaduras2, database.getArmaduras());
    }

    @Test
    public void testAddArmaduras() {
        Armadura armadura1 = new Armadura("Cota de malla", 15);
        database.addArmaduras(armadura1);
        assertTrue(database.getArmaduras().contains(armadura1));

        Armadura armadura2 = new Armadura("Casco", 5);
        database.addArmaduras(armadura2);
        assertTrue(database.getArmaduras().contains(armadura2));
    }

    @Test
    public void testGetMensajesCazadores() {
        assertNotNull(database.getMensajesCazadores());

        ArrayList<String> mensajes = database.getMensajesCazadores();
        assertTrue(mensajes.size() > 0);

        // Add a message and check
        mensajes.add("Nuevo mensaje de cazador");
        database.setMensajesCazadores(mensajes);
        assertEquals("Nuevo mensaje de cazador", database.getMensajesCazadores().get(mensajes.size() - 1));
    }

    @Test
    public void testGetMensajesLicantropos() {
        assertNotNull(database.getMensajesLicantropos());

        ArrayList<String> mensajes = database.getMensajesLicantropos();
        assertTrue(mensajes.size() > 0);

        // Add a message and check
        mensajes.add("Nuevo mensaje de licantropo");
        database.setMensajesLicantropos(mensajes);
        assertEquals("Nuevo mensaje de licantropo", database.getMensajesLicantropos().get(mensajes.size() - 1));
    }

    @Test
    public void testGetMensajesVampiros() {
        assertNotNull(database.getMensajesVampiros());

        ArrayList<String> mensajes = database.getMensajesVampiros();
        assertTrue(mensajes.size() > 0);

        // Add a message and check
        mensajes.add("Nuevo mensaje de vampiro");
        database.setMensajesVampiros(mensajes);
        assertEquals("Nuevo mensaje de vampiro", database.getMensajesVampiros().get(mensajes.size() - 1));
    }
}
