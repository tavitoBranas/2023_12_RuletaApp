package Dominio;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public abstract class Efecto {

    //private Ronda rondaDeApuesta;
    private final String nombre;
    private Ronda ronda;
    private final ArrayList<Integer> casillerosGanadores;

    public Efecto(String nombre) {
        this.nombre = nombre;
        casillerosGanadores = new ArrayList<>();
        // rondaDeApuesta = ronda;
    }

    public String getNombre() {
        return nombre;
    }

    public ArrayList<Integer> getCasillerosGanadores() {
        return casillerosGanadores;
    }

    protected int seleccionarNumero() {
        Random random = new Random();
        int numeroAleatorio = random.nextInt(37);
        return numeroAleatorio;
    }

    protected Ronda getRonda() {
        return ronda;
    }

    protected abstract void numeroSorteado();

    protected void setearCasilleroGanador(int resultado) {
        getCasillerosGanadores().add(resultado);

        casilleroGanadorColor(resultado);
        casilleroGanadorDocena(resultado);

        //seteo estadistica
        seteoEstaditicaNumero(resultado);
    }

    protected void casilleroGanadorColor(int numero) {
        String color = "";
        //determino el color
        if (numero != 0) {
            if (ListaUniversalCasilleros.numerosRojos().contains(numero)) {
                this.getCasillerosGanadores().add(ListaUniversalCasilleros.casilleroRojo());
                color = "Rojo";
            } else {
                this.getCasillerosGanadores().add(ListaUniversalCasilleros.casilleroNegro());
                color = "Negro";
            }
        }
        //seteo estadistica
        seteoEstaditicaColor(color);
    }

    protected void casilleroGanadorDocena(int numero) {
        String retornoDocena = "";
        if (numero != 0) {
            HashMap docenas = ListaUniversalCasilleros.apuestasDocena();

            ArrayList primera = (ArrayList) docenas.get("Primera");
            ArrayList segunda = (ArrayList) docenas.get("Segunda");

            if (primera.contains(numero)) {
                this.getCasillerosGanadores().add(ListaUniversalCasilleros.primeraDocena());
                retornoDocena = "Primera";
            } else if (segunda.contains(numero)) {
                this.getCasillerosGanadores().add(ListaUniversalCasilleros.segundaDocena());
                retornoDocena = "Segunda";
            } else {
                this.getCasillerosGanadores().add(ListaUniversalCasilleros.terceraDocena());
                retornoDocena = "Tercera";
            }
        }
        //seteo estadistica
        seteoEstaditicaDocena(retornoDocena);
    }

    protected void seteoEstaditicaNumero(int numeroGanador) {
        ronda.getMesa().getEstadistica().ingresarNumeroSorteado(numeroGanador);
    }

    protected void seteoEstaditicaColor(String color) {
        if (!color.isEmpty()) {
            if (color.equals("Rojo")) {
                ronda.getMesa().getEstadistica().setHistoricoRojo();
            } else {
                ronda.getMesa().getEstadistica().setHistoricoNegro();
            }
        }
    }

    protected void seteoEstaditicaDocena(String docena) {
        if (!docena.isEmpty()) {
            switch (docena) {
                case "Primera":
                    ronda.getMesa().getEstadistica().setHistoricoPrimeraDocena();
                    break;
                case "Segunda":
                    ronda.getMesa().getEstadistica().setHistoricoSegundaDocena();
                    break;
                default:
                    ronda.getMesa().getEstadistica().setHistoricoTerceraDocena();
                    break;
            }
        }
    }
}
