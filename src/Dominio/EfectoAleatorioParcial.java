package Dominio;

public class EfectoAleatorioParcial extends Efecto {

    public EfectoAleatorioParcial() {
        super("Aleatorio parcial");
    }

    @Override
    public void lanzar(Ronda ronda) {
        int resultado;
        do {
            resultado = numeroGanador();
        } while (ronda.getMesa().getEstadistica().getUltimosTresNumerosSorteados().contains(resultado));
        setearNumeroGanador(resultado);
    }
}
