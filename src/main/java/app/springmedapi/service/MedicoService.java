package app.springmedapi.service;

import app.springmedapi.entity.Endereco;
import app.springmedapi.entity.Medico;
import app.springmedapi.entity.dto.AtualizarMeditoDTO;
import app.springmedapi.entity.dto.ListarMedicoDTO;
import app.springmedapi.entity.dto.CadastrarMedicoDTO;
import app.springmedapi.mapper.EnderecoMapper;
import app.springmedapi.mapper.MedicoMapper;
import app.springmedapi.repository.MedicoRepository;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class MedicoService {
    private final MedicoRepository medicoRepository;
    private final MedicoMapper medicoMapper;
    private final EnderecoMapper enderecoMapper;

    public MedicoService(MedicoRepository medicoRepository, MedicoMapper medicoMapper, EnderecoMapper enderecoMapper) {
        this.medicoRepository = medicoRepository;
        this.medicoMapper = medicoMapper;
        this.enderecoMapper = enderecoMapper;
    }

    @Transactional
    public CadastrarMedicoDTO createDoctor(CadastrarMedicoDTO medicoDTO){
    Medico medico = medicoMapper.toMedico(medicoDTO);
    medico = medicoRepository.save(medico);

    return medicoMapper.toMedicoDTO(medico);
    }

    public Page<ListarMedicoDTO> listarMedicos(Pageable pageable) {
        Page<Medico> medicos = medicoRepository.findAll(pageable);
        return medicos.map(medicoMapper::toListagemMedicoDTO);
    }
    @Transactional
    public AtualizarMeditoDTO atualizarMedico(AtualizarMeditoDTO atualizaMeditoDTO){
        if (atualizaMeditoDTO.id() == null){
            throw new IllegalArgumentException("Id do médico não pode ser nulo");
        }
        Medico medico = medicoRepository.findById(atualizaMeditoDTO.id())
                .orElseThrow(() -> new IllegalArgumentException("Médico não encontrado"));
        if (atualizaMeditoDTO.nome() != null){
            medico.setNome(atualizaMeditoDTO.nome());
        }
        if (atualizaMeditoDTO.telefone() != null) {
            medico.setTelefone(atualizaMeditoDTO.telefone());
        }
        if (atualizaMeditoDTO.endereco() != null){
            Endereco enderecoExistente = medico.getEndereco();

            if (enderecoExistente != null){
                if (atualizaMeditoDTO.endereco().logradouro() != null){
                    enderecoExistente.setLogradouro(atualizaMeditoDTO.endereco().logradouro());
                }
                if (atualizaMeditoDTO.endereco().numero() != 0){
                    enderecoExistente.setNumero(atualizaMeditoDTO.endereco().numero());
                }
                if (atualizaMeditoDTO.endereco().complemento() != null){
                    enderecoExistente.setComplemento(atualizaMeditoDTO.endereco().complemento());
                }
                if (atualizaMeditoDTO.endereco().bairro() != null){
                    enderecoExistente.setBairro(atualizaMeditoDTO.endereco().bairro());
                }
                if (atualizaMeditoDTO.endereco().cidade() != null){
                    enderecoExistente.setCidade(atualizaMeditoDTO.endereco().cidade());
                }
                if (atualizaMeditoDTO.endereco().uf() != null){
                    enderecoExistente.setUf(atualizaMeditoDTO.endereco().uf());
                }
                if (atualizaMeditoDTO.endereco().cep() != null){
                    enderecoExistente.setCep(atualizaMeditoDTO.endereco().cep());
                }else {
                    throw new IllegalArgumentException("Endereço nulo ou nao encontrado");
                }
            }
        }
        medico = medicoRepository.save(medico);
        return medicoMapper.toAtualizarMedicoDTO(medico);
    }
}

