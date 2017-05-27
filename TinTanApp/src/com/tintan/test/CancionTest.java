package com.tintan.test;

import com.tintan.model.Album;
import com.tintan.model.Artista;
import com.tintan.model.Cancion;

/**
 * Created by cfernandez
 * on 5/18/17.
 */
public class CancionTest {

    public static void main(String args[]){
        Album album0 = new Album("OCT-AC-0001", "Octavia Acustico", 2000);
        Artista artista = new Artista("OCT-0001", "Octavia", 20, 1,
                "Grupo", "www.octavia.com");
        Cancion pista1 = new Cancion("OCT-AC-0001-VI", "Verdades Ineditas", 2000, 1, 1);
        Cancion pista2 = new Cancion("OCT-AC-0001-C", "Ciclos", 2000, 1, 1);
        Cancion pista3 = new Cancion("OCT-AC-0001-R", "Redencion", 2000, 1, 1);
        System.out.println(pista1);
        System.out.println(pista2);
        System.out.println(pista3);


    }

}
