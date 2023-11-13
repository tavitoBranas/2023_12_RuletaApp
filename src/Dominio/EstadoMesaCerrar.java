package Dominio;

import Excepciones.MesaAbandonoException;
import Excepciones.MesaEstadoException;
import Excepciones.MesaNoDisponibleException;
import Logica.Fachada;

public final class EstadoMesaCerrar extends EstadoMesa {

    public EstadoMesaCerrar(Mesa mesa) {
        super(mesa);
    }

    @Override
    protected void habilitadoIngreso() throws MesaNoDisponibleException {
        throw new MesaNoDisponibleException("Esta mesa esta cerrando. No es posible su acceso");
    }

    @Override
    protected void habilitadoAvandono() throws MesaAbandonoException {
        throw new MesaAbandonoException("No se puede avandonar mesa. La misma esta pagando");
    }

    @Override
    protected void habilitadoCierreDeMesa() throws MesaEstadoException {
    }

    @Override
    protected void cerrar() {
        mesa.setMensaje("La mesa se va a cerrar");
        mesa.avisar(Eventos.MesaPorCerrar);
        BalanceMesa balance = new BalanceMesa(mesa.getEstadistica().getNumeroDeRonda());
        pagarJugadores(mesa, balance);
        balanceMesa(mesa, balance);
        mesa.getEstadistica().setNumeroDeRonda();
        mesa.expulsarJugadores(); //elimino a los jugadores de la mesa
        Fachada.getInstancia().eliminarMesa(mesa);//elimino la mesa de disponibles
        Fachada.getInstancia().desloguearUsuarioCrupier(mesa.getCrupier());//deslogueo al crupier
    }
}
