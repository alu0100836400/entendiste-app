package com.example.entendiste.model;

import java.util.Date;

public class Asignatura {

    String id;
    String idProfesorAlta;


    String nombre;
    String password;
    Date fechaCreacion;
    Date fechaModificacion;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}