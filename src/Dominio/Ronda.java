package Dominio;

import java.util.ArrayList;

public class Ronda {

    private final Mesa mesa;
    private final Efecto efecto;
    private final ArrayList<Integer> casillerosSeleccionados;
    private ArrayList<Apuesta> apuestas;

    public Ronda(Efecto ef, ArrayList<Integer> casilleros, Mesa mesa) {
        this.mesa = mesa;
        efecto = ef;
        casillerosSeleccionados = casilleros;
    }

    public Mesa getMesa() {
        return mesa;
    }

    public ArrayList<Integer> apuestaDerecta() {
        ArrayList<Integer> retorno = new ArrayList<>();

        for (int a : getCasillerosSeleccionados()) {
            if (a >= 0 && a <= 36 && !retorno.contains(a)) {
                retorno.add(a);
            }
        }
        return retorno;
    }

    public Efecto getEfecto() {
        return efecto;
    }

    public ArrayList<Apuesta> getApuestas() {
        return apuestas;
    }

    public ArrayList<Integer> getCasillerosSeleccionados() {
        return casillerosSeleccionados;
    }
    
    public void lanzar(){
        this.getEfecto().lanzar();
    }
}
