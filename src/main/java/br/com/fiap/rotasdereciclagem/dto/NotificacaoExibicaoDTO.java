package br.com.fiap.rotasdereciclagem.dto;

import java.sql.Date;

import br.com.fiap.rotasdereciclagem.model.Notificacao;

public record NotificacaoExibicaoDTO(
        Long idNotificacao,
        String mensagem,
        Date dataEnvio,
        String status,
        Long idMorador) {
    public NotificacaoExibicaoDTO(Notificacao notificacao) {
        this(
                notificacao.getIdNotificacao(),
                notificacao.getMensagem(),
                notificacao.getDataEnvio(),
                notificacao.getStatus(),
                notificacao.getIdMorador());
    }
}
