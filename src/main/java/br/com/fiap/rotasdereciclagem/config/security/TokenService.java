package br.com.fiap.rotasdereciclagem.config.security;

import br.com.fiap.rotasdereciclagem.exception.GerarTokenException;
import br.com.fiap.rotasdereciclagem.model.Morador;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {

    @Value("${JWT.SECRET:reciclagem")
    private String palavraSecreta;

    public String gerarToken (Morador morador){

        try {
            Algorithm algorithm = Algorithm.HMAC256(palavraSecreta);

            String token = JWT.create()
                    .withIssuer("morador")
                    .withSubject(morador.getEmail())
                    .withExpiresAt(gerarDataDeExpiracao())
                    .sign(algorithm);

            return token;
        } catch (JWTCreationException e){
            throw new GerarTokenException("Não foi possível gerar o token!");
        }

    }

    private Instant gerarDataDeExpiracao(){
        return LocalDateTime
                .now()
                .plusHours(2)
                .toInstant(ZoneOffset.of("-03:00"));
    }

    public String validarToken (String token){

        try {
            Algorithm algorithm = Algorithm.HMAC256(palavraSecreta);

            return JWT.require(algorithm)
                    .withIssuer("morador")
                    .build()
                    .verify(token)
                    .getSubject();

        }catch (JWTVerificationException e){
            return "";
        }
    }

}
