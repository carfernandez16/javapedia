package com.contactos.model;

/**
 * Created by cfernandez
 * on 5/14/17.
 */
public class Contacto {

    private String nombre;
    private int edad;
    private String genero;
    private String correo;
    private String telefono;
    private String codigo;
    private boolean familiar;
    private String notas;
    private int ciudad;

    public Contacto(String nombre, int edad, String genero, String correo, String telefono, String codigo,
                    boolean familiar, String notas, int ciudad) {
        this.nombre = nombre;
        this.edad = edad;
        this.genero = genero;
        this.correo = correo;
        this.telefono = telefono;
        this.codigo = codigo;
        this.familiar = familiar;
        this.notas = notas;
        this.ciudad = ciudad;
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

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNotas() {
        return notas;
    }

    public void setNotas(String notas) {
        this.notas = notas;
    }

    public boolean isFamiliar() {
        return familiar;
    }

    public void setFamiliar(boolean familiar) {
        this.familiar = familiar;
    }

    public int getCiudad() {
        return ciudad;
    }

    public void setCiudad(int ciudad) {
        this.ciudad = ciudad;
    }

    @Override
    public String toString() {
        return "Contacto{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", genero='" + genero + '\'' +
                ", correo='" + correo + '\'' +
                ", telefono='" + telefono + '\'' +
                ", codigo='" + codigo + '\'' +
                ", familiar=" + familiar +
                ", notas='" + notas + '\'' +
                ", ciudad=" + ciudad +
                '}';
    }
}
