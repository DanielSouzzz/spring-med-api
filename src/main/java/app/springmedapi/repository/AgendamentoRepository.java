package app.springmedapi.repository;

import app.springmedapi.entity.Agendamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;

public interface AgendamentoRepository extends JpaRepository<Agendamento, Long> {
    @Query(value = """
            select a.data from agendamentos a
            where a.data = :data
            and a.id_medico = :id_medico
       """, nativeQuery = true)
    Integer findRandomDoctor(@Param("data") LocalDateTime data,@Param("id_medico") String id_medico);
}
