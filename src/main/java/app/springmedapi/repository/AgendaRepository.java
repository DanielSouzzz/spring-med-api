package app.springmedapi.repository;

import app.springmedapi.entity.Agenda;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgendaRepository extends JpaRepository<Agenda, Long> {
}
