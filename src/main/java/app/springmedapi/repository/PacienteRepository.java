package app.springmedapi.repository;

import app.springmedapi.entity.Medico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository extends JpaRepository<Medico, Long> {
}


