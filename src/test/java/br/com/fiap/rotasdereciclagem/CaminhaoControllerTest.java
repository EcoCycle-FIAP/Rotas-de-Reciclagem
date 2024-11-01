package br.com.fiap.rotasdereciclagem.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class CaminhaoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testListarTodos() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/reciclagem/caminhoes"))
                .andExpect(status().isOk());
    }

    @Test
    public void testGravar() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/reciclagem/caminhoes")
                .contentType("application/json")
                .content("{\"placa\":\"XYZ-1234\", \"modelo\":\"Modelo X\"}"))
                .andExpect(status().isCreated());
    }
}