package com.ceiba.cinemax.infraestructura.entidad;
import com.ceiba.cinemax.dominio.validador.ValidadorArgumento;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@Table(name = "reserva")
public class ReservaEntidad {

    private static final String ESTE_CAMPO_ES_OBLIGATORIO="El campo es obligatorio";
    private static final String ERROR_FECHA_RESERVA="La fecha de reserva no es valida";

    @Id
    @GeneratedValue(
            strategy= GenerationType.AUTO,
            generator="native"
    )
    @Column(name = "codigo_reserva", nullable = false, length = 11)
    private Long idReserva;

    @Column(name = "nombre_pelicula", nullable = false, length = 100)
    private String nombrePelicula;

    @Column(name = "fecha_reserva", nullable = false , length = 20)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-mm-dd")
    private LocalDate fechaReservaPelicula;

    @Column(name = "Cantidad_Puestos", nullable=false, length =3)
    private int cantidadPuestos;

    @Column(name = "id_cliente", nullable =false,length = 11)
    private int documentoCliente;

    @Column(name = "nombre_cliente",nullable=false,length = 100)
    private String nombreCliente;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "codigofactura" )
    private FacturaEntidad facturaEntidad;

    public ReservaEntidad(Long idReserva, String nombrePelicula, LocalDate fechaReservaPelicula, int cantidadPuestos, int documentoCliente, String nombreCliente, FacturaEntidad facturaEntidad) {


        ValidadorArgumento.validarCampoObligatorio(fechaReservaPelicula,ESTE_CAMPO_ES_OBLIGATORIO);
        ValidadorArgumento.validarCampoObligatorio(cantidadPuestos,ESTE_CAMPO_ES_OBLIGATORIO);
        ValidadorArgumento.validarCampoObligatorio(documentoCliente,ESTE_CAMPO_ES_OBLIGATORIO);
        ValidadorArgumento.validarCampoObligatorio(nombreCliente,ESTE_CAMPO_ES_OBLIGATORIO);
        ValidadorArgumento.validadorFechaValida(fechaReservaPelicula,ERROR_FECHA_RESERVA);
        this.idReserva = idReserva;
        this.nombrePelicula = nombrePelicula;
        this.fechaReservaPelicula = fechaReservaPelicula;
        this.cantidadPuestos = cantidadPuestos;
        this.documentoCliente = documentoCliente;
        this.nombreCliente = nombreCliente;
        this.facturaEntidad = facturaEntidad;
    }

    public ReservaEntidad(){}

}
