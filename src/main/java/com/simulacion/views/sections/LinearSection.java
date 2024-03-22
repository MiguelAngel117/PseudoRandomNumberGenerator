package com.simulacion.views.sections;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import com.simulacion.views.panels.JPanelSection;

/**
 * Clase que representa una sección para la generación de pseudo Números con el método de congruencia lineal.
 */
public class LinearSection extends JPanelSection {
    private final JTextField x; // Campo de texto para el valor de X
    private final JTextField k; // Campo de texto para el valor de K
    private final JTextField c; // Campo de texto para el valor de C
    private final JTextField g; // Campo de texto para el valor de G
    private final JTextField max; // Selector para el valor máximo
    private final JTextField min; // Selector para el valor mínimo
    private final JTextField quantity; // Campo de texto para la cantidad de números a generar
    private final JButton button; // Botón para generar números
    private final JComboBox jComboBox; // Lista desplegable para la opción de generación

    /**
     * Constructor de la clase LinearSection.
     * 
     * @param listener ActionListener para manejar eventos del botón y la lista desplegable.
     */
    public LinearSection(ActionListener listener) {
        x = createTextField("Valor de X", "0"); // Crea un campo de texto para el valor de X
        c = createTextField("Valor de C", "0"); // Crea un campo de texto para el valor de C
        k = createTextField("Valor de K", "0"); // Crea un campo de texto para el valor de K
        g = createTextField("Valor de G", "0"); // Crea un campo de texto para el valor de G
        max = createTextField("Máximo", "1"); 
        min = createTextField("Minimo", "0"); 
        quantity = createTextField("Cantidad", "0"); // Crea un campo de texto para la cantidad de números a generar
        button = createButton("Generar Numeros", listener); // Crea un botón para generar números
        jComboBox = createJComboBox(listener); // Crea una lista desplegable para la opción de generación

        setLayout(new GridLayout(2, 4, 5, 2)); // Establece el diseño del panel
        initComponents(); // Inicializa los componentes del panel
    }

    /**
     * Método privado para inicializar los componentes del panel.
     */
    private void initComponents() {
        add(x); 
        add(c); 
        add(max); 
        add(g); 
        add(button); 
        add(k); 
        add(quantity);
        add(min); 
        add(jComboBox);
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
        return textField; // Devuelve el campo de texto creado
    }

    /**
     * Método privado para crear un botón con un texto especificado y un ActionListener
     * @param listener ActionListener para manejar eventos del botón.
     * @return Botón creado.
     */
    private JButton createButton(String label, ActionListener listener) {
        JButton button = new JButton(label); // Crea un nuevo botón con el texto especificado
        button.addActionListener(listener); // Agrega un ActionListener al botón
        button.setActionCommand("LINEAR"); // Establece el comando de acción del botón como "LINEAR"
        return button;
    }

    /**
     * Método privado para crear una lista desplegable con opciones predefinidas y un ActionListener.
     * 
     * @param listener ActionListener para manejar eventos de la lista desplegable.
     * @return Lista desplegable creada.
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    private JComboBox createJComboBox(ActionListener listener) {
        JComboBox comboBox = new JComboBox(); // Crea una nueva lista desplegable
        comboBox.addActionListener(listener); // Agrega un ActionListener a la lista desplegable
        comboBox.addItem("Ri ∈ [0,1]"); // Agrega una opción predefinida a la lista desplegable
        comboBox.addItem("Ri ∈ [0,1)"); // Agrega otra opción predefinida a la lista desplegable
        return comboBox;
    }

    @Override
    public boolean getType(){
        String type = jComboBox.getSelectedItem().toString(); 
        return (type.equals("Ri ∈ [0,1]"))? true: false; // Devuelve true si el tipo es "Ri ∈ [0,1]", de lo contrario, devuelve false
    }

    @Override
    public int getXi() {
        return Integer.parseInt(x.getText()); // Devuelve el valor entero del campo de texto para el valor de X
    }

    @Override
    public int getK() {
        return Integer.parseInt(k.getText()); // Devuelve el valor entero del campo de texto para el valor de K
    }

    @Override
    public int getC() {
        return Integer.parseInt(c.getText()); // Devuelve el valor entero del campo de texto para el valor de C
    }

    @Override
    public int getG() {
        return Integer.parseInt(g.getText()); // Devuelve el valor entero del campo de texto para el valor de G
    }

    @Override
    public int getQuantity() {
        return Integer.parseInt(quantity.getText()); // Devuelve el valor entero del campo de texto para la cantidad
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
