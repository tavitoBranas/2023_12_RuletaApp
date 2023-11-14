package Dominio;

import Excepciones.EfectoException;
import Excepciones.MesaAbandonoException;
import Excepciones.MesaEstadoException;
import Excepciones.MesaNoDisponibleException;
import java.util.ArrayList;
import java.util.HashMap;

public final class EstadoMesaLanzar extends EstadoMesa {

    private final HashMap casillerosGanadores;

    public EstadoMesaLanzar(Mesa mesa) {
        super(mesa);
        casillerosGanadores = new HashMap<String, Integer>();
    }

    @Override
    protected void pagar() throws MesaEstadoException {
        mesa.setEstado(new EstadoMesaPagar(mesa));
        mesa.pagar();
    }

    @Override
    protected void cerrar() throws MesaEstadoException {
        throw new MesaEstadoException("No se puede CERRAR. Para ello la mesa debe de haber lanzado ");
    }

    @Override
    protected void habilitadoIngreso() throws MesaNoDisponibleException {
        throw new MesaNoDisponibleException("Esta mesa se encuentra pagando. Intente nuevamente en unos segundos");
    }

    @Override
    protected void habilitadoAvandono() throws MesaAbandonoException {
        throw new MesaAbandonoException("No se puede avandonar mesa. La misma esta pagando");
    }

    @Override
    public void lanzar() throws EfectoException {

        mesa.setMensaje("La mesa esta bloqueada. No se puede apostar ni abandonar la misma");
        //si da error el lanzar retorno a estado de mesa anterior
        try {
            mesa.getRonda().lanzar();
        } catch (EfectoException ex) {
            mesa.setEstado(new EstadoMesaAbierta(mesa));
            throw ex;
        }
        //seteo casilleros ganadores
        casillerosGanadores.clear();
        int numeroGanador = mesa.getRonda().getEfecto().getNumeroGanador();
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
        mesa.avisar(Eventos.Lanzar);
        mesa.setEstado(new EstadoMesaPagar(mesa));
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
