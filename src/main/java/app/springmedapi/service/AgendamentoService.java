package app.springmedapi.service;

import app.springmedapi.entity.Agendamento;
import app.springmedapi.entity.AgendamentoDTO.AgendamentoRequestDTO;
import app.springmedapi.entity.AgendamentoDTO.AgendamentoResponseDTO;
import app.springmedapi.infra.exception.ValidacaoException;
import app.springmedapi.mapper.AgendamentoMapper;
import app.springmedapi.repository.AgendamentoRepository;
import app.springmedapi.repository.MedicoRepository;
import app.springmedapi.repository.PacienteRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AgendamentoService {
    private final AgendamentoRepository agendamentoRepository;
    private final MedicoRepository medicoRepository;
    private final AgendamentoMapper agendamentoMapper;
    private final PacienteRepository pacienteRepository;

    public AgendamentoService(AgendamentoRepository agendamentoRepository, MedicoRepository medicoRepository, AgendamentoMapper agendamentoMapper, PacienteRepository pacienteRepository) {
        this.agendamentoRepository = agendamentoRepository;
        this.medicoRepository = medicoRepository;
        this.agendamentoMapper = agendamentoMapper;
        this.pacienteRepository = pacienteRepository;
    }

    @Transactional
    public AgendamentoResponseDTO agendar(AgendamentoRequestDTO dto) {
        if (dto.idMedico() != null
                && !medicoRepository.existsById(dto.idMedico())) {
            throw new ValidacaoException("Id do médico informado não existe!");
        }

        if (!pacienteRepository.existsById(dto.idPaciente())){
            throw new ValidacaoException("Id do paciente informado não existe!");
        }

        if (dto.idMedico() == null
                && dto.especialidade() != null){
            Agendamento agendamentoEntity = agendamentoMapper.toAgendamentoEntity(dto);
            agendamentoEntity.setIdMedico(medicoRepository.findRandomDoctor((agendamentoEntity.getEspecialidade())));
        }

        Agendamento agendamentoEntity = agendamentoMapper.toAgendamentoEntity(dto);
        agendamentoEntity = agendamentoRepository.save(agendamentoEntity);
        return agendamentoMapper.toAgendamentoDTO(agendamentoEntity);
    }
}
