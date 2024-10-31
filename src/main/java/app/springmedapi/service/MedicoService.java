package app.springmedapi.service;

import app.springmedapi.entity.Medico;
import app.springmedapi.entity.dto.AtualizarMeditoDTO;
import app.springmedapi.entity.dto.ListarMedicoDTO;
import app.springmedapi.entity.dto.CadastrarMedicoDTO;
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

    public MedicoService(MedicoRepository medicoRepository, MedicoMapper medicoMapper) {
        this.medicoRepository = medicoRepository;
        this.medicoMapper = medicoMapper;
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
        medico = medicoRepository.save(medico);
        return medicoMapper.toAtualizarMedicoDTO(medico);
    }
}

