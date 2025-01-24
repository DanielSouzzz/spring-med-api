package app.springmedapi.entity.AgendamentoDTO;

import app.springmedapi.enums.Especialidade;

public record AgendamentoRequestDTO(
        String data,
        Long idMedico,
        Long idPaciente,
        Especialidade especialidade
) {
}
