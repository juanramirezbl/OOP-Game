package mythossaga;

public class Ranking {
    private UsuarioJugador jugador;
    private int combateGanados;
    private int combatesJugados;
    private float ratio;

    public Ranking(UsuarioJugador jugador) {
        this.jugador = jugador;
        this.combateGanados = 0;
        this.combatesJugados = 0;
    }

    public User getJugador() {
        return jugador;
    }

    public int getCombateGanados() {
        return combateGanados;
    }

    public void setCombateGanados(int combateGanados) {
        this.combateGanados = combateGanados;
    }

    public void addCombateGanados() {
        this.combateGanados ++;
    }

    public int getCombatesJugados() {
        return combatesJugados;
    }

    public void setCombatesJugados(int combatesJugados) {
        this.combatesJugados = combatesJugados;
    }
    public void addCombateJugados() {
        this.combatesJugados ++;
    }
    public float getRatio() {
        return (float) this.combateGanados /this.combatesJugados;
    }

    @Override
    public String toString() {
        return "Nick: " + this.jugador.getNick() + " || Combates Jugados: " + this.combatesJugados + "  || Combates Ganados: " + this.combateGanados + "  || Oro del Personaje: "+jugador.getPersonaje().getOro() ;
    }
}
