package Dominio;

public class EstadoMesaLanzar extends EstadoMesa {

    public EstadoMesaLanzar() {
        super();
        this.setJugadoresAbandonanMesa(false);
        this.setJugadoresApuestan(false);
        this.setJugadoresIngresanMesa(false);
    }
    
    

}
