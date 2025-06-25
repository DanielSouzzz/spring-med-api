package app.springmedapi.mapper;

import app.springmedapi.entity.Agenda;
import app.springmedapi.entity.agenda.AgendaRequestDTO;
import app.springmedapi.entity.agenda.AgendaResponseDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AgendaMapper {
    AgendaResponseDTO toAgendaDTO(Agenda agenda);

    Agenda toAgendaEntity(AgendaRequestDTO agendaRequestDTO);
}
