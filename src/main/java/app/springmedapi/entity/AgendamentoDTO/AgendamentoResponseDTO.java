package app.springmedapi.entity.AgendamentoDTO;

public record AgendamentoResponseDTO(
        Long id,
        String data,
        String medico,
        String paciente,
        String especialidade
) {
}
