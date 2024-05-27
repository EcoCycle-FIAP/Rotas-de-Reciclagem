package br.com.fiap.rotasdereciclagem.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class CaminhaoNaoEncontradoException extends RuntimeException {

    public CaminhaoNaoEncontradoException(String mensagem) {
        super(mensagem);
    }

}
