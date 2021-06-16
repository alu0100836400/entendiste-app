package com.example.entendiste.io.response;

public class RespuestaResponse {
    private int idPregunta;
    private String idAlumno;
    private Boolean respuesta;
    private Boolean empty;
    private Boolean error; //solo para la insercion

    public int getIdPregunta() {
        return idPregunta;
    }

    public void setIdPregunta(int idPregunta) {
        this.idPregunta = idPregunta;
    }

    public String getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(String idAlumno) {
        this.idAlumno = idAlumno;
    }

    public Boolean getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(Boolean respuesta) {
        this.respuesta = respuesta;
    }

    public Boolean getEmpty() {
        return empty;
    }

    public void setEmpty(Boolean empty) {
        this.empty = empty;
    }

    public Boolean getError() { return error; }

    public void setError(Boolean error) { this.error = error; }
}
