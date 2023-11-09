package Dominio;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public abstract class Efecto {

    private final String nombre;
    private Ronda ronda;
    private final HashMap casillerosGanadores;

    public Efecto(String nombre) {
        this.nombre = nombre;
        casillerosGanadores = new HashMap<String, Integer>();
        // rondaDeApuesta = ronda;
    }

    public String getNombre() {
        return nombre;
    }

    public HashMap getCasillerosGanadores() {
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

    public void setRonda(Ronda ronda) {
        this.ronda = ronda;
    }

    protected abstract void lanzar();

    protected void setearCasilleroGanador(int resultado) {
        getCasillerosGanadores().clear();
        casillerosGanadores.put("Numero", resultado);

        casilleroGanadorColor(resultado);
        casilleroGanadorDocena(resultado);

        //seteo estadistica
        seteoEstaditicaNumero(resultado);
        
    }

    private void casilleroGanadorColor(int numero) {
        String color = "";
        //determino el color
        if (numero != 0) {
            if (ListaUniversalCasilleros.numerosRojos().contains(numero)) {
                casillerosGanadores.put("Color", ListaUniversalCasilleros.casilleroRojo());
                color = "Rojo";
            } else {
                casillerosGanadores.put("Color", ListaUniversalCasilleros.casilleroNegro());
                color = "Negro";
            }
        }
        //seteo estadistica
        seteoEstaditicaColor(color);
    }

    private void casilleroGanadorDocena(int numero) {
        String retornoDocena = "";
        if (numero != 0) {
            HashMap docenas = ListaUniversalCasilleros.casillerosDocena();

            ArrayList primera = (ArrayList) docenas.get("Primera");
            ArrayList segunda = (ArrayList) docenas.get("Segunda");

            if (primera.contains(numero)) {
                casillerosGanadores.put("Docena", ListaUniversalCasilleros.casilleroPrimeraDocena());
                retornoDocena = "Primera";
            } else if (segunda.contains(numero)) {

                retornoDocena = "Segunda";
            } else {
                casillerosGanadores.put("Docena", ListaUniversalCasilleros.casilleroTerceraDocena());
                retornoDocena = "Tercera";
            }
        }
        //seteo estadistica
        seteoEstaditicaDocena(retornoDocena);
    }

    private void seteoEstaditicaNumero(int numeroGanador) {
        getRonda().getMesa().getEstadistica().ingresarNumeroSorteado(numeroGanador);
    }

    private void seteoEstaditicaColor(String color) {
        if (!color.isEmpty()) {
            if (color.equals("Rojo")) {
                getRonda().getMesa().getEstadistica().setHistoricoRojo();
            } else {
                getRonda().getMesa().getEstadistica().setHistoricoNegro();
            }
        }
    }

    private void seteoEstaditicaDocena(String docena) {
        if (!docena.isEmpty()) {
            switch (docena) {
                case "Primera":
                    getRonda().getMesa().getEstadistica().setHistoricoPrimeraDocena();
                    break;
                case "Segunda":
                    getRonda().getMesa().getEstadistica().setHistoricoSegundaDocena();
                    break;
                default:
                    getRonda().getMesa().getEstadistica().setHistoricoTerceraDocena();
                    break;
            }
        }
    }

}
