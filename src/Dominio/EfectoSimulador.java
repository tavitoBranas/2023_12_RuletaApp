package Dominio;

public class EfectoSimulador extends Efecto {

    public EfectoSimulador() {
        super("Simulador");
    }

    @Override
    public void lanzar(Ronda ronda) {

        int resultado;
        do {
            resultado = numeroGanador();
            //la bola sortea únicamente entre los números que tienen Apuesta Directa, más el cero
        } while (!ronda.apuestaDerecta().contains(resultado)
                || resultado == 0);

        setearNumeroGanador(resultado);
    }
}
