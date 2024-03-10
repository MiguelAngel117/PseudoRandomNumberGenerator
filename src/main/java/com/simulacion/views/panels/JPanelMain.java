package com.simulacion.views.panels;

import java.awt.BorderLayout;

import javax.swing.JPanel;

public class JPanelMain extends JPanel{

    private JPanelSection section;

    public JPanelMain(JPanelSection section) {
        this.section = section;
        this.setLayout(new BorderLayout());
        initComponents();
    }

    private void initComponents() {
        this.add(section, BorderLayout.NORTH);
    }

    public void setTableForMethod(String[] header) {
        //table.setHeader(header);
    }

    public JPanelSection getSection() {
        return section;
    }
}
