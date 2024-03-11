package com.simulacion.views.panels;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.JPanel;

public class JPanelMain extends JPanel{
    private JPanelDraw draw;
    private JPanelSection section;
    private JPanelTable table;


    public JPanelMain(JPanelSection section) {
        this.section = section;
        this.setLayout(new BorderLayout());
        initComponents();
    }

    private void initComponents() {
        this.add(section, BorderLayout.NORTH);

        table = new JPanelTable();
        this.add(table, BorderLayout.WEST);

        draw = new JPanelDraw();
        this.add(draw, BorderLayout.CENTER);
    }

    public JPanelSection getSection() {
        return section;
    }

     public void setTableRow(Object[] row) {
        table.addRow(row);
    }

    public void resetTable() {
        table.clearTable();
    }

    public void setGraphicData(List<Double> data) {
        draw.setData(data);
    }

    public void resetGraphic() {
        draw.resetGraphic();
    }

    public void setTableHeader(String[] header) {
        table.setHeader(header);
    }
}