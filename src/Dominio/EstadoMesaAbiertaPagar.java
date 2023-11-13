package Dominio;

import Excepciones.MesaEstadoException;
import java.util.ArrayList;
import java.util.Map;

public final class EstadoMesaAbiertaPagar extends EstadoMesa {

    public EstadoMesaAbiertaPagar(Mesa mesa) {
        super(mesa);
    }

    @Override
    protected void habilitadoIngreso() {
    }

    @Override
    protected void habilitadoAvandono() {
    }

    @Override
    protected void habilitadoCierreDeMesa() throws MesaEstadoException {
        throw new MesaEstadoException("No se puede cerrar la mesa. Para ello la misma debe de estar "
                + "Lanzando");
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
