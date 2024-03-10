package com.simulacion.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase para gestionar un intervalo y cálculos relacionados para distribución normal.
 */
public class Interval {

    private List<Double> interval;
    private double average;
    private double deviation;
    private double variation;
    private List<Double> aleatory;
    private int min;
    private int max;

    /**
     * Constructor para Interval.
     *
     * @param min      Mínimo
     * @param max      Máximo
     * @param aleatory Lista de aleatorios 0-1
     */
    public Interval(int min, int max, List<Double> aleatory) {
        this.aleatory = aleatory;
        this.min = min;
        this.max = max;
        calculateAverage();
        calculateVariation();
        calculateDeviation();
    }

    /**
     * Obtiene el intervalo de números.
     *
     * @return Lista de números en el intervalo
     */
    public List<Double> getInterval() {
        this.interval = new ArrayList<>();
        for (Double ri : aleatory) {
            interval.add(min + (max - min) * ri);
        }
        return interval;
    }

    /**
     * Calcula el promedio del intervalo.
     */
    private void calculateAverage() {
        double sum = 0;
        for (Double num : getInterval()) {
            sum += num;
        }
        average = sum / aleatory.size();
    }

    /**
     * Calcula la variación del intervalo.
     */
    private void calculateVariation() {
        double rango;
        for (Double num : interval) {
            rango = Math.pow(num - average, 2);
            variation += rango;
        }
    }

    /**
     * Calcula la desviación estándar del intervalo.
     *
     * @return Desviación estándar
     */
    private double calculateDeviation() {
        deviation = Math.sqrt(variation);
        return deviation;
    }

    /**
     * Obtiene la media del intervalo.
     *
     * @return Media
     */
    public double getAverage() {
        return average;
    }

    /**
     * Obtiene la desviación estándar del intervalo.
     *
     * @return Desviación estándar
     */
    public double getDeviation() {
        return deviation;
    }

    /**
     * Obtiene la variación del intervalo.
     *
     * @return Variación
     */
    public double getVariation() {
        return variation;
    }
}
