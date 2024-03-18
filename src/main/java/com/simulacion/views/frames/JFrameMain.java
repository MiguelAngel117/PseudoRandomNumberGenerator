package com.simulacion.views.frames;

import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.simulacion.views.panels.JPanelSection;
import com.simulacion.views.panels.JTabbedMethods;

/**
 * Clase que representa el marco principal de la aplicación.
 */
public class JFrameMain extends JFrame {

    private static final int WIDTH = 1270; // Ancho predeterminado del marco
    private static final int HEIGHT = 650; // Altura predeterminada del marco
    private static JTabbedMethods methods; // Objeto para administrar los métodos de simulación

    /**
     * Constructor de la clase JFrameMain.
     * 
     * @param listener ActionListener para manejar eventos de los componentes.
     */
    public JFrameMain(ActionListener listener) {
        initializeFrame(); // Inicializa el marco
        initComponents(listener); // Inicializa los componentes del marco
    }

    /**
     * Método privado para inicializar el marco.
     */
    private void initializeFrame() {
        setTitle("Pseudo-aleatory"); // Establece el título del marco
        setMinimumSize(new Dimension(WIDTH, HEIGHT)); // Establece el tamaño mínimo del marco
        setLocationRelativeTo(null); // Centra el marco en la pantalla
        setDefaultCloseOperation(EXIT_ON_CLOSE); // Establece la operación de cierre del marco
    }

    /**
     * Método privado para inicializar los componentes del marco.
     * 
     * @param listener ActionListener para manejar eventos de los componentes.
     */
    private void initComponents(ActionListener listener) {
        methods = new JTabbedMethods(listener); // Crea un nuevo objeto para gestionar los métodos de simulación
        add(methods); // Agrega el panel de pestañas al marco
    }

    /**
     * Método para obtener la sección de la cabecera según el tipo de sección.
     * 
     * @param section Tipo de sección.
     * @return La sección correspondiente al tipo especificado.
     */
    public JPanelSection getHeaderByType(String section) {
        return methods.getSection(section); // Devuelve la sección correspondiente al tipo especificado
    }

    /**
     * Método para establecer filas en la tabla de un método específico.
     * 
     * @param section Tipo de método.
     * @param xiList Lista de valores Xi.
     * @param riList Lista de valores Ri.
     * @param niList Lista de valores Ni.
     */
    public void setTableRow(String section, List<Integer> xiList, List<Double> riList, List<Double> niList) {
        methods.setTableRow(section, xiList, riList, niList); // Establece filas en la tabla del método especificado
    }

    /**
     * Método para reiniciar la tabla de un método específico.
     * 
     * @param section Tipo de método.
     */
    public void resetTable(String section) {
        methods.resetTable(section); // Reinicia la tabla del método especificado
    }

    /**
     * Método para establecer datos en el gráfico de un método específico.
     * 
     * @param section Tipo de método.
     * @param data Lista de datos de dispersión.
     */
    public void setDrawData(String section, List<Double> data, Double min, Double max) {
        methods.setDrawData(section, data,min,max); // Establece datos en el gráfico del método especificado
    }

    /**
     * Método para reiniciar el gráfico de un método específico.
     * 
     * @param section Tipo de método.
     */
    public void resetDraw(String section) {
        methods.resetDraw(section); // Reinicia el gráfico del método especificado
    }

    /**
     * Método para imprimir un mensaje en un cuadro de diálogo.
     * 
     * @param message Mensaje a imprimir.
     */
    public void printMessage(String message) {
        JOptionPane.showMessageDialog(null, message, "Aviso", JOptionPane.INFORMATION_MESSAGE); // Muestra un cuadro de diálogo con el mensaje dado
    }
}
