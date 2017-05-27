package com.tintan.ui;

import com.tintan.controller.AlbumController;
import com.tintan.controller.ArtistaController;
import com.tintan.controller.CancionController;
import com.tintan.model.Album;
import com.tintan.model.Artista;
import com.tintan.model.Cancion;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import java.awt.Dimension;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * Created by cfernandez
 * on 5/21/17.
 */
public class CancionForm {

    private JLabel codigoLabel;
    private JTextField codigoTextField;
    private JLabel nombreLabel;
    private JTextField nombreTextField;
    private JLabel anioLabel;
    private JTextField anioTextField;
    private JLabel albumLabel;
    private JComboBox albumComboBox;
    private JLabel artistaLabel;
    private JComboBox artistaComboBox;

    private JButton guardarButton;
    private JButton limpiarButton;
    private JButton cargarButton;


    public JPanel getForm() {
        JComponent component = new JPanel();
        Dimension size = new Dimension(500,300);
        component.setMaximumSize(size);
        component.setPreferredSize(size);
        component.setMinimumSize(size);
        TitledBorder border = new TitledBorder(new LineBorder(Color.black), "", TitledBorder.CENTER, TitledBorder.BELOW_TOP);
        border.setTitleColor(Color.black);
        component.setBorder(border);
        component.setLayout(null);

        // codigo
        codigoLabel = new JLabel("C\u00f3digo");
        codigoLabel.setBounds(20,20,80,25);
        component.add(codigoLabel);

        codigoTextField = new JTextField(20);
        codigoTextField.setBounds(100,20,200,25);
        component.add(codigoTextField);

        // Nombre
        nombreLabel = new JLabel("Nombre");
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

        // artista
        artistaLabel = new JLabel("Artista");
        artistaLabel.setBounds(20,110,80,25);
        component.add(artistaLabel);

        Artista artistas[] = getArtistas();
        artistaComboBox = new JComboBox(artistas);
        artistaComboBox.setBounds(100,110,250,25);
        component.add(artistaComboBox);

        // album
        albumLabel = new JLabel("Album");
        albumLabel.setBounds(20,140,80,25);
        component.add(albumLabel);

        Album albunes[] = getAlbunes();
        albumComboBox = new JComboBox(albunes);
        albumComboBox.setBounds(100,140,250,25);
        component.add(albumComboBox);

        // Boton Guardar
        guardarButton = new JButton("Guardar");
        guardarButton.setBounds(50, 250, 80, 25);
        component.add(guardarButton);
        addActionBotonGuardar();

        // Boton Limpiar
        limpiarButton = new JButton("Limpiar");
        limpiarButton.setBounds(150, 250, 80, 25);
        component.add(limpiarButton);

        // Boton Cargar
        cargarButton = new JButton("Cargar");
        cargarButton.setBounds(250, 250, 80, 25);
        component.add(cargarButton);


        JPanel artistaPanel = new JPanel();
        artistaPanel.setLayout(new BoxLayout(artistaPanel, BoxLayout.X_AXIS));
        artistaPanel.add(component);

        return artistaPanel;
    }

    private void addActionBotonGuardar() {
        CancionController cancionController = new CancionController();

        guardarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String codigo = codigoTextField.getText();
                String nombre = nombreTextField.getText();
                int anio = Integer.parseInt(anioTextField.getText());
                int artista = artistaComboBox.getSelectedIndex();
                int albun = albumComboBox.getSelectedIndex();

                Cancion cancion = new Cancion(codigo, nombre, anio, artista, albun);
                cancionController.guardar("/Users/cfernandez/Desktop/docencia/tintanapp/", cancion);

            }
        });
    }

    public Artista[] getArtistas(){
        ArtistaController artistaController = new ArtistaController();
        List<Artista> artistas = artistaController.cargarTodosLosArtistas("/Users/cfernandez/Desktop/docencia/tintanapp/");
        int i=0;
        Artista artistas1[] = new Artista[100];
        for (Artista artista : artistas) {
            artistas1[i] = artista;
            i++;
        }
        return artistas1;
    }

    public Album[] getAlbunes() {
        AlbumController albumController = new AlbumController();
        List<Album> albunes = albumController.cargarTodosLosAlbunes("/Users/cfernandez/Desktop/docencia/tintanapp/");
        Album albumesArray[] = new Album [100];
        int i = 0;
        for (Album album : albunes) {
            albumesArray[i] = album;
            i++;
        }
        return albumesArray;
    }

    public void reloadArtistas(){
        Artista artistas[] = getArtistas();
        artistaComboBox.removeAllItems();
        for (int i = 0; i < artistas.length; i++) {
            Artista artista = artistas[i];
            artistaComboBox.addItem(artista);
        }
    }

    public void reloadAlbunes(){
        Album albunes[] = getAlbunes();
        albumComboBox.removeAllItems();
        for (int i = 0; i < albunes.length; i++) {
            Album albun = albunes[i];
            albumComboBox.addItem(albun);
        }
    }
}
