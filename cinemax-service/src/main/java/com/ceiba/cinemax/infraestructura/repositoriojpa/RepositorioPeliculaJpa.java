package com.ceiba.cinemax.infraestructura.repositoriojpa;


import com.ceiba.cinemax.infraestructura.entidad.PeliculaEntidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.io.Serializable;


@Repository
public interface RepositorioPeliculaJpa extends JpaRepository<PeliculaEntidad, Serializable> {

    @Query(value="select * from pelicula where pelicula.nombre= :nombre", nativeQuery = true)
    PeliculaEntidad filtroPorNombrePelicula(@Param("nombre") String nombre);



}
