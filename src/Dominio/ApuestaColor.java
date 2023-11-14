package Dominio;

import Excepciones.ApuestaInvalidaException;
import java.util.ArrayList;

public final class ApuestaColor extends TipoApuesta {

    public ApuestaColor(int factor) {
        super("Apuesta a Color", factor);
    }

    @Override
    public void validacionConUltimaJugada(Apuesta apuesta, Estadistica estadistica) throws ApuestaInvalidaException {
        Jugador jugador = apuesta.getJugador();
        //averiguo si el jugador aposto a color en la ronda anterior y obtengo los casilleros apostados y su monto
        ArrayList<Apuesta> apuestasAanalizar = jugador.jugadorApostoColorEnRondaAnterior();

        //consigo el ultimo casillero ganador
        if (!estadistica.getNumerosSorteados().isEmpty()) {
            int ultimoGanador = estadistica.getNumerosSorteados().get(0);
            //analizo restricciones basado en el ultimo ganador
            if (!apuestasAanalizar.isEmpty()) {
                if (ultimoGanador != 0) {
                    int colorBuscado = ListaUniversalCasilleros.colorDelCasillero(ultimoGanador);
                    //el color que se aposto anteriormente no gano?
                    if (apuestasAanalizar.size() == 1 && apuestasAanalizar.get(0).getCasillero() != colorBuscado) {
                        //la apuesta es al mismo color que se aposto anteriormente Y apuesto por un monto mayor
                        if (apuestasAanalizar.get(0).getMontoApostado() < apuesta.getMontoApostado()
                                && apuesta.getCasillero() == apuestasAanalizar.get(0).getCasillero()) {
                            throw new ApuestaInvalidaException("No esta permitido en este caso apostar un monto mayor al color"
                                    + " que no gano la jugada anterior");
                        }
                    }
                    //salio el cero, entonces se perdio. No se puede apostar un monto mayor al anterior
                } else {
                    if (apuestasAanalizar.size() == 2) {
                        for (Apuesta apuestaHistorico : apuestasAanalizar) {
                            if (apuestaHistorico.getCasillero() == apuesta.getCasillero()
                                    && apuestaHistorico.getMontoApostado() < apuesta.getMontoApostado()) {
                                throw new ApuestaInvalidaException("No esta permitido en este caso apostar un monto mayor al color"
                                        + " que no gano la jugada anterior");
                            }
                        }
                    }
                }
            }
        }
    }
}
