package com.simulacion.models;

import java.util.ArrayList;
import java.util.List;
import com.simulacion.utils.Interval;
import org.apache.commons.math3.distribution.NormalDistribution;

/**
 * Implementación de generador de números pseudoaleatorios con distribución normal.
 */
public class Normal {

    private double average;
    private double deviation;
    private List<Double> aleatory;
    private List<Double> seeds;

    /**
     * Constructor para Normal.
     *
     * @param quantity   Cantidad de Números a Generar
     * @param inte       Intervalo Aleatorio para Media y Desviación
     * @param aleatoryXi Semillas para Generar Números
     */
    public Normal(int quantity, Interval inte, List<Double> aleatoryXi) {
        this.average = inte.getAverage();
        this.deviation = inte.getDeviation();
        this.seeds = aleatoryXi;
    }

    /**
     * Obtiene los números aleatorios generados.
     *
     * @return Lista de Números Aleatorios
     */
    public List<Double> getAleatory() {
        aleatory = new ArrayList<>();
        generateRandom();
        return aleatory;
    }

    /**
     * Genera números aleatorios con distribución normal.
     */
    private void generateRandom() {
        for (Double x : seeds) {
            aleatory.add(new NormalDistribution(average, deviation).inverseCumulativeProbability(x));
        }
    }
}
