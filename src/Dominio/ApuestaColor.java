package Dominio;

public class ApuestaColor extends TipoApuesta {

    private int factorDePago;

    public ApuestaColor(String tipo) {
        super(tipo);
        factorDePago = 2;
    }

    public void esValidaApuesta() {
        //TODO
        /*  Restricciones: si un jugador pierde una apuesta por valor N a un color,
        no podrá volver a apostar un monto superior a N en la siguiente ronda en el mismo color. Si
        un jugador apuesta montos a los dos colores en la misma ronda, la restricción anterior no aplica, salvo que haya
        salido el cero.    */
    }

}
