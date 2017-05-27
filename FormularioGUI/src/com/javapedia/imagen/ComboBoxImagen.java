package com.javapedia.imagen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by cfernandez
 * on 5/15/17.
 */
public class ComboBoxImagen {

    public static void main(String args[]){

        // creando una ventana
        JFrame jFrame = new JFrame("Ejemplo Frame y Boton");
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // adicinando label en blanco
        JLabel jLabel = new JLabel("");
        Dimension dimension = new Dimension(200,200);
        jLabel.setPreferredSize(dimension);
        jFrame.getContentPane().add(jLabel, BorderLayout.CENTER);

        // adicionando boton
        JButton jButton = new JButton();
        jButton.setText("Mostrar Imagen");
        jFrame.getContentPane().add(jButton, BorderLayout.SOUTH);

        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ImageIcon icon = crearImageIcon("Bird.gif");
                jLabel.setIcon(icon);
            }
        });

        // mostrando ventana
        jFrame.pack();
        jFrame.setVisible(true);
    }

    protected static ImageIcon crearImageIcon(String path) {
        java.net.URL imgURL = ComboBoxImagen.class.getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }

}
