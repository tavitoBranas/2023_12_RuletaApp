package Dominio;

public final class EstadoMesaPagar extends EstadoMesa {

    public EstadoMesaPagar(Mesa mesa) {
        super();
        this.setJugadoresAbandonanMesa(false);
        this.setJugadoresApuestan(false);
        this.setJugadoresIngresanMesa(false);
        accionar(mesa);
    }

    @Override
    protected void accionar(Mesa mesa) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
