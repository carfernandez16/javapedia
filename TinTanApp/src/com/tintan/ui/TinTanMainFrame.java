package com.tintan.ui;

import javax.swing.*;
import java.awt.*;

/**
 * Created by cfernandez
 * on 5/17/17.
 */
public class TinTanMainFrame{

    public void iniciarGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("Tin Tan Application");
        frame.setSize(800, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Create and set up the content pane.
        TinTanMainPanel tinTanMainPanel = new TinTanMainPanel();
        tinTanMainPanel.setOpaque(true); //content panes must be opaque
        frame.setContentPane(tinTanMainPanel);

        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }
}
