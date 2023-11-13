package Dominio;

public class EfectoAleatorio extends Efecto {

    public EfectoAleatorio() {
        super("Aleatorio");
    }

    @Override
    public void lanzar(Ronda ronda) {
        int numero = numeroGanador();
        setearNumeroGanador(numero);
    }
}
