package com.simulacion.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

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
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        new Thread(() -> {
            try {
                generateNumbers(e.getActionCommand());
            } catch (Exception et) {
                System.out.println("Se está creando el Frame");
                System.out.println(et.getMessage());
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
        Double min = (double) section.getMin();
        Double max = (double) section.getMax(); 
        System.out.println(uniform.getNumbersNi().toString()); 
        FileManager.writeToArchive(uniform.getNumbersRi(), "files/uniform.csv");
        frameMain.resetTable(method);
        frameMain.resetDraw(method);
        frameMain.setDrawData(method, uniform.getNumbersNi(), min, max);
        frameMain.setTableRow(method,null,uniform.getNumbersRi(), uniform.getNumbersNi());
    }

    public void normalDistribution(JPanelSection section, String method) throws IOException{
        NormalDistri normal = new NormalDistri(section.getQuantity(),section.getMin(),section.getMax(), section.getXi());
        Double min = (double) section.getMin();
        Double max = (double) section.getMax(); 
        FileManager.writeToArchive(normal.getAleatoryRi(), "files/normal.csv");
        frameMain.resetTable(method);
        frameMain.resetDraw(method);
        frameMain.setDrawData(method, normal.getAleatoryNi(), min,max);
        frameMain.setTableRow(method,null,normal.getAleatoryRi(), normal.getAleatoryNi());
    }

    public void linearCongruence(JPanelSection section, String method) throws IOException{
        LinearCongruence congruence = new LinearCongruence(section.getXi(), section.getK(), section.getC(), section.getG(), section.getQuantity(), section.getMin(), section.getMax(), section.getType());
        Double min = (double) section.getMin();
        Double max = (double) section.getMax(); 
        FileManager.writeToArchive(congruence.getAleatoryRi(), "files/linearCongruence.csv");
        frameMain.resetTable(method);
        frameMain.resetDraw(method);
        frameMain.setDrawData(method, congruence.getAleatoryNi(),min,max);
        frameMain.setTableRow(method,congruence.getSeeds(),congruence.getAleatoryRi(), congruence.getAleatoryNi());
    }

    public void multiplicativeCongruence(JPanelSection section, String method) throws IOException{
        MultiplicativeCongruence mCongruence = new MultiplicativeCongruence(section.getXi(), section.getT(), section.getG(), section.getQuantity(),section.getMin(), section.getMax(), section.getType());
        Double min = (double) section.getMin();
        Double max = (double) section.getMax(); 
        FileManager.writeToArchive(mCongruence.getAleatoryRi(), "files/multiCongruence.csv");
        frameMain.resetTable(method);
        frameMain.resetDraw(method);
        frameMain.setDrawData(method, mCongruence.getAleatoryNi(),min,max);
        frameMain.setTableRow(method,mCongruence.getSeeds(),mCongruence.getAleatoryRi(), mCongruence.getAleatoryNi());
    }

    public void halfSquares(JPanelSection section, String method) throws IOException{
        String length = section.getSeed() + "";
        if(length.length() == section.getDigits()){
            HalfSquares squares = new HalfSquares(section.getSeed(), section.getDigits(), section.getQuantity(),section.getMin(),section.getMax());
            Double min = (double) section.getMin();
            Double max = (double) section.getMax(); 
            FileManager.writeToArchive(squares.getAleatory(), "files/halfSquares.csv");
            frameMain.resetTable(method);
            frameMain.resetDraw(method);
            frameMain.setDrawData(method, squares.getNumbersNi(),min,max);
            frameMain.setTableRow(method,squares.getCenters(),squares.getAleatory(),squares.getNumbersNi());
        }else{
            frameMain.printMessage("La semilla inicial debe tener la misma cantidad de digitos que solicitó");
        }        
    }
}