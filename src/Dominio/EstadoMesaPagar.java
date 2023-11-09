package Dominio;

public class EstadoMesaPagar extends EstadoMesa {

    public EstadoMesaPagar() {
        super();
        this.setJugadoresAbandonanMesa(false);
        this.setJugadoresApuestan(false);
        this.setJugadoresIngresanMesa(false);
    }
    
    

}
