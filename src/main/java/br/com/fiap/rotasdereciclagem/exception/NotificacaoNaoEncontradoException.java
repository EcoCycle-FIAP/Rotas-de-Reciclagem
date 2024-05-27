package br.com.fiap.rotasdereciclagem.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class NotificacaoNaoEncontradoException extends RuntimeException {

    public NotificacaoNaoEncontradoException(String mensagem) {
        super(mensagem);
    }

}
