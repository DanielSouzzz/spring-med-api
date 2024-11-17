package app.springmedapi.entity.dto;

import app.springmedapi.enums.Especialidade;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record CadastrarMedicoDTO(
        @NotBlank(message = "O nome é obrigatório.")
        String nome,
        @Email(message = "O email deve ser válido.")
        @NotBlank(message = "O email é obrigatório.")
        String email,
        @NotBlank(message = "O telefone é obrigatório.")
        @Pattern(regexp = "\\+?\\d{0,3}\\s?\\(?\\d{2,3}\\)?\\s?\\d{4,5}-?\\d{4}", message = "O telefone deve seguir um formato válido, ex: +55 (11) 91234-5678.")
        String telefone,
        @NotBlank(message = "O CRM é obrigatório.")
        @Pattern(regexp = "\\d{4,6}", message = "O CRM deve conter entre 4 e 6 dígitos.")
        String crm,
        @NotNull(message = "A especialidade é obrigatória.")
        Especialidade especialidade,
        Boolean ativo,
        @NotNull(message = "O endereço é obrigatório.")
        @Valid
        EnderecoDTO endereco) {
}
