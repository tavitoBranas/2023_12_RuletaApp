package Dominio;

import java.util.ArrayList;

public final class ApuestaColor extends TipoApuesta {

    private ArrayList<Integer> casillerosApuestaColor;

    public ApuestaColor(int factor) {
        super("Apuesta a Color", factor);
        casillerosApuestaColor = new ArrayList<>();
        setCasilleros();
    }

    public void setCasilleros() {
        casillerosApuestaColor = ListaUniversalCasilleros.getApuestaColor();
    }

    public ArrayList<Integer> getCasillerosApuestaColor() {
        return casillerosApuestaColor;
    }

    public void esValidaApuesta() {
        //TODO
        /*  Restricciones: si un jugador pierde una apuesta por valor N a un color,
        no podrá volver a apostar un monto superior a N en la siguiente ronda en el mismo color. Si
        un jugador apuesta montos a los dos colores en la misma ronda, la restricción anterior no aplica, salvo que haya
        salido el cero.    */
    }
}
