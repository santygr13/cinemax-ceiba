package com.ceiba.cinemax.testdatabuilder.infraestructura.entidad;


import com.ceiba.cinemax.infraestructura.entidad.FacturaEntidad;
import com.ceiba.cinemax.infraestructura.entidad.ReservaEntidad;



import java.time.LocalDate;

public class EntidadReservaTestDataBuilder {

    private static final Long ID_RESERVA=1L;
    private static final LocalDate FECHA_RESERVA_PELICULA = LocalDate.now();
    private static final int CANTIDAD_PUESTOS=3;
    private static final int DOCUMENTO_CLIENTE=1037854939;
    private static final String NOMBRE_CLIENTE="Santiago";
    private static final String PELICULA="Transformers";
    private static final FacturaEntidad FACTURA= new FacturaEntidad(LocalDate.now(),49000);


    private Long idReserva;
    private LocalDate fechaReservaPelicula;
    private int cantidadPuestos;
    private int documentoCliente;
    private String nombreCliente;
    private String nombrePelicula;
    private FacturaEntidad factura;

    public EntidadReservaTestDataBuilder() {
        this.idReserva=ID_RESERVA;
        this.fechaReservaPelicula=FECHA_RESERVA_PELICULA;
        this.cantidadPuestos=CANTIDAD_PUESTOS;
        this.documentoCliente=DOCUMENTO_CLIENTE;
        this.nombreCliente=NOMBRE_CLIENTE;
        this.nombrePelicula=PELICULA;
        this.factura=FACTURA;

    }

    public EntidadReservaTestDataBuilder conIdReserva(Long id){
        this.idReserva=id;
        return this;
    }

    public EntidadReservaTestDataBuilder conFechaReservaPelicula(LocalDate fechaReserva){
        this.fechaReservaPelicula=fechaReserva;
        return this;
    }

    public EntidadReservaTestDataBuilder conCantidadPuestos(int puestos){
        this.cantidadPuestos=puestos;
        return this;
    }

    public EntidadReservaTestDataBuilder conDocumentoCliente(int documento){
        this.documentoCliente=documento;
        return this;
    }

    public EntidadReservaTestDataBuilder conNombreCliente(String nombre){
        this.nombreCliente=nombre;
        return this;
    }

    public EntidadReservaTestDataBuilder conPelicula(String nombrePelicula){
        this.nombrePelicula=nombrePelicula;
        return this;
    }

    public EntidadReservaTestDataBuilder conFactura(FacturaEntidad factura){
        this.factura=factura;
        return this;
    }

    public ReservaEntidad build(){
        return new ReservaEntidad(this.idReserva,this.nombrePelicula,this.fechaReservaPelicula,this.cantidadPuestos,this.documentoCliente,this.nombreCliente,this.factura);
    }
}
