package com.simulacion.models;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementación de generador de números pseudoaleatorios por congruencia multiplicativa.
 */
public class MultiplicativeCongruence {

    private static final int DEFAULT_T = 5;
    private static final int DEFAULT_G = 10;

    private int a;
    private int m;
    private int min;
    private int max;
    private int quantity;
    private List<Double> aleatoryRi;
    private List<Double> aleatoryNi;
    private List<Integer> seeds;

    /**
     * Constructor para Multiplicative.
     *
     * @param x        Valor de X
     * @param t        Valor de T
     * @param g        Valor G
     * @param quantity Cantidad de Números a Generar
     */
    public MultiplicativeCongruence(int seed, int t, int g, int quantity, int min, int max) {
        this.min = min;
        this.max = max;
        a = 8 * (t > 0 ? t : DEFAULT_T) + 5; //a = 8t +5
        m = (int) Math.pow(2, g > 0 ? g : DEFAULT_G);
        this.aleatoryRi = new ArrayList<>();
        this.aleatoryNi = new ArrayList<>();
        this.quantity = (quantity > 0 ? quantity : 1); // Asegurar que quantity sea un número positivo
        this.seeds = new ArrayList<>();
        generateRandom(calculateSeed(seed));
    }

    /**
     * Obtiene los números aleatorios generados.
     *
     * @return Lista de números aleatorios
     */
    public List<Double> getAleatoryRi() {
        return aleatoryRi;
    }

    public List<Double> getAleatoryNi() {
        return aleatoryNi;
    }

    /**
     * Genera números aleatorios de forma recursiva.
     *
     * @param seed Semilla para la generación de números aleatorios
     */
    private void generateRandom(int seed) {
        while (aleatoryRi.size() < quantity) {
            double ri = calculateNumber(seed);
            aleatoryRi.add(ri);
            aleatoryNi.add(min + (max - min)*ri);
            int newSeed = calculateSeed(seed);
            seeds.add(seed);
            seed = newSeed;
        }
    }

    /**
     * Calcula un número aleatorio normalizado.
     *
     * @param seed Semilla para la generación de números aleatorios
     * @return Número aleatorio normalizado
     */
    private Double calculateNumber(int seed) {
        return (double) seed / (m - 1);
    }

    /**
     * Calcula una nueva semilla.
     *
     * @param xi Semilla actual
     * @return Nueva semilla
     */
    private int calculateSeed(int xi) {
        return (xi * a) % m;
    }

    /**
     * Obtiene la lista de semillas generadas.
     *
     * @return Lista de semillas
     */
    public List<Integer> getSeeds() {
        return seeds;
    }
}