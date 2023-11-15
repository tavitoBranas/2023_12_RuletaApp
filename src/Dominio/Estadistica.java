package Dominio;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Estadistica {

    private final ArrayList<Integer> numerosSorteados;
    private int numeroDeRonda;
    private int historicoRojo;
    private int historicoNegro;
    private int historicoPrimeraDocena;
    private int historicoSegundaDocena;
    private int historicoTerceraDocena;
    private HashMap<Integer, Integer> frecuenciaDeNumerosSorteados; //aca tengo un hasmap con los numeros y la frecuencia que se obtuvieron
    private final ArrayList<BalanceMesa> historicoBalance; //aca tengo un arrayList de los balances de la mesa
    private final Mesa mesa;

    public Estadistica(Mesa mesa) {
        numerosSorteados = new ArrayList<>();
        numeroDeRonda = 1;
        historicoRojo = 0;
        historicoNegro = 0;
        historicoPrimeraDocena = 0;
        historicoSegundaDocena = 0;
        historicoTerceraDocena = 0;
        historicoBalance = new ArrayList<>();
        this.mesa = mesa;
        inicializarEstadisticaNumerosSorteados();
    }

    private void inicializarEstadisticaNumerosSorteados() {
        HashMap<Integer, Integer> estadisticaNumeros = new HashMap<>();
        int i = 0;
        while (i < 37) {
            estadisticaNumeros.put(i, 0);
            i++;
        }
        this.frecuenciaDeNumerosSorteados = estadisticaNumeros;
    }

    public ArrayList<Integer> getUltimosTresNumerosSorteados() {
        ArrayList<Integer> tresUltimos = new ArrayList<>();

        if (!numerosSorteados.isEmpty()) {
            for (int i = 0; i < numerosSorteados.size() && i < 3; i++) {
                tresUltimos.add(numerosSorteados.get(i));
            }
        }
        return tresUltimos;
    }

    public void ingresarNumeroSorteado(int numero) {
        numerosSorteados.add(0, numero);
        //seteo la estadistica del numero
        frecuenciaDeNumerosSorteados.put(numero, frecuenciaDeNumerosSorteados.get(numero) + 1);
    }

    public ArrayList<Integer> getNumerosSorteados() {
        return numerosSorteados;
    }

    public int getHistoricoRojo() {
        return historicoRojo;
    }

    public void setHistoricoRojo() {
        this.historicoRojo += 1;
    }

    public int getHistoricoNegro() {
        return historicoNegro;
    }

    public void setHistoricoNegro() {
        this.historicoNegro += 1;
    }

    public int getHistoricoPrimeraDocena() {
        return historicoPrimeraDocena;
    }

    public void setHistoricoPrimeraDocena() {
        this.historicoPrimeraDocena += 1;
    }

    public int getHistoricoSegundaDocena() {
        return historicoSegundaDocena;
    }

    public void setHistoricoSegundaDocena() {
        this.historicoSegundaDocena += 1;
    }

    public int getHistoricoTerceraDocena() {
        return historicoTerceraDocena;
    }

    public void setHistoricoTerceraDocena() {
        this.historicoTerceraDocena += 1;
    }

    public int getNumeroDeRonda() {
        return numeroDeRonda;
    }

    public void setNumeroDeRonda() {
        numeroDeRonda += 1;
    }

    public ArrayList<BalanceMesa> getHistoricoBalance() {
        return historicoBalance;
    }

    public int getSaldo() {
        return historicoBalance.get(0).getBalancePosterior();
    }

    public void setHistoricoBalance(BalanceMesa balance) {
        if (!historicoBalance.isEmpty()) {
            balance.setBalanceAnterior(historicoBalance.get(0).getBalancePosterior());
            balance.setBalancePosterior();
            this.historicoBalance.add(0, balance);
        } else {
            balance.setBalancePosterior();
            this.historicoBalance.add(0, balance);
        }
    }

    public Map<String, Integer> estadisticasDeLaMesa() {
        Map<String, Integer> estadisticasRetorno = new LinkedHashMap<>();
        int porcentaje;

        //cargo porcentaje de colores
        if (mesa.getTipoApuesta().stream().anyMatch(apuesta -> apuesta instanceof ApuestaColor)) {
            porcentaje = (int) Math.ceil(this.historicoRojo * 100.0f / (numeroDeRonda-1));
            estadisticasRetorno.put("Rojo", porcentaje);

            porcentaje = (int) Math.ceil(this.historicoNegro * 100.0f / (numeroDeRonda-1));
            estadisticasRetorno.put("Negro", porcentaje);
        }

        //cargo porcentajes de docenas
        if (mesa.getTipoApuesta().stream().anyMatch(apuesta -> apuesta instanceof ApuestaDocena)) {
            porcentaje = (int) Math.ceil(this.historicoPrimeraDocena * 100.0f / (numeroDeRonda-1));
            estadisticasRetorno.put("Primera", porcentaje);

            porcentaje = (int) Math.ceil(this.historicoSegundaDocena * 100.0f / (numeroDeRonda-1));
            estadisticasRetorno.put("Segunda", porcentaje);

            porcentaje = (int) Math.ceil(this.historicoTerceraDocena * 100.0f / (numeroDeRonda-1));
            estadisticasRetorno.put("Tercera", porcentaje);
        }

        //cargo porcentaje de numeros sorteados
        if (mesa.getTipoApuesta().stream().anyMatch(apuesta -> apuesta instanceof ApuestaDirecta)) {
            for (int i = 0; i < 37; i++) {
                porcentaje = (int) Math.ceil(this.frecuenciaDeNumerosSorteados.get(i) * 100.0f / (numeroDeRonda-1));
                estadisticasRetorno.put(i + "", porcentaje);
            }
        }
        return estadisticasRetorno;
    }
}
