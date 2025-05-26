package app.springmedapi.entity.AgendamentoDTO;

import app.springmedapi.enums.Especialidade;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record AgendamentoRequestDTO(
        @NotNull
        @Future
        LocalDateTime data,
        Long idMedico,
        @NotNull
        Long idPaciente,
        Especialidade especialidade
) {
}
