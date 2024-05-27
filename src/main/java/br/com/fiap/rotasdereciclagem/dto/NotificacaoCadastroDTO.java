package br.com.fiap.rotasdereciclagem.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.sql.Date;

public record NotificacaoCadastroDTO(

        Long idNotificacao,

        @NotBlank(message = "A mensagem da notificação não pode estar em branco")
        String mensagem,

        @NotNull(message = "A data de envio da notificação não pode ser nula")
        Date dataEnvio,

        String status,

        @NotNull(message = "O ID do morador associado à notificação não pode ser nulo")
        Long idMorador){
}
