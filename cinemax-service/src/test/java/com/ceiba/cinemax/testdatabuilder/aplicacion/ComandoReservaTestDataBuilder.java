package com.ceiba.cinemax.testdatabuilder.aplicacion;

import com.ceiba.cinemax.aplicacion.comando.ComandoReserva;
import com.ceiba.cinemax.dominio.modelo.Factura;


import java.time.LocalDate;

public class ComandoReservaTestDataBuilder {

    private static final Long ID_RESERVA=1L;
    private static final LocalDate FECHA_RESERVA_PELICULA = LocalDate.of(2020,03,28);
    private static final int CANTIDAD_PUESTOS=3;
    private static final int DOCUMENTO_CLIENTE=1037854939;
    private static final String NOMBRE_CLIENTE="Santiago";
    private static final String PELICULA= "Transformers";
    private static final Factura FACTURA= new Factura(LocalDate.of(2020,03,28),21000);



    private Long idReserva;
    private LocalDate fechaReservaPelicula;
    private int cantidadPuestos;
    private int documentoCliente;
    private String nombreCliente;
    private String nombrePelicula;
    private Factura factura;

    public ComandoReservaTestDataBuilder() {
        this.idReserva=ID_RESERVA;
        this.fechaReservaPelicula=FECHA_RESERVA_PELICULA;
        this.cantidadPuestos=CANTIDAD_PUESTOS;
        this.documentoCliente=DOCUMENTO_CLIENTE;
        this.nombreCliente=NOMBRE_CLIENTE;
        this.nombrePelicula=PELICULA;
        this.factura=FACTURA;

    }

    public ComandoReservaTestDataBuilder conIdReserva(Long id){
        this.idReserva=id;
        return this;
    }

    public ComandoReservaTestDataBuilder conFechaReservaPelicula(LocalDate fechaReserva){
        this.fechaReservaPelicula=fechaReserva;
        return this;
    }

    public ComandoReservaTestDataBuilder conCantidadPuestos(int puestos){
        this.cantidadPuestos=puestos;
        return this;
    }

    public ComandoReservaTestDataBuilder conDocumentoCliente(int documento){
        this.documentoCliente=documento;
        return this;
    }

    public ComandoReservaTestDataBuilder conNombreCliente(String nombre){
        this.nombreCliente=nombre;
        return this;
    }

    public ComandoReservaTestDataBuilder conPelicula(String nombrePelicula){
        this.nombrePelicula=nombrePelicula;
        return this;
    }

    public ComandoReservaTestDataBuilder conFactura(Factura factura){
        this.factura=factura;
        return this;
    }

    public ComandoReserva build(){
        return new ComandoReserva(this.idReserva,this.fechaReservaPelicula,this.cantidadPuestos,this.documentoCliente,this.nombreCliente,this.nombrePelicula,this.factura);
    }
}
