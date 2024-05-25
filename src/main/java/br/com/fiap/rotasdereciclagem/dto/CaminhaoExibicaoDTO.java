package br.com.fiap.rotasdereciclagem.dto;

import br.com.fiap.rotasdereciclagem.model.Caminhao;

public record CaminhaoExibicaoDTO(
        Long idCaminhao,
        String motorista,
        String modelo,
        String placa,
        Long capacidadeLitros
){
    public CaminhaoExibicaoDTO(Caminhao caminhao) {
        this(
                caminhao.getIdCaminhao(),
                caminhao.getMotorista(),
                caminhao.getModelo(),
                caminhao.getPlaca(),
                caminhao.getCapacidadeLitros()
        );
    }
}

