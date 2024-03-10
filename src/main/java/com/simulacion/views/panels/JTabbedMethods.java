package com.simulacion.views.panels;

import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JTabbedPane;

import com.simulacion.views.sections.*;

public class JTabbedMethods extends JTabbedPane {

    private final JPanelMain midSquare;
    private final JPanelMain multiplicative;
    private final JPanelMain linear;
    private final JPanelMain uniform;
    private final JPanelMain normal;

    public JTabbedMethods(ActionListener listener) {
        midSquare = createPanel("Cuadrados Medios", new HalfSquaresSection(listener));
        multiplicative = createPanel("Congruencial Multiplicativa", new MultiplicativeSection(listener));
        linear = createPanel("Congruencial Lineal", new LinearSection(listener));
        uniform = createTablePanel("D. Uniforme", new UniformSection(listener), new String[]{"Ri", "Ni"});
        normal = createTablePanel("D. Normal", new NormalSection(listener), new String[]{"Xi", "Ri"});
    }

    private JPanelMain createPanel(String title, JPanelSection section) {
        JPanelMain panel = new JPanelMain(section);
        add(title, panel);
        return panel;
    }

    private JPanelMain createTablePanel(String title, JPanelSection section, String[] headers) {
        JPanelMain panel = createPanel(title, section);
        panel.setTableHeader(headers);
        return panel;
    }


    public JPanelSection getMidSrtHeader() {
        return midSquare.getSection();
    }

    public JPanelSection getMultHeader() {
        return multiplicative.getSection();
    }

    public JPanelSection getLinHeader() {
        return linear.getSection();
    }

    public JPanelSection getUniHeader() {
        return uniform.getSection();
    }

    public JPanelSection getNormHeader() {
        return normal.getSection();
    }

    // Middle
    public void setMiddSTableRow(Object[] element) {
        midSquare.setTableRow(element);
    }

    public void resetMiddleTable() {
        midSquare.resetTable();
    }

    public void setGraphicData(List<Double> data) {
        midSquare.setGraphicData(data);
    }

    public void resetMiddleGraphic() {
        midSquare.resetGraphic();
    }

    // Linear
    public void resetLinearGraphic() {
        linear.resetGraphic();
    }

    public void setLinearGraphicData(List<Double> interval) {
        linear.setGraphicData(interval);
    }

    public void setLinearTableRow(Object[] element) {
        linear.setTableRow(element);
    }

    public void resetLinearTable() {
        linear.resetTable();
    }

    // Multiplicative
    public void resetMultiplicativeTable() {
        multiplicative.resetTable();
    }

    public void resetMultiplicativeGraphic() {
        multiplicative.resetGraphic();
    }

    public void setMultiplicativeGraphicData(List<Double> interval) {
        multiplicative.setGraphicData(interval);
    }

    public void setMultiplicativeTableRow(Object[] element) {
        multiplicative.setTableRow(element);
    }

    // Uniform
    public void resetUniformTable() {
        uniform.resetTable();
    }

    public void resetUniformGraphic() {
        uniform.resetGraphic();
    }

    public void setUniformGraphicData(List<Double> interval) {
        uniform.setGraphicData(interval);
    }

    public void setUniformTableRow(Object[] element) {
        uniform.setTableRow(element);
    }

    // Normal
    public void setNormalTableRow(Object[] element) {
        normal.setTableRow(element);
    }

    public void resetNormalTable() {
        normal.resetTable();
    }

    public void resetNormalGraphic() {
        normal.resetGraphic();
    }

    public void setNormalGraphicData(List<Double> interval) {
        normal.setGraphicData(interval);
    }
}
