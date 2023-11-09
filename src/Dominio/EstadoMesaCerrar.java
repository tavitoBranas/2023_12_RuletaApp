package Dominio;

public final class EstadoMesaCerrar extends EstadoMesa {

    public EstadoMesaCerrar(Mesa mesa) {
        super();
        this.setJugadoresAbandonanMesa(false);
        this.setJugadoresApuestan(false);
        this.setJugadoresIngresanMesa(false);
        accionar(mesa);
    }

    @Override
    protected void accionar(Mesa mesa) {

    }

}
