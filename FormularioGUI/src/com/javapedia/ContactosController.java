package com.javapedia;

/**
 * Created by cfernandez
 * on 5/14/17.
 */
public class ContactosController {

    public void guardar(Contacto contacto){
        System.out.println("Nombre: " + contacto.getGenero());
        System.out.println("Edad: " + contacto.getEdad());
        System.out.println("Genero: " + contacto.getGenero());
        System.out.println("Correo: " + contacto.getCorreo());
        System.out.println("Usuario: " + contacto.getUsuario());
        System.out.println("Password: " + contacto.getPassword());
        System.out.println("Familiar: " + contacto.isFamiliar());
        System.out.println("Notas: " + contacto.getNotas());
        System.out.println("ciudad: " + contacto.getCiudad());
    }

}
