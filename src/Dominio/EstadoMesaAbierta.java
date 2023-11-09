package Dominio;

public final class EstadoMesaAbierta extends EstadoMesa {

    public EstadoMesaAbierta(Mesa mesa) {
        super();
        this.setJugadoresAbandonanMesa(true);
        this.setJugadoresApuestan(true);
        this.setJugadoresIngresanMesa(true);
        accionar(mesa);
    }
    

    @Override
    protected void accionar(Mesa mesa){}
}
