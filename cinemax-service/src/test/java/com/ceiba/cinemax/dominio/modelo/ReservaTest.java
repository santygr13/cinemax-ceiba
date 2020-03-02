package com.ceiba.cinemax.dominio.modelo;


import com.ceiba.cinemax.testdatabuilder.dominio.modelo.ReservaTestDataBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDate;

public class ReservaTest {

    private static final Long ID_RESERVA=1L;
    private static final LocalDate FECHA_RESERVA_PELICULA=LocalDate.of(2019,5,28);
    private static final int CANTIDAD_ENTRADAS=1;
    private static final int DOCUMENTO_CLIENTE=1036919543;
    private static final String NOMBRE_CLIENTE="Santiago";
    private static final String PELICULA= "Transformers";
    private static final Factura FACTURA=Mockito.mock(Factura.class);


    void CreacionReservaTest(){

        Reserva reserva = new ReservaTestDataBuilder().build();
        reserva.setIdReserva(ID_RESERVA);
        reserva.setFechaReservaPelicula(FECHA_RESERVA_PELICULA);
        reserva.setCantidadPuestos(CANTIDAD_ENTRADAS);
        reserva.setDocumentoCliente(DOCUMENTO_CLIENTE);
        reserva.setNombreCliente(NOMBRE_CLIENTE);
        reserva.setNombrePelicula(PELICULA);
        reserva.setFactura(FACTURA);

        Assertions.assertEquals(reserva.getIdReserva(),ID_RESERVA);
        Assertions.assertEquals(reserva.getFechaReservaPelicula(),FECHA_RESERVA_PELICULA);
        Assertions.assertEquals(reserva.getCantidadPuestos(),CANTIDAD_ENTRADAS);
        Assertions.assertEquals(reserva.getDocumentoCliente(),DOCUMENTO_CLIENTE);
        Assertions.assertEquals(reserva.getNombreCliente(),NOMBRE_CLIENTE);
        Assertions.assertEquals(reserva.getNombrePelicula(),PELICULA);
        Assertions.assertEquals(reserva.getFactura(),FACTURA);
    }
}
