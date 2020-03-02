package com.ceiba.cinemax.infraestructura.controlador;

import com.ceiba.cinemax.aplicacion.comando.ComandoReserva;

import com.ceiba.cinemax.aplicacion.comando.manejador.reserva.ManejadorCrearReserva;
import com.ceiba.cinemax.aplicacion.consulta.manejador.reserva.ManejadorListarReservas;
import com.ceiba.cinemax.dominio.modelo.dto.ReservaDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value ="/reserva")
public class ControladorReserva {

    private ManejadorCrearReserva manejadorCrearReserva;
    private ManejadorListarReservas manejadorListarReservas;

    public ControladorReserva(ManejadorCrearReserva manejadorCrearReserva, ManejadorListarReservas manejadorListarReservas) {
        this.manejadorCrearReserva = manejadorCrearReserva;
        this.manejadorListarReservas = manejadorListarReservas;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void guardarReserva(@RequestBody ComandoReserva comandoReserva){
        manejadorCrearReserva.ejecutar(comandoReserva);
    }


    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ReservaDto> listarReserva(){
        return this.manejadorListarReservas.ejecutar();
    }



}
