package com.javapedia.jsonexcel;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by Carlos Fernandez
 * on 07/05/2017.
 */
public class ArchivoExcel {

    private String rutaArchivoExcel;
    private String nombreHoja;

    private XSSFSheet spreadsheet;
    private XSSFWorkbook workbook;
    private int fila;

    public ArchivoExcel(String rutaArchivoExcel, String nombreHoja) {
        this.rutaArchivoExcel = rutaArchivoExcel;
        this.nombreHoja = nombreHoja;
        this.fila = 0;
    }

    public void iniciarCreacion() {
        workbook = new XSSFWorkbook();
        spreadsheet = workbook.createSheet(nombreHoja);
    }

    public void adicionarTitulo() {
        XSSFRow row = spreadsheet.createRow(fila);
        fila++;
        Cell cell0 = row.createCell(0);
        cell0.setCellValue("Numero");
        Cell cel11 = row.createCell(1);
        cel11.setCellValue("Palabra");
        Cell cell2 = row.createCell(2);
        cell2.setCellValue("Tipo");
        Cell cel13 = row.createCell(3);
        cel13.setCellValue("Significado");
    }

    public void adicionarFila(long numero, String palabra, String tipo, String significado) {
        XSSFRow row = spreadsheet.createRow(fila);
        fila++;
        Cell celdaNumero = row.createCell(0);
        celdaNumero.setCellValue(numero);
        Cell celdaPalabra = row.createCell(1);
        celdaPalabra.setCellValue(palabra);
        Cell celdaTipo = row.createCell(2);
        celdaTipo.setCellValue(tipo);
        Cell celdaSignificado = row.createCell(3);
        celdaSignificado.setCellValue(significado);
    }

    public void terminarCreacion() {
        File file = new File(rutaArchivoExcel);
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
}
