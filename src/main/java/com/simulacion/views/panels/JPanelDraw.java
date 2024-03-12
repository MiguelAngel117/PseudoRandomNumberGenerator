package com.simulacion.views.panels;

import java.awt.Color;
import java.util.List;

import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

/**
 * Clase que representa un panel Swing que muestra un gráfico de dispersión.
 */
public class JPanelDraw extends JPanel {
    private XYSeriesCollection dataset;
    private XYSeries series; 
    private JFreeChart chart; 
    private int index;

    /**
     * Constructor de la clase JPanelDraw. Establece el color de fondo del panel y
     * inicializa el gráfico de dispersión.
     */
    public JPanelDraw() {
        this.setBackground(Color.WHITE);
        initializeChart(); // Inicializa el gráfico con una serie vacía al crear el panel.
    }

    /**
     * Método privado para inicializar el gráfico de dispersión.
     */
    private void initializeChart() {
        dataset = new XYSeriesCollection(); // Crea un nuevo conjunto de datos
        series = new XYSeries("Ni"); // Crea una nueva serie con el nombre "Ni"
        index = 0; // Inicializa el índice

        dataset.addSeries(series); // Agrega la serie al conjunto de datos

        // Crea el gráfico de dispersión
        chart = ChartFactory.createScatterPlot("Diagrama de Dispersión", "", "Ni", dataset, PlotOrientation.VERTICAL,
                false, true, false);
        
        // Establece los colores de fondo del gráfico y del área de trazado
        chart.setBackgroundPaint(new Color(255, 255, 255));
        chart.getPlot().setBackgroundPaint(new Color(240, 240, 240));
        // Establece el color de la serie
        chart.getXYPlot().getRenderer().setSeriesPaint(0, new Color(0, 102, 204));
        
        // Crea un panel para el gráfico
        ChartPanel panel = new ChartPanel(chart);
        panel.setBackground(Color.WHITE);
        // Agrega el panel al panel actual
        this.add(panel);
        // Actualiza la interfaz de usuario del panel
        panel.updateUI();
    }

    /**
     * Método para establecer los datos en el gráfico de dispersión.
     * 
     * @param ni Lista de datos de dispersión a establecer en el gráfico.
     */
    public void setData(List<Double> ni) {
        series.clear(); // Limpia la serie antes de agregar nuevos datos.

        // Itera sobre la lista de datos y los agrega a la serie
        for (Double data : ni) {
            series.add(index++, data);
        }

        chart.fireChartChanged(); // Notifica al gráfico sobre los cambios en los datos.
    }

    /**
     * Método para reiniciar el dibujo del gráfico de dispersión.
     */
    public void resetDraw() {
        series.clear(); // Limpia la serie cuando se reinicia el dibujo.
        chart.fireChartChanged(); // Notifica al gráfico sobre los cambios en los datos.
    }
}
