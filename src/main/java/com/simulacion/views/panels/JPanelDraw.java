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
    }

    public void setData(List<Double> ri) {
        dataset = new XYSeriesCollection();
        series = new XYSeries("Ri");
        index = 0;
        for (Double data : ri) {
            series.add(index++, data);
        }
        dataset.addSeries(series);

        // Crear el gráfico con colores llamativos
        chart = ChartFactory.createScatterPlot("Diagrama de Dispersión", "", "Ni", dataset, PlotOrientation.VERTICAL,
                false, true, false);

        // Configuración del gráfico para colores más llamativos
        chart.setBackgroundPaint(new Color(255, 255, 255));
        chart.getPlot().setBackgroundPaint(new Color(240, 240, 240));
        chart.getXYPlot().getRenderer().setSeriesPaint(0, new Color(0, 102, 204));

        // Crear el panel del gráfico y agregarlo al JPanelDraw
        ChartPanel panel = new ChartPanel(chart);
        panel.setBackground(Color.WHITE);
        this.add(panel);
        panel.updateUI();
    }

    public void resetGraphic() {
        this.removeAll();
    }
}
