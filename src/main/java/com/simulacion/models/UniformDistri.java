package com.simulacion.models;
import java.util.ArrayList;
import java.util.List;

public class UniformDistri {
    private int quantity;
    private List<Double> aleatoryNumbers;

    /**
     * Constructor de la clase Uniform.
     *
     * @param quantity Cantidad de números a generar.
     */
    public UniformDistri(int quantity) {
        this.quantity = quantity;
        this.aleatoryNumbers = new ArrayList<>();
    }

    /**
     * Obtiene la lista de números aleatorios generados.
     *
     * @return Lista de números aleatorios.
     */
    public List<Double> getAleatory() {
        generateRandom();
        return aleatoryNumbers;
    }

    /**
     * Genera números aleatorios y los agrega a la lista.
     */
    private void generateRandom() {
        for (int i = 0; i < quantity; i++) {
            aleatoryNumbers.add(Math.random());
        }
    }
}
