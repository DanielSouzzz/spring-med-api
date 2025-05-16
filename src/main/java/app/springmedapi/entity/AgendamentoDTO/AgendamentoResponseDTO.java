package app.springmedapi.entity.AgendamentoDTO;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record AgendamentoResponseDTO(
        Long id,
        @NotNull
        @Future
        LocalDateTime data,
        @NotNull
        Long idMedico,
        @NotNull
        Long idPaciente,
        @NotNull
        String especialidade
) {
}
