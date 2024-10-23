package app.springmedapi.entity.dto;

import app.springmedapi.enums.Especialidade;

public record ListagemMedicoDTO(String nome, String email, String crm, Especialidade especialidade) {
}
