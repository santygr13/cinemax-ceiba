package com.ceiba.cinemax.dominio.puerto.repositorio;

import com.ceiba.cinemax.dominio.modelo.Reserva;
import com.ceiba.cinemax.dominio.modelo.dto.ReservaDto;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositorioReserva {

    void guardar(Reserva reserva);
    List<ReservaDto> listar();


}
