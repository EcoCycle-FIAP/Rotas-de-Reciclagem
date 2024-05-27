package br.com.fiap.rotasdereciclagem.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;

import java.sql.Date;

public record AgendamentoCadastroDTO(

        Long idAgendamento,

        @NotNull
        @Pattern(regexp = "\\d{4}-\\d{2}-\\d{2}", message = "A data deve estar no formato yyyy-MM-dd")
        Date data,

        @NotBlank
        String tipoResiduo,

        @Positive
        Long quantidaeLitros,

        Long idCaminhao,

        Long idMorador
) {
}
