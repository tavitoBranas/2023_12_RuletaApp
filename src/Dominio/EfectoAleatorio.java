package Dominio;

public class EfectoAleatorio extends Efecto {

    public EfectoAleatorio() {
        super("Aleatorio");
    }

    //la bola determina un valor 100% aleatorio en cada ronda.
    @Override
    protected void numeroSorteado() {
        int numero = seleccionarNumero();

        setearCasilleroGanador(numero);
    }

}
