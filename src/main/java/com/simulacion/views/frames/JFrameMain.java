package com.simulacion.views.frames;

import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.simulacion.views.panels.JPanelSection;
import com.simulacion.views.panels.JTabbedMethods;

public class JFrameMain extends JFrame {

    private static final int WIDTH = 1270;
    private static final int HEIGHT = 650;
    private static JTabbedMethods methods;

    public JFrameMain(ActionListener listener) {
        initializeFrame();
        initComponents(listener);
    }

    private void initializeFrame() {
        setTitle("Pseudo-aleatory");
        setMinimumSize(new Dimension(WIDTH, HEIGHT));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void initComponents(ActionListener listener) {
        methods = new JTabbedMethods(listener);
        add(methods);
    }

    public JPanelSection getHeaderByType(String section) {
        return methods.getSection(section);
    }

    public void setTableRow(String section, List<Integer> xiList, List<Double> riList, List<Double> niList) {
        methods.setTableRow(section, xiList, riList, niList);
    }

    public void resetTable(String section) {
        methods.resetTable(section);
    }

    public void setDrawData(String section, List<Double> data) {
        methods.setDrawData(section, data);
    }

    public void resetDraw(String section) {
        methods.resetDraw(section);
    }

    public void printMessage(String message) {
        JOptionPane.showMessageDialog(null, message, "Aviso", JOptionPane.INFORMATION_MESSAGE);
    }
}
