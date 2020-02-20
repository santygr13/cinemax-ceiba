package com.ceiba.cinemax.testdatabuilder.dominio.modelo;

import com.ceiba.cinemax.dominio.modelo.Factura;
import com.ceiba.cinemax.dominio.modelo.Pelicula;
import com.ceiba.cinemax.dominio.modelo.Reserva;
import com.ceiba.cinemax.dominio.modelo.SalaCine;

import java.time.LocalDate;

public class ReservaTestDataBuilder {

    private static final Long ID_RESERVA=1L;
    private static final  LocalDate FECHA_RESERVA_PELICULA = LocalDate.of(2020,02,28);
    private static final int CANTIDAD_PUESTOS=3;
    private static final int DOCUMENTO_CLIENTE=1037854939;
    private static final String NOMBRE_CLIENTE="Santiago";
    private static final String PELICULA= "Transformers";
    private static final Factura FACTURA= new Factura( LocalDate.of(2020,02,27),49000);


    private Long idReserva;
    private LocalDate fechaReservaPelicula;
    private int cantidadPuestos;
    private int documentoCliente;
    private String nombreCliente;
    private String nombrePelicula;
    private Factura factura;

    public ReservaTestDataBuilder() {
        this.idReserva=ID_RESERVA;
        this.fechaReservaPelicula=FECHA_RESERVA_PELICULA;
        this.cantidadPuestos=CANTIDAD_PUESTOS;
        this.documentoCliente=DOCUMENTO_CLIENTE;
        this.nombreCliente=NOMBRE_CLIENTE;
        this.nombrePelicula=PELICULA;
        this.factura=FACTURA;

    }

    public ReservaTestDataBuilder conIdReserva(Long id){
        this.idReserva=id;
        return this;
    }

    public ReservaTestDataBuilder conFechaReservaPelicula(LocalDate fechaReserva){
        this.fechaReservaPelicula=fechaReserva;
        return this;
    }

    public ReservaTestDataBuilder conCantidadPuestos(int puestos){
        this.cantidadPuestos=puestos;
        return this;
    }

    public ReservaTestDataBuilder conDocumentoCliente(int documento){
        this.documentoCliente=documento;
        return this;
    }

    public ReservaTestDataBuilder conNombreCliente(String nombre){
        this.nombreCliente=nombre;
        return this;
    }

    public ReservaTestDataBuilder conPelicula(String pelicula){
        this.nombrePelicula=nombrePelicula;
        return this;
    }

    public ReservaTestDataBuilder conFactura(Factura factura){
        this.factura=factura;
        return this;
    }

    public Reserva build(){
        return new Reserva(this.idReserva,this.fechaReservaPelicula,this.documentoCliente,this.nombreCliente,this.cantidadPuestos,this.nombrePelicula,this.factura);
    }
}
