package mythossaga;

public class Debilidad extends Modificador {
    public Debilidad(String nombre, int valor) {
        super(nombre, valor);
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }
}