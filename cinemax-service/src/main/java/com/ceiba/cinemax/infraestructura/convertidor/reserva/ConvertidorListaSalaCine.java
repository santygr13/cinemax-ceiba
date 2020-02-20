package com.ceiba.cinemax.infraestructura.convertidor.reserva;

import com.ceiba.cinemax.dominio.modelo.dto.SalaCineDto;

import com.ceiba.cinemax.infraestructura.entidad.SalaCineEntidad;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class ConvertidorListaSalaCine {

    private ModelMapper modelMapper = new ModelMapper();

    public List<SalaCineDto> convertirListSalaCineEntidadAListSalaCine(List<SalaCineEntidad> listSalaCineEntidad, List<SalaCineDto> listSalaCine){
        for (SalaCineEntidad salaCineEntidad: listSalaCineEntidad){
            SalaCineDto reserva=modelMapper.map(salaCineEntidad, SalaCineDto.class);
            listSalaCine.add(reserva);
        }
        return listSalaCine;
    }

}
