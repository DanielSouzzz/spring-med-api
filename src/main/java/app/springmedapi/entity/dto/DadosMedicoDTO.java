package app.springmedapi.entity.dto;

import app.springmedapi.enums.Especialidade;

public record DadosMedicoDTO(String nome, String email, String telefone, String crm,
                                  Especialidade especialidade, EnderecoDTO endereco) {
}
