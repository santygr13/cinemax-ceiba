package com.ceiba.cinemax.dominio.servicio.reserva;

import org.springframework.stereotype.Service;
import java.time.LocalDate;

@Service
public  class ServicioDescuentoPagarReserva {

    private static final int VALOR_ENTRADA_POR_PUESTO= 7000;
    private static final int DIVISOR_OPERACION_PORCENTAJE=2;
    private static final int NUMERO_DIA_SEMANA_MARTES=2;
    private static final int NUMERO_DIA_SEMANA_MIERCOLES=3;
    private static final int NUMERO_DIA_SEMANA_DOMINGO=7;
    private static final int INCREMENTO_DIA_DOMINGO=200;
    private static final int NUMERO_DIA_SEMANA_LUNES=1;
    private static final int NUMERO_PORCENTAJE=100;
    private static final String NO_HAY_SERVICIO="Los dias lunes no hay servicio";

    public ServicioDescuentoPagarReserva() {
           //Permite adapatar datos a una salida especifica
    }

        public  int valorReserva(int cantidadPuestos , LocalDate fechaReservaPelicula){
        int valorPagarReserva=0;
        if (fechaReservaPelicula.getDayOfWeek().getValue()==NUMERO_DIA_SEMANA_MARTES || fechaReservaPelicula.getDayOfWeek().getValue()==NUMERO_DIA_SEMANA_MIERCOLES){
            valorPagarReserva= ((cantidadPuestos*VALOR_ENTRADA_POR_PUESTO)/DIVISOR_OPERACION_PORCENTAJE);
        }else if(fechaReservaPelicula.getDayOfWeek().getValue()==NUMERO_DIA_SEMANA_DOMINGO){
            valorPagarReserva=  (cantidadPuestos*VALOR_ENTRADA_POR_PUESTO) ;
            valorPagarReserva=  (valorPagarReserva*INCREMENTO_DIA_DOMINGO)/NUMERO_PORCENTAJE;
        }else if(fechaReservaPelicula.getDayOfWeek().getValue()==NUMERO_DIA_SEMANA_LUNES){
            valorPagarReserva=Integer.parseInt(NO_HAY_SERVICIO);

        }else{
            valorPagarReserva=cantidadPuestos*VALOR_ENTRADA_POR_PUESTO;
        }
        return valorPagarReserva;
    }


}
