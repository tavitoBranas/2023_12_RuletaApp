package Dominio;

import Excepciones.EfectoException;

public class EfectoSimulador extends Efecto {

    public EfectoSimulador() {
        super("Simulador");
    }

    @Override
    public void lanzar(Ronda ronda) throws EfectoException {

        if (ronda.apuestaDerecta().isEmpty()) {
            throw new EfectoException("No se cuenta con apuestas directas para seleccionar un numero ganador "
                    + "mediante Efecto Simulador");
        }
        int resultado;
        do {
            resultado = numeroGanador();
            //la bola sortea únicamente entre los números que tienen Apuesta Directa, más el cero
        } while (!ronda.apuestaDerecta().contains(resultado) || resultado == 0);
        setearNumeroGanador(resultado);
    }
}
