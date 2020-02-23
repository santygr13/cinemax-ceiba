package com.ceiba.cinemax.dominio.validador;

import com.ceiba.cinemax.dominio.excepcion.ExcepcionCampoObligatorio;
import com.ceiba.cinemax.dominio.excepcion.ExcepcionCampoVacio;
import com.ceiba.cinemax.dominio.excepcion.ExcepcionCantidadPositiva;
import com.ceiba.cinemax.dominio.excepcion.ExcepcionFechaInvalida;
import java.time.LocalDate;

public final  class ValidadorArgumento {


    private ValidadorArgumento() {
    }

    public static void validarCampoObligatorio(Object valor , String mensaje){
        if(valor==null){
            throw new ExcepcionCampoObligatorio(mensaje);

        }
    }

    public static void validarCampoVacio(Object valor , String mensaje){
        if(valor==""){
            throw new ExcepcionCampoVacio(mensaje);

        }
    }

    public static void validadorFechaValida(LocalDate fechaReservaPelicula, String mensaje){
        if(fechaReservaPelicula.isBefore(LocalDate.now())){
            throw new ExcepcionFechaInvalida(mensaje);
        }
    }

    public static void validadorArgumentoCantidadPositiva(int cantidadSillas, String mensaje){
        if(cantidadSillas<=0){
            throw new ExcepcionCantidadPositiva(mensaje);
        }
    }


}
