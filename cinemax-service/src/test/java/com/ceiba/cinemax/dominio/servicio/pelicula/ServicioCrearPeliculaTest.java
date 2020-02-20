package com.ceiba.cinemax.dominio.servicio.pelicula;

import com.ceiba.cinemax.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.cinemax.dominio.excepcion.ExcepcionExistenciaSalaCine;
import com.ceiba.cinemax.dominio.modelo.Pelicula;
import com.ceiba.cinemax.dominio.puerto.repositorio.RepositorioPelicula;
import com.ceiba.cinemax.dominio.puerto.repositorio.RepositorioSalaCine;
import com.ceiba.cinemax.dominio.servicio.salacine.ServicioEstadoSalaCine;
import com.ceiba.cinemax.testdatabuilder.dominio.modelo.PeliculaTestDataBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class ServicioCrearPeliculaTest {

    private static final String LA_PELICULA_YA_EXISTE="La pelicula ya se encuentra registrada";
    private static final String LA_SALA_CINE_NO_EXISTE="la sala de cine no existe";

    @Test
    public void validarExistenciaDePeliculaTest(){
        try {

            Pelicula pelicula1= new PeliculaTestDataBuilder().build();

            Pelicula pelicula2= new PeliculaTestDataBuilder().build();

            RepositorioPelicula repositorioPelicula= Mockito.mock(RepositorioPelicula.class);
            RepositorioSalaCine repositorioSalaCine=Mockito.mock(RepositorioSalaCine.class);
            ServicioEstadoSalaCine servicioEstadoSalaCine= Mockito.mock(ServicioEstadoSalaCine.class);
            Mockito.when(repositorioPelicula.existe(Mockito.any())).thenReturn(true);
            ServicioCrearPelicula servicioCrearPelicula= new ServicioCrearPelicula(repositorioPelicula,repositorioSalaCine,servicioEstadoSalaCine);
            servicioCrearPelicula.ejecutar(pelicula1);
            servicioCrearPelicula.ejecutar(pelicula2);

            
        }catch (ExcepcionDuplicidad e){
            Assertions.assertEquals(LA_PELICULA_YA_EXISTE,e.getMessage());
        }

    }



    @Test
    public void validarNoExistenciaSalaCineTest(){
        try {
            Pelicula pelicula= new PeliculaTestDataBuilder().build();
            pelicula.setSalaCine(null);
            RepositorioSalaCine repositorioSalaCine= Mockito.mock(RepositorioSalaCine.class);
            RepositorioPelicula repositorioPelicula= Mockito.mock(RepositorioPelicula.class);
            ServicioEstadoSalaCine servicioEstadoSalaCine= Mockito.mock(ServicioEstadoSalaCine.class);
            Mockito.when(repositorioSalaCine.noExiste(Mockito.any())).thenReturn(true);
            ServicioCrearPelicula servicioCrearPelicula= new ServicioCrearPelicula(repositorioPelicula,repositorioSalaCine,servicioEstadoSalaCine);
            servicioCrearPelicula.ejecutar(pelicula);
        }catch (ExcepcionExistenciaSalaCine e){
            Assertions.assertEquals(LA_SALA_CINE_NO_EXISTE,e.getMessage());
        }
    }

    @Test
    public void ejecutarTest(){
        Pelicula pelicula= new PeliculaTestDataBuilder().build();
        RepositorioPelicula repositorioPelicula= Mockito.mock(RepositorioPelicula.class);
        RepositorioSalaCine repositorioSalaCine= Mockito.mock(RepositorioSalaCine.class);
        Mockito.when(repositorioSalaCine.noExiste(Mockito.any())).thenReturn(true);
        Mockito.when(repositorioPelicula.existe(Mockito.any())).thenReturn(false);
        repositorioPelicula.guardar(pelicula);

    }

}
