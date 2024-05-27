package br.com.fiap.rotasdereciclagem.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class GerarTokenException extends RuntimeException {

    public GerarTokenException(String mensagem) {
        super(mensagem);
    }

}
