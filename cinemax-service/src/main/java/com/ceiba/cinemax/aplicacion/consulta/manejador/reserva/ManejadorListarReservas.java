package com.ceiba.cinemax.aplicacion.consulta.manejador.reserva;

import com.ceiba.cinemax.dominio.modelo.dto.ReservaDto;
import com.ceiba.cinemax.dominio.puerto.repositorio.RepositorioReserva;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorListarReservas {

    private RepositorioReserva repositorioReserva;

    public ManejadorListarReservas(RepositorioReserva repositorioReserva) {
        this.repositorioReserva = repositorioReserva;
    }

    public List<ReservaDto> ejecutar(){
        return this.repositorioReserva.listar();
    }

}
