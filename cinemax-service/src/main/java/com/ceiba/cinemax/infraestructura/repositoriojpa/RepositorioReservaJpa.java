package com.ceiba.cinemax.infraestructura.repositoriojpa;

import com.ceiba.cinemax.infraestructura.entidad.ReservaEntidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.io.Serializable;

@Repository
public interface RepositorioReservaJpa  extends JpaRepository<ReservaEntidad, Serializable> {




}
