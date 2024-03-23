package com.simulacion.views.sections;

import javax.swing.JButton;
import javax.swing.BorderFactory;
import javax.swing.JTextField;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import com.simulacion.views.panels.JPanelSection;

/**
 * Clase que representa una sección para la generación de pseudo números con distribución normal.
 */
public class NormalSection extends JPanelSection {
    // Declaración de campos
    private final JTextField quantity; // Campo para la cantidad de números a generar
    private final JTextField average; // Selector para el valor máximo
    private final JTextField standardDeviation; // Selector para el valor mínimo
    private final JButton button; // Botón para generar números

    /**
     * Constructor de la clase.
     * @param listener ActionListener para manejar eventos.
     */
    public NormalSection(ActionListener listener) {
        // Inicialización de campos
        quantity = createTextField("Cantidad de Numeros", "10");
        average = createTextField("Promedio - Media", "1");
        standardDeviation = createTextField("Desviación Estandar", "0");
        button = createGenerateButton("Generar Numeros", listener);
        setLayout(new GridLayout(2, 2, 5, 2));
        initComponents(); // Inicialización de componentes
    }

    /**
     * Método privado para crear un campo de texto con un borde titulado y un valor inicial especificado.
     * 
     * @param title Título del borde.
     * @param initialValue Valor inicial del campo de texto.
     * @return Campo de texto creado.
     */
    private JTextField createTextField(String title, String initialValue) {
        JTextField textField = new JTextField(); // Crea un nuevo campo de texto
        textField.setBorder(BorderFactory.createTitledBorder(title));
        textField.setText(initialValue); // Establece el valor inicial del campo de texto
        return textField;
    }

    /**
     * Método para crear un botón de generación.
     * @param label Texto del botón.
     * @param listener ActionListener para manejar eventos del botón.
     * @return JButton creado.
     */
    private JButton createGenerateButton(String label, ActionListener listener) {
        JButton button = new JButton(label);
        button.addActionListener(listener);
        button.setActionCommand("NORMAL");
        return button;
    }

    /**
     * Método para inicializar los componentes y añadirlos al panel.
     */
    private void initComponents() {
        add(average);
        add(quantity);
        add(standardDeviation);
        add(button);
        
    }

    // Métodos de acceso para obtener los valores de los campos

    @Override
    public double getStandardDeviation() {
        return Double.parseDouble(standardDeviation.getText()); // Devuelve el valor entero del selector del valor máximo
    }

    @Override
    public double getAverage() {
        return Double.parseDouble(average.getText()); // Devuelve el valor entero del selector del valor mínimo
    }

    @Override
    public int getQuantity() {
        return Integer.parseInt(quantity.getText());
    }

}
