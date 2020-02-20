package com.ceiba.cinemax.infraestructura.controlador;

import com.ceiba.cinemax.CinemaxApplication;
import com.ceiba.cinemax.aplicacion.comando.ComandoSalaCine;
import com.ceiba.cinemax.dominio.modelo.SalaCine;
import com.ceiba.cinemax.infraestructura.adaptador.repositorio.RepositorioSalaCinePostgreSql;
import com.ceiba.cinemax.infraestructura.repositoriojpa.RepositorioSalaCineJpa;
import com.ceiba.cinemax.testdatabuilder.aplicacion.ComandoSalaCineTestDataBuilder;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;
import java.util.ArrayList;
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
    private RepositorioSalaCineJpa repositorioSalaCineJpa;

    @Autowired
    private MockMvc mockMvc;


    @Test
    public void crearSalaCine() throws Exception{
        ComandoSalaCine comandoSalaCine= new ComandoSalaCineTestDataBuilder().build();

        mockMvc.perform(post("http://localhost:8080/salacine")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(comandoSalaCine))
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void listarSalaCineList()throws Exception{
        RepositorioSalaCinePostgreSql repositorioSalaCinePostgreSql = new RepositorioSalaCinePostgreSql(repositorioSalaCineJpa);

        SalaCine primeraSalaCine= new SalaCine("123453",200,true);
        repositorioSalaCinePostgreSql.guardar(primeraSalaCine);


        ArrayList<SalaCine> salaCines = new ArrayList<>();
        salaCines.add(primeraSalaCine);

        mockMvc.perform(get("http://localhost:8080/salacine")
                .contentType(MediaType.APPLICATION_JSON)
        )
                .andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("[0].numeroSalaCine").value("123453"))
                .andExpect(jsonPath("[0].capacidadSillas").value(200))
                .andExpect(jsonPath("[0].estadoSalaCine").value(true));

    }



}
