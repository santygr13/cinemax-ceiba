package com.ceiba.cinemax.infraestructura.convertidor.reserva;

import com.ceiba.cinemax.dominio.modelo.dto.FacturaDto;
import com.ceiba.cinemax.dominio.modelo.dto.ReservaDto;
import com.ceiba.cinemax.infraestructura.entidad.ReservaEntidad;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class ConvertidorListaReserva {

    private ModelMapper modelMapper = new ModelMapper();

    public List<ReservaDto> convertirListReservaEntidadAListReserva(List<ReservaEntidad> listReservaEntidad, List<ReservaDto> listReserva){
        for (ReservaEntidad reservaEntidad: listReservaEntidad){
            ReservaDto reserva=modelMapper.map(reservaEntidad, ReservaDto.class);
            FacturaDto facturaDto=modelMapper.map(reservaEntidad.getFacturaEntidad(),FacturaDto.class);
            reserva.setFacturaDto(facturaDto);
            listReserva.add(reserva);
        }
        return listReserva;
    }
}
