package Dominio;

import java.util.ArrayList;
import java.util.HashMap;

public class ListaUniversalCasilleros {

    private static ArrayList<Integer> apuestaDirecta;
    private static ArrayList<Integer> apuestaColor;
    private static ArrayList<Integer> apuestaDocena;

    public ListaUniversalCasilleros() {
        setApuestaDirecta();
        setApuestaColor();
        setApuestaDocena();
    }

    public static ArrayList<Integer> getApuestaDirecta() {
        return apuestaDirecta;
    }

    private static void setApuestaDirecta() {
        int i = 0;
        while (i < 37) {
            apuestaDirecta.add(i);
            i++;
        }
    }

    public static ArrayList<Integer> getApuestaColor() {
        return apuestaColor;
    }

    private void setApuestaColor() {
        int i = 43;
        while (i < 45) {
            apuestaColor.add(i);
            i++;
        }
    }

    public static ArrayList<Integer> getApuestaDocena() {
        return apuestaDocena;
    }

    private void setApuestaDocena() {
        int i = 40;
        while (i < 43) {
            apuestaDocena.add(i);
            i++;
        }
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

    public static HashMap apuestasDocena() {
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

    public static int primeraDocena() {
        return 40;
    }

    public static int segundaDocena() {
        return 41;
    }

    public static int terceraDocena() {
        return 42;
    }
}
