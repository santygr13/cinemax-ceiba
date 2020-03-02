package com.ceiba.cinemax.dominio.modelo;

import com.ceiba.cinemax.testdatabuilder.dominio.modelo.PeliculaTestDataBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class PeliculaTest {


    private static final String NOMBRE_PELICULA="TRANSFORMERS";
    private static final SalaCine SALA_CINE= Mockito.mock(SalaCine.class);
    private static final   String NUMERO_SALA_CINE="1";


    void funcionamientoGetterPelicula(){

        Pelicula pelicula= new PeliculaTestDataBuilder().build();
        pelicula.setNombre(NOMBRE_PELICULA);
        pelicula.setSalaCine(SALA_CINE);
        pelicula.setNumeroSalaCine(NUMERO_SALA_CINE);

        Assertions.assertEquals(pelicula.getNombre(),NOMBRE_PELICULA);
        Assertions.assertEquals(pelicula.getSalaCine(),SALA_CINE);
        Assertions.assertEquals(pelicula.getNumeroSalaCine(),NUMERO_SALA_CINE);
    }

}
