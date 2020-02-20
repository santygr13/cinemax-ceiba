package com.ceiba.cinemax.aplicacion.comando.fabrica;

import com.ceiba.cinemax.aplicacion.comando.ComandoReserva;
import com.ceiba.cinemax.dominio.modelo.Reserva;
import org.springframework.stereotype.Component;



@Component
public class FabricaReserva {



    public Reserva crear(ComandoReserva comandoReserva){
        return new Reserva(comandoReserva.getIdReserva(),comandoReserva.getFechaReservaPelicula(),comandoReserva.getDocumentoCliente(),
                comandoReserva.getNombreCliente(),comandoReserva.getCantidadPuestos()
                ,comandoReserva.getNombrePelicula(),comandoReserva.getFactura());
    }



}
