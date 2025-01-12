package app.springmedapi.entity.medicoDTO;

import app.springmedapi.enums.Especialidade;

public record ListarMedicoDTO(Long id, String nome, String email, String crm, Especialidade especialidade) {
}
