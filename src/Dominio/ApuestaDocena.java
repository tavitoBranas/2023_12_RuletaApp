package Dominio;

import Excepciones.ApuestaInvalidaException;
import java.util.ArrayList;

public final class ApuestaDocena extends TipoApuesta {

    public ApuestaDocena(int factor) {
        super("Apuesta a Docena", factor);
    }

    @Override
    protected void validacionCantidadApuestasDocena(Apuesta apuesta, Ronda ronda) throws ApuestaInvalidaException {
        Jugador jugador = apuesta.getJugador();
        if (ronda.getApuestas().containsKey(jugador)) {
            ArrayList<Apuesta> apuestasJugador = ronda.getApuestas().get(jugador);

            for (int k = 0; k < apuestasJugador.size(); k++) {
                for (int t = 0; t < ListaUniversalCasilleros.getCasillerosApuestaDocena().size(); t++) {
                    if (apuestasJugador.get(k).getCasillero()
                            == ListaUniversalCasilleros.getCasillerosApuestaDocena().get(t)
                            && apuesta.getCasillero() != apuestasJugador.get(k).getCasillero()) {
                        throw new ApuestaInvalidaException("No se puede apostar a mas de una docena por ronda");
                    }
                }
            }
        }

    }
}
