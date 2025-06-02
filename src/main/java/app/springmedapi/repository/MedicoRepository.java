package app.springmedapi.repository;

import app.springmedapi.entity.Medico;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;

public interface MedicoRepository extends JpaRepository<Medico, Long> {
    Page<Medico> findAllByAtivoTrue(Pageable pageable);

    @Query(value = """
            select * from medicos
            where ativo = true
              and especialidade = :especialidade
              and id not in (
                select id_medico from agendamentos where data = :data
              )
            order by RANDOM()
            limit 1
       """, nativeQuery = true)
    Integer findRandomDoctor(@Param("especialidade") String especialidade,@Param("data") LocalDateTime data);

}