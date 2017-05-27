package com.tintan.test;

import com.tintan.controller.AlbumController;
import com.tintan.model.Album;

/**
 * Created by cfernandez
 * on 5/18/17.
 */
public class AlbumControllerTest {

    public static void main(String args[]){
        Album album0 = new Album("OCT-AC-0001", "Octavia Acustico", 2000);
        AlbumController albumController = new AlbumController();
        albumController.guardar(album0, "/Users/cfernandez/Desktop/docencia/tintanapp/");
    }

}
