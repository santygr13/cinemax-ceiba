package com.ceiba.cinemax.aplicacion.comando;

import com.ceiba.cinemax.dominio.modelo.Factura;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoReserva {

    private Long idReserva;
    private LocalDate fechaReservaPelicula;
    private int cantidadPuestos;
    private int documentoCliente;
    private String nombreCliente;
    private String nombrePelicula;
    private Factura factura;



}
