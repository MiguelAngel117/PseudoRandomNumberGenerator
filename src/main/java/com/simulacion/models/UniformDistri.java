package com.simulacion.models;
import java.util.ArrayList;
import java.util.List;

public class UniformDistri {
    private int quantity;
    private int min;
    private int max;
    private List<Double> aleatoryNumbersRi;
    private List<Double> aleatoryNumbersNi;

    /**
     * Constructor de la clase Uniform.
     *
     * @param quantity Cantidad de números a generar.
     */
    public UniformDistri(int quantity) {
        this.quantity = quantity;
        aleatoryNumbersRi = new ArrayList<>();aleatoryNumbersNi = new ArrayList<>();
        generateNumbersRi();
        generateNumbersNi();
    }

    /**
     * Genera números aleatorios y los agrega a la lista.
     */
    private void generateNumbersRi() {
        for (int i = 0; i < quantity; i++) {
            aleatoryNumbersRi.add(Math.random());
        }
    }

    private void generateNumbersNi() {
        for (Double ri : aleatoryNumbersRi) {
            double ni = min +(max - min) * ri;
            aleatoryNumbersNi.add(ni);
        }
    }

    /**
     * Obtiene la lista de números aleatorios generados.
     *
     * @return Lista de números aleatorios.
     */
    public List<Double> getNumbersRi() {
        return aleatoryNumbersRi;
    }

    public List<Double> getNumbersNi() {
        return aleatoryNumbersNi;
    }

}
