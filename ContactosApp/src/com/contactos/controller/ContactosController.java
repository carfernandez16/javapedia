package com.contactos.controller;

import com.contactos.model.Contacto;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.util.Scanner;

/**
 * Created by cfernandez
 * on 5/14/17.
 */
public class ContactosController {

    private final static String ARCHIVO_JSON = "/Users/cfernandez/Desktop/docencia/contactosApp/contactos.json";

    private final static String NOMBRE = "nombre";
    private final static String EDAD = "edad";
    private final static String GENERO = "genero";
    private final static String CORREO = "correo";
    private final static String CIUDAD = "ciudad";
    private final static String TELEFONO = "telefono";
    private final static String CODIGO = "codigo";
    private final static String FAMILIAR = "familiar";
    private final static String NOTAS = "notas";


    public void guardar(Contacto contacto){
        System.out.println(contacto.toString());

        JSONObject contactoJson = new JSONObject();
        contactoJson.put(NOMBRE, contacto.getNombre());
        contactoJson.put(EDAD, contacto.getEdad());
        contactoJson.put(GENERO, contacto.getGenero());
        contactoJson.put(CORREO, contacto.getCorreo());
        contactoJson.put(CIUDAD, contacto.getCiudad());
        contactoJson.put(TELEFONO, contacto.getTelefono());
        contactoJson.put(CODIGO, contacto.getCodigo());
        contactoJson.put(FAMILIAR, contacto.isFamiliar());
        contactoJson.put(NOTAS, contacto.getNotas());

        File archivo = new File(ARCHIVO_JSON);
        try (FileWriter file = new FileWriter(archivo.getPath(), true)) {
            file.write(contactoJson.toJSONString() + "\n");
            file.flush();
            System.out.println("Contacto guardado correctamente: " + contacto.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public Contacto cargar(String codigo) {

        Contacto contacto = null;

        // 1. leer el archivo json linea por linea
        FileInputStream inputStream = null;
        Scanner sc = null;
        File archivo = new File(ARCHIVO_JSON);
        try {
            inputStream = new FileInputStream(archivo.getPath());
            sc = new Scanner(inputStream, "UTF-8");
            while (sc.hasNextLine()) {
                String linea = sc.nextLine();
                if (!linea.isEmpty()) {
                    System.out.println("linea=" + linea);
                    // 2. convertir la linea a objeto JSON
                    JSONObject jsonObject = convertirLineaAJsonObject(linea);
                    // 3. verificar si el codigo del contacto leido en cada linea es igual al codigo especificado
                    // en la interfaz grafica
                    String codigoLeido = (String)jsonObject.get(CODIGO);
                    if (codigoLeido.equals(codigo)){
                        // 4. Si el codigo es el mismo convertir el JSON leido en la linea a objeto contacto
                        contacto = convertirJsonAContacto(jsonObject);
                        // 5. Como solo se quiere leer un contacto con el codigo introducido en la interfaz grafica
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

        return contacto;
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

    public Contacto convertirJsonAContacto(JSONObject jsonObject){
        String nombre = (String)jsonObject.get("nombre");
        long edad = (long)jsonObject.get(EDAD);
        String genero = (String)jsonObject.get(GENERO);
        String correo = (String)jsonObject.get(CORREO);
        String telefono = (String)jsonObject.get(TELEFONO);
        String codigo = (String)jsonObject.get(CODIGO);
        boolean familiar = (Boolean)jsonObject.get(FAMILIAR);
        String notas = (String)jsonObject.get(NOTAS);
        long ciudad = (long)jsonObject.get(CIUDAD);

        Contacto contacto = new Contacto(nombre, (int)edad, genero, correo, telefono, codigo, familiar, notas, (int)ciudad);
        return contacto;
    }

    public void exportarAExcel(String ruta){

        // 0. creando libro y hoja excel
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet spreadsheet = workbook.createSheet("contactos");
        // 1. adicionar titulo hoja excel
        adicionarTitulo(spreadsheet);

        FileInputStream inputStream = null;
        Scanner sc = null;
        File archivo = new File(ARCHIVO_JSON);
        try {
            inputStream = new FileInputStream(archivo.getPath());
            sc = new Scanner(inputStream, "UTF-8");
            int fila = 1;
            while (sc.hasNextLine()) {
                String linea = sc.nextLine();
                if (!linea.isEmpty()) {
                    System.out.println("linea=" + linea);
                    // 2. convertir la linea a objeto JSON
                    JSONObject jsonObject = convertirLineaAJsonObject(linea);
                    // 3. convertir objeto JSON a objecto contacto
                    Contacto contacto = convertirJsonAContacto(jsonObject);;
                    // 4. adicionar fila excel con el objeto contacto
                    adicionarFila(spreadsheet, fila, contacto);
                    fila ++;
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

        // 5. Escribiendo archivo excel en disco
        crearArchivoExcel(workbook, ruta);
    }

    public void adicionarTitulo(XSSFSheet spreadsheet) {
        XSSFRow row = spreadsheet.createRow(0);
        Cell cell0 = row.createCell(0);
        cell0.setCellValue(NOMBRE);
        Cell cel11 = row.createCell(1);
        cel11.setCellValue(EDAD);
        Cell cell2 = row.createCell(2);
        cell2.setCellValue(GENERO);
        Cell cel13 = row.createCell(3);
        cel13.setCellValue(CORREO);
        Cell cel14 = row.createCell(4);
        cel14.setCellValue(CIUDAD);
        Cell cel15 = row.createCell(5);
        cel15.setCellValue(TELEFONO);
        Cell cel16 = row.createCell(6);
        cel16.setCellValue(CODIGO);
        Cell cel17 = row.createCell(7);
        cel17.setCellValue(FAMILIAR);
        Cell cel18 = row.createCell(8);
        cel18.setCellValue(NOTAS);
    }

    public void crearArchivoExcel(XSSFWorkbook workbook, String ruta) {
        File file = new File(ruta);
        FileOutputStream out = null;
        try {
            out = new FileOutputStream(file);
            workbook.write(out);
            out.close();
            System.out.println("Archivo excel escrito correctamente....");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void adicionarFila(XSSFSheet spreadsheet, int fila, Contacto contacto) {
        XSSFRow row = spreadsheet.createRow(fila);
        Cell celdaNombre = row.createCell(0);
        celdaNombre.setCellValue(contacto.getNombre());
        Cell celdaEdad = row.createCell(1);
        celdaEdad.setCellValue(contacto.getEdad());
        Cell celdaGenero = row.createCell(2);
        celdaGenero.setCellValue(contacto.getGenero());
        Cell celdaCorreo = row.createCell(3);
        celdaCorreo.setCellValue(contacto.getCorreo());
        Cell celdaCiudad = row.createCell(4);
        celdaCiudad.setCellValue(contacto.getCiudad());
        Cell celdaTelefono = row.createCell(5);
        celdaTelefono.setCellValue(contacto.getTelefono());
        Cell celdaCodigo = row.createCell(6);
        celdaCodigo.setCellValue(contacto.getCodigo());
        Cell celdaFamiliar = row.createCell(7);
        celdaFamiliar.setCellValue(contacto.isFamiliar());
        Cell celdaNotas = row.createCell(8);
        celdaNotas.setCellValue(contacto.getNotas());
    }
}
