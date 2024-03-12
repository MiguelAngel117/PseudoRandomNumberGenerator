package com.simulacion.models;


import java.util.ArrayList;
import java.util.List;

/**
 * Implementación de generador de números pseudoaleatorios por congruencia lineal.
 */
public class LinearCongruence {

    private static final int DEFAULT_K = 2;
    private static final int DEFAULT_G = 10;

    private int min;
    private int max;
    private int a;
    private int c;
    private int m;
    private int quantity;
    private List<Double> aleatoryRi;
    private List<Double> aleatoryNi;
    private List<Integer> seeds;

    /**
     * Constructor para LinearCongruence.
     *
     * @param k        Valor de K
     * @param c        Valor de C
     * @param g        Valor G
     * @param quantity Cantidad de Números a Generar
     */
    public LinearCongruence(int seed, int k, int c, int g, int quantity, int min, int max, boolean type) {
        this.min = min;
        this.max = max;
        this.a = 1 + 2 * (k > 0 ? k : DEFAULT_K);
        this.c = c;
        this.m = (int) Math.pow(2, g > 0 ? g : DEFAULT_G);
        this.quantity = (quantity > 0 ? quantity : 1); // Asegurar que quantity sea un número positivo
        seeds = new ArrayList<>();
        aleatoryRi = new ArrayList<>();
        aleatoryNi = new ArrayList<>();
        generateRandom(calculateSeed(seed), type);
    }

    /**
     * Obtiene los números aleatorios generados Ri.
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
    private void generateRandom(int seed, boolean type) {
        while (aleatoryRi.size() < quantity) {
            double ri = calculateNumber(seed, type);
            System.out.println(ri);
            aleatoryRi.add(ri);
            aleatoryNi.add(min + (max - min) * ri);
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
    private Double calculateNumber(int seed, boolean type) { 
        if(type)
            return (double) seed / (m - 1);
        else
            return (double) seed / (m);
    }

    /**
     * Calcula una nueva semilla.
     *
     * @param xi Semilla actual
     * @return Nueva semilla
     */
    private int calculateSeed(int xi) {
        return (a * xi + c) % m;
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
