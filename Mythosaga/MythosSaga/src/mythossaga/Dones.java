package mythossaga;

public class Dones extends Habilidad{
    private Integer rabiaMinima;

    public Dones(String nombre, Integer ataque, Integer defensa, Integer rabiaMinima) {
        super(nombre, ataque, defensa);
        this.rabiaMinima = rabiaMinima;
    }

    public Integer getRabiaMinima() {
        return rabiaMinima;
    }

    public void setRabiaMinima(Integer rabiaMinima) {
        this.rabiaMinima = rabiaMinima;
    }
}
