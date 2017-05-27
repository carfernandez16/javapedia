package com.tintan.ui;

import com.tintan.model.Album;
import com.tintan.model.Cancion;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Created by cfernandez
 * on 5/17/17.
 */
public class TinTanMainPanel extends JPanel {

    public TinTanMainPanel() {
        super(new BorderLayout());

        JTabbedPane tinTanTabPanel = new JTabbedPane();

        JPanel artistasPanel = new JPanel();
        ArtistasForm artistasForm = new ArtistasForm();
        artistasPanel.add(artistasForm.getForm());
        tinTanTabPanel.addTab("Artista", artistasPanel);

        JPanel albumPanel = new JPanel();
        AlbumForm albumForm = new AlbumForm();
        albumPanel.add(albumForm.getForm());
        tinTanTabPanel.addTab("Album", albumPanel);

        JPanel cancionesPanel = new JPanel();
        CancionForm cancionForm = new CancionForm();
        cancionesPanel.add(cancionForm.getForm());
        tinTanTabPanel.addTab("Canci\u00f3n", cancionesPanel);

        tinTanTabPanel.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                if (tinTanTabPanel.getSelectedIndex() == 2){
                    cancionForm.reloadArtistas();
                    cancionForm.reloadAlbunes();
                }
            }
        });

        //Add tabbedPane to this panel.
        add(tinTanTabPanel, BorderLayout.CENTER);
    }
}
