package app.springmedapi.service;

import app.springmedapi.entity.Paciente;
import app.springmedapi.entity.pacienteDTO.CadastrarPacienteDTO;
import app.springmedapi.mapper.PacienteMapper;
import app.springmedapi.repository.PacienteRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class PacienteService {

    private final PacienteRepository pacienteRepository;
    private final PacienteMapper pacienteMapper;

    public PacienteService(PacienteRepository pacienteRepository, PacienteMapper pacienteMapper) {
        this.pacienteRepository = pacienteRepository;
        this.pacienteMapper = pacienteMapper;
    }

    @Transactional
    public CadastrarPacienteDTO createPatient(CadastrarPacienteDTO cadastrarPacienteDTO) {
        Paciente paciente = pacienteMapper.toPacienteEntity(cadastrarPacienteDTO);

        paciente = pacienteRepository.save(paciente);

        return pacienteMapper.toPacienteDTO(paciente);
    }
}
