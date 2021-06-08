package com.example.entendiste.io.response;

import com.example.entendiste.model.Asignatura;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class AsignaturasResponse {

    public String id;
    public String nombre;

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
