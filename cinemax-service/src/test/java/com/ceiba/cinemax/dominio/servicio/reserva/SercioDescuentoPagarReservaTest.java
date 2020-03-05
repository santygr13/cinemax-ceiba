package com.ceiba.cinemax.dominio.servicio.reserva;

import com.ceiba.cinemax.dominio.excepcion.ExcepcionExistenciaPelicula;
import com.ceiba.cinemax.dominio.modelo.Reserva;
import com.ceiba.cinemax.dominio.puerto.repositorio.RepositorioPelicula;
import com.ceiba.cinemax.dominio.puerto.repositorio.RepositorioReserva;
import com.ceiba.cinemax.dominio.servicio.factura.ServicioCrearFactura;
import com.ceiba.cinemax.dominio.servicio.salacine.ServicioCapacidadSalaCine;
import com.ceiba.cinemax.testdatabuilder.dominio.modelo.FacturaTestDataBuilder;
import com.ceiba.cinemax.testdatabuilder.dominio.modelo.ReservaTestDataBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDate;

public class SercioDescuentoPagarReservaTest {

    private static final int NUMERO_ENTRADAS=7;
    private static final LocalDate FECHA_RESERVA=LocalDate.of(2020,1,30);
    private static final LocalDate FECHA_RESERVA_MARTES=LocalDate.of(2020,2,11);
    private static final LocalDate FECHA_RESERVA_DOMINGO=LocalDate.of(2020,2,16);
    private static final String LA_PELICULA_NO_EXISTE="La pelicula no existe";


    RepositorioReserva repositorioReserva;
    RepositorioPelicula repositorioPelicula;
    ServicioCrearFactura servicioCrearFactura;
    ServicioCapacidadSalaCine servicioCapacidadSalaCine;
    ServicioCrearReserva servicioCrearReserva;
    ServicioDescuentoPagarReserva servicioDescuentoPagarReserva;
    @BeforeEach
    public void init(){
        repositorioPelicula=Mockito.mock(RepositorioPelicula.class);
        repositorioReserva=Mockito.mock(RepositorioReserva.class);
        servicioCrearFactura=Mockito.mock(ServicioCrearFactura.class);
        servicioCapacidadSalaCine=Mockito.mock(ServicioCapacidadSalaCine.class);
        servicioCrearReserva= new ServicioCrearReserva(repositorioReserva,repositorioPelicula,servicioCapacidadSalaCine,servicioCrearFactura);
        servicioDescuentoPagarReserva= new ServicioDescuentoPagarReserva();
    }
    

    @Test
    public void valorReservaDiaNormalTest(){

        servicioDescuentoPagarReserva.valorReserva(NUMERO_ENTRADAS,FECHA_RESERVA);
        double valorObtenido=servicioDescuentoPagarReserva.valorReserva(NUMERO_ENTRADAS,FECHA_RESERVA);
        double valorEsperado=49000;
        Assertions.assertEquals(valorEsperado,valorObtenido);
    }


    @Test
    public void valorReservaMartesMiercolestTest(){
        servicioDescuentoPagarReserva.valorReserva(NUMERO_ENTRADAS,FECHA_RESERVA_MARTES);
        double valorObtenido=servicioDescuentoPagarReserva.valorReserva(NUMERO_ENTRADAS,FECHA_RESERVA_MARTES);
        double valorEsperado=24500;
        Assertions.assertEquals(valorEsperado,valorObtenido);
    }

    @Test
    public void valorReservaDomingoTest(){
        servicioDescuentoPagarReserva.valorReserva(NUMERO_ENTRADAS,FECHA_RESERVA_DOMINGO);
        double valorObtenido=servicioDescuentoPagarReserva.valorReserva(NUMERO_ENTRADAS,FECHA_RESERVA_DOMINGO);
        double valorEsperado=98000;
        Assertions.assertEquals(valorEsperado,valorObtenido);
    }

    @Test
    public void validarNoExistenciaDePeliculaTest(){
        try {

            Mockito.when(repositorioPelicula.existe(Mockito.any())).thenReturn(false);
            servicioCrearReserva.ejecutar(new ReservaTestDataBuilder().build());

            Assertions.fail();
        }catch (ExcepcionExistenciaPelicula e){
            Assertions.assertEquals(LA_PELICULA_NO_EXISTE,e.getMessage());
        }
    }


    @Test
    public void ejecutarTest(){

        Reserva reserva= new ReservaTestDataBuilder().build();

        Mockito.when(repositorioPelicula.existe(Mockito.any())).thenReturn(true);
        Mockito.doNothing().when(servicioCapacidadSalaCine).reducirCapacidadSalaCine(Mockito.anyString(),Mockito.any(int.class));
        Mockito.when(servicioCrearFactura.construirFactura(reserva)).thenReturn(new FacturaTestDataBuilder().build());

        try {
            servicioCrearReserva.ejecutar(reserva);

        }catch (ExcepcionExistenciaPelicula e){
            Assertions.fail(e.getMessage());
        }

    }


}
