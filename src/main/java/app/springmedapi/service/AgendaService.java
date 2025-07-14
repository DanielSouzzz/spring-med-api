package app.springmedapi.service;

import app.springmedapi.entity.Agenda;
import app.springmedapi.entity.agenda.AgendaRequestDTO;
import app.springmedapi.entity.agenda.AgendaResponseDTO;
import app.springmedapi.mapper.AgendaMapper;
import app.springmedapi.repository.AgendaRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AgendaService {
    private final AgendaRepository agendaRepository;

    public AgendaService(AgendaRepository agendaRepository) {
        this.agendaRepository = agendaRepository;
    }

    @Transactional
    public AgendaResponseDTO liberarHorarios(@Valid AgendaRequestDTO dto) {
        Agenda agendaEntity = AgendaMapper.toEntity(dto);
        agendaEntity = agendaRepository.save(agendaEntity);
        return AgendaMapper.toDTO(agendaEntity);
    }
}
