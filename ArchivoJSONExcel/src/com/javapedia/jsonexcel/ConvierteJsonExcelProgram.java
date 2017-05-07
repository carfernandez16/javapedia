package com.javapedia.jsonexcel;

import java.util.Scanner;

/**
 * Created by Carlos Fernandez
 * on 07/05/2017.
 */
public class ConvierteJsonExcelProgram {

    /**
     * Al ejecutar escribir las rutas completas de los archivos
     * D:/carlos/javapedia/words.json
     * D:/carlos/javapedia/words2.xlsx
     */
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduzca la direccion del archivo JSON:");
        String rutaArchivoJson = scanner.next();
        System.out.println("Introduzca la direccion del archivo excel:");
        String rutaArchivoExcel = scanner.next();

        ArchivoJson archivoJson = new ArchivoJson(rutaArchivoJson);
        archivoJson.convertir(rutaArchivoExcel);
    }
}
