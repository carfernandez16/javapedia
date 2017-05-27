package com.tintan.ui;

import com.tintan.controller.ArtistaController;
import com.tintan.model.Artista;

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
public class ArtistasForm{

    private JLabel codigoLabel;
    private JTextField codigoTextField;
    private JLabel nombreLabel;
    private JTextField nombreTextField;
    private JLabel edadLabel;
    private JTextField edadTextField;
    private JLabel paisLabel;
    private JComboBox paisComboBox;
    private JLabel categoriaLabel;
    private JTextField categoriaTextField;
    private JLabel paginaWebLabel;
    private JTextField paginaWebTextField;

    private JButton guardarButton;
    private JButton limpiarButton;
    private JButton cargarButton;


    public JPanel   getForm(){
        // creando componente similar a un panel
        JComponent component = new JPanel();
        Dimension size = new Dimension(500,300);
        component.setMaximumSize(size);
        component.setPreferredSize(size);
        component.setMinimumSize(size);
        TitledBorder border = new TitledBorder(new LineBorder(Color.black), "", TitledBorder.CENTER, TitledBorder.BELOW_TOP);
        border.setTitleColor(Color.black);
        component.setBorder(border);
        component.setLayout(null);

        //adicionando elementos al componente
        // codigo
        codigoLabel = new JLabel("C\u00f3digo *");
        codigoLabel.setBounds(20,20,80,25);
        component.add(codigoLabel);

        codigoTextField = new JTextField(20);
        codigoTextField.setBounds(100,20,200,25);
        component.add(codigoTextField);

        // Nombre
        nombreLabel = new JLabel("Nombre *");
        nombreLabel.setBounds(20,50,80,25);
        component.add(nombreLabel);

        nombreTextField = new JTextField(20);
        nombreTextField.setBounds(100,50,200,25);
        component.add(nombreTextField);

        // Edad
        edadLabel = new JLabel("Edad");
        edadLabel.setBounds(20,80,80,25);
        component.add(edadLabel);

        edadTextField = new JTextField(20);
        edadTextField.setBounds(100,80,200,25);
        component.add(edadTextField);

        // Pais
        edadLabel = new JLabel("Pa\u00eds *");
        edadLabel.setBounds(20,110,80,25);
        component.add(edadLabel);

        String ciudades[] = getPaises();
        paisComboBox = new JComboBox(ciudades);
        paisComboBox.setBounds(100,110,200,25);
        component.add(paisComboBox);

        //categoria
        categoriaLabel = new JLabel("Categor\u00eda");
        categoriaLabel.setBounds(20,140,80,25);
        component.add(categoriaLabel);

        categoriaTextField = new JTextField(20);
        categoriaTextField.setBounds(100,140,200,25);
        component.add(categoriaTextField);

        //website
        paginaWebLabel = new JLabel("P\u00e1gina Web");
        paginaWebLabel.setBounds(20,170,80,25);
        component.add(paginaWebLabel);

        paginaWebTextField = new JTextField("www.ejemplo.com");
        paginaWebTextField.setBounds(100,170,200,25);
        component.add(paginaWebTextField);

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


        // Creando panel final para el componente y adicionando el componente a este panel
        JPanel pane = new JPanel();
        pane.setLayout(new BoxLayout(pane, BoxLayout.X_AXIS));
        pane.add(component);

        return pane;
    }

    private void addActionBotonLimpiar() {
        limpiarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                codigoTextField.setText("");
                nombreTextField.setText("");
                edadTextField.setText("");
                paisComboBox.setSelectedIndex(0);
                categoriaTextField.setToolTipText("");
                paginaWebTextField.setText("");
            }
        });
    }

    private void addActionBotonGuardar() {
        ArtistaController artistaController = new ArtistaController();
        guardarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String codigo = codigoTextField.getText();
                String nombre = nombreTextField.getText();
                int edad = Integer.parseInt(edadTextField.getText());
                int pais = paisComboBox.getSelectedIndex();
                String categoria = categoriaTextField.getText();
                String website = paginaWebTextField.getText();
                Artista artista = new Artista(codigo, nombre, edad, pais, categoria, website);
                artistaController.guardar("/Users/cfernandez/Desktop/docencia/tintanapp/", artista);
            }
        });
    }


    public String[] getPaises() {
        ArtistaController artistaController = new ArtistaController();
        String [] paises = artistaController.obtenerPaisesFromJson();
        return paises;
    }
}
