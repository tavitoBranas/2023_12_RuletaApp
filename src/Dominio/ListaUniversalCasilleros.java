package Dominio;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ListaUniversalCasilleros {

    public static ArrayList<Integer> getCasillerosApuestaDirecta() {
        ArrayList<Integer> casillerosApuestaDirecta = new ArrayList<>();
        int i = 0;
        while (i < 37) {
            casillerosApuestaDirecta.add(i);
            i++;
        }
        return casillerosApuestaDirecta;
    }

    public static ArrayList<Integer> getCasillerosApuestaColor() {
        ArrayList<Integer> casillerosApuestaColor = new ArrayList<>();
        int i = 43;
        while (i < 45) {
            casillerosApuestaColor.add(i);
            i++;
        }
        return casillerosApuestaColor;
    }

    public static ArrayList<Integer> getCasillerosApuestaDocena() {
        ArrayList<Integer> casillerosApuestaDocena = new ArrayList<>();

        int i = 40;
        while (i < 43) {
            casillerosApuestaDocena.add(i);
            i++;
        }
        return casillerosApuestaDocena;
    }

    public static ArrayList<Integer> numerosRojos() {
        ArrayList<Integer> numerosRojos = new ArrayList<>();
        // Agregar los números rojos a la lista
        numerosRojos.add(1);
        numerosRojos.add(3);
        numerosRojos.add(5);
        numerosRojos.add(7);
        numerosRojos.add(9);
        numerosRojos.add(12);
        numerosRojos.add(14);
        numerosRojos.add(16);
        numerosRojos.add(18);
        numerosRojos.add(19);
        numerosRojos.add(21);
        numerosRojos.add(23);
        numerosRojos.add(25);
        numerosRojos.add(27);
        numerosRojos.add(30);
        numerosRojos.add(32);
        numerosRojos.add(34);
        numerosRojos.add(36);

        return numerosRojos;
    }

    public static HashMap casillerosDocena() {
        HashMap<String, ArrayList<Integer>> docenas = new HashMap<>();

        ArrayList<Integer> primeraDocena = new ArrayList<>();
        ArrayList<Integer> segundaDocena = new ArrayList<>();
        ArrayList<Integer> terceraDocena = new ArrayList<>();

        // Llenar las listas con los números de las docenas
        for (int i = 1; i <= 12; i++) {
            primeraDocena.add(i);
        }
        for (int i = 13; i <= 24; i++) {
            segundaDocena.add(i);
        }
        for (int i = 25; i <= 36; i++) {
            terceraDocena.add(i);
        }
        docenas.put("Primera", primeraDocena);
        docenas.put("Segunda", segundaDocena);
        docenas.put("Tercera", terceraDocena);

        return docenas;
    }

    public static int casilleroRojo() {
        return 43;
    }

    public static int casilleroNegro() {
        return 44;
    }

    public static int casilleroPrimeraDocena() {
        return 40;
    }

    public static int casilleroSegundaDocena() {
        return 41;
    }

    public static int casilleroTerceraDocena() {
        return 42;
    }

    public static boolean apuestaInvolucraDocena(Apuesta apuesta) {
        return getCasillerosApuestaDocena().stream().anyMatch(a -> a == apuesta.getCasillero());
    }

    public static boolean apuestaInvolucraColor(Apuesta apuesta) {
        return ListaUniversalCasilleros.getCasillerosApuestaColor().stream().anyMatch(a -> a == apuesta.getCasillero());
    }

    public static int colorCasillero(int ultimoGanador) {
        int retorno = -1; //si es cero no se determina color
        if (numerosRojos().stream().anyMatch(l -> l == ultimoGanador)) {
            retorno = casilleroRojo();
        } else {
            retorno = casilleroNegro();
        }
        return retorno;
    }

    static int docenaCasillero(int numeroGanador) {
        int retorno = -1; //si el ganador es cero entonces no tiene docena
        Map<String, ArrayList<Integer>> docenas = casillerosDocena();
        for (Map.Entry<String, ArrayList<Integer>> elemento : docenas.entrySet()) {
            String docena = elemento.getKey();
            ArrayList<Integer> numerosDeDocena = elemento.getValue();

            if (numerosDeDocena.stream().anyMatch(d -> d == numeroGanador)) {
                retorno = numeroDocena(docena);
            }
        }
        return retorno;
    }

    private static int numeroDocena(String docena) {
        int retorno;

        switch (docena) {
            case "Primera":
                retorno = casilleroPrimeraDocena();
                break;
            case "Segunda":
                retorno = casilleroSegundaDocena();
                break;
            default:
                retorno = casilleroTerceraDocena();
                break;
        }
        return retorno;
    }

    public static ArrayList<Integer> casillerosDisponibles() {
        ArrayList<Integer> retorno = new ArrayList<>();

        for (Integer casillero : getCasillerosApuestaDirecta()) {
            retorno.add(casillero);
        }
        for (Integer casillero : getCasillerosApuestaColor()) {
            retorno.add(casillero);
        }
        for (Integer casillero : getCasillerosApuestaDocena()) {
            retorno.add(casillero);
        }
        return retorno;
    }
}
