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
 * Clase que representa una sección para la generación de números mediante medio cuadrado.
 */
public class HalfSquaresSection extends JPanelSection {
    private final JTextField seed;
    private final JTextField digits;
    private final JSpinner max;
    private final JSpinner min;
    private final JTextField quantity;
    private final JButton generate;

    public HalfSquaresSection(ActionListener listener) {
        seed = createTextField("Semilla");
        digits = createTextField("Digitos", "4");
        max = createSpinner("Maximo", 1);
        min = createSpinner("Minimo", 0);
        quantity = createTextField("Cantidad");
        generate = createGenerateButton("Generar Numeros", listener);

        setLayout(new GridLayout(2, 3, 5, 2));
        initComponents();
    }

    private JTextField createTextField(String title) {
        JTextField textField = new JTextField();
        textField.setBorder(BorderFactory.createTitledBorder(title));
        return textField;
    }

    private JTextField createTextField(String title, String initialValue) {
        JTextField textField = createTextField(title);
        textField.setText(initialValue);
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
        button.setActionCommand("HALF");
        return button;
    }

    private void initComponents() {
        add(seed);
        add(max);
        add(digits);
        add(quantity);
        add(min);
        add(generate);
    }

    @Override
    public int getSeed() {
        return Integer.parseInt(seed.getText());
    }

    @Override
    public int getQuantity() {
        return Integer.parseInt(quantity.getText());
    }

    @Override
    public int getDigits() {
        return Integer.parseInt(digits.getText());
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
