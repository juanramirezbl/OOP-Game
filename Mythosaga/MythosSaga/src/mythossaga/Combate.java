package mythossaga;
import java.io.IOException;
import java.io.Serializable;
import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Combate implements Serializable {
    private final Personaje desafiante;
    private final Personaje desafiado;
    private int saludDesafiante;
    private int saludDesafiado;

    private int saludEsbirrosDesafiante;
    private int saludEsbirrosDesafiado;
    private int round;
    private Personaje esbirrosSupervivientes;
    private Personaje vencedor;
    private int oroGanado;

    public Combate(Personaje desafiante, Personaje desafiado, int saludDesafiante, int saludDesafiado, Date fecha) {
        this.desafiante = desafiante;
        this.desafiado = desafiado;
        this.saludDesafiante = saludDesafiante;
        this.saludDesafiado = saludDesafiado;
        this.saludEsbirrosDesafiante = calcularSaludEsbirros(desafiante);
        this.saludEsbirrosDesafiado = calcularSaludEsbirros(desafiado);
        this.round = 0;
        this.vencedor = null;
        this.oroGanado = 0;
    }

    public void setModificadores(Desafio desafio) {

    }

    public Personaje getVencedor() {
        return vencedor;
    }

    public int getOroGanado() {
        return oroGanado;
    }

    public UsuarioJugador jugar(Desafio desafio, Database data){
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Pulsa enter para comenzar el combate...");
        try {
            reader.readLine();
            while(this.saludDesafiante > 0 && this.saludDesafiado > 0) {
                System.out.println("Pulsa enter para jugar la siguiente ronda...");
                reader.readLine();
                jugarRonda(desafio, data);
            }
            Personaje vencedor = terminarCombate(desafio);
            desafio.setTerminado(true);
        } catch (IOException e) {
            System.out.println("Error");;
        }
        if(desafio.getDesafiante().getPersonaje() == vencedor){
            return desafio.getDesafiante();
        }else {
            return desafio.getDesafiado();
        }
    }

    protected void jugarRonda(Desafio desafio, Database data) {
        this.round++;

        System.out.println("Ronda " + this.round + ":");


        System.out.println("La salud del desafiante "+ desafio.getDesafiante().getNombre() +" ("+desafiante.getNombre()+") es: "+ this.saludDesafiante);
        System.out.println("La salud del desafiado "+ desafio.getDesafiado().getNombre() +" ("+desafiado.getNombre()+") es: "+ this.saludDesafiado + "\n");


        // Calculamos el potencial de ataque de los personajes
        int potencialAtaqueDesafiante = calcularPotencialAtaque(desafiante);
        int potencialAtaqueDesafiado = calcularPotencialAtaque(desafiado);

        // Calculamos el potencial de defensa de los personajes
        int potencialDefensaDesafiante = calcularPotencialDefensa(desafiante);
        int potencialDefensaDesafiado = calcularPotencialDefensa(desafiado);

        // Calculamos el numero de exitos de ataque de los personajes
        int exitosAtaqueDesafiante = calcularExitos(potencialAtaqueDesafiante);
        int exitosAtaqueDesafiado = calcularExitos(potencialAtaqueDesafiado);

        // Calculamos el numero de exitos de ataque de los personajes
        int exitosDefensaDesafiante = calcularExitos(potencialDefensaDesafiante);
        int exitosDefensaDesafiado = calcularExitos(potencialDefensaDesafiado);

        // Calculamos el daño final de los personajes
        int danoDesafiante = Math.max(0, exitosAtaqueDesafiante - exitosDefensaDesafiado);
        int danoDesafiado = Math.max(0, exitosAtaqueDesafiado - exitosDefensaDesafiante);



        // Restamos vida a los esbirros, sino al personaje

            // Ataque al Jugador desafiante
            System.out.println(desafiado.getNombre()+": ");
            mensaje(this.desafiado, data);
            if (saludEsbirrosDesafiante > 0) {
                this.saludEsbirrosDesafiante -= danoDesafiado;
                System.out.println("Los esbirros de " + desafiante.getNombre() + " han perdido " + danoDesafiado + " puntos de vida\n");
            }
            else {
                this.saludDesafiante -= danoDesafiado;
                System.out.println(desafiante.getNombre() + " ha perdido " + danoDesafiado + " puntos de vida\n");
            }
            // Ataque al Jugador desafiado
            System.out.println(desafiante.getNombre()+": ");
            mensaje(this.desafiante, data);
            if (saludEsbirrosDesafiado > 0) {
                this.saludEsbirrosDesafiado -= danoDesafiante;
                System.out.println("Los esbirros de " + desafiado.getNombre() + " han perdido " + danoDesafiado + " puntos de vida\n");
            }
            else {
                this.saludDesafiado -= danoDesafiante;
                System.out.println(desafiado.getNombre() + " ha perdido " + danoDesafiante + " puntos de vida\n");
            }
    }


    protected int calcularPotencialAtaque(Personaje personaje) {
        int potencialAtaque = personaje.getPoder(); // Primero el potencial de ataque es el poder del personaje (común)
        for (Modificador modificador: personaje.getFortaleza())
            potencialAtaque += modificador.getValor();

        for (Modificador modificador: personaje.getDebilidad())
            potencialAtaque -= modificador.getValor();



        switch (personaje) {
            case Vampiro vampiro -> {

                potencialAtaque += vampiro.getValorAtaqueDisciplina(); // Sumar el valor de ataque de la disciplina

                potencialAtaque += vampiro.getValorAtaqueEquipoActivo(); // Sumar el valor de ataque del equipo activo

                if (vampiro.getPuntosSangre() >= 5) { // Si el valor de sangre es mayor o igual a 5
                    potencialAtaque += 2; // Sumar 2 al potencial de ataque
                }

            }
            case Licantropo licantropo -> {

                potencialAtaque += licantropo.getValorAtaqueDon(); // Sumar el valor de ataque del don (condición implementada en el metodo)

                potencialAtaque += licantropo.getValorAtaqueEquipoActivo(); // Sumar el valor de ataque del equipo activo

                potencialAtaque += licantropo.getRabia(); // Sumar la rabia actual  // Si el personaje es un licántropo
            }
            case Cazador cazador -> {
                potencialAtaque += cazador.getValorAtaqueEquipoActivo(); // Sumar el valor de ataque del equipo activo

                potencialAtaque += cazador.getVoluntadActual(); // Sumar la voluntad actual  // Si el personaje es un cazador
            }
            default -> {
            }
        }

        return potencialAtaque;
    }


    public int  calcularExitos(int potencial) {

        int exitos = 0;
        Random random = new Random();
        for (int i = 0; i < potencial; i++) {
            if (random.nextInt(6) + 1 >= 5) {
                exitos++;
            }
        }
        return exitos;
    }


    protected Personaje terminarCombate(Desafio desafio) {
        if (this.saludDesafiante <= 0 && this.saludDesafiado <= 0) {
            System.out.println("El combate ha terminado en empate.");
        } else if (this.saludDesafiante <= 0) {
            this.vencedor = this.desafiado;
            desafiado.setOro(desafiado.getOro()+desafio.getApuesta());
            desafiante.setOro(desafiante.getOro()-desafio.getApuesta());
            System.out.println("El combate ha terminado. El vencedor es " + this.vencedor.getNombre() + ".");
        } else {
            this.vencedor = this.desafiante;
            desafiante.setOro(desafiante.getOro()+desafio.getApuesta());
            desafiado.setOro(desafiado.getOro()-desafio.getApuesta());
            System.out.println("El combate ha terminado. El vencedor es " + this.vencedor.getNombre() + ".");
        }
        return this.vencedor;
    }

    protected int calcularPotencialDefensa(Personaje personaje) {
        int potencialDefensa= 0 ;

        switch (personaje) {
            case Vampiro vampiro -> {
                potencialDefensa += vampiro.getValorDefensaDisciplina(); // Sumar el valor de defensa de la disciplina

                potencialDefensa += vampiro.getValorDefensaEquipoActivo(); // Sumar el valor de defensa del equipo activo  // Si el personaje es un vampiro
            }
            case Licantropo licantropo -> {
                potencialDefensa += licantropo.getValorDefensaDon(); // Sumar el valor de defensa del don

                potencialDefensa += licantropo.getValorDefensaEquipoActivo(); // Sumar el valor de defensa del equipo activo  // Si el personaje es un licántropo
            }
            case Cazador cazador -> {
                potencialDefensa+= cazador.getVoluntadActual(); // Sumar la voluntad actual  // Si el personaje es un cazador


                potencialDefensa += cazador.getValorDefensaEquipoActivo(); // Sumar el valor de defensa del equipo activo  // Si el personaje es un cazador
            }
            default -> {
            }
        }
        return potencialDefensa;
    }

    protected int calcularSaludEsbirros(Personaje personaje){

        int salud = 0;
        ArrayList<Esbirro> esbirrosDesafiante = personaje.getEsbirros();
        if(esbirrosDesafiante != null){
            for (Esbirro esbirro: esbirrosDesafiante)
                if (esbirro.getSalud() > 0)
                    salud += esbirro.getSalud();
        }
        return salud;
    }

    protected void mensaje(Personaje atacante,  Database data) {
        Random random = new Random();
        String mensajeSeleccionado = "";

        // Verificar el tipo de instancia del atacante
        if (atacante instanceof Cazador) {
            // Seleccionar un mensaje al azar para Cazadores
            int index = random.nextInt(data.getMensajesCazadores().size());
            mensajeSeleccionado = data.getMensajesCazadores().get(index);
        } else if (atacante instanceof Licantropo) {
            // Seleccionar un mensaje al azar para Licántropos
            int index = random.nextInt(data.getMensajesLicantropos().size());
            mensajeSeleccionado = data.getMensajesLicantropos().get(index);
        } else if (atacante instanceof Vampiro) {
            // Seleccionar un mensaje al azar para Vampiros
            int index = random.nextInt(data.getMensajesVampiros().size());
            mensajeSeleccionado = data.getMensajesVampiros().get(index);
        }

        // Imprimir el mensaje seleccionado
        System.out.println(mensajeSeleccionado);
    }


    public Personaje getDesafiante() {
        return desafiante;
    }

    public Personaje getDesafiado() {
        return desafiado;
    }
}
