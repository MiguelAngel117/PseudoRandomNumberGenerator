package com.simulacion.views.frames;

import java.awt.Dimension;
import java.awt.event.ActionListener;
import javax.swing.JFrame;


import com.simulacion.views.panels.JTabbedMethods;

public class JFrameMain extends JFrame {

    private static final int WIDTH = 1200;
    private static final int HEIGHT = 580;
    private JTabbedMethods methods;;

    public JFrameMain(ActionListener listener) {
        this.setTitle("Pseudo-aleatory number Generator");
        this.setMinimumSize(new Dimension(WIDTH, HEIGHT));
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        initComponents(listener);
    }

    public void initComponents(ActionListener listener) {
        this.methods = new JTabbedMethods(listener);
        this.add(methods);
    }
    
}
