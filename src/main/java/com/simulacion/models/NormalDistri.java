package com.simulacion.models;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.math3.distribution.NormalDistribution;

/**
 * Implementación de generador de números pseudoaleatorios con distribución normal.
 */
public class NormalDistri {

    private List<Double> aleatoryNumbersRi;
    private List<Double> aleatoryNumbersNi;
    private int quantity;
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
    public NormalDistri(int quantity, double average, double desviation) {
        this.quantity = quantity;
        this.average = average;
        this.desviation = desviation;
        aleatoryNumbersRi = new ArrayList<>();
        aleatoryNumbersNi = new ArrayList<>();
        generateRandomRi();
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
     * Genera números aleatorios y los agrega a la lista Ri.
     */
    private void generateRandomRi() {
        ReduceLinear linear = new ReduceLinear(quantity);
        aleatoryNumbersRi = linear.getListRi();
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
