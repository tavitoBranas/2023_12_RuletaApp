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
            //la bola determina un valor aleatorio, pero asegurando de no repetir los últimos 3 valores. 
        } while (ronda.getMesa().getEstadistica().getUltimosTresNumerosSorteados().contains(resultado));

        setearNumeroGanador(resultado);
    }
}
