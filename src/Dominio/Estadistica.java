package Dominio;

import comun.Observable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Estadistica extends Observable {

    private final ArrayList<Integer> numerosSorteados;
    private int numeroDeRonda;
    private int historicoRojo;
    private int historicoNegro;
    private int historicoPrimeraDocena;
    private int historicoSegundaDocena;
    private int historicoTerceraDocena;
    private HashMap<Integer, Integer> frecuenciaDeNumerosSorteados;

    public Estadistica() {
        numerosSorteados = new ArrayList<>();
        numeroDeRonda = 1;
        historicoRojo = 0;
        historicoNegro = 0;
        historicoPrimeraDocena = 0;
        historicoSegundaDocena = 0;
        historicoTerceraDocena = 0;
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
        numeroDeRonda += 1;
        avisar(Eventos.NumeroGanador);
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

    public Map<String, Integer> estadisticasDeLaMesa() {

        Map<String, Integer> estadisticasRetorno = new LinkedHashMap<>();

        //cargo porcentaje de colores
        int porcentaje = (int) Math.ceil(this.historicoRojo * 100.0f / numeroDeRonda);
        estadisticasRetorno.put("Rojo", porcentaje);

        porcentaje = (int) Math.ceil(this.historicoNegro * 100.0f / numeroDeRonda);
        estadisticasRetorno.put("Negro", porcentaje);

        //cargo porcentajes de docenas
        porcentaje = (int) Math.ceil(this.historicoPrimeraDocena * 100.0f / numeroDeRonda);
        estadisticasRetorno.put("Primera", porcentaje);

        porcentaje = (int) Math.ceil(this.historicoSegundaDocena * 100.0f / numeroDeRonda);
        estadisticasRetorno.put("Segunda", porcentaje);

        porcentaje = (int) Math.ceil(this.historicoTerceraDocena * 100.0f / numeroDeRonda);
        estadisticasRetorno.put("Tercera", porcentaje);

        //cargo porcentaje de numeros sorteados
        for (int i = 0; i < 37; i++) {
            int frecuencia = this.frecuenciaDeNumerosSorteados.get(i);
            porcentaje = (int) Math.ceil(this.frecuenciaDeNumerosSorteados.get(i) * 100.0f / numeroDeRonda);
            estadisticasRetorno.put(i + "", porcentaje);
        }
        return estadisticasRetorno;
    }

}
