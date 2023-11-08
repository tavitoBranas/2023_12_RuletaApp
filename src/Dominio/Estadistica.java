package Dominio;

import java.util.ArrayList;

public class Estadistica {

    private ArrayList<Integer> numerosSorteados;
    private int historicoRojo;
    private int historicoNegro;
    private int historicoPrimeraDocena;
    private int historicoSegundaDocena;
    private int historicoTerceraDocena;

    public Estadistica() {
        numerosSorteados = new ArrayList<>();
        historicoRojo = 0;
        historicoNegro = 0;
        historicoPrimeraDocena = 0;
        historicoSegundaDocena = 0;
        historicoTerceraDocena = 0;
    }

    public void ingresarNumeroSorteado(int numero) {
        numerosSorteados.add(0, numero);
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

}
