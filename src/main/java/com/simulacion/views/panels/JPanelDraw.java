package com.simulacion.views.panels;
import java.awt.BorderLayout;
import java.awt.Color;
import java.util.List;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYSplineRenderer;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class JPanelDraw extends JPanel {
    private JFreeChart chart;
    private XYSeriesCollection dataset;

    public JPanelDraw() {
        super(new BorderLayout());
        initComponents();
    }

    private void initComponents() {
        dataset = new XYSeriesCollection();
        chart = ChartFactory.createXYLineChart("Distribución Normal (Campana de Gauss)", "Valor", "Frecuencia", dataset,
                PlotOrientation.VERTICAL, true, true, false);

        XYPlot plot = (XYPlot) chart.getPlot();
        plot.setBackgroundPaint(Color.WHITE);
        plot.setDomainGridlinePaint(Color.BLACK);
        plot.setRangeGridlinePaint(Color.BLACK);

        XYSplineRenderer renderer = new XYSplineRenderer();
        plot.setRenderer(renderer);

        NumberAxis yAxis = (NumberAxis) plot.getRangeAxis();
        yAxis.setAutoRangeIncludesZero(false); // Evita que el eje Y incluya el cero
        yAxis.setAutoRange(true); // Ajusta automáticamente el rango del eje Y

        add(new ChartPanel(chart), BorderLayout.CENTER);
    }

    public void setData(List<Double> data) {
        dataset.removeAllSeries();
        XYSeries series = new XYSeries("Data");
        for (int i = 0; i < data.size(); i++) {
            series.add(i, data.get(i));
        }
        dataset.addSeries(series);
    }

    public void resetDraw() {
        dataset.removeAllSeries();
    }
}