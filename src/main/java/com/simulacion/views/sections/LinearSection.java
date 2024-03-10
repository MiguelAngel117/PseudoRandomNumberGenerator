package com.simulacion.views.sections;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import com.simulacion.views.panels.JPanelSection;

/**
 * Clase que representa una sección para la generación de pseudo Numeros con el metodo de congruencia lineal
 */
public class LinearSection extends JPanelSection {
    private final JTextField x;
    private final JTextField k;
    private final JTextField c;
    private final JTextField g;
    private final JSpinner max;
    private final JSpinner min;
    private final JTextField quantity;
    private final JButton generate;

    public LinearSection(ActionListener listener) {
        x = createTextField("Valor de X");
        c = createTextField("Valor de C");
        k = createTextField("Valor de K");
        g = createTextField("Valor de G");
        max = createSpinner("Valor Máximo", 1);
        min = createSpinner("Minimo", 0);
        quantity = createTextField("Cantidad");
        generate = createGenerateButton("Generar Numeros", listener);

        setLayout(new GridLayout(2, 4, 5, 2));
        initComponents();
    }

    private void initComponents() {
        add(x);
        add(c);
        add(max);
        add(quantity);
        add(k);
        add(g);
        add(min);
        add(generate);
    }

    private JTextField createTextField(String title) {
        JTextField textField = new JTextField();
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
        button.setActionCommand("GENERATE_LINEAS");
        return button;
    }

    @Override
    public int getXi() {
        return Integer.parseInt(x.getText());
    }

    @Override
    public int getK() {
        return Integer.parseInt(k.getText());
    }

    @Override
    public int getC() {
        return Integer.parseInt(c.getText());
    }

    @Override
    public int getG() {
        return Integer.parseInt(g.getText());
    }

    @Override
    public int getQuantity() {
        return Integer.parseInt(quantity.getText());
    }

    @Override
    public int getMax() {
        return (int) max.getValue();
    }

    @Override
    public int getMin() {
        return (int) min.getValue();
    }
}