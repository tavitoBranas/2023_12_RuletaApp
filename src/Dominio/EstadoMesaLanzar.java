package Dominio;

import java.util.ArrayList;
import java.util.HashMap;

public final class EstadoMesaLanzar extends EstadoMesa {

    private final HashMap casillerosGanadores;

    public EstadoMesaLanzar() {
        super();
        //aca bloqueo apuestas y abandono de jugadores
        this.setJugadoresAbandonanMesa(false);
        this.setJugadoresApuestan(false);
        this.setJugadoresIngresanMesa(false);
        casillerosGanadores = new HashMap<String, Integer>();
    }

    @Override
    public void accionar(Mesa mesa) {
        //seteo casilleros ganadores
        casillerosGanadores.clear();
        int numeroGanador = mesa.getRonda().getEfecto().numeroGanador();
        ArrayList<TipoApuesta> tipoApuestas = mesa.getTipoApuesta();

        if (tipoApuestas.stream().anyMatch(apuesta -> apuesta instanceof ApuestaDirecta)) {
            setearNumeroGanador(numeroGanador, mesa);
        }
        if (tipoApuestas.stream().anyMatch(apuesta -> apuesta instanceof ApuestaColor)) {
            casilleroGanadorColor(numeroGanador, mesa);
        }
        if (tipoApuestas.stream().anyMatch(apuesta -> apuesta instanceof ApuestaDocena)) {
            casilleroGanadorDocena(numeroGanador, mesa);
        }
    }

    private void setearNumeroGanador(int resultado, Mesa mesa) {
        casillerosGanadores.put("Ganador", resultado);
        //seteo estadistica
        seteoEstaditicaNumero(resultado, mesa);
    }

    private void casilleroGanadorColor(int numero, Mesa mesa) {
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
        seteoEstaditicaColor(color, mesa);
    }

    private void casilleroGanadorDocena(int numero, Mesa mesa) {
        String retornoDocena = "";
        if (numero != 0) {
            HashMap docenas = ListaUniversalCasilleros.casillerosDocena();

            ArrayList primera = (ArrayList) docenas.get("Primera");
            ArrayList segunda = (ArrayList) docenas.get("Segunda");

            if (primera.contains(numero)) {
                casillerosGanadores.put("Docena", ListaUniversalCasilleros.casilleroPrimeraDocena());
                retornoDocena = "Primera";
            } else if (segunda.contains(numero)) {
                casillerosGanadores.put("Docena", ListaUniversalCasilleros.casilleroSegundaDocena());
                retornoDocena = "Segunda";
            } else {
                casillerosGanadores.put("Docena", ListaUniversalCasilleros.casilleroTerceraDocena());
                retornoDocena = "Tercera";
            }
        }
        //seteo estadistica
        seteoEstaditicaDocena(retornoDocena, mesa);
    }

    private void seteoEstaditicaNumero(int numeroGanador, Mesa mesa) {
        mesa.getEstadistica().ingresarNumeroSorteado(numeroGanador);
    }

    private void seteoEstaditicaColor(String color, Mesa mesa) {
        if (!color.isEmpty()) {
            if (color.equals("Rojo")) {
                mesa.getEstadistica().setHistoricoRojo();
            } else {
                mesa.getEstadistica().setHistoricoNegro();
            }
        }
    }

    private void seteoEstaditicaDocena(String docena, Mesa mesa) {
        if (!docena.isEmpty()) {
            switch (docena) {
                case "Primera":
                    mesa.getEstadistica().setHistoricoPrimeraDocena();
                    break;
                case "Segunda":
                    mesa.getEstadistica().setHistoricoSegundaDocena();
                    break;
                default:
                    mesa.getEstadistica().setHistoricoTerceraDocena();
                    break;
            }
        }
    }

}
