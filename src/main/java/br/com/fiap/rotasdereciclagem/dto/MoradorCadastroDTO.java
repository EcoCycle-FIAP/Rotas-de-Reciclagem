package br.com.fiap.rotasdereciclagem.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record MoradorCadastroDTO(

        Long idMorador,

        @NotBlank(message = "O nome do usuário é obrigatório!")
        String nome,

        @NotBlank(message = "O endereço do morador é obrigatório!")
        String endereco,

        @NotBlank(message = "O número da residência do morador é obrigatório!")
        Long endNumero,
        String endComplemento,

        @NotBlank(message = "O bairro do morador é obrigatório!")
        String endBairro,

        @NotBlank(message = "O e-mail do morador é obrigatório!")
        @Email(message = "O e-mail do morador não é válido!")
        String email,

        @NotBlank(message = "O telefone do morador é obrigatório!")
        String telefone,

        @Size(min = 6, max = 20, message = "A senha deve conter entre 6 e 20 caracteres!")
        String senha
) {
}
