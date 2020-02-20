package com.ceiba.cinemax.dominio.excepcion;

public class ExcepcionCantidadPositiva extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public ExcepcionCantidadPositiva(String mensaje) {super(mensaje);
    }
}
