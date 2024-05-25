package br.com.fiap.rotasdereciclagem.dto;

import java.sql.Date;

import br.com.fiap.rotasdereciclagem.model.Agendamento;

public record AgendamentoExibicaoDTO(
        Long idAgendamento,
        Date data,
        String tipoResiduo,
        Long quantidaeLitros,
        Long idCaminhao,
        Long idMorador) {
    public AgendamentoExibicaoDTO(Agendamento agendamento) {
        this(
                agendamento.getIdAgendamento(),
                agendamento.getData(),
                agendamento.getTipoResiduo(),
                agendamento.getQuantidaeLitros(),
                agendamento.getIdCaminhao(),
                agendamento.getIdMorador()
        );
    }
}
