package app.springmedapi.entity.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record EnderecoDTO(
        @NotBlank(message = "O logradouro é obrigatório.")
        String logradouro,
        @NotNull(message = "O número é obrigatório.")
        int numero,
        String complemento,
        @NotBlank(message = "O bairro é obrigatório.")
        String bairro,
        @NotBlank(message = "A cidade é obrigatória.")
        String cidade,
        @NotBlank(message = "O estado é obrigatório.")
        String uf,
        @NotBlank(message = "O CEP é obrigatório.")
        String cep) {
}
