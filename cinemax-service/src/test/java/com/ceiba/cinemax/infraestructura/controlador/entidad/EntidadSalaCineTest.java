package com.ceiba.cinemax.infraestructura.controlador.entidad;

import com.ceiba.cinemax.infraestructura.entidad.SalaCineEntidad;
import com.ceiba.cinemax.testdatabuilder.infraestructura.entidad.EntidadSalaCineTestDataBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class EntidadSalaCineTest {


    private static final String NUMERO_SALA_CINE="1";
    private static final int CAPACIDAD_SILLAS=300;
    private static final boolean ESTADO_SALA_CINE= true;

    @Test
    void funcionamientoGetSalaCineEntidadTest(){
        SalaCineEntidad salaCineEntidad= new EntidadSalaCineTestDataBuilder().build();

        salaCineEntidad.setNumeroSalaCine(NUMERO_SALA_CINE);
        salaCineEntidad.setCapacidadSillas(CAPACIDAD_SILLAS);
        salaCineEntidad.setEstadoSalaCine(ESTADO_SALA_CINE);


        Assertions.assertEquals(salaCineEntidad.getNumeroSalaCine(),NUMERO_SALA_CINE);
        Assertions.assertEquals(salaCineEntidad.getCapacidadSillas(),CAPACIDAD_SILLAS);
        Assertions.assertEquals(salaCineEntidad.isEstadoSalaCine(),ESTADO_SALA_CINE);
    }


}
