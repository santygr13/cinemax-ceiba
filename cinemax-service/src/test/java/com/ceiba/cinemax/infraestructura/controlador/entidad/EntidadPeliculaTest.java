package com.ceiba.cinemax.infraestructura.controlador.entidad;

import com.ceiba.cinemax.infraestructura.entidad.PeliculaEntidad;
import com.ceiba.cinemax.infraestructura.entidad.SalaCineEntidad;

import com.ceiba.cinemax.testdatabuilder.infraestructura.entidad.EntidadPeliculaTestDataBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class EntidadPeliculaTest {


    private static final String NOMBRE_PELICULA="TRANSFORMERS";
    private static final SalaCineEntidad SALA_CINE= Mockito.mock(SalaCineEntidad.class);
    private static final String NUMERO_SALA_CINE="1";

    @Test
    void funcionamientoGetPeliculaTest(){

        PeliculaEntidad peliculaEntidad = new EntidadPeliculaTestDataBuilder().build();
        peliculaEntidad.setNombre(NOMBRE_PELICULA);
        peliculaEntidad.setSalaCineEntidad(SALA_CINE);
        peliculaEntidad.setNumeroSalaCine(NUMERO_SALA_CINE);

        Assertions.assertEquals(peliculaEntidad.getNombre(),NOMBRE_PELICULA);
        Assertions.assertEquals(peliculaEntidad.getSalaCineEntidad(),SALA_CINE);
        Assertions.assertEquals(peliculaEntidad.getNumeroSalaCine(),NUMERO_SALA_CINE);
    }



}
