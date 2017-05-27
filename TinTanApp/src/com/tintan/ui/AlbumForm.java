package com.tintan.ui;

import com.tintan.controller.AlbumController;
import com.tintan.model.Album;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by cfernandez
 * on 5/21/17.
 */
public class AlbumForm {
    private final static String directorio_persistencia = "/Users/cfernandez/Desktop/docencia/tintanapp/";

    private JLabel codigoLabel;
    private JTextField codigoTextField;
    private JLabel nombreLabel;
    private JTextField nombreTextField;
    private JLabel anioLabel;
    private JTextField anioTextField;
    private JButton guardarButton;
    private JButton limpiarButton;
    private JButton cargarButton;

    public JPanel getForm(){
        JComponent component = new JPanel();
        Dimension size = new Dimension(500,300);
        component.setMaximumSize(size);
        component.setPreferredSize(size);
        component.setMinimumSize(size);
        TitledBorder border = new TitledBorder(new LineBorder(Color.black), "", TitledBorder.CENTER,
                TitledBorder.BELOW_TOP);
        border.setTitleColor(Color.black);
        component.setBorder(border);
        component.setLayout(null);

        // codigo
        codigoLabel = new JLabel("C\u00f3digo *");
        codigoLabel.setBounds(20,20,80,25);
        component.add(codigoLabel);

        codigoTextField = new JTextField(20);
        codigoTextField.setBounds(100,20,200,25);
        component.add(codigoTextField);

        // Nombre
        nombreLabel = new JLabel("T\u00edtulo *");
        nombreLabel.setBounds(20,50,80,25);
        component.add(nombreLabel);

        nombreTextField = new JTextField(20);
        nombreTextField.setBounds(100,50,200,25);
        component.add(nombreTextField);

        // anio
        anioLabel = new JLabel("A\u00f1o");
        anioLabel.setBounds(20,80,80,25);
        component.add(anioLabel);

        anioTextField = new JTextField(20);
        anioTextField.setBounds(100,80,200,25);
        component.add(anioTextField);

        // Boton Guardar
        guardarButton = new JButton("Guardar");
        guardarButton.setBounds(50, 250, 80, 25);
        component.add(guardarButton);
        addActionBotonGuardar();

        // Boton Limpiar
        limpiarButton = new JButton("Limpiar");
        limpiarButton.setBounds(150, 250, 80, 25);
        component.add(limpiarButton);
        addActionBotonLimpiar();

        // Boton Cargar
        cargarButton = new JButton("Cargar");
        cargarButton.setBounds(250, 250, 80, 25);
        component.add(cargarButton);
        addActionBotonCargar();

        JPanel pane = new JPanel();
        pane.setLayout(new BoxLayout(pane, BoxLayout.X_AXIS));
        pane.add(component);

        return pane;
    }

    private void addActionBotonCargar() {
        AlbumController albumController = new AlbumController();
        cargarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String codigo = codigoTextField.getText();
                if (codigo.isEmpty()){
                    JOptionPane.showMessageDialog(null, "Debe introducir el codigo del Album",
                            "TinTanApp", 2);
                    return;
                }
                Album album = albumController.cargar(codigo, directorio_persistencia);
                nombreTextField.setText(album.getTitulo());
                anioTextField.setText(String.valueOf(album.getYear()));
            }
        });
    }

    private void addActionBotonLimpiar() {
        limpiarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                codigoTextField.setText("");
                nombreTextField.setText("");
                anioTextField.setText("");
            }
        });
    }

    private void addActionBotonGuardar() {
        AlbumController albumController = new AlbumController();
        guardarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String codigo = codigoTextField.getText();
                String nombre  = nombreTextField.getText();
                String anio = anioTextField.getText();
                int anio0 = Integer.parseInt(anio);
                Album album = new Album(codigo, nombre, anio0);
                albumController.guardar(album, directorio_persistencia);
            }
        });
    }
}
