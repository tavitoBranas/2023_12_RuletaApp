package Dominio;

public class ApuestaDocena extends TipoApuesta {

    private int factorDePago;

    public ApuestaDocena(String tipo) {
        super(tipo);
        factorDePago = 3;
    }

    public void esValidaApuesta() {
        //TODO
        /*  Apostar a un grupo de 12 números (1-12, 13-24, 25-36).
        Restricciones: no se puede apostar a más de una docena por ronda.   */
    }
}
