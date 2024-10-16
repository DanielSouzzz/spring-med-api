package app.springmedapi.service;

import app.springmedapi.entity.Medico;
import app.springmedapi.entity.dto.MedicoDTO;
import app.springmedapi.mapper.MedicoMapper;
import app.springmedapi.repository.MedicoRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class MedicoService {
    private final MedicoRepository medicoRepository;
    private final MedicoMapper medicoMapper = MedicoMapper.INSTANCE;

    public MedicoService(MedicoRepository medicoRepository) {
        this.medicoRepository = medicoRepository;
    }

    @Transactional
    public MedicoDTO createDoctor(MedicoDTO medicoDTO){
        Medico medico = medicoMapper.toEntity(medicoDTO);

        Medico medicoSalvo = medicoRepository.save(medico);
        return medicoMapper.toDto(medicoSalvo);
    }
}