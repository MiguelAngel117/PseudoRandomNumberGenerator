package com.simulacion.views.sections;


import javax.swing.JButton;
import javax.swing.BorderFactory;
import javax.swing.JTextField;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import com.simulacion.views.panels.JPanelSection;

/**
 * Clase que representa una sección para la generación de números mediante medio cuadrado.
 */
public class HalfSquaresSection extends JPanelSection {
    private final JTextField seed; // Campo de texto para la semilla
    private final JTextField digits; // Campo de texto para la cantidad de dígitos para la extracción
    private final JTextField max; // Selector para el valor máximo
    private final JTextField min; // Selector para el valor mínimo
    private final JTextField quantity; // Campo de texto para la cantidad de números a generar
    private final JButton button; // Botón para generar números

    /**
     * Constructor de la clase HalfSquaresSection.
     * 
     * @param listener ActionListener para manejar eventos del botón.
     */
    public HalfSquaresSection(ActionListener listener){
        seed = createTextField("Semilla", "0"); // Crea un campo de texto para la semilla
        digits = createTextField("Digitos Para Extracción", "4"); // Crea un campo de texto para los dígitos con un valor predeterminado de "4"
        max = createTextField("Máximo", "1"); 
        min = createTextField("Minimo", "0"); 
        quantity = createTextField("Cantidad", "0"); // Crea un campo de texto para la cantidad de números a generar
        button = createGenerateButton("Generar Numeros", listener); // Crea un botón para generar números

        setLayout(new GridLayout(2, 3, 5, 2)); // Establece el diseño del panel
        initComponents(); // Inicializa los componentes del panel
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
     * Método privado para crear un botón con un texto especificado y un ActionListener.
     * 
     * @param label Texto del botón.
     * @param listener ActionListener para manejar eventos del botón.
     * @return Botón creado.
     */
    private JButton createGenerateButton(String label, ActionListener listener) {
        JButton button = new JButton(label); // Crea un nuevo botón con el texto especificado
        button.addActionListener(listener); // Agrega un ActionListener al botón
        button.setActionCommand("HALF"); 
        return button; // Devuelve el botón creado
    }

    /**
     * Método privado para inicializar los componentes del panel.
     */
    private void initComponents() {
        add(seed); // Agrega el campo de texto de la semilla al panel
        add(max); // Agrega el selector del valor máximo al panel
        add(digits); // Agrega el campo de texto de los dígitos al panel
        add(quantity); // Agrega el campo de texto de la cantidad al panel
        add(min); // Agrega el selector del valor mínimo al panel
        add(button); // Agrega el botón al panel
    }

    @Override
    public int getSeed() {
        return Integer.parseInt(seed.getText()); // Devuelve el valor entero del campo de texto de la semilla
    }

    @Override
    public int getQuantity() {
        return Integer.parseInt(quantity.getText()); // Devuelve el valor entero del campo de texto de la cantidad
    }

    @Override
    public int getDigits() {
        return Integer.parseInt(digits.getText()); // Devuelve el valor entero del campo de texto de los dígitos
    }

    @Override
    public int getMax() {
        return Integer.parseInt(max.getText()); // Devuelve el valor entero del selector del valor máximo
    }

    @Override
    public int getMin() {
        return Integer.parseInt(min.getText()); // Devuelve el valor entero del selector del valor mínimo
    }
}
