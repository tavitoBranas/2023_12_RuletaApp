package Dominio;

import java.util.ArrayList;

public final class ApuestaDirecta extends TipoApuesta {

    private ArrayList<Integer> casillerosApuestaDirecta;
    
    public ApuestaDirecta(int factor) {
        super("Apuesta Directa", factor);
        casillerosApuestaDirecta = new ArrayList<>();
        setCasilleros();
    }

    public void setCasilleros() {
        casillerosApuestaDirecta = ListaUniversalCasilleros.getApuestaDirecta();
    }

    public ArrayList<Integer> getCasillerosApuestaDirecta() {
        return casillerosApuestaDirecta;
    }

}
