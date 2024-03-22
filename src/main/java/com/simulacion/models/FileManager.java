package com.simulacion.models;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.StringJoiner;

public class FileManager {

    /**
     * Escribe los números en un archivo, separados por punto y coma.
     * @param numbers Lista de números a escribir en el archivo.
     * @param filePath Ruta del archivo.
     * @throws IOException Excepción si hay un error de E/S al escribir en el archivo.
     */
    public static void writeToArchive(List<Double> numbers, String filePath) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            StringJoiner joiner = new StringJoiner("\n");
            for (Double number : numbers) {
                joiner.add(String.valueOf(number));
            }
            writer.write(joiner.toString());
        }
    }
}

