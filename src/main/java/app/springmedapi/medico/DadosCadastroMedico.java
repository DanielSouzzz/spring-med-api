package app.springmedapi.medico;

import app.springmedapi.endereco.DadosEndereco;

public record DadosCadastroMedico(String nome, String email, String telefone, String crm,
                                  Especialidade especialidade, DadosEndereco endereco) {
}
