package br.com.fiap.rotasdereciclagem.dto;

import br.com.fiap.rotasdereciclagem.model.Morador;

public record MoradorExibicaoDTO(
        Long idMorador,
        String nome,
        String endereco,
        Long endNumero,
        String endComplemento,
        String endBairro,
        String email,
        String telefone
){
    public MoradorExibicaoDTO(Morador morador) {
        this(
                morador.getIdMorador(),
                morador.getNome(),
                morador.getEndereco(),
                morador.getEndNumero(),
                morador.getEndComplemento(),
                morador.getEndBairro(),
                morador.getEmail(),
                morador.getTelefone()
        );
    }
}

