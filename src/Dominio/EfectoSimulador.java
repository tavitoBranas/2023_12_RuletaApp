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
        ronda.apuestaDerecta().add(0);
        do {
            resultado = numeroGanador();
        } while (!ronda.apuestaDerecta().contains(resultado));
        setearNumeroGanador(resultado);
    }
}
