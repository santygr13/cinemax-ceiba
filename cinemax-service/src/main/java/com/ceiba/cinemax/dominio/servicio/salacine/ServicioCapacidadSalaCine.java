package com.ceiba.cinemax.dominio.servicio.salacine;

import com.ceiba.cinemax.dominio.excepcion.ExcepcionEstadoDisponibilidadPelicula;
import com.ceiba.cinemax.dominio.modelo.SalaCine;
import com.ceiba.cinemax.dominio.puerto.repositorio.RepositorioPelicula;
import com.ceiba.cinemax.dominio.puerto.repositorio.RepositorioSalaCine;
import org.springframework.stereotype.Service;


@Service
public class ServicioCapacidadSalaCine {
    private static final String LA_PELICULA_NO_SE_ENCUENTRA_DISPONIBLE="La pelicula no se encuentra disponible,capacidad de sala llena";


    RepositorioPelicula repositorioPelicula;
    RepositorioSalaCine repositorioSalaCine;

    public ServicioCapacidadSalaCine(RepositorioPelicula repositorioPelicula, RepositorioSalaCine repositorioSalaCine) {
        this.repositorioPelicula = repositorioPelicula;
        this.repositorioSalaCine = repositorioSalaCine;
    }

    public boolean capacidadSalaCine(String nombrePelicula, int cantidadEntradas){
        SalaCine salaCine=repositorioSalaCine.filtroCapacidadPorNombrePelicula(nombrePelicula);
        return salaCine.getCapacidadSillas() > 0 && salaCine.getCapacidadSillas() >= cantidadEntradas ;
    }


    public void reducirCapacidadSalaCine(String nombrePelicula, int cantidadEntradas){
        if (capacidadSalaCine(nombrePelicula, cantidadEntradas)){
            SalaCine salaCine=repositorioSalaCine.filtroCapacidadPorNombrePelicula(nombrePelicula);
            salaCine.setCapacidadSillas(salaCine.getCapacidadSillas() - cantidadEntradas);
            repositorioSalaCine.guardar(salaCine);
        }else {
            throw new ExcepcionEstadoDisponibilidadPelicula(LA_PELICULA_NO_SE_ENCUENTRA_DISPONIBLE);
        }
    }

}
