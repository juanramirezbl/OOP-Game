/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mythossaga;

import com.sun.security.auth.UnixNumericUserPrincipal;

import java.io.IOException;
import java.util.*;
import java.util.Date;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Sistema {

    public User userActivo;
    static transient Scanner scanner = new Scanner(System.in);
    private HashMap<String, User> usuarios;

    private HashMap<String, Ranking> ranking;
    public Sistema(){
        this.ranking = new HashMap<>();
    }
    public void menuInicio(Database database) throws IOException {
        int opcion = 0;
        usuarios = database.getUsuarios();
        while (opcion != 3) {
            System.out.println("-----------------------");
            System.out.println("  MYTHOSSAGA ");
            System.out.println("-----------------------");
            System.out.println("Introduzca 1 para registrarse");
            System.out.println("Introduzca 2 para iniciar sesion");
            System.out.println("Introduzca 3 para salir del sistema");
            opcion = scanner.nextInt();
            if (opcion == 1) {
                registro(database);
            } else if (opcion == 2) {
                login(database);
            }
        }
        System.out.println("Hasta luego rey");
        scanner.close();
    }

    private void registro(Database data) {
        System.out.println("Introduce tu nick: ");
        String nick = scanner.next();
        if (!usuarios.containsKey(nick)) {
            System.out.println("Introduce tu nombre de usuario: ");
            String usuario = scanner.next();
            System.out.println("Introduce tu contraseña: ");
            String contrasena = scanner.next();
            User user = new UsuarioJugador(usuario, nick, contrasena);
            usuarios.put(nick, user);
            this.userActivo = user;
            menuUsuario(data);
        } else {
            System.out.println("Ese nick de usuario ya esta cogido");
        }
    }

    private void login(Database data) {
        System.out.print("Introduce el nick: ");
        String nick = scanner.next();
        System.out.print("Introduce la contraseña: ");
        String contrasena = scanner.next();
        if (usuarios.containsKey(nick) && usuarios.get(nick).getPassword().equals(contrasena)) { //puede que se pueda quitar la primera condicion del if
            System.out.println("Te has logeado correctamente en la aplicación");
            userActivo = usuarios.get(nick);
            if (userActivo instanceof UsuarioJugador) {
                if (((UsuarioJugador) userActivo).isBloqueado()) {
                    System.out.println("Se le ha bloqueado la entrada al sistema");
                } else {
                    menuUsuario(data);
                }
            } else {
                menuOperadores(data);
            }
        } else {
            System.out.println("Nombre de usuario o contraseña incorrecto");
        }
    }

    public void menuOperadores(Database data) {
        HashMap<String, User> usuarios = data.getUsuarios();
        ArrayList<Desafio> desafios = data.getDesafios();
        int opcion;

        do {
            System.out.println("\nMenu Operador");
            System.out.println("Introduzca 0 para ver los usuarios");
            System.out.println("Introduzca 1 para editar personaje");
            System.out.println("Introduzca 2 para añadir items al personaje");
            System.out.println("Introduzca 3 para validar desafios");
            System.out.println("Introduzca 4 para bloquear usuarios");
            System.out.println("Introduzca 5 para desbloquear usuarios");
            System.out.println("Introduzca 6 para darse de baja");
            System.out.println("Introduzca 7 para salir");
            opcion = scanner.nextInt();
            switch (opcion) {
                case 0:
                    data.printUsuariosOperador();
                    break;
                case 1:
                    System.out.println("Editando personaje");
                    editarPersonaje(usuarios);
                    break;
                case 2:
                    System.out.println("Añadiendo items");
                    anadirItems(usuarios, data);
                    break;
                case 3:
                    validarDesafios(desafios);
                    break;
                case 4:
                    System.out.println("Introduce el nick de un usuario que quieras bloquear");
                    String nombre = scanner.next();
                    if (usuarios.containsKey(nombre)) {
                        User user = usuarios.get(nombre);
                        if (user instanceof UsuarioJugador) {
                            ((UsuarioJugador) user).setBloqueado(true);
                            System.out.println("Usuario bloqueado");
                        } else {
                            System.out.println("No se puede bloquear a un operador");
                        }
                    } else {
                        System.out.println("No se encuentra a ese usuario");
                    }
                    break;
                case 5:
                    System.out.println("Usuarios bloqueados");
                    for (User u : usuarios.values()) {
                        if (u instanceof UsuarioJugador) {
                            if (((UsuarioJugador) u).isBloqueado()) {
                                System.out.println(u.getNombre());
                            }
                        }
                    }
                    System.out.println("Introduce el nick de un usuario que quieras desbloquear");
                    String n = scanner.next();
                    if (usuarios.containsKey(n)) {
                        User user = usuarios.get(n);
                        if (user instanceof UsuarioJugador) {
                            ((UsuarioJugador) user).setBloqueado(false);
                            System.out.println("Usuario desbloqueado");
                        }
                    } else {
                        System.out.println("No se encuentra a ese usuario");
                    }
                    break;
                case 6:
                    System.out.println("Introduzca 'SI' si desea confirmar que se da de baja");
                    String confirmacion = scanner.next();
                    if (Objects.equals(confirmacion, "SI")) {
                        System.out.println("Dándose de baja...");
                        System.out.println(userActivo.getNombre() + " ya no existe");
                        usuarios.remove(userActivo.getNick());
                        opcion = 5;
                    } else {
                        System.out.println("No se ha dado de baja");
                    }
                    break;
                case 7:
                    System.out.println("Cerrando sesion...");
                    break;
                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        } while (opcion != 7);
    }

    private void anadirItems(HashMap<String, User> usuarios, Database data) {
        System.out.print("Introduzca el nick del usuario al que deseas modificar su personaje: ");
        String nick = scanner.next();
        if (usuarios.containsKey(nick)) {
            User user = usuarios.get(nick);
            if (user instanceof UsuarioJugador) {
                System.out.println("Seleccione qué desea añadir al personaje:");
                System.out.println("1. Armas");
                System.out.println("2. Armaduras");
                System.out.println("3. Fortaleza");
                System.out.println("4. Debilidad");
                System.out.println("5. Esbirros");
                System.out.println("0. Salir");

                int opcion = scanner.nextInt();

                switch (opcion) {
                    case 1:
                        System.out.println("Introduzca el nombre del arma");
                        String nombreArma = scanner.next();
                        System.out.println("Introduzca el modificador de ataque del arma");
                        int modificadorAtaque = scanner.nextInt();
                        System.out.println("Introduzca las manos del arma");
                        int manos = scanner.nextInt();
                        Arma newArma = new Arma(nombreArma, modificadorAtaque, manos);
                        ((UsuarioJugador) user).getPersonaje().addArmas(newArma);
                        data.addArmas(newArma);
                        System.out.println("Arma añadida correctamente");
                        break;
                    case 2:
                        System.out.println("Introduzca el nombre de la armadura");
                        String nombreArmadura = scanner.next();
                        System.out.println("Introduzca el modificador de defensa de la armadura");
                        int modifcadorDefensa = scanner.nextInt();
                        Armadura newArmadura = new Armadura(nombreArmadura, modifcadorDefensa);
                        ((UsuarioJugador) user).getPersonaje().addArmadura(newArmadura);
                        data.addArmaduras(newArmadura);
                        System.out.println("Armadura añadida correctamente");
                        break;
                    case 3:
                        System.out.println("Introduzca el nombre de la debilidad");
                        String nombreDebilidad = scanner.next();
                        System.out.println("Introduzca el valor de la debilidad");
                        int valorDebilidad = scanner.nextInt();
                        Debilidad newDebilidad = new Debilidad(nombreDebilidad, valorDebilidad);
                        ((UsuarioJugador) user).getPersonaje().getDebilidad().add(newDebilidad);
                        System.out.println("Debilidad añadida correctamente");
                        break;
                    case 4:
                        System.out.println("Introduzca el nombre de la fortaleza");
                        String nombreFortaleza = scanner.next();
                        System.out.println("Introduzca el valor de la fortaleza");
                        int valorFortaleza = scanner.nextInt();
                        Fortaleza newFortaleza = new Fortaleza(nombreFortaleza, valorFortaleza);
                        ((UsuarioJugador) user).getPersonaje().getFortaleza().add(newFortaleza);
                        System.out.println("Fortaleza añadida correctamente");
                        break;
                    case 5:
                        System.out.println("Escoja el tipo de esbirro");
                        System.out.println("1.Humano\n2.Ghouls\n3.Demonios");
                        int typeEsbirro = scanner.nextInt();
                        System.out.println("Introduzca la salud del esbirro");
                        int saludEsbirro = scanner.nextInt();
                        switch (typeEsbirro){
                            case 1:
                                if(((UsuarioJugador) user).getPersonaje() instanceof Vampiro){
                                    System.out.println("Un vampiro no puede crear esbirros humanos");
                                } else{
                                System.out.println("Escoja la lealtad del humano");
                                System.out.println("1.Alta\n2.normal\n3.Baja");
                                int lealtad = scanner.nextInt();
                                switch (lealtad) {
                                    case 1:
                                        ((UsuarioJugador) user).getPersonaje().addEsbirro(new Humano(TypeEsbirro.humano, saludEsbirro, Lealtad.ALTO));
                                        break;
                                    case 2:
                                        ((UsuarioJugador) user).getPersonaje().addEsbirro(new Humano(TypeEsbirro.humano, saludEsbirro, Lealtad.NORMAL));
                                        break;
                                    case 3:
                                        ((UsuarioJugador) user).getPersonaje().addEsbirro(new Humano(TypeEsbirro.humano, saludEsbirro, Lealtad.BAJO));
                                        break;
                                }
                                }
                            case 2:
                                System.out.println("Introduzca la dependencia del ghoul entre 1 y 5");
                                int dependencia = scanner.nextInt();
                                ((UsuarioJugador) user).getPersonaje().addEsbirro(new Ghoul(TypeEsbirro.ghoul, saludEsbirro, dependencia));
                                break;
                            case 3:
                                System.out.println("Se necesita un pacto entre tu esbirro demonio y tu, escriba: ");
                                String pacto = scanner.next();
                                ((UsuarioJugador) user).getPersonaje().addEsbirro(new Demonio(TypeEsbirro.demonio, saludEsbirro, pacto));
                                break;
                        }
                        break;
                    case 0:
                        System.out.println("Saliendo del menú...");
                        break;
                    default:
                        System.out.println("Opción no válida. Por favor, seleccione una opción del menú.");
                        break;
                }
            }
        } else {
            System.out.println("No se encuentra a ese usuario");
        }
    }

    private void editarPersonaje(HashMap<String, User> usuarios) {
        System.out.print("Introduzca el nick del usuario al que deseas modificar su personaje: ");
        String nick = scanner.next();
        if (usuarios.containsKey(nick)) {
            User user = usuarios.get(nick);
            if (user instanceof UsuarioJugador) {
                Personaje personaje = ((UsuarioJugador) user).getPersonaje();
                System.out.println("Introduce los campos que deseas modificar, sino pulse enter");
                System.out.println("Oro actual " + personaje.getOro() + ", nuevo oro: ");
                if (scanner.hasNextInt()) {
                    int nuevoOro = scanner.nextInt();
                    personaje.setOro(nuevoOro);
                    System.out.println("Oro cambiado correctamente");
                } else {
                    scanner.next(); // Consumir la entrada incorrecta (no es un entero)
                    System.out.println("No has introducido un número válido.");
                }
                System.out.println("Salud actual " + personaje.getSalud() + ", nueva salud: ");
                if (scanner.hasNextInt()) {
                    int nuevaSalud = scanner.nextInt();
                    personaje.setSalud(nuevaSalud);
                    System.out.println("Salud cambiada correctamente");
                } else {
                    scanner.next(); // Consumir la entrada incorrecta (no es un entero)
                    System.out.println("No has introducido un número válido.");
                }
                System.out.println("Poder actual " + personaje.getPoder() + ", nuevo poder: ");
                if (scanner.hasNextInt()) {
                    int nuevoPoder = scanner.nextInt();
                    personaje.setPoder(nuevoPoder);
                    System.out.println("Poder cambiado correctamente");
                } else {
                    scanner.next(); // Consumir la entrada incorrecta (no es un entero)
                    System.out.println("No has introducido un número válido.");
                }
                System.out.println("Armadura actual " + personaje.getArmaduraActiva() + ", nueva armadura: ");
                String acarreo = scanner.nextLine();
                String input = scanner.nextLine();
                if (!input.isEmpty()) {
                    try {
                        if (personaje.getArmaduras().containsKey(input)) {
                            personaje.setArmaduraActiva(personaje.getArmaduras().get(input));
                            System.out.println("Armadura cambiada correctamente");
                        } else {
                            System.out.println("El personaje no tiene esa armadura");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Entrada no válida. Por favor, introduce un número.");
                    }
                } else {
                    System.out.println("No has introducido ningún valor. Se mantendrá la armadura actual.");
                }
                //Falta el arma
            }
        } else {
            System.out.println("No se encuentra a ese usuario");
        }
    }

    private static void validarDesafios(ArrayList<Desafio> desafios) {
        boolean desafioValidable = false;
        for (Desafio d : desafios) {
            if (!d.isComprobado()) {
                desafioValidable = true;
                System.out.println("Desafiante: " + d.getDesafiante().getNombre());
                System.out.println("Desafiado: " + d.getDesafiado().getNombre());
                System.out.println("Oro apostado: " + d.getApuesta());

                System.out.println("Si quieres validar introduce 'VALIDAR'");
                if (scanner.next().equals("VALIDAR")) {
                    d.setComprobado(true);
                    System.out.println("Desafio validado");
                }
            }
        }
        if (!desafioValidable) {
            System.out.println("No hay desafios por validar");
        }
    }

    public void menuUsuario(Database data) {
        HashMap<String, User> usuarios = data.getUsuarios();
        ArrayList<Desafio> desafios = data.getDesafios();
        int opcion;
        UsuarioJugador userDesafiado = (UsuarioJugador) userActivo;
        for (Desafio desafio : desafios) {
            if (desafio.isComprobado() && Objects.equals(desafio.getDesafiado().getNombre(),userDesafiado.getNombre())&& !(desafio.isTerminado())) {
                System.out.println("Tienes un desafio pendiente de " + desafio.getDesafiante().getNombre());
                System.out.println("Si desea aceptarlo escriba 1, escriba 2 para rechazarlo");
                String accept = scanner.next();
                if (Objects.equals(accept, "1")) {
                    iniciarCombate(desafio, usuarios, data);
                } else {
                    desafio.setTerminado(true);
                    double oro = 0.1 * desafio.getApuesta();
                    User desafiante = desafio.getDesafiante();
                    UsuarioJugador desafianteJugador = (UsuarioJugador) desafiante;
                    desafianteJugador.actualizarOro(oro);
                    User desafiado = desafio.getDesafiado();
                    UsuarioJugador desafiadoJugador = (UsuarioJugador) desafiado;
                    desafiadoJugador.actualizarOro(-oro);
                }
            }
        }
        do {
            System.out.println("\nMenu");
            System.out.println("Introduzca 1 para gestionar personaje");
            if (((UsuarioJugador) userActivo).getPersonaje() != null){
                System.out.println("Introduzca 2 para gestionar desafios");
            }
            System.out.println("Introduzca 3 para consultar estadísticas");
            System.out.println("Introduzca 4 para consultar historial");
            System.out.println("Introduzca 5 para darse de baja");
            System.out.println("Introduzca 6 para cerrar sesión");
            opcion = scanner.nextInt();
            switch (opcion) {
                case 1:
                    System.out.println("Gestionando personaje...");
                    userActivo.menuGestionarPersonajes(scanner, data);
                    break;
                case 2:
                    if (((UsuarioJugador) userActivo).getPersonaje() == null){
                        System.out.println("No tienes personaje no puedes desafiar");
                    } else {
                        System.out.println("Gestionando desafíos...");
                        if (userActivo.comprobarPersonajes()) {
                            gestionarDesafios(data);
                        } else {
                            System.out.println("No hay personajes creados, no se puede desafiar");
                        }
                    }
                    break;
                case 3:
                    System.out.println("Consultando estadísticas...");
                    List<Ranking> listaOrdenada = ranking.values()
                            .stream()
                            .sorted(Comparator.comparingDouble(Ranking::getRatio).reversed())
                            .toList();

                    System.out.println("Se mostraran a continuacion el ranking de jugadores ordenados por mejor ratio de combates ganados/peleados");
                    int i = 0;
                    for (Ranking r : listaOrdenada) {
                        i++;
                        System.out.println(i + ". " + r);
                    }
                    break;
                case 4:
                    System.out.println("Historial de combates:");
                    System.out.println("\nAtaques: ");
                    int oroGanado = 0;
                    int oroPerdido = 0;
                    for (Desafio desafio: desafios)
                    {
                        if (desafio.isTerminado() && desafio.getDesafiante() == userActivo){
                            System.out.println("\n--------------------------------");
                            System.out.println("Desafiante: " + desafio.getDesafiante().getNombre());
                            System.out.println("Desafiante: " + desafio.getDesafiado().getNombre());
                            System.out.println("\nGanador: " + desafio.getCombate().getVencedor().getNombre());
                            System.out.println("Oro apostado: " + desafio.getApuesta());
                            System.out.println("--------------------------------");

                            if (desafio.getCombate().getVencedor() == ((UsuarioJugador) userActivo).getPersonaje())
                                oroGanado += desafio.getApuesta();
                            else
                                oroPerdido += desafio.getApuesta();
                        }
                    }

                    System.out.println("\nDefensas: ");
                    for (Desafio desafio: desafios)
                    {
                        if (desafio.isTerminado() && desafio.getDesafiado() == userActivo){
                            System.out.println("\n--------------------------------");
                            System.out.println("Desafiante: " + desafio.getDesafiante().getNombre());
                            System.out.println("Desafiante: " + desafio.getDesafiado().getNombre());
                            System.out.println("\nGanador: " + desafio.getCombate().getVencedor().getNombre());
                            System.out.println("Oro apostado: " + desafio.getApuesta());
                            System.out.println("--------------------------------");


                            if (desafio.getCombate().getVencedor() == ((UsuarioJugador) userActivo).getPersonaje())
                                oroGanado += desafio.getApuesta();
                            else
                                oroPerdido += desafio.getApuesta();
                        }
                    }
                    System.out.printf("Oro ganado: " + oroGanado);
                    System.out.printf("\nOro perdido: -" + oroPerdido + "\n");

                    break;
                case 5:
                    System.out.println("Introduzca 'SI' si desea confirmar que se da de baja");
                    String confirmacion = scanner.next();
                    if (Objects.equals(confirmacion, "SI")) {
                        System.out.println("Dándose de baja...");
                        System.out.println(userActivo.getNombre() + " ya no existe");
                        usuarios.remove(userActivo.getNick());
                        opcion = 6;
                    } else {
                        System.out.println("No se ha dado de baja");
                    }
                    break;
                case 6:
                    System.out.println("Cerrando sesión...");
                    break;
                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        } while (opcion != 6);
    }

    private void gestionarDesafios(Database data) {
        data.printUsuarios(userActivo);
        HashMap<String, User> usuarios = data.getUsuarios();
        System.out.println("\nDESAFIO\nIntroduzca el nombre del usuario a desafiar");
        String desafiado = scanner.next();
        UsuarioJugador usuarioDesafiado = null;
        for (User usuario : usuarios.values()) {
            if (usuario instanceof UsuarioJugador jugador) {
                if (jugador.getNombre().equalsIgnoreCase(desafiado)) {
                    usuarioDesafiado = jugador;
                    break;
                }
            }
        }

        if (usuarios.containsKey(desafiado)) {

            System.out.println("Introduzca la cantidad de oro a apostar");
            int oro_apostado = scanner.nextInt();
            if (oro_apostado > 0 && usuarios.get(desafiado).oroSuficiente(oro_apostado)) {
                UsuarioJugador Desafiante = (UsuarioJugador)userActivo;
                System.out.println(Desafiante.getNombre());
                assert usuarioDesafiado != null;
                System.out.println(usuarioDesafiado.getNombre());
                data.crearDesafio(Desafiante, usuarioDesafiado, oro_apostado);
                System.out.println("Desafio creado");

            } else {
                System.out.println("No puedes apostar esa cantidad de oro");
            }

        } else {
            System.out.println("No se ha encontrado a ningun jugador con ese nick");
        }
    }

    private void iniciarCombate(Desafio desafio, HashMap<String, User> usuarios, Database data) {

        String nombreDesafiante = desafio.getNombreDesafiante();
        String nombreDesafiado = desafio.getNombreDesafiado();

        Random random = new Random();
        System.out.println("Comienza el Combate");


        User usuarioDesafiante = usuarios.get(nombreDesafiante);
        User usuarioDesafiado = usuarios.get(nombreDesafiado);

        if (usuarioDesafiante instanceof UsuarioJugador jugadorDesafiante && usuarioDesafiado instanceof UsuarioJugador jugadorDesafiado) {
            Personaje personajeDesafiante = jugadorDesafiante.getPersonaje();
            Personaje personajeDesafiado = jugadorDesafiado.getPersonaje();

            Date fecha = new Date();
            Combate combate = new Combate(personajeDesafiante, personajeDesafiado, personajeDesafiante.getSalud(), personajeDesafiado.getSalud(), fecha);
            UsuarioJugador vencedor = combate.jugar(desafio, data);
            desafio.setCombate(combate);
            UsuarioJugador perdedor;
            if(vencedor.equals(usuarioDesafiante)){
                perdedor = (UsuarioJugador) usuarioDesafiado;
            } else {
                perdedor = (UsuarioJugador) usuarioDesafiante;
            }
            if(ranking.containsKey(vencedor.getNick())){
                Ranking rankVencedor = ranking.get(vencedor.getNick());
                rankVencedor.addCombateGanados();
                rankVencedor.addCombateJugados();
            } else {
                Ranking rankVencedor = new Ranking(vencedor);
                rankVencedor.addCombateGanados();
                rankVencedor.addCombateJugados();
                ranking.put(vencedor.getNick(), rankVencedor);
            }
            if(ranking.containsKey(perdedor.getNick())){
                Ranking rankPerdedor = ranking.get(perdedor.getNick());
                rankPerdedor.addCombateJugados();
            } else {
                Ranking rankPerdedor = new Ranking(perdedor);
                rankPerdedor.addCombateJugados();
                ranking.put(perdedor.getNick(), rankPerdedor);
            }


        } else {
            System.out.println("Uno o ambos de los desafiados no son jugadores. Un operador no puede combatir.");
            return;
        }
    }


    public HashMap<String, User> getUsuarios() {
        return this.usuarios;
    }

}










