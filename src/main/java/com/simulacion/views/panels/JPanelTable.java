package com.simulacion.views.panels;

import java.awt.Color;
import java.awt.Dimension;
import java.util.List;

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
        setPreferredSize(new Dimension(400, 570));

        dtmElements = new DefaultTableModel(new String[]{"Xi", "Ri", "Ni"}, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        table = new JTable(dtmElements);
        table.setGridColor(Color.decode("#30373D"));
        table.getTableHeader().setReorderingAllowed(false);
        table.setRowHeight(30); // Ajuste de altura de fila
        table.setBackground(Color.WHITE);
        table.setForeground(Color.BLACK); // Cambio de color del texto
        table.setFont(table.getFont().deriveFont(14f)); // Ajuste del tamaño de la fuente
        table.setFillsViewportHeight(true);

        scroll = new JScrollPane(table);
        scroll.setAlignmentX(CENTER_ALIGNMENT);
        scroll.getViewport().setBackground(Color.decode("#30373D")); // Cambio de color del fondo de la tabla
        scroll.setBorder(null); // Eliminación del borde del JScrollPane

        add(scroll);
    }

    public void addRows(List<Integer> xiList, List<Double> riList, List<Double> niList) {
        int rowCount = Math.min(xiList.size(), Math.min(riList.size(), niList.size()));
        for (int i = 0; i < rowCount; i++) {
            Object[] row = {xiList.get(i), riList.get(i), niList.get(i)};
            dtmElements.addRow(row);
        }
    }

    public void addRows(List<Double> riList, List<Double> niList) {
        int rowCount = Math.min(riList.size(), niList.size());
        for (int i = 0; i < rowCount; i++) {
            Object[] row = {riList.get(i), niList.get(i)};
            dtmElements.addRow(row);
        }
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
