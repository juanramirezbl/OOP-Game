package mythossaga;

import java.io.Serializable;

public class Desafio implements Serializable {
    private UsuarioJugador desafiante;
    private UsuarioJugador desafiado;
    private int apuesta;
    private boolean comprobado;
    private boolean terminado;
    private Combate combate;

    public Desafio(UsuarioJugador desafiante, UsuarioJugador desafiado, int apuesta) {
        this.desafiante = desafiante;
        this.desafiado = desafiado;
        this.apuesta = apuesta;
        this.comprobado = false;
        this.terminado = false;
    }

    public UsuarioJugador getDesafiante() {
        return desafiante;
    }

    public String getNombreDesafiante(){return this.desafiante.getNombre();}

    public void setDesafiante(UsuarioJugador desafiante) {
        this.desafiante = desafiante;
    }

    public UsuarioJugador getDesafiado() {
        return desafiado;
    }

    public String getNombreDesafiado(){return this.desafiado.getNombre();}

    public void setDesafiado(UsuarioJugador desafiado) {
        this.desafiado = desafiado;
    }

    public int getApuesta() {
        return apuesta;
    }

    public boolean isTerminado() {
        return terminado;
    }

    public void setTerminado(boolean terminado) {
        this.terminado = terminado;
    }

    public void setApuesta(int apuesta) {
        this.apuesta = apuesta;
    }

    public boolean isComprobado() {
        return comprobado;
    }

    public void setComprobado(boolean comprobado) {
        this.comprobado = comprobado;
    }

    public Combate getCombate() {
        return combate;
    }

    public void setCombate(Combate combate) {
        this.combate = combate;
    }
}
