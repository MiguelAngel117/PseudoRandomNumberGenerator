package com.simulacion.views.sections;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.GridLayout;


import com.simulacion.views.panels.JPanelSection;

/**
 * Clase que representa una sección para la generación de números mediante congruencia multiplicativa.
 */
public class MultiplicativeSection extends JPanelSection {
    // Declaración de campos
    private final JTextField x; // Campo para el valor de X
    private final JTextField t; // Campo para el valor de T
    private final JTextField g; // Campo para el valor de G
    private final JTextField max; // Selector para el valor máximo
    private final JTextField min; // Selector para el valor mínimo
    private final JTextField quantity; // Campo para la cantidad de números a generar
    private final JButton button; // Botón para generar números
    private final JComboBox jComboBox; // ComboBox para opciones

    /**
     * Constructor de la clase.
     * @param listener ActionListener para manejar eventos.
     */
    public MultiplicativeSection(ActionListener listener) {
        // Inicialización de campos
        x = createTextField("Valor de X", "0");
        t = createTextField("Valor de T", "0");
        g = createTextField("Valor de G","0");
        max = createTextField("Máximo", "1");
        min = createTextField("Minimo", "0");
        quantity = createTextField("Cantidad", "10");
        jComboBox = createJComboBox(listener);
        button = createGenerateButton("Generar Numeros", listener);
        
        // Configuración del diseño de la sección
        setLayout(new GridLayout(2, 4, 5, 2));
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
        button.setActionCommand("MULTIPLICATIVE");
        return button;
    }

    /**
     * Método para crear un ComboBox con opciones.
     * @param listener ActionListener para manejar eventos del ComboBox.
     * @return JComboBox creado.
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    private JComboBox createJComboBox(ActionListener listener) {
        JComboBox comboBox = new JComboBox();
        comboBox.addActionListener(listener);
        comboBox.addItem("Ri ∈ [0,1]");
        comboBox.addItem("Ri ∈ [0,1)");
        comboBox.setActionCommand("OPTIONM");
        return comboBox;
    }

    /**
     * Método para inicializar los componentes y añadirlos al panel.
     */
    private void initComponents() {
        add(x);
        add(t);
        add(max);
        add(jComboBox);
        add(quantity);
        add(g);
        add(min);
        add(button);
    }

    // Métodos de acceso para obtener los valores de los campos

    @Override
    public boolean getType(){
        String type = jComboBox.getSelectedItem().toString();
        return (type.equals("Ri ∈ [0,1]"))? true: false;
    }

    @Override
    public int getXi() {
        return Integer.parseInt(x.getText());
    }

    @Override
    public int getT() {
        return Integer.parseInt(t.getText());
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
        return Integer.parseInt(max.getText()); // Devuelve el valor entero del selector del valor máximo
    }

    @Override
    public int getMin() {
        return Integer.parseInt(min.getText()); // Devuelve el valor entero del selector del valor mínimo
    }
}
