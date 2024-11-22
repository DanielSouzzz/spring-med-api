package app.springmedapi.entity.dto;

import app.springmedapi.entity.Medico;

public record DadosDetalhamentoMedicoDTO(Long id, String nome, String email, String crm, String telefone,
                                         String especialidade, EnderecoDTO endereco) {

    public DadosDetalhamentoMedicoDTO(Medico medico) {
        this(medico.getId(), medico.getNome(), medico.getEmail(), medico.getCrm(), medico.getTelefone(), medico.getEspecialidade().name(), new EnderecoDTO(
                medico.getEndereco().getLogradouro(),
                medico.getEndereco().getNumero(),
                medico.getEndereco().getComplemento(),
                medico.getEndereco().getBairro(),
                medico.getEndereco().getCidade(),
                medico.getEndereco().getUf(),
                medico.getEndereco().getCep()
        ));
    }
}
