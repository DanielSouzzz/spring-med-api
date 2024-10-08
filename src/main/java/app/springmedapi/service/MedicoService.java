package app.springmedapi.service;

import app.springmedapi.entity.Medico;
import app.springmedapi.repository.MedicoRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class MedicoService {
    private final MedicoRepository medicoRepository;

    public MedicoService(MedicoRepository medicoRepository) {
        this.medicoRepository = medicoRepository;
    }

    @Transactional
    public Medico createDoctor(Medico medico){
        medico.setId(null);
        return medicoRepository.save(medico);
    }
}
