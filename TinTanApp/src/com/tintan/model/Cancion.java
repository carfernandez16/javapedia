package com.tintan.model;

/**
 * Created by cfernandez
 * on 5/18/17.
 */
public class Cancion {
    private String codigo;
    private String nombre;
    private int year;

    private int artista;
    private int album;

    public Cancion(String codigo, String nombre, int year, int artista, int album) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.year = year;
        this.artista = artista;
        this.album = album;
    }

    @Override
    public String toString() {
        return "Cancion{" +
                "codigo='" + codigo + '\'' +
                ", nombre='" + nombre + '\'' +
                ", year=" + year +
                ", artista=" + artista +
                ", album=" + album +
                '}';
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

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getArtista() {
        return artista;
    }

    public void setArtista(int artista) {
        this.artista = artista;
    }

    public int getAlbum() {
        return album;
    }

    public void setAlbum(int album) {
        this.album = album;
    }
}
