package Dominio;

public class EfectoAleatorioParcial extends Efecto {

    public EfectoAleatorioParcial() {
        super("Aleatorio parcial");
    }

    @Override
    protected void numeroSorteado() {
        int resultado;
        do {
            resultado = seleccionarNumero();
            //la bola determina un valor aleatorio, pero asegurando de no repetir los últimos 3 valores. 
        } while (!getRonda().getMesa().getEstadistica().getUltimosTresNumerosSorteados().contains(resultado));
        
        setearCasilleroGanador(resultado);
    }
}
