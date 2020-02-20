package com.ceiba.cinemax.infraestructura.controlador.entidad;

import com.ceiba.cinemax.infraestructura.entidad.FacturaEntidad;
import com.ceiba.cinemax.infraestructura.entidad.PeliculaEntidad;
import com.ceiba.cinemax.infraestructura.entidad.ReservaEntidad;
import com.ceiba.cinemax.testdatabuilder.infraestructura.entidad.EntidadReservaTestDataBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDate;

public class EntidadReservaTest {

    private static final Long ID_RESERVA=1L;
    private static final LocalDate FECHA_RESERVA_PELICULA=LocalDate.of(2019,5,28);
    private static final int CANTIDAD_ENTRADAS=1;
    private static final int DOCUMENTO_CLIENTE=1036919543;
    private static final String NOMBRE_CLIENTE="Santiago";
    private static final String PELICULA="Transformers";
    private static final FacturaEntidad FACTURA=Mockito.mock(FacturaEntidad.class);

    @Test
    void funcionamientoGetReservaEntidadTest(){
        ReservaEntidad reservaEntidad= new EntidadReservaTestDataBuilder().build();
        reservaEntidad.setIdReserva(ID_RESERVA);
        reservaEntidad.setFechaReservaPelicula(FECHA_RESERVA_PELICULA);
        reservaEntidad.setCantidadPuestos(CANTIDAD_ENTRADAS);
        reservaEntidad.setDocumentoCliente(DOCUMENTO_CLIENTE);
        reservaEntidad.setNombreCliente(NOMBRE_CLIENTE);
        reservaEntidad.setNombrePelicula(PELICULA);
        reservaEntidad.setFacturaEntidad(FACTURA);

        Assertions.assertEquals(reservaEntidad.getIdReserva(),ID_RESERVA);
        Assertions.assertEquals(reservaEntidad.getFechaReservaPelicula(),FECHA_RESERVA_PELICULA);
        Assertions.assertEquals(reservaEntidad.getCantidadPuestos(),CANTIDAD_ENTRADAS);
        Assertions.assertEquals(reservaEntidad.getDocumentoCliente(),DOCUMENTO_CLIENTE);
        Assertions.assertEquals(reservaEntidad.getNombreCliente(),NOMBRE_CLIENTE);
        Assertions.assertEquals(reservaEntidad.getNombrePelicula(),PELICULA);
        Assertions.assertEquals(reservaEntidad.getFacturaEntidad(),FACTURA);


    }




}
