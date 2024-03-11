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
        //linearCongruence();
        //multiplicativeCongruence();
        //halfSquares();
        //normalDistribution();
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
                section = frameMain.getHeaderByType("HALF");
                try {
                    halfSquares(section);
                } catch (IOException e1) {
                    JOptionPane.showMessageDialog(null, "App Failure!", "Error", JOptionPane.ERROR_MESSAGE);
                }
                break;
            case "LINEAR":
                section = frameMain.getHeaderByType("LINEAR");
                try {
                    linearCongruence(section);
                } catch (IOException e1) {
                    JOptionPane.showMessageDialog(null, "App Failure!", "Error", JOptionPane.ERROR_MESSAGE);
                }
                break;
            case "MULTIPLICATIVE":
                section = frameMain.getHeaderByType("MULTIPLICATIVE");
                try {
                    multiplicativeCongruence(section);
                } catch (IOException e1) {
                    JOptionPane.showMessageDialog(null, "App Failure!", "Error", JOptionPane.ERROR_MESSAGE);
                }
                break;
            case "UNIFORM":
                section = frameMain.getHeaderByType("UNIFORM");
                try {
                    uniformDistribution(section);
                } catch (IOException e1) {
                    JOptionPane.showMessageDialog(null, "DISTRIBICÓN NORMAL", "Error", JOptionPane.ERROR_MESSAGE);
                }
                break;
            case "NORMAL":
            System.out.println("ENTRA-----");
                section = frameMain.getHeaderByType("NORMAL");
                try {
                    normalDistribution(section);
                } catch (IOException e1) {
                    JOptionPane.showMessageDialog(null, "App Failure!", "Error", JOptionPane.ERROR_MESSAGE);
                }
                break;
        }

    }

     // Uniform
    private void uniformDistribution(JPanelSection section) throws IOException {
        UniformDistri uniform = new UniformDistri(80, 8,20);
        System.out.println(uniform.getNumbersNi().toString()); 
        FileManager.writeToArchive(uniform.getNumbersRi(), "files/uniform.csv");
        //manageUniformTable(aleatory, interval);
    }

    public void normalDistribution(JPanelSection section) throws IOException{
        NormalDistri normal = new NormalDistri(100,10,17,15);
        FileManager.writeToArchive(normal.getAleatoryNi(), "files/normal.csv");
    }

    public void linearCongruence(JPanelSection section) throws IOException{
        LinearCongruence congruence = new LinearCongruence(1, 4, 3, 7, 128, 8, 10);
        FileManager.writeToArchive(congruence.getAleatoryNi(), "files/linearCongruence.csv");
    }

    public void multiplicativeCongruence(JPanelSection section) throws IOException{
        MultiplicativeCongruence congruence = new MultiplicativeCongruence(5, 2, 10, 129,8,10);
        FileManager.writeToArchive(congruence.getAleatoryNi(), "files/multiCongruence.csv");
    }

    public void halfSquares(JPanelSection section) throws IOException{
        HalfSquares squares = new HalfSquares(3456, 4, 67,2,5);
        FileManager.writeToArchive(squares.getNumbersNi(), "files/halfSquares.csv");
    }

    /*
    private void manageUniformTable(List<Double> aleatory, List<Double> interval) {
        frameMain.resetUniformTable();
        frameMain.resetUniformGraphic();
        frameMain.setUniformGraphicData(interval);
        List<Object[]> elements = Ulitities.toObjectArrayList(aleatory, interval);
        for (Object[] element : elements) {
            frameMain.setUniformTableRow(element);
        }
    }

    // Normal
    private void manageNormal(JPanelSection section) throws IOException {
        List<Double> aleatory = new Uniform(section.getXi()).getAleatory();
        List<Double> seeds = new Uniform(section.getQuantity()).getAleatory();
        
        Normal normal = new Normal(section.getQuantity(), new Interval(section.getMin(), section.getMax(), aleatory),
                seeds);
        System.out.println("--------->"+ normal.getAleatory().toString());
        FileManager.writeToArchive(normal.getAleatory(), "files/normal.num");
        manageNormalTable(seeds, normal.getAleatory());
    }

    private void manageNormalTable(List<Double> seeds, List<Double> normList) {
        frameMain.resetNormalTable();
        frameMain.resetNormalGraphic();
        frameMain.setNormalGraphicData(normList);
        List<Object[]> elements = Ulitities.toObjectArrayList(seeds, normList);
        for (Object[] element : elements) {
            frameMain.setNormalTableRow(element);
        }
    }

    // Multiplicative
    private void manageMultiplicative(JPanelSection section) throws IOException {
        Multiplicative multiplicative = new Multiplicative(section.getXi(), section.getT(), section.getG(),
                section.getQuantity());
        List<Double> aleatory = multiplicative.getAleatory();
        System.out.println(aleatory);
        List<Double> interval = new Interval(section.getMin(), section.getMax(), aleatory).getInterval();

        FileManager.writeToArchive(aleatory, "files/multiplicative.num");
        manageMultiplicativeTable(multiplicative.getSeeds(), aleatory, interval);
    }

    private void manageMultiplicativeTable(List<Integer> seeds, List<Double> aleatory, List<Double> interval) {
        frameMain.resetMultiplicativeTable();
        frameMain.resetMultiplicativeGraphic();
        frameMain.setMultiplicativeGraphicData(interval);
        List<Object[]> elements = Ulitities.toObjectArrayList(seeds, aleatory, interval);
        for (Object[] element : elements) {
            frameMain.setMultiplicativeTableRow(element);
        }
    }

    // Linear
    private void manageLinear(JPanelSection section) throws IOException {
        Linear linear = new Linear(section.getXi(), section.getK(), section.getC(), section.getG(), section.getQuantity());
        List<Double> aleatory = linear.getAleatory();
        List<Double> interval = new Interval(section.getMin(), section.getMax(), aleatory).getInterval();

        FileManager.writeToArchive(aleatory, "files/linear.num");
        manageLinearTable(linear.getSeeds(), aleatory, interval);
    }

    private void manageLinearTable(List<Integer> seeds, List<Double> aleatory, List<Double> interval) {
        frameMain.resetLinearTable();
        frameMain.resetLinearGraphic();
        frameMain.setLinearGraphicData(interval);
        List<Object[]> elements = Ulitities.toObjectArrayList(seeds, aleatory, interval);
        for (Object[] element : elements) {
            frameMain.setLinearTableRow(element);
        }
    }

    // Middle
    private void manageMiddleSqr(JPanelSection section) throws IOException {
        MiddleSquare middleSquare = new MiddleSquare(section.getSeed(), section.getDigits(), section.getQuantity());
        List<Double> aleatory = middleSquare.getAleatory();
        List<Double> interval = new Interval(section.getMin(), section.getMax(), aleatory).getInterval();

        FileManager.writeToArchive(aleatory, "files/middle-sqr.num");
        manageMiddleTable(middleSquare.getCenters(), aleatory, interval);
    }

    private void manageMiddleTable(List<Integer> xi, List<Double> ri, List<Double> ni) {
        frameMain.resetMiddleTable();
        frameMain.resetMiddleGraphic();
        frameMain.setGraphicData(ni);
        List<Object[]> elements = Ulitities.toObjectArrayList(xi, ri, ni);
        for (Object[] element : elements) {
            frameMain.setMiddTableRow(element);
        }
    }*/
}