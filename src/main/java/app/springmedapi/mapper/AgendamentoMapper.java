package app.springmedapi.mapper;

import app.springmedapi.entity.Agendamento;
import app.springmedapi.entity.AgendamentoDTO.AgendamentoRequestDTO;
import app.springmedapi.entity.AgendamentoDTO.AgendamentoResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
    public interface AgendamentoMapper {

    AgendamentoResponseDTO toAgendamentoDTO(Agendamento agendamentoEntity);

    @Mapping(target = "idMedico", ignore = true)
    Agendamento toAgendamentoEntity(AgendamentoRequestDTO agendamentoRequestDTO);
}
