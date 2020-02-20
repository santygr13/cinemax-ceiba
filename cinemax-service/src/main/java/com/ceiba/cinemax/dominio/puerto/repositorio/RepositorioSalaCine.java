package com.ceiba.cinemax.dominio.puerto.repositorio;

import com.ceiba.cinemax.dominio.modelo.SalaCine;
import com.ceiba.cinemax.dominio.modelo.dto.SalaCineDto;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositorioSalaCine {

    void guardar(SalaCine salaCine);

    void guardarEstado(SalaCine salaCine);

    SalaCine filtroCapacidadPorNombrePelicula(String nombrePelicula);


    SalaCine filtrarSalaCinePorNumeroSalaCinePeliculaEnPelicula(String numeroSalacinePelicula);



    boolean existe(SalaCine salaCine);
    boolean noExiste(String numeroSala);
    List<SalaCineDto> listar();


}
