package app.springmedapi.service;

import app.springmedapi.entity.Agendamento;
import app.springmedapi.entity.AgendamentoDTO.AgendamentoRequestDTO;
import app.springmedapi.entity.AgendamentoDTO.AgendamentoResponseDTO;
import app.springmedapi.mapper.AgendamentoMapper;
import app.springmedapi.repository.AgendamentoRepository;
import org.springframework.stereotype.Service;

@Service
public class AgendamentoService {
    private final AgendamentoRepository agendamentoRepository;
    private final AgendamentoMapper agendamentoMapper;

    public AgendamentoService(AgendamentoRepository agendamentoRepository, AgendamentoMapper agendamentoMapper) {
        this.agendamentoRepository = agendamentoRepository;
        this.agendamentoMapper = agendamentoMapper;
    }

    public AgendamentoResponseDTO agendar(AgendamentoRequestDTO agendamentoRequestDTO) {
        Agendamento agendamentoEntity = agendamentoMapper.toAgendamentoEntity(agendamentoRequestDTO);
        agendamentoEntity = agendamentoRepository.save(agendamentoEntity);
        return agendamentoMapper.toAgendamentoDTO(agendamentoEntity);
    }
}
