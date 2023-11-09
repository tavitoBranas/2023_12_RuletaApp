package Dominio;

public class EstadoMesaCerrar extends EstadoMesa {

    public EstadoMesaCerrar() {
        super();
        this.setJugadoresAbandonanMesa(false);
        this.setJugadoresApuestan(false);
        this.setJugadoresIngresanMesa(false);
    }

}
