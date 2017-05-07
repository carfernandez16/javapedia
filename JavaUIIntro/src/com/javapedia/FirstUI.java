package com.javapedia;

import javax.swing.*;

/**
 * Created by Carlos Fernandez
 * on 07/05/2017.
 */
public class FirstUI {

    public static void main(String args[]){
        String nombre = JOptionPane.showInputDialog("Introduzca su nombre:");
        String saludo = "Hola " + nombre;
        JOptionPane.showMessageDialog(null, saludo);
        //JOptionPane.showMessageDialog(null, saludo,"FirstUI",1);
    }

}
