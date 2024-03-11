package com.simulacion.views.frames;

import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JFrame;
import com.simulacion.views.panels.JPanelSection;
import com.simulacion.views.panels.JTabbedMethods;

public class JFrameMain extends JFrame {

    private static final int WIDTH = 1200;
    private static final int HEIGHT = 580;
    private static JTabbedMethods methods;

    public JFrameMain(ActionListener listener) {
        initializeFrame();
        initComponents(listener);
    }

    private void initializeFrame() {
        setTitle("Pseudo-aleatory number Generator");
        setMinimumSize(new Dimension(WIDTH, HEIGHT));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void initComponents(ActionListener listener) {
        methods = new JTabbedMethods(listener);
        add(methods);
    }

    public JPanelSection getHeaderByType(String type) {
        switch (type) {
            case "HALF":
                return methods.getMidSrtHeader();
            case "LINEAR":
                return methods.getLinHeader();
            case "MULTIPLICATIVE":
                return methods.getMultHeader();
            case "NORMAL":
                return methods.getNormHeader();
            case "UNIFORM":
                return methods.getUniHeader();
            default:
                return null;
        }
    }

    public void setTableRow(String type, List<Integer> xiList, List<Double> riList, List<Double> niList) {
        switch (type) {
            case "HALF":
                methods.setMiddSTableRow(xiList,riList,niList);
                break;
            case "LINEAR":
                methods.setLinearTableRow(xiList,riList,niList);
                break;
            case "MULTIPLICATIVE":
                methods.setMultiplicativeTableRow(xiList,riList,niList);
                break;
            case "UNIFORM":
                methods.setUniformTableRow(riList,niList);
                break;
            case "NORMAL":
                methods.setNormalTableRow(riList,niList);
                break;
        }
    }

    public void resetTable(String type) {
        switch (type) {
            case "HALF":
                methods.resetMiddleTable();
                break;
            case "LINEAR":
                methods.resetLinearTable();
                break;
            case "MULTIPLICATIVE":
                methods.resetMultiplicativeTable();
                break;
            case "UNIFORM":
                methods.resetUniformTable();
                break;
            case "NORMAL":
                methods.resetNormalTable();
                break;
        }
    }

    public void setGraphicData(String type, List<Double> data) {
        switch (type) {
            case "HALF":
                methods.setGraphicData(data);
                break;
            case "LINEAR":
                methods.setLinearGraphicData(data);
                break;
            case "MULTIPLICATIVE":
                methods.setMultiplicativeGraphicData(data);
                break;
            case "UNIFORM":
                methods.setUniformGraphicData(data);
                break;
            case "NORMAL":
                methods.setNormalGraphicData(data);
                break;
        }
    }

    public void resetGraphic(String type) {
        switch (type) {
            case "HALF":
                methods.resetMiddleGraphic();
                break;
            case "LINEAR":
                methods.resetLinearGraphic();
                break;
            case "MULTIPLICATIVE":
                methods.resetMultiplicativeGraphic();
                break;
            case "UNIFORM":
                methods.resetUniformGraphic();
                break;
            case "NORMAL":
                methods.resetNormalGraphic();
                break;
        }
    }
}
