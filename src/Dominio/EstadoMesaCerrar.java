package Dominio;

import Logica.Fachada;

public final class EstadoMesaCerrar extends EstadoMesa {

    public EstadoMesaCerrar(Mesa mesa) {
        super();
        this.setJugadoresAbandonanMesa(false);
        this.setJugadoresApuestan(false);
        this.setJugadoresIngresanMesa(false);
    }

    @Override
    protected void cerrar(Mesa mesa) {
        mesa.setMensaje("La mesa se va a cerrar");
        mesa.avisar(Eventos.MesaPorCerrar);
        BalanceMesa balance = new BalanceMesa(mesa.getEstadistica().getNumeroDeRonda());
        pagarJugadores(mesa, balance);
        //ya establece la recoleccion de la mesa al ver que perdieron
        //setea la liquidacion al pagar al jugador
        //setea ganancias y perdidas de jugador a nivel de su balance
        balanceMesa(mesa, balance);  //setea monto total
        mesa.getEstadistica().setNumeroDeRonda();
        //elimino a los jugadores de la mesa
        mesa.expulsarJugadores();
        //elimino la mesa de disponibles
        Fachada.getInstancia().eliminarMesa(mesa);
        //deslogueo al crupier
        Fachada.getInstancia().desloguearUsuarioCrupier(mesa.getCrupier());
    }

}
