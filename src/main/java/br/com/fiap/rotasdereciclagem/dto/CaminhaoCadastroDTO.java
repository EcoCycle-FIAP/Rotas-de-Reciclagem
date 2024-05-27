package br.com.fiap.rotasdereciclagem.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;

public record CaminhaoCadastroDTO(

        Long idCaminhao,

        @NotBlank()
        String motorista,

        @NotBlank(message = "Modelo do caminhão é necessário")
        String modelo,

        @NotBlank(message = "Placa do caminhão necessária")
        @Pattern(regexp = "[A-Z]{3}\\\\d[A-Z]\\\\d{2}", message = "Formato de placa inválido, deve seguir o padrão ABC1A21")
        String placa,

        @Positive
        Long capacidadeLitros
) {
}
