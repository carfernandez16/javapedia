package com.tintan.test;

import javax.swing.*;

/**
 * Created by cfernandez
 * on 5/18/17.
 */
public class MenuPrincipalTest {

    public static void main(String args[]){
        JMenuBar menuBar = new JMenuBar();
        JMenu menuArtista = new JMenu("Artista");
        menuBar.add(menuArtista);
        JMenu menuAlbum = new JMenu("Album");
        menuBar.add(menuAlbum);
        JMenu menuCancion = new JMenu("Cancion");
        menuBar.add(menuCancion);

        JFrame frame = new JFrame("MenuDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Create and set up the content pane.
        frame.setJMenuBar(menuBar);

        //Display the window.
        frame.setSize(450, 260);
        frame.setVisible(true);
    }

}
