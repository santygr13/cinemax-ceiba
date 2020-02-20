package com.ceiba.cinemax.infraestructura.repositoriojpa;

import com.ceiba.cinemax.infraestructura.entidad.SalaCineEntidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

@Repository
public interface RepositorioSalaCineJpa extends JpaRepository<SalaCineEntidad, Serializable> {

    @Query(value = "select sc.* from sala_cine sc join pelicula p on sc.numero_sala_cine = p.numero_sala_cine where p.nombre = :nombrePelicula", nativeQuery = true )
    SalaCineEntidad capacidad(@Param("nombrePelicula") String nombrePelicula);

    @Query(value="select * from sala_cine where sala_cine.numero_sala_cine= :numeroSalaCine", nativeQuery = true)
    SalaCineEntidad filtroPorNumeroSalaCine(@Param("numeroSalaCine") String numeroSalaCine);

    @Query(value="select * from sala_cine where numero_sala_cine=:numeroSalacinePelicula  ", nativeQuery = true)
    SalaCineEntidad filtrarSalaCinePorNumeroSalaCinePeliculaEnPelicula (@Param("numeroSalacinePelicula") String numeroSalacinePelicula);

    @Query(value ="select * from sala_cine where estado_sala_cine=true", nativeQuery = true)
    List<SalaCineEntidad> filtrarSalaCinePorEstadoSalaCineDisponible ();


}
