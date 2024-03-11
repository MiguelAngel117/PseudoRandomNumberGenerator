package com.simulacion.views.panels;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class JPanelTable extends JPanel {
    private DefaultTableModel dtmElements;
    private JTable table;
    private JScrollPane scroll;

    public JPanelTable() {
        initializeComponents();
    }

    private void initializeComponents() {
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        setBackground(Color.decode("#30373D"));
        setPreferredSize(new Dimension(500, 570));

        dtmElements = new DefaultTableModel(new String[]{"Xi", "Ri", "Ni"}, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        table = new JTable(dtmElements);
        table.setGridColor(Color.decode("#30373D"));
        table.getTableHeader().setReorderingAllowed(false);
        table.setRowHeight(50);
        table.setBackground(Color.WHITE);
        table.setFillsViewportHeight(true);

        scroll = new JScrollPane(table);
        scroll.setAlignmentX(CENTER_ALIGNMENT);

        add(scroll);
    }

    public void addRow(Object[] row) {
        dtmElements.addRow(row);
    }

    public void setTableHeader(String[] header) {
        dtmElements.setColumnIdentifiers(header);
    }

    public void clearTable() {
        dtmElements.setRowCount(0);
    }

    public void setHeader(String[] header) {
        setTableHeader(header);
    }
}