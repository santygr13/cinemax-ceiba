package com.ceiba.cinemax.dominio.modelo;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class FacturaTest {

    private static final LocalDate FECHA_REGISTRO=LocalDate.of(2019,5,28);
    private static final double VALOR_PAGAR=49000;


    void  funcionamientoGetterAndSetterDeFacturaTest(){

        Factura factura = new Factura(LocalDate.now(),49000);
        factura.setFechaReserva(FECHA_REGISTRO);
        factura.setValor(VALOR_PAGAR);

        Assertions.assertEquals(factura.getFechaReserva(),FECHA_REGISTRO);
        Assertions.assertEquals(factura.getValor(),VALOR_PAGAR);
    }














}
