package br.com.fiap.rotasdereciclagem.controller;

import br.com.fiap.rotasdereciclagem.config.security.TokenService;
import br.com.fiap.rotasdereciclagem.dto.LoginDTO;
import br.com.fiap.rotasdereciclagem.dto.TokenDTO;
import br.com.fiap.rotasdereciclagem.dto.MoradorCadastroDTO;
import br.com.fiap.rotasdereciclagem.dto.MoradorExibicaoDTO;
import br.com.fiap.rotasdereciclagem.model.Morador;
import br.com.fiap.rotasdereciclagem.service.MoradorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private MoradorService moradorService;


    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid LoginDTO moradorDto){

        UsernamePasswordAuthenticationToken usernamePassword =
                new UsernamePasswordAuthenticationToken(
                        moradorDto.email(),
                        moradorDto.senha());

        Authentication auth = authenticationManager.authenticate(usernamePassword);

        System.out.println(auth.getPrincipal());

        String token = tokenService.gerarToken((Morador) auth.getPrincipal());

        return ResponseEntity.ok(new TokenDTO(token));
    }

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public MoradorExibicaoDTO registrar(@RequestBody @Valid MoradorCadastroDTO moradorDTO){

        MoradorExibicaoDTO moradorSalvo = null;
        moradorSalvo = moradorService.gravar(moradorDTO);

        return moradorSalvo;

    }
}
