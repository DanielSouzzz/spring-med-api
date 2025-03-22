package app.springmedapi.entity.AgendamentoDTO;

import app.springmedapi.enums.Especialidade;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;

public record AgendamentoRequestDTO(
        @NotNull
        @Future
        String data,
        @NotNull
        Long idMedico,
        @NotNull
        Long idPaciente,
        @NotNull
        Especialidade especialidade
) {
}
