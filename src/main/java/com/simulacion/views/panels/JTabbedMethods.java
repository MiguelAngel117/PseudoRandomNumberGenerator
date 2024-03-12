package com.simulacion.views.panels;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JTabbedPane;

import com.simulacion.views.sections.*;

public class JTabbedMethods extends JTabbedPane {

    private final JPanelMain halfSquare;
    private final JPanelMain multiplicative;
    private final JPanelMain linear;
    private final JPanelMain uniform;
    private final JPanelMain normal;

    public JTabbedMethods(ActionListener listener) {
        linear = createPanel("Congruencial Lineal", new LinearSection(listener));
        multiplicative = createPanel("Congruencial Multiplicativa", new MultiplicativeSection(listener));
        halfSquare = createPanel("Cuadrados Medios", new HalfSquaresSection(listener));
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
