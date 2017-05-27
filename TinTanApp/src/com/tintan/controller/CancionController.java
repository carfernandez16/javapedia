package com.tintan.controller;

import com.tintan.model.Cancion;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by cfernandez
 * on 5/21/17.
 */
public class CancionController {

    private static final String NOMBRE_ARCHIVO = "cancion.json";

    public void guardar(String ruta, Cancion cancion) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("codigo", cancion.getCodigo());
        jsonObject.put("nombre", cancion.getNombre());
        jsonObject.put("year", cancion.getYear());
        jsonObject.put("artista", cancion.getArtista());
        jsonObject.put("albun", cancion.getAlbum());

        FileWriter file = null;
        try {
            file = new FileWriter(ruta + NOMBRE_ARCHIVO, true);
            file.write(jsonObject.toJSONString() + "\n");
            file.flush();
            file.close();
            System.out.println("Cancion Guardado correctamente: " + jsonObject.toString());
        } catch (IOException e) {
            System.out.println("Error intentando guardar cancion");
            e.printStackTrace();
        } finally {
            if (file != null) {
                try {
                    file.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
