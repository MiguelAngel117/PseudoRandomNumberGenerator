package com.simulacion.views.panels;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.JPanel;

/**
 * Clase que representa el panel principal de la interfaz de usuario.
 */
public class JPanelMain extends JPanel{
    private JPanelDraw draw; // Panel para dibujar el gráfico de dispersión
    private JPanelSection section; // Panel de la sección
    private JPanelTable table; // Panel para mostrar la tabla de datos

    /**
     * Constructor de la clase JPanelMain.
     * 
     * @param section El panel de la sección que se agregará al panel principal.
     */
    public JPanelMain(JPanelSection section) {
        this.section = section;
        this.setLayout(new BorderLayout());
        initComponents();
    }

    /**
     * Método privado para inicializar los componentes del panel principal.
     */
    private void initComponents() {
        this.add(section, BorderLayout.SOUTH); // Agrega el panel de sección al sur del panel principal

        table = new JPanelTable(); // Crea un nuevo panel de tabla
        this.add(table, BorderLayout.WEST); // Agrega el panel de tabla al oeste del panel principal

        draw = new JPanelDraw(); // Crea un nuevo panel para dibujar el gráfico
        this.add(draw, BorderLayout.CENTER); // Agrega el panel de dibujo al centro del panel principal
    }

    /**
     * Método para obtener el panel de la sección.
     * 
     * @return El panel de la sección.
     */
    public JPanelSection getSection() {
        return section;
    }

    /**
     * Método para establecer filas en la tabla de datos.
     * 
     * @param xiList Lista de valores de xi.
     * @param riList Lista de valores de ri.
     * @param niList Lista de valores de ni.
     */
    public void setTableRow(List<Integer> xiList, List<Double> riList, List<Double> niList) {
        table.addRows(xiList, riList, niList);
    }

    /**
     * Método sobrecargado para establecer filas en la tabla de datos sin los valores de xi.
     * 
     * @param riList Lista de valores de ri.
     * @param niList Lista de valores de ni.
     */
    public void setTableRow(List<Double> riList, List<Double> niList) {
        table.addRows(riList, niList);
    }

    /**
     * Método para reiniciar la tabla de datos.
     */
    public void resetTable() {
        table.clearTable();
    }

    /**
     * Método para establecer datos en el gráfico de dispersión.
     * 
     * @param data Lista de datos de dispersión a establecer en el gráfico.
     */
    public void setDrawData(List<Double> data, Double min, Double max) {
        draw.setData(data);
    }

    /**
     * Método para reiniciar el gráfico de dispersión.
     */
    public void resetDraw() {
        draw.resetDraw();
    }

    /**
     * Método para establecer la sección de la tabla.
     * 
     * @param section Arreglo de cadenas que representa la sección de la tabla.
     */
    public void setTableSection(String[] section) {
        table.setHeader(section);
    }
}
