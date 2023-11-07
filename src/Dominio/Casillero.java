package Dominio;

import java.util.ArrayList;

public class Casillero {

    private final ArrayList<Integer> casillerosHabilitados;

    public Casillero(ArrayList<Integer> casillerosHabilitados) {
        this.casillerosHabilitados = casillerosHabilitados;
    }

    public boolean casilleroHabilitado(int numero) {
        return casillerosHabilitados.contains(numero);
    }
}
