package Dominio;

public class ApuestaDirecta extends TipoApuesta {

    private static int factorDePago;

    public ApuestaDirecta(String tipo){
        super(tipo);
        factorDePago = 36;
    }

    public static int getFactorDePago() {
        return factorDePago;
    }
}
