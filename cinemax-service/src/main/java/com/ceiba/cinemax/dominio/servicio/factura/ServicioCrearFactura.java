package com.ceiba.cinemax.dominio.servicio.factura;

import com.ceiba.cinemax.dominio.modelo.Factura;
import com.ceiba.cinemax.dominio.modelo.Reserva;
import com.ceiba.cinemax.dominio.servicio.reserva.ServicioDescuentoPagarReserva;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public  class ServicioCrearFactura {

    private  ServicioDescuentoPagarReserva servicioDescuentoPagarReserva;

    public  ServicioCrearFactura(ServicioDescuentoPagarReserva servicioDescuentoPagarReserva) {
        this.servicioDescuentoPagarReserva=servicioDescuentoPagarReserva;
    }

    public  Factura construirFactura(Reserva reserva){
        return new Factura(LocalDate.now(),servicioDescuentoPagarReserva.valorReserva(reserva.getCantidadPuestos(),reserva.getFechaReservaPelicula()));
    }



}
