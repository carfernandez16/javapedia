package com.tintan.controller;

import com.tintan.model.Artista;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/**
 * Created by cfernandez
 * on 5/18/17.
 */
public class ArtistaController {

    private static final String NOMBRE_ARCHIVO = "artista.json";

    private static final String CODIGO = "codigo";
    private static final String NOMBRE = "nombre";
    private static final String EDAD = "edad";
    private static final String PAIS = "pais";
    private static final String CATEGORIA = "categoria";
    private static final String WEBSITE = "website";

    public void guardar(String ruta, Artista artista){

        JSONObject jsonObject = new JSONObject();
        jsonObject.put(CODIGO, artista.getCodigo());
        jsonObject.put(NOMBRE, artista.getNombre());
        jsonObject.put(EDAD, artista.getEdad());
        jsonObject.put(PAIS, artista.getPais());
        jsonObject.put(CATEGORIA, artista.getCategoria());
        jsonObject.put(WEBSITE, artista.getWebsite());

        FileWriter file = null;
        try{
            file = new FileWriter(ruta + NOMBRE_ARCHIVO, true);
            file.write(jsonObject.toJSONString() + "\n");
            file.flush();
            file.close();
            System.out.println("Artista Guardado correctamente: " + jsonObject.toString());
        } catch (IOException e) {
            System.out.println("Error intentando guardar artista");
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

    public List<Artista> cargarTodosLosArtistas(String ruta) {
        List<Artista> artistas = new ArrayList<>();
        FileInputStream inputStream = null;
        Scanner sc = null;
        File archivo = new File(ruta + NOMBRE_ARCHIVO);
        if (!archivo.exists()){
            // si el archivo no existe retornar vacio
            return artistas;
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
                    Artista artista = convertirJsonAArtista(jsonObject);
                    artistas.add(artista);
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
        return artistas;
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

    public Artista convertirJsonAArtista(JSONObject jsonObject){
        String codigo = (String)jsonObject.get(CODIGO);
        String nombre = (String)jsonObject.get(NOMBRE);
        long edad = (long)jsonObject.get(EDAD);
        long pais = (long)jsonObject.get(PAIS);
        String categoria = (String)jsonObject.get(CATEGORIA);
        String website = (String)jsonObject.get(WEBSITE);

        Artista artista = new Artista(codigo, nombre, (int)edad, (int)pais, categoria, website);
        return artista;
    }

    public String [] obtenerPaisesFromJson(){
        System.out.println("Cargando paises...");
        String paises [] = new String[1000];
        int paisesCounter = 0;
        JSONParser parser = new JSONParser();
        try {
            Object obj = parser.parse(new FileReader("/Users/cfernandez/Desktop/docencia/tintanapp/paises-array.json"));
            JSONArray msg = (JSONArray) obj;
            Iterator<JSONObject> iterator = msg.iterator();
            while (iterator.hasNext()) {
                JSONObject jsonObject = (JSONObject) iterator.next();
                System.out.println(jsonObject);
                String pais = (String)jsonObject.get("nome");
                paises[paisesCounter] = pais;
                paisesCounter++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return paises;
    }
}
