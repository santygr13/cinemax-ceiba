package com.ceiba.cinemax.dominio.excepcion;

public class ExcepcionExistenciaSalaCine extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public ExcepcionExistenciaSalaCine(String mensaje) {super(mensaje);
    }
}
