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
@Table(name ="factura")
public class FacturaEntidad {

    private static final String ESTE_CAMPO_ES_OBLIGATORIO="El campo es obligatorio";

    @Id
    @GeneratedValue(
            strategy= GenerationType.AUTO,
            generator="native"
    )
    @Column(name = "codigofactura", nullable = false, length = 11)
    private Long idFactura;

    @Column(name = "date_fecha_registro", nullable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-mm-dd")
    private LocalDate fechaReserva;

    @Column(name = "int_valor_pagar", nullable = false)
    private int valor;


    public FacturaEntidad(LocalDate fechaReserva, int valor) {
        ValidadorArgumento.validarCampoObligatorio(valor,ESTE_CAMPO_ES_OBLIGATORIO);
        ValidadorArgumento.validarCampoObligatorio(fechaReserva,ESTE_CAMPO_ES_OBLIGATORIO);
        this.fechaReserva = fechaReserva;
        this.valor = valor;
    }

    public FacturaEntidad(){}
}
