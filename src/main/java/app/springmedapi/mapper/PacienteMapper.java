package app.springmedapi.mapper;

import app.springmedapi.entity.Paciente;
import app.springmedapi.entity.pacienteDTO.CadastrarPacienteDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {EnderecoMapper.class})
public interface PacienteMapper {
    CadastrarPacienteDTO toPacienteDTO(Paciente paciente);

    Paciente toPacienteEntity(CadastrarPacienteDTO cadastrarPacienteDTO);
}
