package br.com.fiap.rotasdereciclagem.dto;

import java.sql.Date;

import br.com.fiap.rotasdereciclagem.model.Rota;

public record RotaExibicaoDTO(
        Long idRota,
        String pontosDeColeta,
        Date horarioInicial,
        Date horarioFinal,
        Long idCaminhao) {
    public RotaExibicaoDTO(Rota rota) {
        this(
                rota.getIdRota(),
                rota.getPontosDeColeta(),
                rota.getHorarioInicial(),
                rota.getHorarioFinal(),
                rota.getIdCaminhao());
    }
}
