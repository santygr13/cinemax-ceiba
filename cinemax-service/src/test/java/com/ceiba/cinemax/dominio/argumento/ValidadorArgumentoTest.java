package com.ceiba.cinemax.dominio.argumento;

import com.ceiba.cinemax.dominio.excepcion.ExcepcionCampoObligatorio;
import com.ceiba.cinemax.dominio.excepcion.ExcepcionCampoVacio;
import com.ceiba.cinemax.dominio.excepcion.ExcepcionCantidadPositiva;
import com.ceiba.cinemax.dominio.excepcion.ExcepcionFechaInvalida;
import com.ceiba.cinemax.dominio.validador.ValidadorArgumento;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class ValidadorArgumentoTest {

    private static final String ESTE_CAMPO_ES_OBLIGATORIO="El campo es obligatorio";
    private static final LocalDate FECHA_RESERVA=LocalDate.of(2020,1,29);
    private static final String ERROR_FECHA_RESERVA="La fecha de reserva no es valida";
    private static final String LA_CANTIDAD_NO_PUEDE_SER_NEGATIVA="la cantidad debe de ser positiva";
    private static final int CANTIDAD=-3;
    private static final String CAMPO_VACIO ="";

    @Test
    public void validarCampoObligatrioTest(){
        try {
            ValidadorArgumento.validarCampoObligatorio(null,ESTE_CAMPO_ES_OBLIGATORIO);
        }catch (ExcepcionCampoObligatorio e){
            Assertions.assertEquals(ESTE_CAMPO_ES_OBLIGATORIO,e.getMessage());
        }
    }

    @Test
    public void validarCampoVacioTest(){
        try {
            ValidadorArgumento.validarCampoVacio(null,CAMPO_VACIO);
        }catch (ExcepcionCampoVacio e){
            Assertions.assertEquals(CAMPO_VACIO,e.getMessage());
        }
    }


    @Test
    public void validarFechaValidaTest(){
        try {
            ValidadorArgumento.validadorFechaValida(FECHA_RESERVA,ERROR_FECHA_RESERVA);
        }catch (ExcepcionFechaInvalida e){
            Assertions.assertEquals(ERROR_FECHA_RESERVA,e.getMessage());
        }
    }

    @Test
    public void validadorArgumentoCantidadPositivaTest(){
        try{
            ValidadorArgumento.validadorArgumentoCantidadPositiva(CANTIDAD,LA_CANTIDAD_NO_PUEDE_SER_NEGATIVA);

        }catch (ExcepcionCantidadPositiva e){
            Assertions.assertEquals(LA_CANTIDAD_NO_PUEDE_SER_NEGATIVA,e.getMessage());
        }
    }

}




