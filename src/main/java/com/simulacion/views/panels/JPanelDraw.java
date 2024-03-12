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

public class JPanelDraw extends JPanel {
    private XYSeriesCollection dataset;
    private XYSeries series;
    private JFreeChart chart;
    private int index;

    public JPanelDraw() {
        this.setBackground(Color.WHITE);
        initializeChart(); // Inicializa el gráfico con una serie vacía al crear el panel.
    }

    private void initializeChart() {
        dataset = new XYSeriesCollection();
        series = new XYSeries("Ni");
        index = 0;

        dataset.addSeries(series);

        chart = ChartFactory.createScatterPlot("Diagrama de Dispersión", "", "Ni", dataset, PlotOrientation.VERTICAL,
                false, true, false);
        chart.setBackgroundPaint(new Color(255, 255, 255));
        chart.getPlot().setBackgroundPaint(new Color(240, 240, 240));
        chart.getXYPlot().getRenderer().setSeriesPaint(0, new Color(0, 102, 204));
        ChartPanel panel = new ChartPanel(chart);
        panel.setBackground(Color.WHITE);
        this.add(panel);
        panel.updateUI();
    }

    public void setData(List<Double> ni) {
        series.clear(); // Limpia la serie antes de agregar nuevos datos.

        for (Double data : ni) {
            series.add(index++, data);
        }

        chart.fireChartChanged(); // Notifica al gráfico sobre los cambios en los datos.
    }

    public void resetDraw() {
        series.clear(); // Limpia la serie cuando se reinicia el dibujo.
        chart.fireChartChanged(); // Notifica al gráfico sobre los cambios en los datos.
    }
}
