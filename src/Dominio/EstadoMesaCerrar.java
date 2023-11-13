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
        balanceMesa(mesa, balance);  //setea monto total
        mesa.getEstadistica().setNumeroDeRonda(); 
        mesa.expulsarJugadores(); //elimino a los jugadores de la mesa
        Fachada.getInstancia().eliminarMesa(mesa);//elimino la mesa de disponibles
        Fachada.getInstancia().desloguearUsuarioCrupier(mesa.getCrupier());//deslogueo al crupier
    }
}
