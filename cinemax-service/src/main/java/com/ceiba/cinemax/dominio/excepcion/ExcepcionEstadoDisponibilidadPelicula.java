package com.ceiba.cinemax.dominio.excepcion;


public class ExcepcionEstadoDisponibilidadPelicula extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public ExcepcionEstadoDisponibilidadPelicula(String mensaje) {
        super(mensaje);
    }

}
