package Dominio;

import java.util.ArrayList;
import java.util.Map;

public final class EstadoMesaAbiertaPagar extends EstadoMesa {

    public EstadoMesaAbiertaPagar(Mesa mesa) {
        super();
        this.setJugadoresAbandonanMesa(true);
        this.setJugadoresApuestan(true);
        this.setJugadoresIngresanMesa(true);
        mesa.setMensaje("La mesa esta disponible para jugar");
    }

    @Override
    protected void pagar(Mesa mesa) {
        mesa.setMensaje("La mesa esta disponible para jugar");
        BalanceMesa balance = new BalanceMesa(mesa.getEstadistica().getNumeroDeRonda());
        pagarJugadores(mesa, balance);
        balanceMesa(mesa, balance);  //setea monto total
        actualizarUltimaJugadaJugadores(mesa);
        generacionNuevaRonda(mesa);
        mesa.getEstadistica().setNumeroDeRonda();
    }

    private void generacionNuevaRonda(Mesa mesa) {
        Ronda nuevaronda = new Ronda(mesa);
        mesa.setRonda(nuevaronda);
    }

    private void actualizarUltimaJugadaJugadores(Mesa mesa) {

        Map<Jugador, ArrayList<Apuesta>> apuestas = mesa.getRonda().getApuestas();

        for (Map.Entry<Jugador, ArrayList<Apuesta>> elemento : apuestas.entrySet()) {
            //obtengo para cada jugador sus apuestas
            Jugador jugador = elemento.getKey();
            ArrayList<Apuesta> listaApuestas = elemento.getValue();
            //la seteo como la ultima apuesta del jugador
            jugador.setUltimasApuestas(listaApuestas);
        }
    }
}
