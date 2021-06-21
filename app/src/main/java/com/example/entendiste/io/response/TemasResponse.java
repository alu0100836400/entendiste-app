package com.example.entendiste.io.response;

public class TemasResponse {
    public String id;
    public String idAsignatura;
    public String idProfesor;
    public String pregunta;

    public String getId() {
        return id;
    }

    public void setId(String idPregunta) {
        this.id = idPregunta;
    }

    public String getIdAsignatura() {
        return idAsignatura;
    }

    public void setIdAsignatura(String idAsignatura) {
        this.idAsignatura = idAsignatura;
    }

    public String getIdProfesor() {
        return idProfesor;
    }

    public void setIdProfesor(String idProfesor) {
        this.idProfesor = idProfesor;
    }

    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }
}
