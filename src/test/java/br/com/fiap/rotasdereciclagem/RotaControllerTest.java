package br.com.fiap.rotasdereciclagem;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class RotaControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testListarTodos() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/reciclagem/rotas"))
                .andExpect(status().isOk());
    }

    @Test
    public void testGravar() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/reciclagem/rotas")
                .contentType("application/json")
                .content("{\"nome\":\"Rota 1\", \"pontosColeta\":\"Ponto A, Ponto B\"}"))
                .andExpect(status().isCreated());
    }
}
