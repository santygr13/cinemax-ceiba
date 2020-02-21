package com.ceiba.cinemax.dominio.servicio.salacine;

import com.ceiba.cinemax.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.cinemax.dominio.modelo.SalaCine;
import com.ceiba.cinemax.dominio.puerto.repositorio.RepositorioSalaCine;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class ServicioCrearSalaCineTest {

    private static final String LA_SALA_CINE_YA_EXISTE="La sala de cine ya se encuentra registrada";


    @Test
    public void validarExistenciaDeSalaCineTest(){
        try {
            SalaCine salaCine= new SalaCine("1",200,true);

            RepositorioSalaCine repositorioSalaCine= Mockito.mock(RepositorioSalaCine.class);
            Mockito.when(repositorioSalaCine.existe(Mockito.any())).thenReturn(true);
            ServicioCrearSalaCine servicioCrearSalaCine= new ServicioCrearSalaCine(repositorioSalaCine);
            servicioCrearSalaCine.ejecutar(salaCine);

        }catch (ExcepcionDuplicidad e){
            Assertions.assertEquals(LA_SALA_CINE_YA_EXISTE,e.getMessage());
        }
    }



    @Test
    public void ejecutarTest(){

            SalaCine salaCine= new SalaCine("1",200,true);
            RepositorioSalaCine repositorioSalaCine= Mockito.mock(RepositorioSalaCine.class);
            Mockito.when(repositorioSalaCine.existe(Mockito.any())).thenReturn(false);
            repositorioSalaCine.guardar(salaCine);
    }


}
