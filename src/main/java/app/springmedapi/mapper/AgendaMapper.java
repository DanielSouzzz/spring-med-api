package app.springmedapi.mapper;

import app.springmedapi.entity.Agenda;
import app.springmedapi.entity.agenda.AgendaRequestDTO;

public class AgendaMapper {
    public static AgendaRequestDTO toDTO(Agenda agenda){
        if (agenda == null){
            return null;
        }

        var dto = new AgendaRequestDTO(
                agenda.getIdMedico(),
                agenda.getEspecialidade(),
                agenda.getDayOfWeek(),
                agenda.getStartTime(),
                agenda.getEndTime()
        );
        return dto;
    }

    public static Agenda toEntity(AgendaRequestDTO dto){
        if(dto == null){
            return null;
        }

        var agenda = new Agenda();

        agenda.setIdMedico(dto.idMedico());
        agenda.setEspecialidade(dto.especialidade());
        agenda.setDayOfWeek(dto.dayOfWeek());
        agenda.setStartTime(dto.startTime());
        agenda.setEndTime(dto.endTime());

        return agenda;
    }
}
