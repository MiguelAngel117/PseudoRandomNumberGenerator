package com.simulacion.views.panels;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JTabbedPane;

import com.simulacion.views.sections.*;

/**
 * Clase que representa un panel con pestañas para diferentes métodos de simulación.
 */
public class JTabbedMethods extends JTabbedPane {

    private final JPanelMain halfSquare; // Panel para el método de cuadrados medios
    private final JPanelMain multiplicative; // Panel para el método congruencial multiplicativo
    private final JPanelMain linear; // Panel para el método congruencial lineal
    private final JPanelMain uniform; // Panel para el método de distribución uniforme
    private final JPanelMain normal; // Panel para el método de distribución normal

    /**
     * Constructor de la clase JTabbedMethods.
     * 
     * @param listener ActionListener para manejar eventos de los componentes.
     */
    public JTabbedMethods(ActionListener listener) {
        // Crea los paneles para cada método con su respectiva sección
        linear = createPanel("Congruencial Lineal", new LinearSection(listener));
        multiplicative = createPanel("Congruencial Multiplicativa", new MultiplicativeSection(listener));
        halfSquare = createPanel("Cuadrados Medios", new HalfSquaresSection(listener));
        uniform = createTablePanel("D. Uniforme", new UniformSection(listener), new String[]{"Ri", "Ni"});
        normal = createTablePanel("D. Normal", new NormalSection(listener), new String[]{"Ri", "Ni"});
        
        setTabPlacement(JTabbedPane.LEFT); // Establece la ubicación de las pestañas
        setBackground(Color.decode("#A7643D")); // Establece el color de fondo del panel
    }

    /**
     * Método privado para crear un panel con su respectiva sección.
     * 
     * @param title Título de la pestaña.
     * @param section Sección del panel.
     * @return El panel creado.
     */
    private JPanelMain createPanel(String title, JPanelSection section) {
        JPanelMain panel = new JPanelMain(section); // Crea un nuevo panel con la sección dada
        add(title, panel); // Agrega el panel como una pestaña al panel principal
        return panel; // Devuelve el panel creado
    }

    /**
     * Método privado para crear un panel de tabla con su respectiva sección y filas.
     * 
     * @param title Título de la pestaña.
     * @param section Sección del panel.
     * @param rows Nombres de las columnas de la tabla.
     * @return El panel de tabla creado.
     */
    private JPanelMain createTablePanel(String title, JPanelSection section, String[] rows) {
        JPanelMain panel = createPanel(title, section); // Crea un nuevo panel de tabla
        panel.setTableSection(rows); // Establece la sección de la tabla con los nombres de columnas dados
        return panel; // Devuelve el panel de tabla creado
    }

    /**
     * Método para obtener la sección de un método específico.
     * 
     * @param type Tipo de método.
     * @return La sección correspondiente al tipo de método.
     */
    public JPanelSection getSection(String type) {
        switch (type) {
            case "HALF":
                return halfSquare.getSection();
            case "LINEAR":
                return linear.getSection();
            case "MULTIPLICATIVE":
                return multiplicative.getSection();
            case "UNIFORM":
                return uniform.getSection();
            case "NORMAL":
                return normal.getSection();
            default:
                return halfSquare.getSection();
        }
    }

    /**
     * Método para establecer filas en la tabla de un método específico.
     * 
     * @param type Tipo de método.
     * @param xiList Lista de valores Xi.
     * @param riList Lista de valores Ri.
     * @param niList Lista de valores Ni.
     */
    public void setTableRow(String type, List<Integer> xiList, List<Double> riList, List<Double> niList) {
        switch (type) {
            case "HALF":
                halfSquare.setTableRow(xiList,riList,niList);
                break;
            case "LINEAR":
                linear.setTableRow(xiList,riList,niList);
                break;
            case "MULTIPLICATIVE":
                multiplicative.setTableRow(xiList,riList,niList);
                break;
            case "UNIFORM":
                uniform.setTableRow(riList,niList);
                break;
            case "NORMAL":
                normal.setTableRow(riList,niList);
                break;
        }
    }

    /**
     * Método para reiniciar la tabla de un método específico.
     * 
     * @param type Tipo de método.
     */
    public void resetTable(String type) {
        switch (type) {
            case "HALF":
                halfSquare.resetTable();
                break;
            case "LINEAR":
                linear.resetTable();
                break;
            case "MULTIPLICATIVE":
                multiplicative.resetTable();
                break;
            case "UNIFORM":
                uniform.resetTable();
                break;
            case "NORMAL":
                normal.resetTable();
                break;
        }
    }

    /**
     * Método para establecer datos en el gráfico de un método específico.
     * 
     * @param type Tipo de método.
     * @param data Lista de datos de dispersión.
     */
    public void setDrawData(String type, List<Double> data) {
        switch (type) {
            case "HALF":
                halfSquare.setDrawData(data);
                break;
            case "LINEAR":
                linear.setDrawData(data);
                break;
            case "MULTIPLICATIVE":
                multiplicative.setDrawData(data);
                break;
            case "UNIFORM":
                uniform.setDrawData(data);
                break;
            case "NORMAL":
                normal.setDrawData(data);
                break;
        }
    }

    /**
     * Método para reiniciar el gráfico de un método específico.
     * 
     * @param type Tipo de método.
     */
    public void resetDraw(String type) {
        switch (type) {
            case "HALF":
                halfSquare.resetDraw();
                break;
            case "LINEAR":
                linear.resetDraw();
                break;
            case "MULTIPLICATIVE":
                multiplicative.resetDraw();
                break;
            case "UNIFORM":
                uniform.resetDraw();
                break;
            case "NORMAL":
                normal.resetDraw();
                break;
        }
    }
}