package app.springmedapi.mapper;

import app.springmedapi.entity.Agenda;
import app.springmedapi.entity.agenda.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AgendaMapper {
    AgendaResponseDTO toAgendaDTO(Agenda agenda);

    @Mapping(target = "dayOfWeek", expression = "java(DayOfWeekEnum.valueOf(dto.getDayOfWeek()))")
    Agenda toAgendaEntity(AgendaRequestDTO agendaRequestDTO);
}
