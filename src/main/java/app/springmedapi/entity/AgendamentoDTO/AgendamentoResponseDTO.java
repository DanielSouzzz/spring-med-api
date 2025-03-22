package app.springmedapi.entity.AgendamentoDTO;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;

public record AgendamentoResponseDTO(
        Long id,
        @NotNull
        @Future
        String data,
        @NotNull
        String medico,
        @NotNull
        String paciente,
        @NotNull
        String especialidade
) {
}
