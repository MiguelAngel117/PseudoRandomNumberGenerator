package com.simulacion.views.panels;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import java.awt.Color;


public class JPanelSection extends JPanel {
    public JPanelSection() {
        initializePanel();
    }

    private void initializePanel() {
        setBorder(BorderFactory.createTitledBorder("Metodos de Generación"));
        setBackground(Color.decode("#A7643D"));
    }

    /**
     * Métodos para obtener valores predeterminados.
     */

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

    public int getT() {
        return 0;
    }
}