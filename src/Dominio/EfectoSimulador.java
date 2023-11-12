package Dominio;

public class EfectoSimulador extends Efecto {

    public EfectoSimulador() {
        super("Simulador");
    }

    @Override
    public void lanzar(Ronda ronda) {

        int resultado;
        
        do {
            resultado = numeroGanador();
            //la bola sortea únicamente entre los números que tienen Apuesta Directa, más el cero
        } while (validar(ronda, resultado) || resultado == 0);

        setearNumeroGanador(resultado);
    }
    
    private boolean validar(Ronda ronda, int resultado){
        boolean validar = false;
        if(!ronda.apuestaDerecta().isEmpty()){
            validar = !ronda.apuestaDerecta().contains(resultado);
        }
        return validar;
    }
        
}
