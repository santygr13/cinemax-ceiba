package com.ceiba.cinemax.aplicacion.comando.manejador.reserva;

import com.ceiba.cinemax.aplicacion.comando.ComandoReserva;
import com.ceiba.cinemax.aplicacion.comando.fabrica.FabricaReserva;
import com.ceiba.cinemax.dominio.modelo.Reserva;
import com.ceiba.cinemax.dominio.servicio.reserva.ServicioCrearReserva;
import org.springframework.stereotype.Component;

@Component
public class ManejadorCrearReserva {

    private ServicioCrearReserva servicioCrearReserva;
    private FabricaReserva fabricaReserva;

    public ManejadorCrearReserva(ServicioCrearReserva servicioCrearReserva, FabricaReserva fabricaReserva) {
        this.servicioCrearReserva = servicioCrearReserva;
        this.fabricaReserva = fabricaReserva;
    }

    public void ejecutar(ComandoReserva comandoReserva){
        Reserva reserva = this.fabricaReserva.crear(comandoReserva);
        servicioCrearReserva.ejecutar(reserva);
    }

}
