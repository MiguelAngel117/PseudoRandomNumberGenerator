package com.simulacion.utils;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class FileManager {

    /**
     * 
     * @param numbers Numeros Aleatorios
     * @param path Ruta del Archivo
     * @throws IOException Excepcion si la ruta no existe
     */
    public static void writeToArchive(List<Double> numbers, String path) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(path));
        for (Double number : numbers) {
            writer.write(String.valueOf(number));
            writer.write(";");
        }
        writer.close();
    }
}
