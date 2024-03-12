package com.simulacion.views.panels;

import java.awt.Color;
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
        normal = createTablePanel("D. Normal", new NormalSection(listener), new String[]{"Ri", "Ni"});
        setTabPlacement(JTabbedPane.LEFT);
        setBackground(Color.decode("#A7643D"));
    }

    private JPanelMain createPanel(String title, JPanelSection section) {
        JPanelMain panel = new JPanelMain(section);
        add(title, panel);
        return panel;
    }

    private JPanelMain createTablePanel(String title, JPanelSection section, String[] rows) {
        JPanelMain panel = createPanel(title, section);
        panel.setTableSection(rows);
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
    public void setMiddSTableRow(List<Integer> xiList, List<Double> riList, List<Double> niList) {
        midSquare.setTableRow(xiList,riList,niList);
    }

    public void resetMiddleTable() {
        midSquare.resetTable();
    }

    public void setDrawData(List<Double> data) {
        midSquare.setDrawData(data);
    }

    public void resetMiddleGraphic() {
        midSquare.resetDraw();
    }

    // Linear
    public void resetLinearGraphic() {
        linear.resetDraw();
    }

    public void setLinearGraphicData(List<Double> interval) {
        linear.setDrawData(interval);
    }

    public void setLinearTableRow(List<Integer> xiList, List<Double> riList, List<Double> niList) {
        linear.setTableRow(xiList,riList,niList);
    }

    public void resetLinearTable() {
        linear.resetTable();
    }

    // Multiplicative
    public void resetMultiplicativeTable() {
        multiplicative.resetTable();
    }

    public void resetMultiplicativeGraphic() {
        multiplicative.resetDraw();
    }

    public void setMultiplicativeGraphicData(List<Double> interval) {
        multiplicative.setDrawData(interval);
    }

    public void setMultiplicativeTableRow(List<Integer> xiList, List<Double> riList, List<Double> niList) {
        multiplicative.setTableRow(xiList,riList,niList);
    }

    // Uniform
    public void resetUniformTable() {
        uniform.resetTable();
    }

    public void resetUniformGraphic() {
        uniform.resetDraw();
    }

    public void setUniformGraphicData(List<Double> interval) {
        uniform.setDrawData(interval);
    }

    public void setUniformTableRow(List<Double> riList, List<Double> niList) {
        uniform.setTableRow(riList,niList);
    }

    // Normal
    public void setNormalTableRow(List<Double> riList, List<Double> niList) {
        normal.setTableRow(riList,niList);
    }

    public void resetNormalTable() {
        normal.resetTable();
    }

    public void resetNormalGraphic() {
        normal.resetDraw();
    }

    public void setNormalGraphicData(List<Double> interval) {
        normal.setDrawData(interval);
    }
}
