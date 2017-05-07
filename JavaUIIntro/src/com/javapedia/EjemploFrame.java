package com.javapedia;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Carlos Fernandez
 * on 07/05/2017.
 */
public class EjemploFrame {

    public void crearYMostrarGUI(){
        // creando una ventana
        JFrame jFrame = new JFrame("Ejemplo Frame");
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel jLabel = new JLabel("");
        Dimension dimension = new Dimension(300,300);
        jLabel.setPreferredSize(dimension);

        jFrame.getContentPane().add(jLabel, BorderLayout.CENTER);

        // mostrando ventana
        jFrame.pack();
        jFrame.setVisible(true);
    }

    public static void main(String args[]){
        EjemploFrame ejemploFrame = new EjemploFrame();
        ejemploFrame.crearYMostrarGUI();
    }

}
