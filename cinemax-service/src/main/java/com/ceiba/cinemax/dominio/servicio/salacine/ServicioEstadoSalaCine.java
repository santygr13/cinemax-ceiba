package com.ceiba.cinemax.dominio.servicio.salacine;

import com.ceiba.cinemax.dominio.excepcion.ExcepcionEstadoSalaCine;
import com.ceiba.cinemax.dominio.modelo.SalaCine;
import com.ceiba.cinemax.dominio.puerto.repositorio.RepositorioSalaCine;


import org.springframework.stereotype.Service;

@Service
public class ServicioEstadoSalaCine {


    private static final String SALA_CINE_OCUPADA="La sala de cine se encuentra ocupada ";
    private final RepositorioSalaCine repositorioSalaCine;


    public ServicioEstadoSalaCine(RepositorioSalaCine repositorioSalaCine) {
        this.repositorioSalaCine = repositorioSalaCine;
    }


    public void cambiarEstadoSalaCine(String numeroSalaCine){

        SalaCine salaCine = repositorioSalaCine.filtrarSalaCinePorNumeroSalaCinePeliculaEnPelicula(numeroSalaCine);

        if(salaCine.isEstadoSalaCine()){
            salaCine.setEstadoSalaCine(false);
        }else if (!salaCine.isEstadoSalaCine()){
            throw new ExcepcionEstadoSalaCine(SALA_CINE_OCUPADA);
        }
        this.repositorioSalaCine.guardarEstado(salaCine);
    }


}
