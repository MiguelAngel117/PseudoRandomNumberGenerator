package com.simulacion.views.panels;

import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JTabbedPane;

import com.simulacion.views.sections.*;


public class JTabbedMethods extends JTabbedPane {

    private JPanelMain midSquare;
    private JPanelMain multiplicative;
    private JPanelMain linear;
    private JPanelMain uniform;
    private JPanelMain normal;

    public JTabbedMethods(ActionListener listener) {
        initComponents(listener);
    }

    private void initComponents(ActionListener listener) {
        midSquare = new JPanelMain(new HalfSquaresSection(listener));
        this.add("Cuadrados Medios", midSquare);

        multiplicative = new JPanelMain(new MultiplicativeSection(listener));
        this.add("Congruencial Multiplicativa", multiplicative);

        linear = new JPanelMain(new LinearSection(listener));
        this.add("Congruencial Lineal", linear);

        uniform = new JPanelMain(new UniformSection(listener));
        //uniform.setTableHeader(new String[] { "Ri", "Ni" });
        this.add("D. Uniforme", uniform);

        normal = new JPanelMain(new NormalSection(listener));
        //normal.setTableHeader(new String[] { "Xi", "Ri" });
        this.add("D. Normal", normal);
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

   /*// Middle
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
    }*/
}