package main.java;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import main.java.Palabra;

public class BasePalabras {
    private static Map<Integer, Palabra> base = new HashMap<Integer, Palabra>();

    static void generarPalabras() {
        base.put(0, new Palabra("Facil", "esp", "Animales", "Gato"));
        base.put(1, new Palabra("Intermedio", "esp", "Animales", "Rinoceronte"));
        base.put(2, new Palabra("Intermedio", "esp", "Animales", "Elefante"));
        base.put(3, new Palabra("Intermedio", "esp", "Animales", "Ballena"));
        base.put(4, new Palabra("Intermedio", "esp", "Animales", "Leopardo"));
        base.put(5, new Palabra("Dificil", "esp", "Animales", "Fanfin"));
    }

    static Palabra obtenerPalabra(String idioma, String dificultad, String tematica) {
        Palabra palabra = null;
        int cantPalabras = base.size();
        Random rand = new Random();

        int  n = 0;
        while (!base.get(n).getIdioma().equals(idioma) ||
               !base.get(n).getTematica().equals(tematica) ||
               !base.get(n).getDificultad().equals(dificultad)) {
            n = rand.nextInt(cantPalabras);
        }
        return palabra = base.get(n);
    }
}
