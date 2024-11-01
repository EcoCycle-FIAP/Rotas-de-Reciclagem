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
public class NotificacaoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testListarTodos() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/reciclagem/notificacoes"))
                .andExpect(status().isOk());
    }

    @Test
    public void testGravar() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/reciclagem/notificacoes")
                .contentType("application/json")
                .content("{\"mensagem\":\"Nova notificação\"}"))
                .andExpect(status().isCreated());
    }
}
