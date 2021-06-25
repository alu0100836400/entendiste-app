package com.example.entendiste.io.response;

public class AsignaturasResponse {

    public String id;
    public String nombre;
    public String password;
    public String idProfesorAlta;
    public boolean insercionCorrecta;

    public String getId() { return id; }

    public void setId(String id) { this.id = id; }

    public String getNombre() { return nombre; }

    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getPassword() { return password; }

    public void setPassword(String password) { this.password = password; }

    public String getIdProfesorAlta() { return idProfesorAlta; }

    public void setIdProfesorAlta(String idProfesorAlta) { this.idProfesorAlta = idProfesorAlta; }

    public boolean isInsercionCorrecta() { return insercionCorrecta; }

    public void setInsercionCorrecta(boolean insercionCorrecta) { this.insercionCorrecta = insercionCorrecta; }
}
