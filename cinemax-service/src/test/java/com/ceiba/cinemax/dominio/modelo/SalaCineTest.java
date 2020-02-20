package com.ceiba.cinemax.dominio.modelo;


import com.ceiba.cinemax.testdatabuilder.dominio.modelo.SalaCineTestDataBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SalaCineTest {


    private static final String NUMERO_SALA_CINE="1";
    private static final int CAPACIDAD_SILLAS=300;
    private static final boolean ESTADO_SALA_CINE= true;

    @Test
    void funcionamientoGetterSalaCine(){
        SalaCine salaCine= new SalaCineTestDataBuilder().buil();

        salaCine.setNumeroSalaCine(NUMERO_SALA_CINE);
        salaCine.setCapacidadSillas(CAPACIDAD_SILLAS);
        salaCine.setEstadoSalaCine(ESTADO_SALA_CINE);


        Assertions.assertEquals(salaCine.getNumeroSalaCine(),NUMERO_SALA_CINE);
        Assertions.assertEquals(salaCine.getCapacidadSillas(),CAPACIDAD_SILLAS);
        Assertions.assertEquals(salaCine.isEstadoSalaCine(),ESTADO_SALA_CINE);
    }

}
