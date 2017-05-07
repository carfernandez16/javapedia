package com.javapedia.jsonexcel;

import org.apache.poi.ss.usermodel.Cell;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

/**
 * Created by Carlos Fernandez
 * on 07/05/2017.
 */
public class ArchivoJson {

    private String rutaArchivoJson;

    public ArchivoJson(String rutaArchivoJson) {
        this.rutaArchivoJson = rutaArchivoJson;
    }

    public void convertir(String rutaArchivoExcel) {
        System.out.println("convirtiendo archivo json a excel");
        System.out.println("rutaArchivoJson='" + rutaArchivoJson + "'");

        ArchivoExcel archivoExcel = new ArchivoExcel(rutaArchivoExcel, "words");
        archivoExcel.iniciarCreacion();
        archivoExcel.adicionarTitulo();
        JSONParser parser = new JSONParser();
        try {
            Object obj = parser.parse(new FileReader(rutaArchivoJson));
            JSONArray msg = (JSONArray) obj;
            Iterator<JSONObject> iterator = msg.iterator();
            while (iterator.hasNext()) {
                JSONObject jsonObject = iterator.next();
                System.out.println(jsonObject);
                long numero = (Long)jsonObject.get("numero");
                String palabra = (String)jsonObject.get("palabra");
                String tipo = (String)jsonObject.get("tipo");
                String significado = (String)jsonObject.get("significado");
                archivoExcel.adicionarFila(numero, palabra, tipo, significado);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        archivoExcel.terminarCreacion();
    }
}
