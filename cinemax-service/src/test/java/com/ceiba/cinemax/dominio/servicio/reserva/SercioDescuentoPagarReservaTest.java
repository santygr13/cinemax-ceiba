package com.ceiba.cinemax.dominio.servicio.reserva;



import com.ceiba.cinemax.dominio.excepcion.ExcepcionExistenciaPelicula;
import com.ceiba.cinemax.dominio.modelo.Reserva;
import com.ceiba.cinemax.dominio.puerto.repositorio.RepositorioPelicula;
import com.ceiba.cinemax.dominio.puerto.repositorio.RepositorioReserva;
import com.ceiba.cinemax.dominio.servicio.factura.ServicioCrearFactura;
import com.ceiba.cinemax.dominio.servicio.salacine.ServicioCapacidadSalaCine;
import com.ceiba.cinemax.testdatabuilder.dominio.modelo.ReservaTestDataBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDate;

public class SercioDescuentoPagarReservaTest {

    private static final int NUMERO_ENTRADAS=7;
    private static final LocalDate FECHA_RESERVA=LocalDate.of(2020,1,30);
    private static final LocalDate FECHA_RESERVA_MARTES=LocalDate.of(2020,2,11);
    private static final LocalDate FECHA_RESERVA_DOMINGO=LocalDate.of(2020,2,16);
    private static final String LA_PELICULA_NO_EXISTE="La pelicula no existe";


    @Test
    public void valorReservaDiaNormalTest(){
        ServicioDescuentoPagarReserva.valorReserva(NUMERO_ENTRADAS,FECHA_RESERVA);

        double valorObtenido=ServicioDescuentoPagarReserva.valorReserva(NUMERO_ENTRADAS,FECHA_RESERVA);
        double valorEsperado=49000;
        Assertions.assertEquals(valorEsperado,valorObtenido);
    }


    @Test
    public void valorReservaMartesMiercolestTest(){
        ServicioDescuentoPagarReserva.valorReserva(NUMERO_ENTRADAS,FECHA_RESERVA_MARTES);
        double valorObtenido=ServicioDescuentoPagarReserva.valorReserva(NUMERO_ENTRADAS,FECHA_RESERVA_MARTES);
        double valorEsperado=24500;
        Assertions.assertEquals(valorEsperado,valorObtenido);
    }

    @Test
    public void valorReservaDomingoTest(){
        ServicioDescuentoPagarReserva.valorReserva(NUMERO_ENTRADAS,FECHA_RESERVA_DOMINGO);
        double valorObtenido=ServicioDescuentoPagarReserva.valorReserva(NUMERO_ENTRADAS,FECHA_RESERVA_DOMINGO);
        double valorEsperado=98000;
        Assertions.assertEquals(valorEsperado,valorObtenido);
    }


    @Test
    public void validarPeliculaNoExisteTest(){
        try {
            Reserva reserva= new ReservaTestDataBuilder().build();
            reserva.setNombrePelicula(null);
            RepositorioReserva repositorioReserva=Mockito.mock(RepositorioReserva.class);
            RepositorioPelicula repositorioPelicula= Mockito.mock(RepositorioPelicula.class);
            ServicioCapacidadSalaCine servicioCapacidadSalaCine=Mockito.mock(ServicioCapacidadSalaCine.class);
            ServicioCrearFactura servicioCrearFactura=Mockito.mock(ServicioCrearFactura.class);
            Mockito.when(repositorioPelicula.noExiste(Mockito.any())).thenReturn(true);
            ServicioCrearReserva servicioCrearReserva= new ServicioCrearReserva(repositorioReserva,repositorioPelicula,servicioCapacidadSalaCine,servicioCrearFactura);
            servicioCrearReserva.ejecutar(reserva);
        }catch (ExcepcionExistenciaPelicula e){
            Assertions.assertEquals(LA_PELICULA_NO_EXISTE,e.getMessage());
        }
    }






}
