package com.example.entendiste.io.response;

public class EstadisticasResponse {
    private int porcentaje;
    private int respondieron;
    private int entendieron;
    private int noEntendieron;

    public int getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(int porcentaje) {
        this.porcentaje = porcentaje;
    }

    public int getRespondieron() {
        return respondieron;
    }

    public void setRespondieron(int respondieron) {
        this.respondieron = respondieron;
    }

    public int getEntendieron() {
        return entendieron;
    }

    public void setEntendieron(int entendieron) {
        this.entendieron = entendieron;
    }

    public int getNoEntendieron() {
        return noEntendieron;
    }

    public void setNoEntendieron(int noEntendieron) {
        this.noEntendieron = noEntendieron;
    }
}
