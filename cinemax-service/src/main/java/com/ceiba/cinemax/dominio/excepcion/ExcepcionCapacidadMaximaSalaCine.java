package com.ceiba.cinemax.dominio.excepcion;

public class ExcepcionCapacidadMaximaSalaCine extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public ExcepcionCapacidadMaximaSalaCine(String mensaje) {
        super(mensaje);
    }

}
