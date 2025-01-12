package app.springmedapi.entity.pacienteDTO;

import app.springmedapi.entity.medicoDTO.EnderecoDTO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record CadastrarPacienteDTO(
        @NotBlank(message = "O nome é obrigatório.")
        String nome,
        @NotBlank(message = "O email é obrigatório.")
        String email,
        @NotBlank(message = "O telefone é obrigatório.")
        @Pattern(regexp = "\\+?\\d{0,3}\\s?\\(?\\d{2,3}\\)?\\s?\\d{4,5}-?\\d{4}", message = "O telefone deve seguir um formato válido, ex: +55 (11) 91234-5678.")
        String telefone,
        @Pattern(regexp = "\\d{11}", message = "O CPF deve conter exatamente 11 dígitos.")
        String cpf,
        @Valid
        EnderecoDTO endereco
) {
}
