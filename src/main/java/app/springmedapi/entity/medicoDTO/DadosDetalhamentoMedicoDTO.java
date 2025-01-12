package app.springmedapi.entity.medicoDTO;

public record DadosDetalhamentoMedicoDTO(Long id, String nome, String email, String crm, String telefone,
                                         String especialidade, EnderecoDTO endereco) {
}
