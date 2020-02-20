package com.ceiba.cinemax.infraestructura.error;

public class Error {

    private String nombreExcepcion;
    private String mensajeExcepcion;

    public Error(String nombreExcepcion, String mensajeExcepcion) {
        this.nombreExcepcion = nombreExcepcion;
        this.mensajeExcepcion = mensajeExcepcion;
    }

    public String getNombreExcepcion() {
        return nombreExcepcion;
    }

    public String getMensajeExcepcion() {
        return mensajeExcepcion;
    }
}
