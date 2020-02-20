package com.ceiba.cinemax.dominio.excepcion;

public class ExcepcionFechaInvalida extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public ExcepcionFechaInvalida( String mensaje) {
        super(mensaje);
    }

}
