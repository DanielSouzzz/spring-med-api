package app.springmedapi.mapper;

import app.springmedapi.entity.Agenda;
import app.springmedapi.entity.agenda.AgendaRequestDTO;
import app.springmedapi.entity.agenda.AgendaResponseDTO;

public class AgendaMapper {
    public static AgendaResponseDTO toDTO(Agenda agenda){
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

    public static Agenda toEntity(AgendaRequestDTO )
}
