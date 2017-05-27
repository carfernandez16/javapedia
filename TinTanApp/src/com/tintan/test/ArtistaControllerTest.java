package com.tintan.test;

import com.tintan.controller.ArtistaController;
import com.tintan.model.Artista;

/**
 * Created by cfernandez
 * on 5/18/17.
 */
public class ArtistaControllerTest {

    public static void main(String args[]){
        Artista artista = new Artista("OCT-0001", "Octavia", 20, 1,
                "Grupo", "www.octavia.com");
        ArtistaController artistaController = new ArtistaController();
        artistaController.guardar("/Users/cfernandez/Desktop/docencia/tintanapp/", artista);
    }

}
