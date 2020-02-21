package com.ceiba.cinemax.infraestructura.controlador;

import com.ceiba.cinemax.aplicacion.comando.ComandoSalaCine;

import com.ceiba.cinemax.aplicacion.comando.manejador.salacine.ManejadorCrearSalaCine;
import com.ceiba.cinemax.aplicacion.consulta.manejador.salacine.ManejadorListarSalaCine;
import com.ceiba.cinemax.dominio.modelo.dto.SalaCineDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestClientResponseException;

import java.util.List;

@RestController
@RequestMapping(value ="/salacine")
public class ControladorSalaCine {

    private final ManejadorCrearSalaCine manejadorCrearSalaCine;
    private final ManejadorListarSalaCine manejadorListarSalaCine;

    public ControladorSalaCine(ManejadorCrearSalaCine manejadorCrearSalaCine, ManejadorListarSalaCine manejadorListarSalaCine) {
        this.manejadorCrearSalaCine = manejadorCrearSalaCine;
        this.manejadorListarSalaCine = manejadorListarSalaCine;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void guardarSalaCine(@RequestBody ComandoSalaCine comandoSalaCine){
        manejadorCrearSalaCine.ejecutar(comandoSalaCine);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<SalaCineDto> listarSalaCine(){
        return this.manejadorListarSalaCine.ejecutar();
    }

}
