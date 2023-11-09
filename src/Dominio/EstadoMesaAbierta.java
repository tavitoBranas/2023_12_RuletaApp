package Dominio;

public class EstadoMesaAbierta extends EstadoMesa {

    public EstadoMesaAbierta() {
        super();
        this.setJugadoresAbandonanMesa(true);
        this.setJugadoresApuestan(true);
        this.setJugadoresIngresanMesa(true);
    }
}
