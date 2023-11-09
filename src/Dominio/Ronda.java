package Dominio;

import java.util.ArrayList;

public class Ronda {

    private final Mesa mesa;
    private Efecto efecto;
    private ArrayList<Integer> casillerosSeleccionados;
    private ArrayList<Apuesta> apuestas;

    public Ronda(Mesa mesa) {
        this.mesa = mesa;
        mesa.setRonda(this);
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

    public void setCasillerosSeleccionados(ArrayList<Integer> casillerosSeleccionados) {
        this.casillerosSeleccionados = casillerosSeleccionados;
    }

    public void lanzar() {
        this.getEfecto().lanzar();
    }

    public void setEfecto(Efecto efecto) {
        this.efecto = efecto;
        efecto.setRonda(this);
    }
    /*
    public void setCasillerosSeleccionados(ArrayList<Integer> casillerosSeleccionados) {
        this.casillerosSeleccionados = casillerosSeleccionados;
    }

    public void setApuestas(ArrayList<Apuesta> apuestas) {
        this.apuestas = apuestas;
    }*/

}
