package app.springmedapi.entity.medicoDTO;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record AtualizarMeditoDTO(
        @NotNull
        Long id,
        @NotBlank(message = "O nome é obrigatório")
        String nome,
        @NotBlank(message = "O telefone é obrigatório")
        String telefone,
        @NotNull(message = "O endereço é obrigatório")
        @Valid
        EnderecoDTO endereco) {
}
