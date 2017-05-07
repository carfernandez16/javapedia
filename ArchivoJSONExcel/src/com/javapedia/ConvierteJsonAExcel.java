package com.javapedia;

import java.io.*;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * Created by Carlos Fernandez
 * on 06/05/2017.
 */
public class ConvierteJsonAExcel {

    public static void main(String args[]){

        //Creando archivo de tipo Excel
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet spreadsheet = workbook.createSheet("words");
        XSSFRow row = spreadsheet.createRow(0);

        // Creando fila de titulo
        Cell cell0 = row.createCell(0);
        cell0.setCellValue("Numero");
        Cell cel11 = row.createCell(1);
        cel11.setCellValue("Palabra");
        Cell cell2 = row.createCell(2);
        cell2.setCellValue("Tipo");
        Cell cel13 = row.createCell(3);
        cel13.setCellValue("Significado");

        // lectura del archivo json
        String jsonFile = "D:/carlos/javapedia/words.json";
        JSONParser parser = new JSONParser();
        int fila = 1;
        row = spreadsheet.createRow(fila);
        try {
            Object obj = parser.parse(new FileReader(jsonFile));
            JSONArray msg = (JSONArray) obj;
            Iterator<JSONObject> iterator = msg.iterator();
            while (iterator.hasNext()) {
                JSONObject jsonObject = iterator.next();
                System.out.println(jsonObject);
                long numero = (Long)jsonObject.get("numero");
                String palabra = (String)jsonObject.get("palabra");
                String tipo = (String)jsonObject.get("tipo");
                String significado = (String)jsonObject.get("significado");

                Cell celdaNumero = row.createCell(0);
                celdaNumero.setCellValue(numero);
                Cell celdaPalabra = row.createCell(1);
                celdaPalabra.setCellValue(palabra);
                Cell celdaTipo = row.createCell(2);
                celdaTipo.setCellValue(tipo);
                Cell celdaSignificado = row.createCell(3);
                celdaSignificado.setCellValue(significado);

                fila ++;
                row = spreadsheet.createRow(fila);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        String excelFile = "D:/carlos/javapedia/words.xlsx";
        FileOutputStream out = null;
        try {
            out = new FileOutputStream(new File(excelFile));
            workbook.write(out);
            out.close();
            System.out.println("Archivo excel escrito correctamente....");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
