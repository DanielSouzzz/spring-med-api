package app.springmedapi.service;

import app.springmedapi.entity.agenda.AgendaRequestDTO;
import app.springmedapi.entity.agenda.AgendaResponseDTO;
import app.springmedapi.mapper.AgendaMapper;
import app.springmedapi.repository.AgendaRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

@Service
public class AgendaService {
    private final AgendaRepository agendaRepository;
    private final AgendaMapper agendaMapper;

    public AgendaService(AgendaRepository agendaRepository, AgendaMapper agendaMapper) {
        this.agendaRepository = agendaRepository;
        this.agendaMapper = agendaMapper;
    }

    public AgendaResponseDTO liberarHorarios(@Valid AgendaRequestDTO agendaResquestDTO) {
    }
}
