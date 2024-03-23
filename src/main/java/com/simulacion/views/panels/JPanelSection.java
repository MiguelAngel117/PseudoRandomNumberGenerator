package com.simulacion.views.panels;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import java.awt.Color;


public class JPanelSection extends JPanel {
    public JPanelSection() {
        initializePanel();
    }

    private void initializePanel() {
        setBorder(BorderFactory.createTitledBorder("Parametros del metodo: "));
        setBackground(Color.decode("#A7643D"));
    }

    public int getSeed() {
        return 0;
    }

    public int getDigits() {
        return 0;
    }

    public int getQuantity() {
        return 0;
    }

    public int getMin() {
        return 0;
    }

    public int getMax() {
        return 0;
    }

    public int getK() {
        return 0;
    }

    public int getG() {
        return 0;
    }

    public int getC() {
        return 0;
    }

    public int getXi() {
        return 0;
    }

    public double getAverage(){
        return 0;
    }
    public double getStandardDeviation(){
        return 0;
    }

    public int getT() {
        return 0;
    }

    public boolean getType(){
        return false;
    }
}