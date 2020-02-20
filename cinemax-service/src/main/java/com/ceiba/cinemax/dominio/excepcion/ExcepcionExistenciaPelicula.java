package com.ceiba.cinemax.dominio.excepcion;

public class ExcepcionExistenciaPelicula extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public ExcepcionExistenciaPelicula(String mensaje) {super(mensaje);
    }
}
