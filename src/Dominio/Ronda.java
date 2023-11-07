package Dominio;

import java.util.ArrayList;

public class Ronda {

    private Mesa mesa;
    private ArrayList<Apuesta> apuestas;

    public Ronda(Mesa mesa) {
        this.mesa = mesa;
    }

    public Mesa getMesa() {
        return mesa;
    }

    public ArrayList<Integer> apuestaDerecta() {
        ArrayList<Integer> retorno = new ArrayList<>();

        for (Apuesta a : apuestas) {
            if (a.getCasillero() >= 0 && a.getCasillero() <= 36 && !retorno.contains(a.getCasillero())) {
                retorno.add(a.getCasillero());
            }
        }
        return retorno;
    }
}
