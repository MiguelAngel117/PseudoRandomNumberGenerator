package com.simulacion.views.panels;

import java.awt.Color;
import java.awt.Dimension;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 * Clase que representa un panel que contiene una tabla para mostrar datos.
 */
public class JPanelTable extends JPanel {
    private DefaultTableModel dtmElements;
    private JTable table;
    private JScrollPane scroll; 

    /**
     * Constructor de la clase JPanelTable. Inicializa los componentes de la tabla.
     */
    public JPanelTable() {
        initializeComponents();
    }

    /**
     * Método privado para inicializar los componentes de la tabla.
     */
    private void initializeComponents() {
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS)); // Establece el diseño del panel como vertical
        setBackground(Color.decode("#30373D")); // Establece el color de fondo del panel
        setPreferredSize(new Dimension(400, 570)); // Establece el tamaño preferido del panel

        // Crea el modelo de tabla con columnas Xi, Ri, Ni
        dtmElements = new DefaultTableModel(new String[]{"Xi", "Ri", "Ni"}, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Hace que las celdas de la tabla no sean editables
            }
        };

        table = new JTable(dtmElements); // Crea la tabla con el modelo de tabla
        table.setGridColor(Color.decode("#30373D")); // Establece el color de la cuadrícula de la tabla
        table.getTableHeader().setReorderingAllowed(false); // Deshabilita la reordenación de columnas
        table.setRowHeight(30); // Establece la altura de las filas de la tabla
        table.setBackground(Color.WHITE); // Establece el color de fondo de la tabla
        table.setForeground(Color.BLACK); // Establece el color del texto de la tabla
        table.setFont(table.getFont().deriveFont(14f)); // Establece el tamaño de la fuente de la tabla
        table.setFillsViewportHeight(true); // Hace que la tabla llene la altura del panel

        scroll = new JScrollPane(table); // Crea un panel de desplazamiento para la tabla
        scroll.setAlignmentX(CENTER_ALIGNMENT); // Alinea el panel de desplazamiento al centro horizontalmente
        scroll.getViewport().setBackground(Color.decode("#30373D")); // Establece el color de fondo del área visible de la tabla
        scroll.setBorder(null); // Elimina el borde del panel de desplazamiento

        add(scroll); // Agrega el panel de desplazamiento al panel principal
    }

    /**
     * Método para agregar filas a la tabla con datos Xi, Ri, Ni.
     * 
     * @param xiList Lista de valores Xi.
     * @param riList Lista de valores Ri.
     * @param niList Lista de valores Ni.
     */
    public void addRows(List<Integer> xiList, List<Double> riList, List<Double> niList) {
        int rowCount = Math.min(xiList.size(), Math.min(riList.size(), niList.size()));
        for (int i = 0; i < rowCount; i++) {
            Object[] row = {xiList.get(i), riList.get(i), niList.get(i)};
            dtmElements.addRow(row);
        }
    }

    /**
     * Método para agregar filas a la tabla con datos Ri, Ni.
     * 
     * @param riList Lista de valores Ri.
     * @param niList Lista de valores Ni.
     */
    public void addRows(List<Double> riList, List<Double> niList) {
        int rowCount = Math.min(riList.size(), niList.size());
        for (int i = 0; i < rowCount; i++) {
            Object[] row = {riList.get(i), niList.get(i)};
            dtmElements.addRow(row);
        }
    }

    /**
     * Método para establecer la sección de la tabla.
     * 
     * @param section Arreglo de cadenas que representa la sección de la tabla.
     */
    public void setTableSection(String[] section) {
        dtmElements.setColumnIdentifiers(section); // Establece los encabezados de columna
    }

    /**
     * Método para limpiar la tabla.
     */
    public void clearTable() {
        dtmElements.setRowCount(0); // Elimina todas las filas de la tabla
    }

    /**
     * Método para establecer los encabezados de columna de la tabla.
     * 
     * @param section Arreglo de cadenas que representa la sección de la tabla.
     */
    public void setHeader(String[] section) {
        setTableSection(section); // Establece los encabezados de columna de la tabla
    }
}
