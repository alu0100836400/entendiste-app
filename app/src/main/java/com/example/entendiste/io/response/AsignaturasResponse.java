package com.example.entendiste.io.response;

public class AsignaturasResponse {

    public String id;
    public String nombre;
    public String password;
    //añadir al profe encargado de esa asignatura

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

    public String getPassword() { return password; }

    public void setPassword(String password) { this.password = password; }
}
