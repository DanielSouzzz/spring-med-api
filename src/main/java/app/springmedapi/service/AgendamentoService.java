package app.springmedapi.service;

import app.springmedapi.entity.AgendamentoDTO.AgendamentoRequestDTO;
import app.springmedapi.entity.AgendamentoDTO.AgendamentoResponseDTO;
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
        Agendamento agendamento = agendamentoMapper.toEntity(agendamentoRequestDTO);
        Agendamento agendamentoSalvo = agendamentoRepository.save(agendamento);
        return agendamentoMapper.toDTO(agendamentoSalvo);
    }
}
