package com.simulacion.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import org.apache.commons.math3.distribution.NormalDistribution;

import com.simulacion.models.FileManager;
import com.simulacion.models.HalfSquares;
import com.simulacion.models.LinearCongruence;
import com.simulacion.models.MultiplicativeCongruence;
import com.simulacion.models.NormalDistri;
import com.simulacion.models.UniformDistri;
import com.simulacion.views.frames.JFrameMain;
import com.simulacion.views.panels.JPanelSection;

public class Controller implements ActionListener{

    private JFrameMain frameMain;
    private JPanelSection section;

    public Controller(){
        frameMain = new JFrameMain(this);
        frameMain.setVisible(true);
        double x = 0.04824394453316927;
        System.out.println(new NormalDistribution(27.2, 3.4).inverseCumulativeProbability(x));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        new Thread(() -> {
            try {
                generateNumbers(e.getActionCommand());
            } catch (Exception et) {
                System.out.println("Se está creando el Frame");
            }
            
        }).start();
    }
    
    public void generateNumbers(String method){
        section = frameMain.getHeaderByType(method);
        switch (method) {
            case "HALF":
                try {
                    halfSquares(section, method);
                } catch (IOException e1) {
                    frameMain.printMessage("Error en Metodo de cuadrados medios");
                }
                break;
            case "LINEAR":
                try {
                    linearCongruence(section, method);
                } catch (IOException e1) {
                    frameMain.printMessage("Error en Metodo de Congruencia Lineal");
                }
                break;
            case "MULTIPLICATIVE":
                try {
                    multiplicativeCongruence(section, method);
                } catch (IOException e1) {
                    frameMain.printMessage("Error en Metodo de Congruencia Multiplicativa");
                }
                break;
            case "UNIFORM":
                try {
                    uniformDistribution(section, method);
                } catch (IOException e1) {
                    frameMain.printMessage("Error en Metodo de Distribución uniforme");
                }
                break;
            case "NORMAL":
                try {
                    normalDistribution(section, method);
                } catch (IOException e1) {
                    frameMain.printMessage("Error en Metodo de Distribución normal");
                }
                break;
        }

    }

    private void uniformDistribution(JPanelSection section, String method) throws IOException {
        UniformDistri uniform = new UniformDistri(section.getQuantity(), section.getMin(),section.getMax());
        System.out.println(uniform.getNumbersNi().toString()); 
        FileManager.writeToArchive(uniform.getNumbersRi(), "files/uniformRi.csv");
        frameMain.resetTable(method);
        frameMain.resetDraw(method);
        frameMain.setTableRow(method,null,uniform.getNumbersRi(), uniform.getNumbersNi());
        if(uniform.getNumbersRi().size() <= 10000){
            frameMain.setDrawData(method, uniform.getNumbersNi());
        }else{
            frameMain.printMessage("No se grafica, pues la aplicación se congela por la libreria que se usa");
        }
        
    }

    public void normalDistribution(JPanelSection section, String method) throws IOException{
        NormalDistri normal = new NormalDistri(section.getQuantity(),section.getAverage(), section.getStandardDeviation());
        FileManager.writeToArchive(normal.getAleatoryRi(), "files/normalRi.csv");
        frameMain.resetTable(method);
        frameMain.resetDraw(method);
        frameMain.setTableRow(method,null,normal.getAleatoryRi(), normal.getAleatoryNi());
        if(section.getQuantity() <= 10000){
            frameMain.setDrawData(method, normal.getAleatoryNi());
        }else{
            frameMain.printMessage("No se grafica, pues la aplicación se congela por la libreria que se usa");
        }
    }

    public void linearCongruence(JPanelSection section, String method) throws IOException{
        LinearCongruence congruence = new LinearCongruence(section.getXi(), section.getK(), section.getC(), section.getG(), section.getQuantity(), section.getMin(), section.getMax(), section.getType());
        FileManager.writeToArchive(congruence.getAleatoryRi(), "files/linearCongruenceRi.csv");
        frameMain.resetTable(method);
        frameMain.resetDraw(method);
        frameMain.setTableRow(method,congruence.getSeeds(),congruence.getAleatoryRi(), congruence.getAleatoryNi());
        frameMain.setDrawData(method, congruence.getAleatoryNi());
    }

    public void multiplicativeCongruence(JPanelSection section, String method) throws IOException{
        MultiplicativeCongruence mCongruence = new MultiplicativeCongruence(section.getXi(), section.getT(), section.getG(), section.getQuantity(),section.getMin(), section.getMax(), section.getType());
        FileManager.writeToArchive(mCongruence.getAleatoryRi(), "files/multiCongruenceRi.csv");
        frameMain.resetTable(method);
        frameMain.resetDraw(method);
        frameMain.setTableRow(method,mCongruence.getSeeds(),mCongruence.getAleatoryRi(), mCongruence.getAleatoryNi());
        frameMain.setDrawData(method, mCongruence.getAleatoryNi());
    }

    public void halfSquares(JPanelSection section, String method) throws IOException{
        String length = section.getSeed() + "";
        if(length.length() == section.getDigits()){
            HalfSquares squares = new HalfSquares(section.getSeed(), section.getDigits(), section.getQuantity(),section.getMin(),section.getMax());
            FileManager.writeToArchive(squares.getAleatory(), "files/halfSquaresRi.csv");
            frameMain.resetTable(method);
            frameMain.resetDraw(method);
            frameMain.setTableRow(method,squares.getCenters(),squares.getAleatory(),squares.getNumbersNi());
            frameMain.setDrawData(method, squares.getNumbersNi());
        }else{
            frameMain.printMessage("La semilla inicial debe tener la misma cantidad de digitos que solicitó");
        }        
    }
}