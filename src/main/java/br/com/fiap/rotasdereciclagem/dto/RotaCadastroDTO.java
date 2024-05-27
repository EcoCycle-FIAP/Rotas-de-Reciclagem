package br.com.fiap.rotasdereciclagem.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import java.sql.Date;

public record RotaCadastroDTO(

        Long idRota,

        @NotBlank
        String pontosDeColeta,

        @NotNull
        @Pattern(regexp = "^\\d{2}:\\d{2}$", message = "O formato do horário deve ser HH:mm")
        Date horarioInicial,

        @NotNull
        @Pattern(regexp = "^\\d{2}:\\d{2}$", message = "O formato do horário deve ser HH:mm")
        Date horarioFinal,

        Long idCaminhao) {
}
