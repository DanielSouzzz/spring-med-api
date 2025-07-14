package app.springmedapi.entity.agenda;

import app.springmedapi.enums.DayOfWeekEnum;

import java.time.LocalTime;

public record AgendaResponseDTO(
        Long id,
        Integer idMedico,
        String especialidade,
        DayOfWeekEnum dayOfWeek,
        LocalTime startTime,
        LocalTime endTime
) {}
