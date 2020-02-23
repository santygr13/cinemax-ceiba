package com.ceiba.cinemax.dominio.servicio.salacine;

import com.ceiba.cinemax.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.cinemax.dominio.excepcion.ExcepcionExistenciaPelicula;
import com.ceiba.cinemax.dominio.modelo.SalaCine;
import com.ceiba.cinemax.dominio.puerto.repositorio.RepositorioSalaCine;
import com.ceiba.cinemax.testdatabuilder.dominio.modelo.SalaCineTestDataBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class ServicioCrearSalaCineTest {

    private static final String LA_SALA_CINE_YA_EXISTE="La sala de cine ya se encuentra registrada";


    ServicioCrearSalaCine servicioCrearSalaCine;
    RepositorioSalaCine repositorioSalaCine;

    @BeforeEach
    public void init(){
        repositorioSalaCine=Mockito.mock(RepositorioSalaCine.class);
        servicioCrearSalaCine= new ServicioCrearSalaCine(repositorioSalaCine);
    }

    @Test
    public void validarExistenciaDeSalaCineTest(){
        try {
            repositorioSalaCine=Mockito.mock(RepositorioSalaCine.class);
            servicioCrearSalaCine= new ServicioCrearSalaCine(repositorioSalaCine);
            SalaCine salaCine= new SalaCineTestDataBuilder().conNumeroSalaCine("1").build();
            Mockito.when(repositorioSalaCine.existe(Mockito.any())).thenReturn(true);
            servicioCrearSalaCine.ejecutar(salaCine);
            Assertions.fail();
        }catch (ExcepcionDuplicidad e){
            Assertions.assertEquals(LA_SALA_CINE_YA_EXISTE,e.getMessage());
        }
    }


    @Test
    public void ejecutarTest(){

            SalaCine salaCine = new SalaCineTestDataBuilder().build();
            Mockito.when(repositorioSalaCine.existe(Mockito.any())).thenReturn(false);
            Mockito.doNothing().when(repositorioSalaCine).guardar(salaCine);
        try {
            servicioCrearSalaCine.ejecutar(salaCine);
        }catch (ExcepcionExistenciaPelicula e){
            Assertions.assertEquals(LA_SALA_CINE_YA_EXISTE,e.getMessage());
        }

    }
}
