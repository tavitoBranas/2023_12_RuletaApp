package Dominio;

import java.util.ArrayList;

public final class ApuestaDocena extends TipoApuesta {

    private ArrayList<Integer> casillerosApuestaDocena;
    
    public ApuestaDocena(int factor) {
        super("Apuesta a Docena", factor);
        casillerosApuestaDocena = new ArrayList<>();
        setCasilleros();
    }

   public void setCasilleros() {
        casillerosApuestaDocena = ListaUniversalCasilleros.getCasillerosApuestaDocena();
    }

    public ArrayList<Integer> getCasillerosApuestaColor() {
        return casillerosApuestaDocena;
    }

    public void esValidaApuesta() {
        //TODO
        /*  Apostar a un grupo de 12 números (1-12, 13-24, 25-36).
        Restricciones: no se puede apostar a más de una docena por ronda.   */
    }
}
