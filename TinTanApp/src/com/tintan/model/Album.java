package com.tintan.model;

/**
 * Created by cfernandez
 * on 5/18/17.
 */
public class Album {
    private String codigo;
    private String titulo;
    private int year;

    public Album(String codigo, String titulo, int year) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.year = year;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return codigo + " - " + titulo;
    }
}
