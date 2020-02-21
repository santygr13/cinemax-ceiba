package com.ceiba.cinemax.dominio.servicio.pelicula;

import com.ceiba.cinemax.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.cinemax.dominio.excepcion.ExcepcionExistenciaPelicula;
import com.ceiba.cinemax.dominio.excepcion.ExcepcionExistenciaSalaCine;
import com.ceiba.cinemax.dominio.modelo.Pelicula;
import com.ceiba.cinemax.dominio.modelo.SalaCine;
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
    private static final String LA_PELICULA_NO_EXISTE="La pelicula no existe";

    @Test
    public void validarExistenciaDePeliculaTest(){
        try {

            Pelicula pelicula= new PeliculaTestDataBuilder().build();
            RepositorioPelicula repositorioPelicula= Mockito.mock(RepositorioPelicula.class);
            RepositorioSalaCine repositorioSalaCine=Mockito.mock(RepositorioSalaCine.class);
            ServicioEstadoSalaCine servicioEstadoSalaCine= Mockito.mock(ServicioEstadoSalaCine.class);
            Mockito.when(repositorioPelicula.existe(Mockito.any())).thenReturn(true);
            ServicioCrearPelicula servicioCrearPelicula= new ServicioCrearPelicula(repositorioPelicula,repositorioSalaCine,servicioEstadoSalaCine);
            servicioCrearPelicula.ejecutar(pelicula);

        }catch (ExcepcionDuplicidad e){
            Assertions.assertEquals(LA_PELICULA_YA_EXISTE,e.getMessage());
        }

    }

    @Test
    public void validarNoExistenciaSalaCineTest(){
        try {
            Pelicula pelicula= new Pelicula("Transformers",new SalaCine("1",200,true),"1");
            RepositorioSalaCine repositorioSalaCine= Mockito.mock(RepositorioSalaCine.class);
            RepositorioPelicula repositorioPelicula= Mockito.mock(RepositorioPelicula.class);
            ServicioEstadoSalaCine servicioEstadoSalaCine= Mockito.mock(ServicioEstadoSalaCine.class);
            Mockito.when(repositorioSalaCine.noExiste(Mockito.any())).thenReturn(false);
            ServicioCrearPelicula servicioCrearPelicula= new ServicioCrearPelicula(repositorioPelicula,repositorioSalaCine,servicioEstadoSalaCine);
            servicioCrearPelicula.ejecutar(pelicula);
        }catch (ExcepcionExistenciaSalaCine e){
            Assertions.assertEquals(LA_SALA_CINE_NO_EXISTE,e.getMessage());
        }
    }


    @Test
    public void validarNoExistenciaDePeliculaTest(){
        try {

            Pelicula pelicula=new Pelicula("Transformers",new SalaCine("1",200,true),"1");
            RepositorioPelicula repositorioPelicula= Mockito.mock(RepositorioPelicula.class);
            RepositorioSalaCine repositorioSalaCine=Mockito.mock(RepositorioSalaCine.class);
            ServicioEstadoSalaCine servicioEstadoSalaCine= Mockito.mock(ServicioEstadoSalaCine.class);
            Mockito.when(repositorioPelicula.noExiste(Mockito.any())).thenReturn(true);
            ServicioCrearPelicula servicioCrearPelicula= new ServicioCrearPelicula(repositorioPelicula,repositorioSalaCine,servicioEstadoSalaCine);
            servicioCrearPelicula.ejecutar(pelicula);

        }catch (ExcepcionExistenciaPelicula e){
            Assertions.assertEquals(LA_PELICULA_NO_EXISTE,e.getMessage());
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
