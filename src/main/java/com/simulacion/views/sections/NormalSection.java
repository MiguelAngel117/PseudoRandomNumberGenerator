package com.simulacion.views.sections;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import com.simulacion.views.panels.JPanelSection;

/**
 * Clase que representa una sección para la generación de pseudo números con distribución normal.
 */
public class NormalSection extends JPanelSection {
    private final JTextField quantity;
    private final JTextField sampleQuantity;
    private final JSpinner max;
    private final JSpinner min;
    private final JButton button;

    public NormalSection(ActionListener listener) {
        quantity = createTextField("Cantidad de Numeros");
        sampleQuantity = createTextField("Cantidad de Xo");
        max = createSpinner("Maximo", 1);
        min = createSpinner("Minimo", 0);
        button = createGenerateButton("Generar Numeros", listener);

        setLayout(new GridLayout(2, 2, 5, 2));
        initComponents();
    }

    private JTextField createTextField(String title) {
        JTextField textField = new JTextField("0");
        textField.setBorder(BorderFactory.createTitledBorder(title));
        return textField;
    }

    private JSpinner createSpinner(String title, int initialValue) {
        JSpinner spinner = new JSpinner();
        spinner.setBorder(BorderFactory.createTitledBorder(title));
        spinner.setBackground(Color.WHITE);
        spinner.setValue(initialValue);
        return spinner;
    }

    private JButton createGenerateButton(String label, ActionListener listener) {
        JButton button = new JButton(label);
        button.addActionListener(listener);
        button.setActionCommand("NORMAL");
        return button;
    }

    private void initComponents() {
        add(sampleQuantity);
        add(max);
        add(button);
        add(quantity);
        add(min);
    }

    @Override
    public int getMax() {
        return (int) max.getValue();
    }

    @Override
    public int getMin() {
        return (int) min.getValue();
    }

    @Override
    public int getQuantity() {
        return Integer.parseInt(quantity.getText());
    }

    @Override
    public int getXi() {
        return Integer.parseInt(sampleQuantity.getText());
    }
}