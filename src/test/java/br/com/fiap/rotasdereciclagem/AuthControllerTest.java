package br.com.fiap.rotasdereciclagem.controller;

import br.com.fiap.rotasdereciclagem.dto.LoginDTO;
import br.com.fiap.rotasdereciclagem.dto.MoradorCadastroDTO;
import br.com.fiap.rotasdereciclagem.dto.MoradorExibicaoDTO;
import br.com.fiap.rotasdereciclagem.service.MoradorService;
import br.com.fiap.rotasdereciclagem.config.security.TokenService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.hamcrest.Matchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class AuthControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private MoradorService moradorService;

    @Test
    public void testLogin() throws Exception {
        LoginDTO loginDTO = new LoginDTO("email@test.com", "password");
        mockMvc.perform(MockMvcRequestBuilders.post("/auth/login")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"email\":\"email@test.com\", \"senha\":\"password\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.token").exists());
    }

    @Test
    public void testRegister() throws Exception {
        MoradorCadastroDTO moradorCadastroDTO = new MoradorCadastroDTO("Nome", "email@test.com", "password");
        mockMvc.perform(MockMvcRequestBuilders.post("/auth/register")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"nome\":\"Nome\", \"email\":\"email@test.com\", \"senha\":\"password\"}"))
                .andExpect(status().isCreated());
    }
}
