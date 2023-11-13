package Dominio;

import java.util.ArrayList;

public final class ApuestaDirecta extends TipoApuesta {

    private ArrayList<Integer> casillerosApuestaDirecta;

    public ApuestaDirecta(int factor) {
        super("Apuesta Directa", factor);
        //casillerosApuestaDirecta = new ArrayList<>();
        // setCasilleros();
    }

    public ApuestaDirecta() {
        super();
    }
    
}
