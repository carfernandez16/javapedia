package com.tintan.model;

/**
 * Created by cfernandez
 * on 5/18/17.
 */
public class Artista {
    private String codigo;
    private String nombre;
    private int edad;
    private int pais;
    private String categoria;
    private String website;

    public Artista(String codigo, String nombre, int edad, int pais, String categoria, String website) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.edad = edad;
        this.pais = pais;
        this.categoria = categoria;
        this.website = website;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getPais() {
        return pais;
    }

    public void setPais(int pais) {
        this.pais = pais;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    @Override
    public String toString() {
        return codigo + " - " + nombre;
    }
}
