package app.springmedapi.entity.dto;

import app.springmedapi.enums.Especialidade;
import jakarta.validation.constraints.NotNull;

public record AtualizarMeditoDTO(
        @NotNull
        Long id,
        String nome,
        String telefone,
        EnderecoDTO endereco) {
}
