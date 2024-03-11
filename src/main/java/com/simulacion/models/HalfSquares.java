
package com.simulacion.models;
import java.util.ArrayList;
import java.util.List;

/**
 * Implementación de generador de números pseudoaleatorios por cuadrados medios.
 */
public class HalfSquares {

    private int min;
    private int max;
    private int digits;
    private int quantity;
    private List<Double> aleatoryRi;
    private List<Double> aleatoryNi;
    private List<Integer> centers;

    /**
     * Constructor para MiddleSquare.
     *
     * @param seed     Semilla Inicial
     * @param digits   Dígitos del Centro
     * @param quantity Cantidad de Números a Generar
     */
    public HalfSquares(int seed, int digits, int quantity, int min, int max) {
        this.digits = digits;
        this.quantity = quantity;
        this.min = min;
        this.max = max;
        this.aleatoryRi = new ArrayList<>();
        this.aleatoryNi = new ArrayList<>();
        this.centers = new ArrayList<>();
        generateRandom(seed);
    }

    /**
     * Obtiene los números aleatorios generados.
     *
     * @return Lista de números aleatorios
     */
    public List<Double> getAleatory() {
        return aleatoryRi;
    }

    /**
     * Genera números aleatorios de forma recursiva.
     *
     * @param seed Semilla para la generación de números aleatorios
     */
    private void generateRandom(int seed) {
        while (aleatoryRi.size() < quantity) {
            int pow = (int) Math.pow(seed, 2);
            int center = calculateCenter(pow);
            centers.add(seed);
            double ri = center / Math.pow(10, digits);
            aleatoryRi.add(ri);
            aleatoryNi.add(min +((max - min))* ri);
            seed = center;
        }
    }

    /**
     * Calcula el centro de la semilla.
     *
     * @param pow Semilla para calcular el nuevo centro
     * @return Centro de la semilla
     */
    private int calculateCenter(int pow) {
        String aux = String.valueOf(pow);
        int step = (digits * 2) - aux.length();
        char[] number = new char[digits * 2];
        number = fillNumber(step, aux, number);
        return Integer.parseInt(getCenterNumber(number));
    }

    /**
     * Obtiene las posiciones centrales del número.
     *
     * @param number Arreglo de caracteres para obtener las posiciones centrales
     * @return Centro de la semilla
     */
    private String getCenterNumber(char[] number) {
        int position = calculatePosition(number);
        StringBuilder newSeed = new StringBuilder();
        for (int i = position; i < position + digits; i++) {
            newSeed.append(number[i]);
        }
        return newSeed.toString();
    }

    /**
     * Calcula las posiciones a rellenar con ceros.
     *
     * @param number Semilla
     * @return Posiciones a rellenar de 0's
     */
    private int calculatePosition(char[] number) {
        int rest = number.length - digits;
        return rest / 2;
    }

    /**
     * Rellena la semilla con ceros.
     *
     * @param step Posición de inicio de la semilla
     * @param aux  Semilla en String
     * @param number Nueva semilla como arreglo de caracteres
     * @return Semilla nueva rellena con ceros
     */
    private char[] fillNumber(int step, String aux, char[] number) {
        for (int i = 0; i < step; i++) {
            number[i] = '0';
        }
        int index = 0;
        for (int i = step; i < number.length; i++) {
            number[i] = aux.charAt(index++);
        }
        return number;
    }

    /**
     * Obtiene la lista de centros generados.
     *
     * @return Lista de centros
     */
    public List<Integer> getCenters() {
        return centers;
    }

    public List<Double> getNumbersNi() {
        return aleatoryNi;
    }
}