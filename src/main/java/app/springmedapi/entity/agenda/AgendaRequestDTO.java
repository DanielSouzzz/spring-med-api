package app.springmedapi.entity.agenda;

import app.springmedapi.enums.DayOfWeekEnum;
import app.springmedapi.enums.Especialidade;

import java.time.LocalTime;

public record AgendaRequestDTO(
        Long idMedico,
        Especialidade especialidade,
        DayOfWeekEnum dayOfWeek,
        LocalTime startTime,
        LocalTime endTime
) {
}
