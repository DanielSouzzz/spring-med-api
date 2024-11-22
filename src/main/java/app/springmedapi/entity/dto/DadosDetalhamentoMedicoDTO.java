package app.springmedapi.entity.dto;

public record DadosDetalhamentoMedicoDTO(Long id, String nome, String email, String crm, String telefone,
                                         String especialidade, EnderecoDTO endereco) {
}
