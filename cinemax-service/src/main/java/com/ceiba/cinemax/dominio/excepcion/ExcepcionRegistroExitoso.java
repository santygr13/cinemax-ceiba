package com.ceiba.cinemax.dominio.excepcion;

public class ExcepcionRegistroExitoso extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public ExcepcionRegistroExitoso( String mensaje) {
        super(mensaje);
    }
}
