package com.javapedia;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Carlos Fernandez
 * on 07/05/2017.
 */
public class EjemploFrameBoton {

    public void crearYMostrarGUI(){
        // creando una ventana
        JFrame jFrame = new JFrame("Ejemplo Frame y Boton");
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // adicinando label en blanco
        JLabel jLabel = new JLabel("");
        Dimension dimension = new Dimension(300,300);
        jLabel.setPreferredSize(dimension);
        jFrame.getContentPane().add(jLabel, BorderLayout.CENTER);

        // adicionando boton
        JButton jButton = new JButton();
        jButton.setText("Mostrar Mensaje");
        jFrame.getContentPane().add(jButton, BorderLayout.SOUTH);

        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jLabel.setText("Hola");
            }
        });

        // mostrando ventana
        jFrame.pack();
        jFrame.setVisible(true);
    }

    public static void main(String args[]){
        EjemploFrameBoton ejemploFrameBoton = new EjemploFrameBoton();
        ejemploFrameBoton.crearYMostrarGUI();
    }

}
