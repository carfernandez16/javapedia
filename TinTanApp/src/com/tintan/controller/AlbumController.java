package com.tintan.controller;

import com.tintan.model.Album;
import com.tintan.model.Artista;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by cfernandez
 * on 5/18/17.
 */
public class AlbumController {

    private static final String NOMBRE_ARCHIVO = "album.json";

    private static final String CODIGO = "codigo";
    private static final String TITULO = "titulo";
    private static final String YEAR = "year";

    public Album cargar(String codigo, String ruta){
        Album album = null;

        // 1. leer el archivo json linea por linea
        FileInputStream inputStream = null;
        Scanner sc = null;
        File archivo = new File(ruta + NOMBRE_ARCHIVO);
        try {
            inputStream = new FileInputStream(archivo.getPath());
            sc = new Scanner(inputStream, "UTF-8");
            while (sc.hasNextLine()) {
                String linea = sc.nextLine();
                if (!linea.isEmpty()) {
                    System.out.println("linea=" + linea);
                    // 2. convertir la linea a objeto JSON
                    JSONObject jsonObject = convertirLineaAJsonObject(linea);
                    // 3. verificar si el codigo del album leido en cada linea es igual al codigo especificado
                    // en la interfaz grafica
                    String codigoLeido = (String)jsonObject.get(CODIGO);
                    if (codigoLeido.equals(codigo)){
                        // 4. Si el codigo es el mismo convertir el JSON leido en la linea a objeto album
                        album = convertirJsonAContacto(jsonObject);
                        // 5. Como solo se quiere leer un album con el codigo introducido en la interfaz grafica
                        // entonces ya no es necesario leer las demas lineas, para esto se utiliza la palabra break
                        // para terminar el ciclo while
                        break;
                    }
                }
            }
            if (sc.ioException() != null) {
                throw sc.ioException();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (sc != null) {
                sc.close();
            }
        }

        return album;
    }

    public Album convertirJsonAContacto(JSONObject jsonObject){
        String codigo = (String) jsonObject.get(CODIGO);
        String titulo = (String)jsonObject.get(TITULO);
        long anio = (long)jsonObject.get(YEAR);

        Album album = new Album(codigo, titulo, (int)anio);
        return album;
    }

    public void guardar(Album album, String ruta){

        JSONObject jsonObject = new JSONObject();
        jsonObject.put(CODIGO, album.getCodigo());
        jsonObject.put(TITULO, album.getTitulo());
        jsonObject.put(YEAR, album.getYear());

        FileWriter file = null;
        try{
            file = new FileWriter(ruta + NOMBRE_ARCHIVO, true);
            file.write(jsonObject.toJSONString() + "\n");
            file.flush();
            file.close();
            System.out.println("Album Guardado correctamente: " + jsonObject.toString());
        } catch (IOException e) {
            System.out.println("Error intentando guardar album");
            e.printStackTrace();
        } finally {
            if (file != null){
                try {
                    file.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public List<Album> cargarTodosLosAlbunes(String ruta){
        List<Album> albunes = new ArrayList<>();
        FileInputStream inputStream = null;
        Scanner sc = null;
        File archivo = new File(ruta + NOMBRE_ARCHIVO);
        if (!archivo.exists()){
            // si el archivo no existe retornar vacio
            return albunes;
        }
        try {
            inputStream = new FileInputStream(archivo.getPath());
            sc = new Scanner(inputStream, "UTF-8");
            while (sc.hasNextLine()) {
                String linea = sc.nextLine();
                if (!linea.isEmpty()) {
                    System.out.println("linea=" + linea);
                    // 2. convertir la linea a objeto JSON
                    JSONObject jsonObject = convertirLineaAJsonObject(linea);
                    Album album = convertirJsonAAlbun(jsonObject);
                    albunes.add(album);
                }
            }
            if (sc.ioException() != null) {
                throw sc.ioException();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (sc != null) {
                sc.close();
            }
        }
        return albunes;
    }

    private Album convertirJsonAAlbun(JSONObject jsonObject) {
        String codigo = (String)jsonObject.get(CODIGO);
        String nombre = (String)jsonObject.get(TITULO);
        long anio = (long)jsonObject.get(YEAR);
        Album album = new Album(codigo, nombre, (int)anio);
        return album;
    }

    public JSONObject convertirLineaAJsonObject(String linea){
        JSONObject jsonObject = null;
        JSONParser parser = new JSONParser();
        try {
            Object obj = parser.parse(linea);
            jsonObject = (JSONObject) obj;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return jsonObject;
    }

}
