package Dominio;

public final class EstadoMesaAbiertaPagar extends EstadoMesa {

    public EstadoMesaAbiertaPagar(Mesa mesa) {
        super();
        this.setJugadoresAbandonanMesa(true);
        this.setJugadoresApuestan(true);
        this.setJugadoresIngresanMesa(true);
        mesa.setMensaje("La mesa esta disponible para jugar");
        generacionNuevaRonda(mesa);
    }

    @Override
    protected void accionar(Mesa mesa) {
        mesa.setMensaje("La mesa esta disponible para jugar");
        balanceMesa(mesa);
        generacionNuevaRonda(mesa);
    }

    private void generacionNuevaRonda(Mesa mesa) {
        Ronda nuevaronda = new Ronda(mesa);
        mesa.setRonda(nuevaronda);
    }

    private void balanceMesa(Mesa mesa) {
        //TODO balance mesa
        BalanceMesa balance = new BalanceMesa(100, 70, 150);
        mesa.getEstadistica().setHistoricoBalance(balance);
    }
}
