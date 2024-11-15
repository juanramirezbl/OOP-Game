package mythossaga;

import mythossaga.Database;
import mythossaga.UsuarioJugador;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

public class UsuarioJugadorTest {

    private UsuarioJugador usuario;

    @BeforeEach
    public void setUp() {
        usuario = new UsuarioJugador("Juan", "juan123", "password");
    }

    @Test
    public void testGenerarNumeroRegistro_CorrectFormat() {
        // Directly accessing a private method is not possible without reflection or making the method package-private/protected for the sake of testing
        String numeroRegistro = usuario.getNumeroRegistro();
        assertTrue(numeroRegistro.startsWith("L") && numeroRegistro.length() == 5);
    }

    @Test
    public void testMenuGestionarPersonajes_InputHandling() {
        // Prepare inputs as if they were typed by a user
        String input = "3"; // Opción para salir del menú
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        Scanner scanner = new Scanner(System.in);
        usuario.menuGestionarPersonajes(scanner, new Database());

        // Assert some state or behavior if possible
        assertNull(usuario.getPersonaje()); // Assuming no character is registered with input "3"
        scanner.close();
    }

    @AfterEach
    public void restoreSystemIn() {
        System.setIn(System.in);
    }
}
