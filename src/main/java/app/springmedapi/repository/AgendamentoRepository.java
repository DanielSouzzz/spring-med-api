package app.springmedapi.repository;

import app.springmedapi.entity.Agendamento;
import org.postgresql.core.NativeQuery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;

public interface AgendamentoRepository extends JpaRepository<Agendamento, Long> {
    @Query(value = """
        select 1 from agendamentos a
        where a.id_paciente = :idPaciente
        and a.data >= CAST(:data AS DATE)
        and a.data < CAST(:data AS DATE) + INTERVAL '1 day'
""", nativeQuery = true)
    boolean isHasScheduleOnDay(@Param("idPaciente") Long idPaciente,
                               @Param("data") LocalDateTime data);

    @Query(value = """
            select exists (
            SELECT 1 FROM agendamentos
            WHERE idMedico = :idMedico AND data = :data
            )
            """, nativeQuery = true)
    boolean hourAvailable(@Param("idMedico") Long idMedico,
                          @Param("data") LocalDateTime data);
}