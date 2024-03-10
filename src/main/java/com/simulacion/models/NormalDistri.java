package com.simulacion.models;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.apache.commons.math3.distribution.NormalDistribution;

/**
 * Implementación de generador de números pseudoaleatorios con distribución normal.
 */
public class NormalDistri {

    private List<Double> aleatoryNumbersRi;
    private List<Double> aleatoryNumbersXi;
    private List<Double> aleatoryNumbersNi;
    private int quantity;
    private int quantityXi;
    private int min;
    private int max;
    private double average;
    private double desviation;

    /**
     * Constructor para el generador de distribución normal.
     *
     * @param quantity  Cantidad total de números Ri a generar.
     * @param min       Valor mínimo del rango para generación de Xi.
     * @param max       Valor máximo del rango para generación de Xi.
     * @param quantityXi Cantidad de números Xi a generar para entrenamiento.
     */
    public NormalDistri(int quantity, int min, int max, int quantityXi) {
        this.quantity = quantity;
        this.min = min;
        this.max = max;
        this.quantityXi = quantityXi;
        aleatoryNumbersXi = new ArrayList<>();
        aleatoryNumbersRi = new ArrayList<>();
        aleatoryNumbersNi = new ArrayList<>();
        generateRandomRi();
        generateRandomXi();
        calculateAverage();
        calculateStandardDeviation();
        generateRandomNi();
    }

    /**
     * Genera números aleatorios con distribución normal.
     */
    private void generateRandomNi() {
        for (Double x : aleatoryNumbersRi) {
            aleatoryNumbersNi.add(new NormalDistribution(average, desviation).inverseCumulativeProbability(x));
        }
    }

    /**
     * Genera números aleatorios y los agrega a la lista Xi.
     */
    private void generateRandomXi() {
        Random random = new Random();
        for (int i = 0; i < quantityXi; i++) {
            int randomValue = random.nextInt((max - min) + 1) + min;
            double xi = randomValue + Math.random();
            aleatoryNumbersXi.add(xi);
        }
    }

    /**
     * Genera números aleatorios y los agrega a la lista Ri.
     */
    private void generateRandomRi() {
        for (int i = 0; i < quantity; i++) {
            aleatoryNumbersRi.add(Math.random());
        }
    }

    /**
     * Calcula el promedio de la lista de números Xi.
     */
    public void calculateAverage() {
        if (aleatoryNumbersXi == null || aleatoryNumbersXi.isEmpty()) {
            throw new IllegalArgumentException("La lista de números Xi no puede ser nula o vacía.");
        }
        double sum = 0;
        for (double number : aleatoryNumbersXi) {
            sum += number;
        }
        average = sum / aleatoryNumbersXi.size();
    }

    /**
     * Calcula la desviación estándar de la lista de números Xi.
     */
    public void calculateStandardDeviation() {
        if (aleatoryNumbersXi == null || aleatoryNumbersXi.size() < 2) {
            throw new IllegalArgumentException("La lista de números Xi debe contener al menos dos elementos.");
        }
        double sumSquaredDifferences = 0;
        for (double number : aleatoryNumbersXi) {
            double difference = number - average;
            sumSquaredDifferences += difference * difference;
        }

        double variance = sumSquaredDifferences / (aleatoryNumbersXi.size() - 1);
        desviation = Math.sqrt(variance);
    }

    /**
     * Obtiene la lista de números aleatorios generados Ri.
     *
     * @return Lista de números Ri.
     */
    public List<Double> getAleatoryRi() {
        return aleatoryNumbersRi;
    }

    /**
     * Obtiene los números aleatorios generados Ni.
     *
     * @return Lista de Números Pesudo aleatorios Ni.
     */
    public List<Double> getAleatoryNi() {
        return aleatoryNumbersNi;
    }

    /**
     * Obtiene el promedio de la lista de números Xi.
     *
     * @return Promedio de Xi.
     */
    public double getAverage() {
        return average;
    }

    /**
     * Obtiene la desviación estándar de la lista de números Xi.
     *
     * @return Desviación estándar de Xi.
     */
    public double getDesviation() {
        return desviation;
    }
}
