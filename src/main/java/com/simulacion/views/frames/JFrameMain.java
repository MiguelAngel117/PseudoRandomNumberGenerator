package com.simulacion.views.frames;

import java.awt.Dimension;

import javax.swing.JFrame;

import com.simulacion.views.sections.LinearSection;

public class JFrameMain extends JFrame {

    public JFrameMain() {
        this.setTitle("Pseudo-aleatory number Generator");
        this.setMinimumSize(new Dimension(WIDTH, HEIGHT));
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        initComponents();
    }

    public void initComponents() {
        this.add(new LinearSection(null));
    }
    
}
