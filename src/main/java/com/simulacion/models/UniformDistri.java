package com.simulacion.models;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase que representa una distribución uniforme.
 */
public class UniformDistri {
    private final int quantity;
    private final int min;
    private final int max;
    private final List<Double> aleatoryNumbersRi;
    private final List<Double> aleatoryNumbersNi;

    /**
     * Constructor de la clase UniformDistribution.
     *
     * @param quantity Cantidad de números a generar.
     * @param min      Valor mínimo.
     * @param max      Valor máximo.
     */
    public UniformDistri(int quantity, int min, int max) {
        this.quantity = quantity;
        this.min = min;
        this.max = max;
        this.aleatoryNumbersRi = generateNumbersRi();
        this.aleatoryNumbersNi = generateNumbersNi();
    }

    /**
     * Genera números aleatorios y los agrega a la lista.
     *
     * @return Lista de números aleatorios Ri.
     */
    private List<Double> generateNumbersRi() {
        ReduceLinear random = new ReduceLinear(quantity);
        return random.getListRi();
    }

    /**
     * Calcula los números Ni a partir de los números Ri generados.
     *
     * @return Lista de números Ni.
     */
    private List<Double> generateNumbersNi() {
        List<Double> numbersNi = new ArrayList<>(quantity);

        for (Double ri : aleatoryNumbersRi) {
            double ni = min + (max - min) * ri;
            numbersNi.add(ni);
        }

        return numbersNi;
    }

    /**
     * Obtiene la lista de números aleatorios Ri generados.
     *
     * @return Lista de números aleatorios Ri.
     */
    public List<Double> getNumbersRi() {
        return aleatoryNumbersRi;
    }

    /**
     * Obtiene la lista de números Ni generados.
     *
     * @return Lista de números Ni.
     */
    public List<Double> getNumbersNi() {
        return aleatoryNumbersNi;
    }
}