package com.simulacion.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;

import javax.swing.JOptionPane;


import com.simulacion.models.*;
import com.simulacion.utils.FileManager;
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
        getMethod(e.getActionCommand().toString());
    }
    
    public void getMethod(String method){
        System.out.println(method + "----->");
        switch (method) {
            case "HALF":
                section = frameMain.getHeaderByType(method);
                try {
                    halfSquares(section, method);
                } catch (IOException e1) {
                    JOptionPane.showMessageDialog(null, "App Failure!", "Error", JOptionPane.ERROR_MESSAGE);
                }
                break;
            case "LINEAR":
                section = frameMain.getHeaderByType(method);
                try {
                    linearCongruence(section, method);
                } catch (IOException e1) {
                    JOptionPane.showMessageDialog(null, "App Failure!", "Error", JOptionPane.ERROR_MESSAGE);
                }
                break;
            case "MULTIPLICATIVE":
                section = frameMain.getHeaderByType(method);
                try {
                    multiplicativeCongruence(section, method);
                } catch (IOException e1) {
                    JOptionPane.showMessageDialog(null, "App Failure!", "Error", JOptionPane.ERROR_MESSAGE);
                }
                break;
            case "UNIFORM":
                section = frameMain.getHeaderByType(method);
                try {
                    uniformDistribution(section, method);
                } catch (IOException e1) {
                    JOptionPane.showMessageDialog(null, "DISTRIBICÓN NORMAL", "Error", JOptionPane.ERROR_MESSAGE);
                }
                break;
            case "NORMAL":
            System.out.println("ENTRA-----");
                section = frameMain.getHeaderByType("NORMAL");
                try {
                    normalDistribution(section, method);
                } catch (IOException e1) {
                    JOptionPane.showMessageDialog(null, "App Failure!", "Error", JOptionPane.ERROR_MESSAGE);
                }
                break;
        }

    }

    private void uniformDistribution(JPanelSection section, String method) throws IOException {
        UniformDistri uniform = new UniformDistri(section.getQuantity(), section.getMin(),section.getMax());
        System.out.println(uniform.getNumbersNi().toString()); 
        FileManager.writeToArchive(uniform.getNumbersNi(), "files/uniform.csv");
        frameMain.resetTable(method);
        frameMain.resetGraphic(method);
        frameMain.setGraphicData(method, uniform.getNumbersNi());
        frameMain.setTableRow(method,null,uniform.getNumbersRi(), uniform.getNumbersNi());
    }

    public void normalDistribution(JPanelSection section, String method) throws IOException{
        NormalDistri normal = new NormalDistri(section.getQuantity(),section.getMin(),section.getMax(), section.getXi());
        FileManager.writeToArchive(normal.getAleatoryNi(), "files/normal.csv");
        frameMain.resetTable(method);
        frameMain.resetGraphic(method);
        frameMain.setGraphicData(method, normal.getAleatoryNi());
        frameMain.setTableRow(method,null,normal.getAleatoryRi(), normal.getAleatoryNi());
    }

    public void linearCongruence(JPanelSection section, String method) throws IOException{
        LinearCongruence congruence = new LinearCongruence(section.getXi(), section.getK(), section.getC(), section.getG(), section.getQuantity(), section.getMin(), section.getMax());
        FileManager.writeToArchive(congruence.getAleatoryNi(), "files/linearCongruence.csv");
        frameMain.resetTable(method);
        frameMain.resetGraphic(method);
        frameMain.setGraphicData(method, congruence.getAleatoryNi());
        frameMain.setTableRow(method,congruence.getSeeds(),congruence.getAleatoryRi(), congruence.getAleatoryNi());
    }

    public void multiplicativeCongruence(JPanelSection section, String method) throws IOException{
        MultiplicativeCongruence mCongruence = new MultiplicativeCongruence(section.getXi(), section.getT(), section.getG(), section.getQuantity(),section.getMin(), section.getMax());
        FileManager.writeToArchive(mCongruence.getAleatoryNi(), "files/multiCongruence.csv");
        frameMain.resetTable(method);
        frameMain.resetGraphic(method);
        frameMain.setGraphicData(method, mCongruence.getAleatoryNi());
        frameMain.setTableRow(method,mCongruence.getSeeds(),mCongruence.getAleatoryRi(), mCongruence.getAleatoryNi());
    }

    public void halfSquares(JPanelSection section, String method) throws IOException{
        HalfSquares squares = new HalfSquares(section.getSeed(), section.getDigits(), section.getQuantity(),section.getMin(),section.getMax());
        FileManager.writeToArchive(squares.getNumbersNi(), "files/halfSquares.csv");
        frameMain.resetTable(method);
        frameMain.resetGraphic(method);
        frameMain.setGraphicData(method, squares.getNumbersNi());
        frameMain.setTableRow(method,squares.getCenters(),squares.getAleatory(),squares.getNumbersNi());
    }
}