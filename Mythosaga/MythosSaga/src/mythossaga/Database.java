package mythossaga;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Database implements Serializable {

    private HashMap<String, User> usuarios;
    private ArrayList<Desafio> desafios;
    private ArrayList<Arma> armas;
    private ArrayList<Armadura> armaduras;
    private ArrayList<String> mensajesCazadores;
    private ArrayList<String> mensajesLicantropos;
    private ArrayList<String> mensajesVampiros;

    public HashMap<String, User> getUsuarios() {
        return usuarios;
    }

    public ArrayList<Desafio> getDesafios() {
        return desafios;
    }

    public void saveData() throws FileNotFoundException, IOException{
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("database/data.data"));
        out.writeObject(this);
        out.close();
    }

    //Comprueba si el nick esta en uso
    public boolean checkNick(String nick){
        return usuarios.containsKey(nick);
    }

    // Metodo que añade un nuevo usuario a la lista de usuarios que luego irá a la base de datos
    public void nuevoUsuario(User usuario) {
        usuarios.put(usuario.getNick(), usuario);
    }

    // Metodo que busca a un usuario por su nickname en la base de datos y si lo encuentra lo elimina
    public void eliminarUsuario(String nick) {
        usuarios.remove(nick);
        }



    public boolean checkLogIN(String nick, String password){
        if(usuarios.containsKey(nick))
            return password.equals(usuarios.get(nick).getPassword());
        return false;
    }

    public void crearDesafio(UsuarioJugador desafiante, UsuarioJugador desafiado, int oroApostado) {
        Desafio desafio = new Desafio(desafiante, desafiado, oroApostado);
        desafios.add(desafio);
    }

    public void inicializarDatabase(){
        this.usuarios =  new HashMap<>();
        this.desafios =  new ArrayList<>();
        this.armas = new ArrayList<>();
        this.armaduras = new ArrayList<>();
        this.mensajesCazadores = new ArrayList<>();
        this.mensajesLicantropos = new ArrayList<>();
        this.mensajesVampiros = new ArrayList<>();


        // El operador para gestionar los desafios
        Operador fer = new Operador("fer", "nano", "1234");
        this.usuarios.put(fer.getNick(), fer);

        Operador admin = new Operador("admin", "admin", "admin");
        this.usuarios.put(admin.getNick(), admin);

        /////////////////////////
        // El usuario de juan
        /////////////////////////


        UsuarioJugador juan = new UsuarioJugador("jrb", "jrb", "1234");

        HashMap<String, Equipo> armasVampiro = new HashMap<>();
        Arma[] armaActivaVampiro = new Arma[10];
        Arma armaVampiro = new Arma("Estoque Sangriento", 4, 1);
        armasVampiro.put(armaVampiro.getNombre(), armaVampiro);

        HashMap<String, Equipo> armadurasVampiro = new HashMap<>();
        Armadura armaduraVampiro = new Armadura("Coraza de la Noche", 3);
        armadurasVampiro.put(armaduraVampiro.getNombre(), armaduraVampiro);

        ArrayList<Modificador> debilidadVampiro = new ArrayList<>();
        ArrayList<Modificador>  fortalezaVampiro = new ArrayList<>();
        ArrayList<Esbirro> esbirrosVampiro = new ArrayList<>();

        // Creación del personaje Vampiro
        Personaje personajeVampiro = new Vampiro(
                "VladCazador", // nombre del Vampiro
                armasVampiro, // HashMap de armas
                armaActivaVampiro, // Arreglo de armas activas
                armadurasVampiro, // HashMap de armaduras
                armaduraVampiro, // Armadura activa
                12, // salud
                debilidadVampiro, // Lista de debilidades
                fortalezaVampiro, // Lista de fortalezas
                100, // oro
                25, // poder
                esbirrosVampiro, // Lista de esbirros
                30, // nivel
                15 // experiencia
        );
        juan.crearPersonaje(personajeVampiro);
        this.usuarios.put(juan.getNick(), juan);


        /////////////////////////
        // El usuario de guille
        /////////////////////////


        UsuarioJugador guille = new UsuarioJugador("guille", "guille", "1234");

        HashMap<String, Equipo> armasLicantropo = new HashMap<>();
        Arma[] armaActivaLicantropo = new Arma[10];
        Arma armaLicantropo = new Arma("Espada de Plata", 7, 1);
        armasLicantropo.put(armaLicantropo.getNombre(), armaLicantropo);

        HashMap<String, Equipo> armadurasLicantropo = new HashMap<>();
        Armadura armaduraLicantropo = new Armadura("Cota de Mallas", 4);
        armadurasLicantropo.put(armaduraLicantropo.getNombre(), armaduraLicantropo);

        ArrayList<Modificador>  debilidadesLicantropo = new ArrayList<>();
        ArrayList<Modificador>  fortalezasLicantropo = new ArrayList<>();
        ArrayList<Esbirro> esbirrosLicantropo = new ArrayList<>();

        // Creación del personaje Licantropo
        Integer rabiaInicial = 50; // Valor inicial de rabia para el Licantropo
        Personaje personajeLicantropo = new Licantropo(
                "GuerreroLunar", // nombre del Licantropo
                armasLicantropo, // HashMap de armas
                armaActivaLicantropo, // Arreglo de armas activas
                armadurasLicantropo, // HashMap de armaduras
                armaduraLicantropo, // Armadura activa
                15, // salud
                debilidadesLicantropo, // Lista de debilidades
                fortalezasLicantropo, // Lista de fortalezas
                100, // oro
                20, // poder
                esbirrosLicantropo, // Lista de esbirros
                rabiaInicial // rabia
        );
        guille.crearPersonaje(personajeLicantropo);
        this.usuarios.put(guille.getNick(), guille);


        /////////////////////////
        // El usuario de alex
        /////////////////////////


        UsuarioJugador alex = new UsuarioJugador("alex", "alex", "1234");

        HashMap<String, Equipo> armasCazador = new HashMap<>();
        Arma[] armaActivaCazador = new Arma[10];
        Arma armaCazador = new Arma("Ballesta Ligera", 5, 2);
        armasCazador.put(armaCazador.getNombre(), armaCazador);

        HashMap<String, Equipo> armadurasCazador = new HashMap<>();
        Armadura armaduraCazador = new Armadura("Vestimentas de Cuero", 2);
        armadurasCazador.put(armaduraCazador.getNombre(), armaduraCazador);

        List<Modificador> debilidadesCazador = new ArrayList<>();
        List<Modificador> fortalezasCazador = new ArrayList<>();
        ArrayList<Esbirro> esbirrosCazador = new ArrayList<>();

        // Creación del personaje Cazador
        Integer voluntadInicial = 40; // Valor inicial de voluntad para el Cazador
        Personaje personajeCazador = new Cazador(
                "Artemis", // nombre del Cazador
                new ArrayList<>(armasCazador.values()), // Lista de armas
                armaCazador, // Arma activa
                new ArrayList<>(armadurasCazador.values()), // Lista de armaduras
                armaduraCazador, // Armadura activa
                100, // salud
                debilidadesCazador, // Lista de debilidades
                fortalezasCazador, // Lista de fortalezas
                100, // oro
                10, // poder
                esbirrosCazador, // Lista de esbirros
                voluntadInicial // voluntad
        );
        alex.crearPersonaje(personajeCazador);
        this.usuarios.put(alex.getNick(), alex);


        // Inicializamos unas armas
        Arma arma1 = new Arma("Espada Corta", 3, 1);
        Arma arma2 = new Arma("Hacha de Batalla", 6, 2);
        Arma arma3 = new Arma("Daga Venenosa", 2, 1);
        Arma arma4 = new Arma("Martillo de Guerra", 5, 2);
        Arma arma5 = new Arma("Arco Largo", 4, 2);
        Arma arma6 = new Arma("Cimitarra", 3, 1);
        Arma arma7 = new Arma("Lanza de Caballería", 4, 2);
        Arma arma8 = new Arma("Ballesta Pesada", 5, 2);
        Arma arma9 = new Arma("Estoque", 2, 1);
        Arma arma10 = new Arma("Maza de Hierro", 4, 1);

        this.armas.add(arma1);
        this.armas.add(arma2);
        this.armas.add(arma3);
        this.armas.add(arma4);
        this.armas.add(arma5);
        this.armas.add(arma6);
        this.armas.add(arma7);
        this.armas.add(arma8);
        this.armas.add(arma9);
        this.armas.add(arma10);

        // Inicializamos unas armaduras

        Armadura armadura1 = new Armadura("Casco de Hierro", 2);
        Armadura armadura2 = new Armadura("Pechera de Acero", 5);
        Armadura armadura3 = new Armadura("Grebas de Cuero", 1);
        Armadura armadura4 = new Armadura("Guanteletes de Plata", 3);
        Armadura armadura5 = new Armadura("Botas de Mithril", 4);
        Armadura armadura6 = new Armadura("Espaldarones de Bronce", 3);
        Armadura armadura7 = new Armadura("Cinturón de Fuerza", 2);
        Armadura armadura8 = new Armadura("Capa de Invisibilidad", 1);
        Armadura armadura9 = new Armadura("Brazales de Guardián", 2);
        Armadura armadura10 = new Armadura("Yelmo del Dragón", 4);

        this.armaduras.add(armadura1);
        this.armaduras.add(armadura2);
        this.armaduras.add(armadura3);
        this.armaduras.add(armadura4);
        this.armaduras.add(armadura5);
        this.armaduras.add(armadura6);
        this.armaduras.add(armadura7);
        this.armaduras.add(armadura8);
        this.armaduras.add(armadura9);
        this.armaduras.add(armadura10);

        // Inicializamos desafiios

        Desafio desafio1 = new Desafio(juan, alex, 10);
        alex.getPersonaje().addEsbirro(new Humano(TypeEsbirro.humano, 3, Lealtad.ALTO));
        Desafio desafio2 = new Desafio(juan, guille, 20);

        desafio1.setComprobado(true);
        desafio2.setComprobado(true);

        desafios.add(desafio1);
        desafios.add(desafio2);


        // Mensajes para Cazadores
        this.mensajesCazadores.add("¡Con cada flecha, un enemigo menos!");
        this.mensajesCazadores.add("Por la luz, purgaré esta tierra.");
        this.mensajesCazadores.add("La caza ha comenzado, y tú eres la presa.");
        this.mensajesCazadores.add("Mis trampas están listas, el fin se acerca.");
        this.mensajesCazadores.add("Un cazador siempre acecha en la sombra.");
        this.mensajesCazadores.add("El filo de mi hoja será lo último que veas.");
        this.mensajesCazadores.add("Ni la bestia más feroz puede escapar.");
        this.mensajesCazadores.add("La voluntad del cazador es inquebrantable.");
        this.mensajesCazadores.add("En el silencio, la muerte se aproxima.");
        this.mensajesCazadores.add("Por cada caído, mi resolución se fortalece.");

        // Mensajes para Licántropos
        this.mensajesLicantropos.add("La luna llena me guía, tu fin está cerca.");
        this.mensajesLicantropos.add("Deja que la bestia en mí despierte.");
        this.mensajesLicantropos.add("Con garras y colmillos, reclamo mi victoria.");
        this.mensajesLicantropos.add("El aullido del licántropo es el presagio de tu derrota.");
        this.mensajesLicantropos.add("En la furia, encuentro mi fuerza.");
        this.mensajesLicantropos.add("Ningún escondrijo te salvará de mi olfato.");
        this.mensajesLicantropos.add("La manada es fuerte, y tú eres el débil.");
        this.mensajesLicantropos.add("Mis heridas solo alimentan mi rabia.");
        this.mensajesLicantropos.add("Cuando la bestia interior despierta, huye.");
        this.mensajesLicantropos.add("La cacería nocturna ha comenzado.");

        // Mensajes para Vampiros
        this.mensajesVampiros.add("La eternidad es larga, pero tu vida es corta.");
        this.mensajesVampiros.add("Siente el frío beso de la inmortalidad.");
        this.mensajesVampiros.add("La noche es mi aliada, y tu sangre mi sustento.");
        this.mensajesVampiros.add("Un susurro en la oscuridad, tu final se acerca.");
        this.mensajesVampiros.add("De las sombras me alimento, y en ellas te consumirás.");
        this.mensajesVampiros.add("La sed de sangre nunca se sacia.");
        this.mensajesVampiros.add("Tus venas, el néctar que mi ser anhela.");
        this.mensajesVampiros.add("Inmortalidad es poder, y tú eres solo un mortal.");
        this.mensajesVampiros.add("Mi maldición es tu perdición.");
        this.mensajesVampiros.add("La noche me pertenece, como tu vida ahora.");

    }

    public ArrayList<Arma> getArmas() {
        return armas;
    }

    public void setArmas(ArrayList<Arma> armas) {
        this.armas = armas;
    }

    public void addArmas(Arma arma) {
        this.armas.add(arma);
    }

    public ArrayList<Armadura> getArmaduras() {
        return armaduras;
    }

    public void setArmaduras(ArrayList<Armadura> armaduras) {
        this.armaduras = armaduras;
    }

    public void addArmaduras(Armadura armadura) {
        this.armaduras.add(armadura);
    }

    public ArrayList<String> getMensajesCazadores() {
        return mensajesCazadores;
    }

    public ArrayList<String> getMensajesLicantropos() {
        return mensajesLicantropos;
    }

    public ArrayList<String> getMensajesVampiros() {
        return mensajesVampiros;
    }

    public void setMensajesCazadores(ArrayList<String> mensajesCazadores) {
        this.mensajesCazadores = mensajesCazadores;
    }

    public void setMensajesLicantropos(ArrayList<String> mensajesLicantropos) {
        this.mensajesLicantropos = mensajesLicantropos;
    }

    public void setMensajesVampiros(ArrayList<String> mensajesVampiros) {
        this.mensajesVampiros = mensajesVampiros;
    }

    public void printUsuarios(User userActivo){
        System.out.println("Los usuarios en el sistema son los siguientes");
        for(User u: this.usuarios.values()){
            if (u instanceof UsuarioJugador){
                if (userActivo != u){
                    System.out.println(u.getNick());
                }
            }
        }
    }
    public void printUsuariosOperador(){
        System.out.println("Los usuarios en el sistema son los siguientes");
        for(User u: this.usuarios.values()){
            if (u instanceof UsuarioJugador){
                System.out.println(u);
            }
        }
    }
}

