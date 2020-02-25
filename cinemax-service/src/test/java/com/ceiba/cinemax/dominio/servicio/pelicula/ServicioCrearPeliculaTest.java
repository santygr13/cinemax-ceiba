package com.ceiba.cinemax.dominio.servicio.pelicula;

import com.ceiba.cinemax.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.cinemax.dominio.excepcion.ExcepcionExistenciaSalaCine;
import com.ceiba.cinemax.dominio.modelo.Pelicula;
import com.ceiba.cinemax.dominio.puerto.repositorio.RepositorioPelicula;
import com.ceiba.cinemax.dominio.puerto.repositorio.RepositorioSalaCine;
import com.ceiba.cinemax.dominio.servicio.salacine.ServicioCapacidadSalaCine;
import com.ceiba.cinemax.dominio.servicio.salacine.ServicioEstadoSalaCine;
import com.ceiba.cinemax.testdatabuilder.dominio.modelo.PeliculaTestDataBuilder;
import com.ceiba.cinemax.testdatabuilder.dominio.modelo.SalaCineTestDataBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class ServicioCrearPeliculaTest {

    private static final String LA_PELICULA_YA_EXISTE="La pelicula ya se encuentra registrada";
    private static final String LA_SALA_CINE_NO_EXISTE="la sala de cine no existe";


    ServicioCrearPelicula servicioCrearPelicula;
    RepositorioSalaCine repositorioSalaCine;
    ServicioEstadoSalaCine servicioEstadoSalaCine;
    RepositorioPelicula repositorioPelicula;
    ServicioCapacidadSalaCine servicioCapacidadSalaCine;

    @BeforeEach
    public void init(){
        repositorioSalaCine= Mockito.mock(RepositorioSalaCine.class);
        repositorioPelicula= Mockito.mock(RepositorioPelicula.class);
        servicioEstadoSalaCine=Mockito.mock(ServicioEstadoSalaCine.class);
        servicioCrearPelicula= new ServicioCrearPelicula(repositorioPelicula,repositorioSalaCine,servicioEstadoSalaCine);
        servicioCapacidadSalaCine= new ServicioCapacidadSalaCine(repositorioPelicula,repositorioSalaCine);
    }

    @Test
    public void validarExistenciaDePeliculaTest(){
        try {
            Pelicula pelicula= new PeliculaTestDataBuilder().build();

            Mockito.when(repositorioPelicula.existe(Mockito.any())).thenReturn(true);
            servicioCrearPelicula.ejecutar(pelicula);

            Assertions.fail();
        }catch (ExcepcionDuplicidad e){
            Assertions.assertEquals(LA_PELICULA_YA_EXISTE,e.getMessage());
        }
    }

    @Test
    public void validarNoExistenciaSalaCineTest(){
        try {
            Pelicula pelicula= new PeliculaTestDataBuilder().build();

            Mockito.when(repositorioPelicula.existe(Mockito.any())).thenReturn(false);
            Mockito.when(repositorioSalaCine.noExiste(Mockito.any())).thenReturn(true);
            servicioCrearPelicula.ejecutar(pelicula);

            Assertions.fail();
        }catch (ExcepcionExistenciaSalaCine e){
            Assertions.assertEquals(LA_SALA_CINE_NO_EXISTE,e.getMessage());
        }
    }



    @Test
    public void ejecutarTest(){

        Pelicula pelicula= new PeliculaTestDataBuilder().build();

        Mockito.when(repositorioSalaCine.noExiste(Mockito.any())).thenReturn(false);
        Mockito.when(repositorioPelicula.existe(Mockito.any())).thenReturn(false);
        Mockito.when(repositorioSalaCine.filtrarSalaCinePorNumeroSalaCinePeliculaEnPelicula(Mockito.any()))
                .thenReturn(new SalaCineTestDataBuilder().build());
        Mockito.doNothing().when(servicioEstadoSalaCine).cambiarEstadoSalaCine(Mockito.any());


        try {
            servicioCrearPelicula.ejecutar(pelicula);
        }catch (ExcepcionExistenciaSalaCine | ExcepcionDuplicidad e){
            Assertions.fail(e.getMessage());
        }
    }

}
