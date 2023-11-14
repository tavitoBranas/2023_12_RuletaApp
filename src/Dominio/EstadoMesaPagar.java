package Dominio;

import Excepciones.EfectoException;
import Excepciones.MesaEstadoException;
import java.util.ArrayList;
import java.util.Map;

public final class EstadoMesaPagar extends EstadoMesa {

    public EstadoMesaPagar(Mesa mesa) {
        super(mesa);
    }

    @Override
    protected void lanzar() throws EfectoException, MesaEstadoException {
        throw new MesaEstadoException("No se puede LANZAR. Para ello la mesa debe de haber "
                + "abierta");
    }

    @Override
    protected void cerrar() throws MesaEstadoException {
        mesa.setEstado(new EstadoMesaCerrar(mesa));
        mesa.cerrar();
    }

    @Override
    protected void habilitadoIngreso() {
    }

    @Override
    protected void habilitadoAvandono() {
    }

    @Override
    protected void pagar() {
        mesa.setMensaje("La mesa esta disponible para jugar");
        BalanceMesa balance = new BalanceMesa(mesa.getEstadistica().getNumeroDeRonda());
        pagarJugadores(mesa, balance);
        balanceMesa(mesa, balance);  //setea monto total
        actualizarUltimaJugadaJugadores(mesa);
        generacionNuevaRonda(mesa);
        mesa.getEstadistica().setNumeroDeRonda();
        mesa.avisar(Eventos.Pagar);
        //actualizo estado a abrir
        mesa.setEstado(new EstadoMesaAbierta(mesa));
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
