package app.springmedapi.repository;

import app.springmedapi.entity.Agendamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;

public interface AgendamentoRepository extends JpaRepository<Agendamento, Long> {

    @Query(value = """
            select exists (
            SELECT 1 FROM agendamentos
            WHERE medico_id = :idMedico AND data_hora = :data
            )
            """, nativeQuery = true)
    boolean hourAvailable(@Param("idMedico") Long idMedico,
                           @Param("data") LocalDateTime data);

