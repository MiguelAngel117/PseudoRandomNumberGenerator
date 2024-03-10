/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.simulacion.models;


import java.util.ArrayList;
import java.util.List;

/**
 * Implementación de generador de números pseudoaleatorios por congruencia lineal.
 */
public class LinearCongruence {

    private static final int DEFAULT_K = 2;
    private static final int DEFAULT_G = 10;

    private int x;
    private int a;
    private int c;
    private int m;
    private int quantity;
    private List<Double> aleatory;
    private List<Integer> seeds;

    /**
     * Constructor para LinearCongruence.
     *
     * @param x        Valor de X
     * @param k        Valor de K
     * @param c        Valor de C
     * @param g        Valor G
     * @param quantity Cantidad de Números a Generar
     */
    public LinearCongruence(int x, int k, int c, int g, int quantity) {
        this.x = x;
        this.a = 1 + 2 * (k > 0 ? k : DEFAULT_K);
        this.c = c;
        this.m = (int) Math.pow(2, g > 0 ? g : DEFAULT_G);
        System.out.println(g);
        this.aleatory = new ArrayList<>();
        this.quantity = (quantity > 0 ? quantity : 1); // Asegurar que quantity sea un número positivo
        this.seeds = new ArrayList<>();
    }

    /**
     * Obtiene los números aleatorios generados Ri.
     *
     * @return Lista de números aleatorios
     */
    public List<Double> getAleatory() {
        generateRandom(calculateSeed(this.x));
        return aleatory;
    }

    /**
     * Genera números aleatorios de forma recursiva.
     *
     * @param seed Semilla para la generación de números aleatorios
     */
    private void generateRandom(int seed) {
        while (aleatory.size() < quantity) {
            aleatory.add(calculateNumber(seed));
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
