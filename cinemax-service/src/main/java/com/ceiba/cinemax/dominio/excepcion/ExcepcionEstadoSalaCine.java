package com.ceiba.cinemax.dominio.excepcion;

public class ExcepcionEstadoSalaCine  extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public ExcepcionEstadoSalaCine(String mensaje) {
        super(mensaje);
    }
}
