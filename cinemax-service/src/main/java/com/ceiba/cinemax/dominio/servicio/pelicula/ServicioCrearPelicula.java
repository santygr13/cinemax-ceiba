package com.ceiba.cinemax.dominio.servicio.pelicula;

import com.ceiba.cinemax.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.cinemax.dominio.excepcion.ExcepcionExistenciaSalaCine;
import com.ceiba.cinemax.dominio.modelo.Pelicula;
import com.ceiba.cinemax.dominio.modelo.SalaCine;
import com.ceiba.cinemax.dominio.puerto.repositorio.RepositorioPelicula;
import com.ceiba.cinemax.dominio.puerto.repositorio.RepositorioSalaCine;
import com.ceiba.cinemax.dominio.servicio.salacine.ServicioEstadoSalaCine;

import org.springframework.stereotype.Service;

@Service
public class ServicioCrearPelicula {

    private static final String LA_PELICULA_YA_EXISTE="La pelicula ya se encuentra registrada";
    private static final String LA_SALA_CINE_NO_EXISTE="la sala de cine no existe";

    private ServicioEstadoSalaCine servicioEstadoSalaCine;
    private RepositorioSalaCine repositorioSalaCine;
    private RepositorioPelicula repositorioPelicula;

    public ServicioCrearPelicula(RepositorioPelicula repositorioPelicula, RepositorioSalaCine repositorioSalaCine, ServicioEstadoSalaCine servicioEstadoSalaCine) {
        this.repositorioPelicula = repositorioPelicula;
        this.repositorioSalaCine= repositorioSalaCine;
        this.servicioEstadoSalaCine=servicioEstadoSalaCine;
    }


    public void validarExistenciaPelicula(String nombre){
        boolean existe = this.repositorioPelicula.existe(nombre);
        if (existe){
            throw new ExcepcionDuplicidad(LA_PELICULA_YA_EXISTE);
        }
    }

    public void validarExistenciaSalaCine(Pelicula pelicula){
        boolean existe = this.repositorioSalaCine.noExiste(pelicula.getNumeroSalaCine());
        if (existe){
            throw new ExcepcionExistenciaSalaCine(LA_SALA_CINE_NO_EXISTE);
        }
    }


    public void ejecutar(Pelicula pelicula){

        this.validarExistenciaPelicula(pelicula.getNombre());
        this.validarExistenciaSalaCine(pelicula);
        SalaCine salaCine= repositorioSalaCine.filtrarSalaCinePorNumeroSalaCinePeliculaEnPelicula(pelicula.getNumeroSalaCine());
        pelicula.setSalaCine(salaCine);
        servicioEstadoSalaCine.cambiarEstadoSalaCine(pelicula.getNumeroSalaCine());
        this.repositorioPelicula.guardar(pelicula);

    }



}
