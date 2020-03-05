package com.ceiba.cinemax.infraestructura.controlador;

import com.ceiba.cinemax.CinemaxApplication;
import com.ceiba.cinemax.aplicacion.comando.ComandoSalaCine;
import com.ceiba.cinemax.dominio.modelo.SalaCine;
import com.ceiba.cinemax.dominio.puerto.repositorio.RepositorioSalaCine;
import com.ceiba.cinemax.testdatabuilder.aplicacion.ComandoSalaCineTestDataBuilder;
import com.ceiba.cinemax.testdatabuilder.dominio.modelo.SalaCineTestDataBuilder;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest(classes = CinemaxApplication.class)
@AutoConfigureMockMvc

public class ControladorSalaCineTest {

    @Autowired
    private WebApplicationContext wac;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private RepositorioSalaCine repositorioSalaCine;

    @Autowired
    private MockMvc mockMvc;


    @Test
    public void crearSalaCine() throws Exception{

        ComandoSalaCine comandoSalaCine= new ComandoSalaCineTestDataBuilder().build();

        mockMvc.perform(post("http://localhost:4567/salacine")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(comandoSalaCine))
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }


    @Test
    public void listarSalaCineList()throws Exception{

        SalaCine primeraSalaCine= new SalaCineTestDataBuilder().build();
        repositorioSalaCine.guardar(primeraSalaCine);

        List<SalaCine> salaCines = new ArrayList<>();
        salaCines.add(primeraSalaCine);

        mockMvc.perform(get("http://localhost:4567/salacine")
                .contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(salaCines)))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("[0].numeroSalaCine").value("3"))
                .andExpect(jsonPath("[0].capacidadSillas").value(300))
                .andExpect(jsonPath("[0].estadoSalaCine").value(true));
    }

}
